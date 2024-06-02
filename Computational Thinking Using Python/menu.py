import json  # Serve para trabalhar com dados em formato JSON. Utilizado para ler e escrever credenciais em arquivos JSON.
import oracledb  # Biblioteca para conexão e interação com bancos de dados Oracle.
import pandas as pd  # Biblioteca para manipulação e análise de dados. Utilizada para ler CSVs e trabalhar com DataFrames.
from sqlalchemy import create_engine, types  # create_engine é usado para criar uma conexão SQLAlchemy e types é utilizado para especificar tipos de dados ao inserir dados no banco de dados.
import getpass  # É utilizado para manipulação segura de senhas, permitindo ao usuário digitar a senha sem que ela seja exibida na tela.
import os  # Usado para interação com o sistema operacional. Dessa forma pode remover arquivos de credenciais.

# Função para validar as credenciais
def validar_credenciais(user, password, dsn):
    try:
        connection = oracledb.connect(user=user, password=password, dsn=dsn)
        connection.close()
        return True
    except oracledb.Error:
        return False

# Função para escrever as credenciais no arquivo 'secret.txt'
def escrever_credenciais():
    while True:
        user = input("Digite o usuário do banco de dados: ")
        password = getpass.getpass("Digite a senha do banco de dados: ")
        dsn = "oracle.fiap.com.br:1521/orcl"

        if validar_credenciais(user, password, dsn):
            credenciais = {
                "user": user,
                "password": password,
                "dsn": dsn
            }
            with open('secret.txt', 'w') as file:
                json.dump(credenciais, file)
            print("Credenciais escritas com sucesso.\n")
            break
        else:
            print("Credenciais inválidas. Tente novamente.\n")

# Função para limpar as credenciais removendo o arquivo 'secret.txt'
def limpar_credenciais():
    try:
        os.remove('secret.txt')
        print("Credenciais removidas com sucesso.\n")
    except FileNotFoundError:
        print("Arquivo de credenciais não encontrado.\n")

# Função para criar a conexão com o banco de dados
def conectar_banco_de_dados(secret_file):
    with open(secret_file) as file:
        secret = json.load(file)
    
    usuario = secret['user']
    senha = secret['password']
    oracle = secret['dsn']

    # Retorna a conexão e o engine
    connection = oracledb.connect(user=usuario, password=senha, dsn=oracle)
    engine = create_engine('oracle+oracledb://', creator=lambda: connection)
    
    return connection, engine

# Função para inserir os dados de um CSV no banco de dados
def inserir_dados_csv_no_banco(csv_file, table_name, engine):
    data = pd.read_csv(csv_file)
    
    # Definir mapeamento de tipos de dados para evitar problemas com FLOAT
    dtype_mapping = {
        'float64': types.Numeric(precision=38, scale=10),
        'int64': types.Integer,
        'object': types.String(255)
    }
    
    # Gerar dicionário de tipos para cada coluna
    dtype = {col: dtype_mapping[str(data[col].dtype)] for col in data.columns}
    
    data.to_sql(table_name, engine, if_exists='replace', index=False, dtype=dtype)

# Função para obter os nomes das colunas de uma tabela
def obter_nomes_colunas(table_name, engine):
    query = f"SELECT * FROM {table_name} WHERE ROWNUM = 1"
    data = pd.read_sql(query, engine)
    return data.columns.tolist()

# Função para ler dados de uma tabela do banco de dados
def ler_dados_tabela(table_name, engine):
    query = f"SELECT * FROM {table_name}"
    data = pd.read_sql(query, engine)
    return data

# Função para gerar relatórios específicos para produção de plástico
def gerar_relatorio_producao(engine, relatorio_tipo, colunas):
    col_ano = colunas[1]  # segundo item é 'Ano'
    col_producao = colunas[2]  # terceiro item é 'Produção Anual de Plástico'

    if relatorio_tipo == '1':
        query = f'''
        SELECT "{col_ano}", SUM("{col_producao}") AS Produção_Anual_Total
        FROM producao_plastico_global
        GROUP BY "{col_ano}"
        ORDER BY "{col_ano}"
        '''
    elif relatorio_tipo == '2':
        query = f'''
        SELECT TRUNC("{col_ano}", -1) AS Década, AVG("{col_producao}") AS Produção_Média_Década
        FROM producao_plastico_global
        GROUP BY TRUNC("{col_ano}", -1)
        ORDER BY TRUNC("{col_ano}", -1)
        '''
    elif relatorio_tipo == '3':
        query = f'''
        SELECT "{col_ano}", "{col_producao}"
        FROM producao_plastico_global
        ORDER BY "{col_producao}" DESC
        FETCH FIRST 5 ROWS ONLY
        '''
    elif relatorio_tipo == '4':
        query = f'''
        SELECT "{col_ano}",
               "{col_producao}",
               LAG("{col_producao}", 1) OVER (ORDER BY "{col_ano}") AS Produção_Anterior,
               ((("{col_producao}" - LAG("{col_producao}", 1) OVER (ORDER BY "{col_ano}")) / 
               LAG("{col_producao}", 1) OVER (ORDER BY "{col_ano}")) * 100) AS Crescimento_Percentual
        FROM producao_plastico_global
        ORDER BY "{col_ano}"
        '''
    elif relatorio_tipo == '5':
        query = f'''
        SELECT SUM("{col_producao}") AS Produção_Total
        FROM producao_plastico_global
        WHERE "{col_ano}" BETWEEN 2000 AND 2010
        '''
    else:
        print("Opção de relatório inválida.")
        return
    
    data = pd.read_sql(query, engine)
    print(data)

# Função para gerar relatórios específicos para despejo de resíduo plástico
def gerar_relatorio_despejo(engine, relatorio_tipo, colunas):
    col_entidade = colunas[0]  # primeiro item é 'Entidade'
    col_ano = colunas[2]  # terceiro item é 'Ano'
    col_participacao = colunas[3]  # quarto item é 'Participação na emissão global de plásticos para o oceano'

    if relatorio_tipo == '1':
        query = f'''
        SELECT "{col_entidade}", "{col_ano}", "{col_participacao}"
        FROM despejo_residuo_plastico
        ORDER BY "{col_ano}", "{col_entidade}"
        '''
    elif relatorio_tipo == '2':
        query = f'''
        SELECT "{col_entidade}", "{col_participacao}"
        FROM despejo_residuo_plastico
        WHERE "{col_ano}" = '2019'
        ORDER BY "{col_participacao}" DESC
        '''
    elif relatorio_tipo == '3':
        query = f'''
        SELECT "{col_entidade}", SUM("{col_participacao}") AS Participacao_Total
        FROM despejo_residuo_plastico
        WHERE "{col_entidade}" IN ('Africa', 'Asia', 'Europe', 'North America', 'Oceania', 'South America')
        GROUP BY "{col_entidade}"
        ORDER BY Participacao_Total DESC
        '''
    else:
        print("Opção de relatório inválida.")
        return
    
    data = pd.read_sql(query, engine)
    print(data)

# Função para gerar relatórios específicos para destino do plástico
def gerar_relatorio_destino(engine, relatorio_tipo, colunas):
    col_entidade = colunas[0]  # primeiro item é 'Entidade'
    col_ano = colunas[2]  # terceiro item é 'Ano'
    col_reciclagem = colunas[3]  # quarto item é 'Participação da reciclagem do lixo total regional'
    col_queima = colunas[4]  # quinto item é 'Participação da queima do lixo total regional'
    col_lixo_mal_gerido = colunas[5]  # sexto item é 'Participação do lixo descartado e mal gerido do total regional'
    col_aterro = colunas[6]  # sétimo item é 'Participação do lixo encaminhado para aterros do total regional'

    if relatorio_tipo == '1':
        query = f'''
        SELECT "{col_ano}", AVG("{col_reciclagem}") AS media_reciclagem
        FROM destino_plastico
        GROUP BY "{col_ano}"
        ORDER BY "{col_ano}"
        '''
    elif relatorio_tipo == '2':
        query = f'''
        SELECT "{col_entidade}", AVG("{col_queima}") AS media_queima
        FROM destino_plastico
        GROUP BY "{col_entidade}"
        ORDER BY media_queima DESC
        '''
    elif relatorio_tipo == '3':
        query = f'''
        SELECT "{col_entidade}", MAX("{col_lixo_mal_gerido}") AS max_lixo_mal_gerido
        FROM destino_plastico
        GROUP BY "{col_entidade}"
        ORDER BY max_lixo_mal_gerido DESC
        FETCH FIRST 10 ROWS ONLY
        '''
    elif relatorio_tipo == '4':
        query = f'''
        SELECT "{col_ano}", "{col_aterro}"
        FROM destino_plastico
        WHERE "{col_entidade}" = 'Americas (excl. USA)'
        ORDER BY "{col_ano}"
        '''
    elif relatorio_tipo == '5':
        query = f'''
        SELECT "{col_entidade}", 
               "{col_reciclagem}",
               "{col_queima}",
               "{col_lixo_mal_gerido}",
               "{col_aterro}"
        FROM destino_plastico
        WHERE "{col_ano}" = 2020
        ORDER BY "{col_entidade}"
        '''
    else:
        print("Opção de relatório inválida.")
        return
    
    data = pd.read_sql(query, engine)
    print(data)

## Função para gerar relatórios específicos para de plástico per capita
def gerar_relatorio_desperdicio(engine, relatorio_tipo, colunas):
    col_entidade = colunas[0]  # primeiro item é 'Entidade'
    col_ano = colunas[2]  # terceiro item é 'Ano'
    col_lixo = colunas[3]  # quarto item é 'Lixo plástico mal gerenciado por pessoa (kg por ano)'

    if relatorio_tipo == '1':
        query = f'''
        SELECT "{col_ano}", AVG("{col_lixo}") AS media_lixo_mal_gerenciado
        FROM desperdicio_plastico_per_capita
        GROUP BY "{col_ano}"
        ORDER BY "{col_ano}"
        '''
    elif relatorio_tipo == '2':
        query = f'''
        SELECT "{col_entidade}", "{col_lixo}"
        FROM desperdicio_plastico_per_capita
        WHERE "{col_ano}" = 2019
        ORDER BY "{col_lixo}" DESC
        FETCH FIRST 10 ROWS ONLY
        '''
    elif relatorio_tipo == '3':
        query = f'''
        SELECT "{col_entidade}", SUM("{col_lixo}") AS total_lixo_mal_gerenciado
        FROM desperdicio_plastico_per_capita
        WHERE "{col_ano}" = 2019
        GROUP BY "{col_entidade}"
        ORDER BY total_lixo_mal_gerenciado DESC
        '''
    elif relatorio_tipo == '4':
        query = f'''
        SELECT "{col_ano}", "{col_lixo}"
        FROM desperdicio_plastico_per_capita
        WHERE "{col_entidade}" = 'Brazil'
        ORDER BY "{col_ano}"
        '''
    elif relatorio_tipo == '5':
        query = f'''
        SELECT "{col_entidade}", "{col_lixo}"
        FROM desperdicio_plastico_per_capita
        WHERE "{col_ano}" = 2019 AND "{col_lixo}" < 10
        ORDER BY "{col_lixo}" ASC
        '''
    else:
        print("Opção de relatório inválida.")
        return
    
    data = pd.read_sql(query, engine)
    print(data)
    
# Função para gerar relatórios específicos para poluição da água nas cidades
def gerar_relatorio_poluicao(engine, relatorio_tipo, colunas):
    col_cidade = colunas[0]  # primeiro item é 'Cidade'
    col_regiao = colunas[1]  # segundo item é 'Região'
    col_entidade = colunas[2]  # terceiro item é 'Entidade'
    col_qualidade_ar = colunas[3]  # quarto item é 'Qualidade do Ar'
    col_poluicao_agua = colunas[4]  # quinto item é 'Poluição da Água'

    if relatorio_tipo == '1':
        query = f'''
        SELECT "{col_regiao}", AVG("{col_poluicao_agua}") AS media_poluicao_agua
        FROM poluicao_agua_cidades
        GROUP BY "{col_regiao}"
        ORDER BY media_poluicao_agua DESC
        '''
    elif relatorio_tipo == '2':
        query = f'''
        SELECT "{col_cidade}", "{col_entidade}", "{col_poluicao_agua}"
        FROM poluicao_agua_cidades
        ORDER BY "{col_poluicao_agua}" DESC
        FETCH FIRST 10 ROWS ONLY
        '''
    elif relatorio_tipo == '3':
        query = f'''
        SELECT "{col_cidade}", "{col_regiao}", "{col_qualidade_ar}", "{col_poluicao_agua}"
        FROM poluicao_agua_cidades
        WHERE "{col_cidade}" IN ('New York City', 'Berlin', 'Los Angeles')
        ORDER BY "{col_cidade}"
        '''
    elif relatorio_tipo == '4':
        query = f'''
        SELECT "{col_cidade}", "{col_entidade}", "{col_poluicao_agua}"
        FROM poluicao_agua_cidades
        WHERE "{col_poluicao_agua}" < 30
        ORDER BY "{col_poluicao_agua}" ASC
        '''
    elif relatorio_tipo == '5':
        query = f'''
        SELECT "{col_entidade}", AVG("{col_qualidade_ar}") AS media_qualidade_ar, AVG("{col_poluicao_agua}") AS media_poluicao_agua
        FROM poluicao_agua_cidades
        GROUP BY "{col_entidade}"
        ORDER BY "{col_entidade}"
        '''
    else:
        print("Opção de relatório inválida.")
        return
    
    data = pd.read_sql(query, engine)
    print(data)

# Função para exibir submenu de relatórios de produção de plástico
def submenu_relatorios_producao(engine, colunas):
    while True:
        print("\nSelecione o tipo de relatório:")
        print("1. Consultar a produção total de plástico por ano")
        print("2. Consultar a produção média de plástico por década")
        print("3. Consultar os 5 anos com a maior produção de plástico")
        print("4. Consultar o crescimento percentual da produção de plástico ano a ano")
        print("5. Consultar a produção total de plástico para um determinado período")
        print("6.Voltar ")

        escolha_relatorio = input("Escolha uma opção: ")

        if escolha_relatorio == '6':
            break
        else:
            gerar_relatorio_producao(engine, escolha_relatorio, colunas)

# Função para exibir submenu de relatórios de despejo de resíduo plástico
def submenu_relatorios_despejo(engine, colunas):
    while True:
        print("\nSelecione o tipo de relatório:")
        print("1. Consultar a participação na emissão global de plásticos para o oceano por entidade")
        print("2. Consultar a participação na emissão global de plásticos para o oceano por entidade mais recente (2019)")
        print("3. Consultar a participação total na emissão global de plásticos para o oceano por continente")
        print("4.Voltar ")

        escolha_relatorio = input("Escolha uma opção: ")

        if escolha_relatorio == '4':
            break
        else:
            gerar_relatorio_despejo(engine, escolha_relatorio, colunas)

# Função para exibir submenu de relatórios de destino do plástico
def submenu_relatorios_destino(engine, colunas):
    while True:
        print("\nSelecione o tipo de relatório:")
        print("1. Média de Reciclagem por Ano")
        print("2. Média de Queima por Entidade")
        print("3. Entidades com Maior Proporção de Lixo Mal Gerido")
        print("4. Participação do Lixo Encaminhado para Aterros ao Longo dos Anos")
        print("5. Comparação Anual das Participações")
        print("6.Voltar ")

        escolha_relatorio = input("Escolha uma opção: ")

        if escolha_relatorio == '6':
            break
        else:
            gerar_relatorio_destino(engine, escolha_relatorio, colunas)

# Função para exibir submenu de relatórios de destino do plástico
def submenu_relatorios_desperdicio(engine, colunas):
    while True:
        print("\nSelecione o tipo de relatório:")
        print("1. Média de Lixo Plástico Mal Gerenciado por Pessoa por Ano")
        print("2. Top 10 Países com Maior Desperdício Plástico Per Capita em um Ano Específico")
        print("3. Total de Lixo Plástico Mal Gerenciado por Região em um Ano Específico")
        print("4. Variação Anual do Lixo Plástico Mal Gerenciado por País")
        print("5. Países com Desperdício Plástico Mal Gerenciado Abaixo de um Limite")
        print("6.Voltar  ")

        escolha_relatorio = input("Escolha uma opção: ")

        if escolha_relatorio == '6':
            break
        else:
            gerar_relatorio_desperdicio(engine, escolha_relatorio, colunas)
      
# Função para exibir submenu de relatórios de destino do plástico      
def submenu_relatorios_poluicao(engine, colunas):
    while True:
        print("\nSelecione o tipo de relatório:")
        print("1. Média de Poluição da Água por Região")
        print("2. Top 10 Cidades com Maior Poluição da Água")
        print("3. Comparação da Qualidade do Ar e Poluição da Água")
        print("4. Cidades com Poluição da Água Abaixo de um Limite")
        print("5. Média de Poluição da Água e Qualidade do Ar por País")
        print("6.Voltar ")

        escolha_relatorio = input("Escolha uma opção: ")

        if escolha_relatorio == '6':
            break
        else:
            gerar_relatorio_poluicao(engine, escolha_relatorio, colunas)

# Função para exibir submenu de produção de plástico global
def submenu_producao_plastico_global(engine):
    colunas = obter_nomes_colunas('producao_plastico_global', engine)
    print("Colunas disponíveis:", colunas)  # Imprime os nomes das colunas para verificação

    while True:
        data = ler_dados_tabela('producao_plastico_global', engine)
        print(data)
        print("\nDeseja buscar informações específicas?")
        print("1. Sim")
        print("2. Voltar ")

        escolha = input("Escolha uma opção: ")

        if escolha == '1':
            submenu_relatorios_producao(engine, colunas)
        elif escolha == '2':
            break
        else:
            print("Opção inválida. Tente novamente.")

# Função para exibir submenu de participação de despejo de resíduo plástico
def submenu_despejo_residuo_plastico(engine):
    colunas = obter_nomes_colunas('despejo_residuo_plastico', engine)
    print("Colunas disponíveis:", colunas)  # Imprime os nomes das colunas para verificação

    while True:
        data = ler_dados_tabela('despejo_residuo_plastico', engine)
        print(data)
        print("\nDeseja buscar informações específicas?")
        print("1. Sim")
        print("2. Voltar ")

        escolha = input("Escolha uma opção: ")

        if escolha == '1':
            submenu_relatorios_despejo(engine, colunas)
        elif escolha == '2':
            break
        else:
            print("Opção inválida. Tente novamente.")

# Função para exibir submenu de destino do plástico
def submenu_destino_plastico(engine):
    colunas = obter_nomes_colunas('destino_plastico', engine)
    print("Colunas disponíveis:", colunas)  # Imprime os nomes das colunas para verificação

    while True:
        data = ler_dados_tabela('destino_plastico', engine)
        print(data)
        print("\nDeseja buscar informações específicas?")
        print("1. Sim")
        print("2. Voltar ")

        escolha = input("Escolha uma opção: ")

        if escolha == '1':
            submenu_relatorios_destino(engine, colunas)
        elif escolha == '2':
            break
        else:
            print("Opção inválida. Tente novamente.")

# Função para exibir submenu de relatórios de desperdício de plástico per capita
def submenu_desperdicio_plastico(engine):
    colunas = obter_nomes_colunas('desperdicio_plastico_per_capita', engine)
    print("Colunas disponíveis:", colunas)  # Imprime os nomes das colunas para verificação

    while True:
        data = ler_dados_tabela('desperdicio_plastico_per_capita', engine)
        print(data)
        print("\nDeseja buscar informações específicas?")
        print("1. Sim")
        print("2. Voltar ")

        escolha = input("Escolha uma opção: ")

        if escolha == '1':
            submenu_relatorios_desperdicio(engine, colunas)
        elif escolha == '2':
            break
        else:
            print("Opção inválida. Tente novamente.")

# Função para exibir submenu de poluição da água nas cidades
def submenu_poluicao_agua(engine):
    colunas = obter_nomes_colunas('poluicao_agua_cidades', engine)
    print("Colunas disponíveis:", colunas)  # Imprime os nomes das colunas para verificação

    while True:
        data = ler_dados_tabela('poluicao_agua_cidades', engine)
        print(data)
        print("\nDeseja buscar informações específicas?")
        print("1. Sim")
        print("2. Voltar ")

        escolha = input("Escolha uma opção: ")

        if escolha == '1':
            submenu_relatorios_poluicao(engine, colunas)
        elif escolha == '2':
            break
        else:
            print("Opção inválida. Tente novamente.")

# Função para exibir o menu e lidar com as escolhas do usuário
def exibir_menu(engine):
    menu_width = 56
    border = "-" * menu_width
    empty_line = "||" + " " * (menu_width - 4) + "||"
    
    while True:
        print("\n" + border)
        print(empty_line)
        print("||{:^52}||".format("Seja muito bem-vindo ao"))
        print("||{:^52}||".format("Menu Milotech"))
        print(empty_line)
        print(border)
        print("|| 1. Ver produção de plástico global" + " " * 17 + "||")
        print("|| 2. Ver participação de despejo de resíduo plástico ||")
        print("|| 3. Ver destino do plástico" + " " * 25 + "||")
        print("|| 4. Ver desperdício de plástico per capita" + " " * 10 + "||")
        print("|| 5. Ver poluição da água nas cidades" + " " * 16 + "||")
        print("|| 6. Sair" + " " * 44 + "||")
        print(border)

        escolha = input("Escolha uma opção: ")

        if escolha == '1':
            submenu_producao_plastico_global(engine)
        elif escolha == '2':
            submenu_despejo_residuo_plastico(engine)
        elif escolha == '3':
            submenu_destino_plastico(engine)
        elif escolha == '4':
            submenu_desperdicio_plastico(engine)
        elif escolha == '5':
            submenu_poluicao_agua(engine)
        elif escolha == '6':
            print("Saindo...")
            break
        else:
            print("Opção inválida. Tente novamente.")

# Função principal
def main():
    escrever_credenciais()

    # Lista de arquivos CSV e nomes das tabelas correspondentes
    arquivos_csv = [
        ('1- producao-de-plastico-global.csv', 'producao_plastico_global'),
        ('2- participacao-despejo-residuo-plastico.csv', 'despejo_residuo_plastico'),
        ('3- destino-plastico.csv', 'destino_plastico'),
        ('4- desperdicio-plastico-per-capita.csv', 'desperdicio_plastico_per_capita'),
        ('5- poluicao-agua-cidades.csv', 'poluicao_agua_cidades')
    ]

    # Usar a função para conectar ao banco de dados
    connection, engine = conectar_banco_de_dados('secret.txt')

    try:
        # Inserir cada CSV no banco de dados
        for csv_file, table_name in arquivos_csv:
            inserir_dados_csv_no_banco(csv_file, table_name, engine)

        # Exibir o menu para o usuário, mantendo a conexão aberta
        exibir_menu(engine)
    finally:
        connection.close()
        limpar_credenciais()

if __name__ == "__main__":
    main()
