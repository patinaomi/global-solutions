# Grupo: Milotech
- RM553472: Claudio Bispo
- RM552981: Patricia Naomi
- RM553568: Sabrina Café

### Vídeo: https://youtu.be/mAcKCgxrMBA

# Descrição do Projeto:
   A Milotech está desenvolvendo uma solução tecnológica inovadora focada no resgate de animais marinhos em situação de risco devido a atividades antrópicas. Através de um site intuitivo e acessível, os usuários poderão chamar a empresa por meio do nosso website ou chatbot integrado ao Telegram para realizar resgates de animais encalhados, enviando a localização exata e fotos dos mesmos em perigo via integração com a API do Google Maps.

   A Milotech se compromete a tornar a plataforma acessível a todos os usuários, incorporando recursos de acessibilidade como VLibras, Chatbot com text to speech e speech to text, alteração de tema para claro e escuro, escolha de idioma e modificação de tamanho de fonte para garantir uma experiência inclusiva. O objetivo é não apenas resgatar animais marinhos, mas também promover a conscientização e a preservação dos oceanos, contribuindo para um futuro sustentável.

   Este projeto representa um passo significativo na utilização de tecnologia para a proteção dos oceanos, alinhando inovação tecnológica com responsabilidade ambiental e engajamento comunitário. A Milotech está comprometida em criar um impacto positivo e duradouro, protegendo a vida marinha e promovendo a sustentabilidade global.

# Objetivo Geral: 
   O projeto da Milotech visa utilizar tecnologias avançadas para promover um futuro sustentável nos oceanos, focando no resgate de animais marinhos em situações de risco devido a atividades antropogênicas. O objetivo principal é criar uma plataforma digital eficiente e acessível, capaz de coordenar ações de resgate e engajar a comunidade global na proteção dos ecossistemas marinhos.

# Objetivo Específico:
### Desenvolvimento de Front-End:
- Criar um site responsivo e acessível para uma ampla gama de usuários.
- Integrar a API do Google Maps para permitir que os usuários reportem situações de risco, enviando fotos e localizações precisas.
- Incluir um chatbot para responder às dúvidas mais frequentes dos usuários e enviar alertas sobre a localização do atendimento.

### Desenvolvimento de Back-End:
- Utilizar Java para construir uma infraestrutura robusta que suporte as operações do site.
- Implementar soluções em Python e Inteligência Artificial para a análise de dados coletados, ajudando a identificar padrões e otimizar as operações de resgate.
- O usuário pode acompanhar a solicitação como se fosse um pedido feito no Ifood

### Acessibilidade e Inclusão:
- Garantir que o site seja totalmente acessível, incorporando ferramentas como VLibras para atender usuários com deficiência auditiva;
- Chatbot com text to speech e speech to text, ou seja, o usuário poderá mandar sua dúvida em áudio ou texto e recebe-la em áudio ou texto, deixando o sistema personalizado;
- Alterar tema (claro e escuro);
- Modificação no tamanho de fonte;
- Escolha de idioma (português, espanhol e inglês);
- Desenvolver interfaces amigáveis que atendam a necessidades diversas, promovendo inclusão digital.

### Engajamento:
- Criar uma aba específica para investimento, permitindo que indivíduos e organizações contribuam financeiramente para o projeto.
- Página para acompanhar o investimento
- Fornecer informações transparentes e atualizadas sobre o impacto das contribuições e o progresso do projeto.

### Tecnologias Utilizadas:
- Front-End: React, CSS, JavaScript, API do Google Maps, API Login do Google, chatbot(IBM cloud – Watson);
- Back-End: Java para a infraestrutura principal, Python para análise de dados e IA, API do chatgpt e criação do chatbot autônomo;
- Acessibilidade: Implementação de VLibras e outras ferramentas de acessibilidade;
- Plataforma de Investimento: Integração de sistemas de pagamento e gestão de doações;

   Este projeto representa um passo significativo na utilização de tecnologia para a proteção dos oceanos, alinhando inovação tecnológica com responsabilidade ambiental e engajamento comunitário. A Milotech está comprometida em criar um impacto positivo e duradouro, protegendo a vida marinha e promovendo a sustentabilidade global.


# COMPUTATIONAL THINKING USING PYTHON

## Visão Geral

Este projeto é uma aplicação Python que permite a análise de dados relacionados à produção, despejo e destino de plásticos, bem como desperdício de plástico per capita e poluição da água nas cidades. Ele se conecta a um banco de dados Oracle para realizar consultas específicas e gerar relatórios a partir de arquivos CSV.

## Funcionalidades

1. **Ver produção de plástico global**
2. **Ver participação de despejo de resíduo plástico**
3. **Ver destino do plástico**
4. **Ver desperdício de plástico per capita**
5. **Ver poluição da água nas cidades**
6. **Sair**

Cada opção permite visualizar os dados carregados e gerar relatórios específicos.

## Estrutura do Código

### Importações

O código utiliza várias bibliotecas:

- `json`: Para manipulação de arquivos JSON.
- `oracledb`: Para conexão com o banco de dados Oracle.
- `pandas`: Para manipulação de dados e leitura de arquivos CSV.
- `sqlalchemy`: Para criação de engines de conexão e definição de tipos de dados.
- `getpass`: Para entrada segura de senhas.
- `os`: Para operações com arquivos do sistema operacional.

### Funções

#### 1. `validar_credenciais(user, password, dsn)`

Valida as credenciais do banco de dados tentando uma conexão. Retorna `True` se a conexão for bem-sucedida, caso contrário, `False`.

#### 2. `escrever_credenciais()`

Solicita ao usuário que insira suas credenciais do banco de dados e tenta validá-las. Se forem válidas, salva as credenciais em um arquivo JSON.

#### 3. `limpar_credenciais()`

Remove o arquivo de credenciais JSON.

#### 4. `conectar_banco_de_dados(secret_file)`

Lê as credenciais do arquivo JSON e cria uma conexão com o banco de dados Oracle.

#### 5. `inserir_dados_csv_no_banco(csv_file, table_name, engine)`

Insere os dados de um arquivo CSV no banco de dados, criando a tabela especificada.

#### 6. `obter_nomes_colunas(table_name, engine)`

Obtém os nomes das colunas de uma tabela no banco de dados.

#### 7. `ler_dados_tabela(table_name, engine)`

Lê todos os dados de uma tabela no banco de dados.

#### 8. `gerar_relatorio_producao(engine, relatorio_tipo, colunas)`

Gera relatórios específicos para produção de plástico global com base no tipo de relatório selecionado.

#### 9. `gerar_relatorio_despejo(engine, relatorio_tipo, colunas)`

Gera relatórios específicos para despejo de resíduo plástico com base no tipo de relatório selecionado.

#### 10. `gerar_relatorio_destino(engine, relatorio_tipo, colunas)`

Gera relatórios específicos para destino do plástico com base no tipo de relatório selecionado.

#### 11. `submenu_relatorios_producao(engine, colunas)`

Exibe o submenu de relatórios de produção de plástico e solicita ao usuário que selecione um tipo de relatório.

#### 12. `submenu_relatorios_despejo(engine, colunas)`

Exibe o submenu de relatórios de despejo de resíduo plástico e solicita ao usuário que selecione um tipo de relatório.

#### 13. `submenu_relatorios_destino(engine, colunas)`

Exibe o submenu de relatórios de destino do plástico e solicita ao usuário que selecione um tipo de relatório.

#### 14. `submenu_producao_plastico_global(engine)`

Exibe os dados de produção de plástico global e oferece a opção de gerar relatórios específicos.

#### 15. `submenu_despejo_residuo_plastico(engine)`

Exibe os dados de despejo de resíduo plástico e oferece a opção de gerar relatórios específicos.

#### 16. `submenu_destino_plastico(engine)`

Exibe os dados de destino do plástico e oferece a opção de gerar relatórios específicos.

#### 17. `submenu_desperdicio_plastico(engine)`

Exibe os dados de desperdício de plástico per capita e oferece a opção de gerar relatórios específicos.

#### 18. `submenu_poluicao_agua(engine)`

Exibe os dados de poluição da água nas cidades e oferece a opção de gerar relatórios específicos.

#### 19. `exibir_menu(engine)`

Exibe o menu principal e permite ao usuário selecionar uma das opções disponíveis.

#### 20. `main()`

Função principal que inicializa o programa, solicita as credenciais do banco de dados, insere os dados dos arquivos CSV no banco de dados e exibe o menu principal.

## Arquivos CSV

Os seguintes arquivos CSV são utilizados:

1. `1- producao-de-plastico-global.csv`
2. `2- participacao-despejo-residuo-plastico.csv`
3. `3- destino-plastico.csv`
4. `4- desperdicio-plastico-per-capita.csv`
5. `5- poluicao-agua-cidades.csv`

## Instruções para Execução

1. **Instale as dependências**:
   - `pandas`
   - `sqlalchemy`
   - `oracledb`
   
   Você pode instalar as dependências usando o `pip`:
   ```bash
   pip install pandas sqlalchemy oracledb
   ```

2. **Execute o script**:
   - Execute o arquivo Python que contém a função `main()`.
   ```bash
   python seu_arquivo.py
   ```

3. **Insira as credenciais**:
   - Digite o usuário e a senha do banco de dados quando solicitado.

4. **Use o menu**:
   - Selecione as opções do menu para visualizar os dados e gerar relatórios específicos.
