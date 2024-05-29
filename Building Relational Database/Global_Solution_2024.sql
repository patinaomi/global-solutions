-- Cria��o da tabela Usuarios -- Ser� preenchido pelos formul�rios do front
CREATE TABLE USUARIO ( 
id_usuario NUMBER(2) PRIMARY KEY, 
nome VARCHAR(255) NOT NULL, 
email VARCHAR(255) UNIQUE NOT NULL, 
senha VARCHAR(255));
--tipo_usuario ENUM('login', 'parceiro', 'fornecedor', 'Investidor') NOT NULL );
-- Conforme o tipo de usuario, precisa abrir mais campos para ele selecionar. Exempo Parceiros: Telefone de contato, Produtos/Servi�os que v�o oferecer. 
--id_tipo_usuario

-- Cria��o da tabela TipoUsuario -- Tabela de apoio para determinar o ID do formul�rio de cima.
CREATE TABLE TIPOUSUARIO (
id_tipo_usuario NUMBER(2) PRIMARY KEY,
descricao VARCHAR(255) NOT NULL );

-- Cria��o da tabela Login -- Login ser� consumido pelo Java para que o front valide se existe ou n�o a pessoa.
CREATE TABLE LOGIN ( 
id_login INT PRIMARY KEY, 
id_usuario INT NOT NULL, --Chave estrangeira aqui
email VARCHAR(255) NOT NULL,  -- Precisa ter a confirma��o do back
senha VARCHAR(255), -- Precisa ter a confirma��o do back
data_login DATE NOT NULL, 
id_tipo_login INT NOT NULL); -- Saber se ser� login apenas pelo cadastro que o usu�rio fez no site. 
-- Os dados da API do Google n�o precisa ser armazenado. Chave estrangeira aqui?
--status ENUM('sucesso', 'falha') NOT NULL, 
--FOREIGN KEY (usuario_id) REFERENCES Usuarios(id), FOREIGN KEY (tipo_login) REFERENCES TipoLogin(id) );

-- Cria��o da tabela TipoLogin
CREATE TABLE TIPOLOGIN (
id_tipo_login INT PRIMARY KEY, 
descricao VARCHAR(255) NOT NULL );

-- Cria��o da tabela SolicitacaoSuporte -- Ser� o formul�rio de cadastro de solicita��o do servi�o
CREATE TABLE SOLICITACAOSUPORTE ( 
id_solicitacao INT PRIMARY KEY, 
id_usuario INT NOT NULL,  --Chave estrangeira
--tipo_suporte 'animal', 'lixo' 
descricao VARCHAR2(255), -- Descri��o da situa��o. Motivo da solicita��o.
localizacao_origem VARCHAR(255) NOT NULL, -- Aqui pode ser s� o CEP? Depois teremos uma tabelas com os locais para organizar para mat�ria de IA
data_solicitacao TIMESTAMP NOT NULL, 
id_animal INT, -- Chave estrangeira
id_tipo_residuo INT); -- Chave estrangeira
--FOREIGN KEY (usuario_id) REFERENCES Usuarios(id), FOREIGN KEY (animal_id) REFERENCES Animais(id), FOREIGN KEY (lixo_id) REFERENCES TiposLixo(id) );
-- Campos que precisam ter no formul�rio:
1. Nome do animal ?
2. Tipo de especie
3. Descri��o do animal

-- Cria��o da tabela Tipos Residuou -- Tabela que ser� consumida no Java e Front para ser consumida pelo usu�rio nos formul�rios.
CREATE TABLE TIPORESIDUO ( 
id_tipo_residuo INT PRIMARY KEY, 
tipo VARCHAR(255) NOT NULL, 
descricao VARCHAR(255) );

-- Cria��o da tabela Tipo ou dados dos animais -- Aqui precisamos ter uma base montada e que set� consumida pelo java e front para mostrar a lista de
-- animais para o usuario selecionar.
id_animal, -- Chave primaria
nome_animal,
especie_animal,
descricao_animal
);

-- Cria��o da tabela Categorias - Para Projetos?
CREATE TABLE Categorias ( 
id_categoria INT PRIMARY KEY, 
nome VARCHAR(255) NOT NULL, 
descricao VARCHAR(255) );

-- Cria��o da tabela Parceiros -- Precisa abrir no front novos campos com base neste campo
CREATE TABLE Parceiros ( 
id_parceiro INT PRIMARY KEY, 
nome VARCHAR(255) NOT NULL, 
contato VARCHAR(255), 
tipo_parceria VARCHAR(255) );

-- Cria��o da tabela Fornecedores -- Tabela que ser� preenchida pelo front quando o usuario se cadastrar para fornecer algo para n�s. 
-- Ser� uma tabela de complemento.
CREATE TABLE FORNECEDOR (
id_fornecedor INT PRIMARY KEY, 
nome VARCHAR(255) NOT NULL, 
contato VARCHAR(255), 
tipo_servico VARCHAR(255) );

-- Cria��o da tabela Investidores -- Tabela que ser� preenchida pelo front. 
-- Abrir� uma op��o caso o usu�rio selecione investidor.
CREATE TABLE INVESTIDORES ( 
id_investidor INT PRIMARY KEY, 
nome VARCHAR(255) NOT NULL, 
contato VARCHAR(255), 
quantia_contribuida DECIMAL(10, 2) );

-- Cria��o da tabela Alertas -- Queremos enviar comunicados para nossa base de usu�rio. Aqui s� ser� utilizada por IA e telegram.
-- Ter� o preenchimento de acordo com as demais tabelas.
CREATE TABLE ALERTAS ( 
id_alerta INT PRIMARY KEY, 
usuario_id INT NOT NULL, 
tipo_alerta VARCHAR(255) NOT NULL, 
mensagem VARCHAR(255), 
data_enviado TIMESTAMP NOT NULL);
-- id_solicitacao_suporte -- chave estrangeira
--lido BOOLEAN, FOREIGN KEY (usuario_id) REFERENCES Usuarios(id) );

-- Cria��o da tabela Feedbacks -- Ser� preenchida pelo Front.
CREATE TABLE Feedbacks ( 
id_feedback INT PRIMARY KEY, 
usuario_id INT NOT NULL, 
descricao VARCHAR(255) NOT NULL, 
data_feedback DATE NOT NULL);
--id_stars -- Chave estrangeira
--FOREIGN KEY (usuario_id) REFERENCES Usuarios(id) );

-- Tabela suporte das estrelas
-- id_stars (ID 1: Igual a 1 estrela, ID 2 para duas estrelas, vai at� 5.
-- quantidade_estrelas number(1)
-- definicao varchar(255) -- Aqui vai falar se � p�ssimo, ruim,regular, boa, excelente

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

