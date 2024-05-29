-- Criação da tabela Usuarios -- Será preenchido pelos formulários do front
CREATE TABLE USUARIO ( 
id_usuario NUMBER(2) PRIMARY KEY, 
nome VARCHAR(255) NOT NULL, 
email VARCHAR(255) UNIQUE NOT NULL, 
senha VARCHAR(255));
--tipo_usuario ENUM('login', 'parceiro', 'fornecedor', 'Investidor') NOT NULL );
-- Conforme o tipo de usuario, precisa abrir mais campos para ele selecionar. Exempo Parceiros: Telefone de contato, Produtos/Serviços que vão oferecer. 
--id_tipo_usuario

-- Criação da tabela TipoUsuario -- Tabela de apoio para determinar o ID do formulário de cima.
CREATE TABLE TIPOUSUARIO (
id_tipo_usuario NUMBER(2) PRIMARY KEY,
descricao VARCHAR(255) NOT NULL );

-- Criação da tabela Login -- Login será consumido pelo Java para que o front valide se existe ou não a pessoa.
CREATE TABLE LOGIN ( 
id_login INT PRIMARY KEY, 
id_usuario INT NOT NULL, --Chave estrangeira aqui
email VARCHAR(255) NOT NULL,  -- Precisa ter a confirmação do back
senha VARCHAR(255), -- Precisa ter a confirmação do back
data_login DATE NOT NULL, 
id_tipo_login INT NOT NULL); -- Saber se será login apenas pelo cadastro que o usuário fez no site. 
-- Os dados da API do Google não precisa ser armazenado. Chave estrangeira aqui?
--status ENUM('sucesso', 'falha') NOT NULL, 
--FOREIGN KEY (usuario_id) REFERENCES Usuarios(id), FOREIGN KEY (tipo_login) REFERENCES TipoLogin(id) );

-- Criação da tabela TipoLogin
CREATE TABLE TIPOLOGIN (
id_tipo_login INT PRIMARY KEY, 
descricao VARCHAR(255) NOT NULL );

-- Criação da tabela SolicitacaoSuporte -- Será o formulário de cadastro de solicitação do serviço
CREATE TABLE SOLICITACAOSUPORTE ( 
id_solicitacao INT PRIMARY KEY, 
id_usuario INT NOT NULL,  --Chave estrangeira
--tipo_suporte 'animal', 'lixo' 
descricao VARCHAR2(255), -- Descrição da situação. Motivo da solicitação.
localizacao_origem VARCHAR(255) NOT NULL, -- Aqui pode ser só o CEP? Depois teremos uma tabelas com os locais para organizar para matéria de IA
data_solicitacao TIMESTAMP NOT NULL, 
id_animal INT, -- Chave estrangeira
id_tipo_residuo INT); -- Chave estrangeira
--FOREIGN KEY (usuario_id) REFERENCES Usuarios(id), FOREIGN KEY (animal_id) REFERENCES Animais(id), FOREIGN KEY (lixo_id) REFERENCES TiposLixo(id) );
-- Campos que precisam ter no formulário:
1. Nome do animal ?
2. Tipo de especie
3. Descrição do animal

-- Criação da tabela Tipos Residuou -- Tabela que será consumida no Java e Front para ser consumida pelo usuário nos formulários.
CREATE TABLE TIPORESIDUO ( 
id_tipo_residuo INT PRIMARY KEY, 
tipo VARCHAR(255) NOT NULL, 
descricao VARCHAR(255) );

-- Criação da tabela Tipo ou dados dos animais -- Aqui precisamos ter uma base montada e que setá consumida pelo java e front para mostrar a lista de
-- animais para o usuario selecionar.
id_animal, -- Chave primaria
nome_animal,
especie_animal,
descricao_animal
);

-- Criação da tabela Categorias - Para Projetos?
CREATE TABLE Categorias ( 
id_categoria INT PRIMARY KEY, 
nome VARCHAR(255) NOT NULL, 
descricao VARCHAR(255) );

-- Criação da tabela Parceiros -- Precisa abrir no front novos campos com base neste campo
CREATE TABLE Parceiros ( 
id_parceiro INT PRIMARY KEY, 
nome VARCHAR(255) NOT NULL, 
contato VARCHAR(255), 
tipo_parceria VARCHAR(255) );

-- Criação da tabela Fornecedores -- Tabela que será preenchida pelo front quando o usuario se cadastrar para fornecer algo para nós. 
-- Será uma tabela de complemento.
CREATE TABLE FORNECEDOR (
id_fornecedor INT PRIMARY KEY, 
nome VARCHAR(255) NOT NULL, 
contato VARCHAR(255), 
tipo_servico VARCHAR(255) );

-- Criação da tabela Investidores -- Tabela que será preenchida pelo front. 
-- Abrirá uma opção caso o usuário selecione investidor.
CREATE TABLE INVESTIDORES ( 
id_investidor INT PRIMARY KEY, 
nome VARCHAR(255) NOT NULL, 
contato VARCHAR(255), 
quantia_contribuida DECIMAL(10, 2) );

-- Criação da tabela Alertas -- Queremos enviar comunicados para nossa base de usuário. Aqui só será utilizada por IA e telegram.
-- Terá o preenchimento de acordo com as demais tabelas.
CREATE TABLE ALERTAS ( 
id_alerta INT PRIMARY KEY, 
usuario_id INT NOT NULL, 
tipo_alerta VARCHAR(255) NOT NULL, 
mensagem VARCHAR(255), 
data_enviado TIMESTAMP NOT NULL);
-- id_solicitacao_suporte -- chave estrangeira
--lido BOOLEAN, FOREIGN KEY (usuario_id) REFERENCES Usuarios(id) );

-- Criação da tabela Feedbacks -- Será preenchida pelo Front.
CREATE TABLE Feedbacks ( 
id_feedback INT PRIMARY KEY, 
usuario_id INT NOT NULL, 
descricao VARCHAR(255) NOT NULL, 
data_feedback DATE NOT NULL);
--id_stars -- Chave estrangeira
--FOREIGN KEY (usuario_id) REFERENCES Usuarios(id) );

-- Tabela suporte das estrelas
-- id_stars (ID 1: Igual a 1 estrela, ID 2 para duas estrelas, vai até 5.
-- quantidade_estrelas number(1)
-- definicao varchar(255) -- Aqui vai falar se é péssimo, ruim,regular, boa, excelente

-- Criar uma tabela com o CEP e que mostre o endereco. Aqui podemos usar a API CEP
id_localizacao
cep
estado
cidade
bairro
rua
complemento
data_cadastro
longitude
latitude

