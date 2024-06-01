import json
import oracledb
import pandas as pd
from sqlalchemy import create_engine, types

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

# Função para ler dados de uma tabela do banco de dados
def ler_dados_tabela(table_name, engine):
    query = f"SELECT * FROM {table_name}"
    data = pd.read_sql(query, engine)
    return data

# Função para exibir o menu e lidar com as escolhas do usuário
def exibir_menu(engine):
    while True:
        print("\nMenu:")
        print("1. Ver produção de plástico global")
        print("2. Ver participação de despejo de resíduo plástico")
        print("3. Ver destino do plástico")
        print("4. Ver desperdício de plástico per capita")
        print("5. Ver poluição da água nas cidades")
        print("6. Sair")

        escolha = input("Escolha uma opção: ")

        if escolha == '1':
            data = ler_dados_tabela('producao_plastico_global', engine)
            print(data)
        elif escolha == '2':
            data = ler_dados_tabela('despejo_residuo_plastico', engine)
            print(data)
        elif escolha == '3':
            data = ler_dados_tabela('destino_plastico', engine)
            print(data)
        elif escolha == '4':
            data = ler_dados_tabela('desperdicio_plastico_per_capita', engine)
            print(data)
        elif escolha == '5':
            data = ler_dados_tabela('poluicao_agua_cidades', engine)
            print(data)
        elif escolha == '6':
            print("Saindo...")
            break
        else:
            print("Opção inválida. Tente novamente.")

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
