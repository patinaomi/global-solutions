-- Criação da tabela Usuarios
CREATE TABLE USUARIO ( 
id NUMBER(2) PRIMARY KEY, 
nome VARCHAR(255) NOT NULL, 
email VARCHAR(255) UNIQUE NOT NULL, 
senha VARCHAR(255));
--tipo_usuario ENUM('login', 'parceiro', 'fornecedor', 'Investidor') NOT NULL );

-- Criação da tabela TipoUsuario
CREATE TABLE TIPOUSUARIO ( 
id NUMBER(2) PRIMARY KEY, 
descricao VARCHAR(255) NOT NULL );

-- Criação da tabela Login
CREATE TABLE LOGIN ( 
id INT PRIMARY KEY, 
usuario_id INT NOT NULL, 
email VARCHAR(255) NOT NULL, 
senha VARCHAR(255), 
data_login DATE NOT NULL, 
tipo_login INT NOT NULL);
--status ENUM('sucesso', 'falha') NOT NULL, 
--FOREIGN KEY (usuario_id) REFERENCES Usuarios(id), FOREIGN KEY (tipo_login) REFERENCES TipoLogin(id) );

-- Criação da tabela TipoLogin
CREATE TABLE TIPOLOGIN ( 
id INT PRIMARY KEY, 
descricao VARCHAR(255) NOT NULL );

-- Criação da tabela SolicitacaoSuporte
CREATE TABLE SOLICITACAOSUPORTE ( 
id_solicitacao INT PRIMARY KEY, 
usuario_id INT NOT NULL, 
--tipo_marcacao ENUM('animal', 'lixo', 'evento') NOT NULL, 
descricao VARCHAR2(255), 
localizacao_origem VARCHAR(255) NOT NULL, 
data_solicitacao TIMESTAMP NOT NULL, 
animal_id INT, 
lixo_id INT);
--FOREIGN KEY (usuario_id) REFERENCES Usuarios(id), FOREIGN KEY (animal_id) REFERENCES Animais(id), FOREIGN KEY (lixo_id) REFERENCES TiposLixo(id) );

-- Criação da tabela TiposLixo
CREATE TABLE TIPORESIDUO ( 
id_tipo INT PRIMARY KEY, 
tipo VARCHAR(255) NOT NULL, 
descricao VARCHAR(255) );

-- Criação da tabela Categorias
CREATE TABLE Categorias ( 
id INT PRIMARY KEY, 
nome VARCHAR(255) NOT NULL, 
descricao VARCHAR(255) );

-- Criação da tabela Parceiros
CREATE TABLE Parceiros ( 
id_parceiro INT PRIMARY KEY, 
nome VARCHAR(255) NOT NULL, 
contato VARCHAR(255), 
tipo_parceria VARCHAR(255) );

-- Criação da tabela Fornecedores
CREATE TABLE FORNECEDOR (
id_fornecedor INT PRIMARY KEY, 
nome VARCHAR(255) NOT NULL, 
contato VARCHAR(255), 
tipo_servico VARCHAR(255) );

-- Criação da tabela Investimentos
CREATE TABLE INVESTIDORES ( 
id_investidor INT PRIMARY KEY, 
nome VARCHAR(255) NOT NULL, 
contato VARCHAR(255), 
quantia_contribuida DECIMAL(10, 2) );

-- Criação da tabela Alertas
CREATE TABLE ALERTAS ( 
id_alerta INT PRIMARY KEY, 
usuario_id INT NOT NULL, 
tipo_alerta VARCHAR(255) NOT NULL, 
mensagem VARCHAR(255), 
data_enviado TIMESTAMP NOT NULL);
--lido BOOLEAN, FOREIGN KEY (usuario_id) REFERENCES Usuarios(id) );

-- Criação da tabela Investimentos
CREATE TABLE Investimentos ( 
id_investimento INT PRIMARY KEY, 
usuario_id INT NOT NULL,
quantia DECIMAL(10, 2) NOT NULL, 
data_investimento DATE NOT NULL);
--FOREIGN KEY (usuario_id) REFERENCES Usuarios(id), FOREIGN KEY (evento_id) REFERENCES Eventos(id) );

-- Criação da tabela Feedbacks
CREATE TABLE Feedbacks ( 
id_feedback INT PRIMARY KEY, 
usuario_id INT NOT NULL, 
descricao VARCHAR(255) NOT NULL, 
data_feedback DATE NOT NULL);
--FOREIGN KEY (usuario_id) REFERENCES Usuarios(id) );

-- Criação da tabela SolicitacaoAjudaAnimais
CREATE TABLE SOLICITACAOAJUDAANIMAIS ( 
id_solicitacao_suporte INT PRIMARY KEY, 
usuario_id INT NOT NULL, 
descricao VARCHAR(255) NOT NULL, 
localizacao VARCHAR(255) NOT NULL, 
data_solicitacao TIMESTAMP NOT NULL);
--status ENUM('pendente', 'em andamento', 'concluído') NOT NULL);
--FOREIGN KEY (usuario_id) REFERENCES Usuarios(id) );