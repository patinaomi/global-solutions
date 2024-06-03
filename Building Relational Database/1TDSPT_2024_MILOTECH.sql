-- Nome dos Integrantes: 
-- Claudio Silva Bispo RM553472
-- Patricia Naomi Yamagishi RM552981
-- Sabrina da Motta Café RM553568

-- Deletar tabelas caso já existam
DROP TABLE Form_Feedback CASCADE CONSTRAINTS;
DROP TABLE Investidor CASCADE CONSTRAINTS;
DROP TABLE Login CASCADE CONSTRAINTS;
DROP TABLE Ocorrencia CASCADE CONSTRAINTS;
DROP TABLE Animal CASCADE CONSTRAINTS;
DROP TABLE Condicao_Animal CASCADE CONSTRAINTS;
DROP TABLE Newsletter CASCADE CONSTRAINTS;
DROP TABLE Usuario CASCADE CONSTRAINTS;
DROP TABLE Tipo_Login CASCADE CONSTRAINTS;
DROP TABLE Tipo_Residuo CASCADE CONSTRAINTS;
DROP TABLE Tipo_Usuario CASCADE CONSTRAINTS;

-- Criação das tabelas

-- Tipo_Usuario
CREATE TABLE Tipo_Usuario (
    id_tipo_usuario INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
    desc_tipo_usuario VARCHAR2(255) NOT NULL
);
ALTER TABLE Tipo_Usuario ADD CONSTRAINT tipo_usuario_pk PRIMARY KEY(id_tipo_usuario);

-- Usuario
CREATE TABLE Usuario (
    id_usuario INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
    nome_usuario VARCHAR2(255) NOT NULL,
    sobrenome_usuario VARCHAR2(255) NOT NULL,
    email_usuario VARCHAR2(255) CONSTRAINT email_unique UNIQUE NOT NULL,
    senha_usuario VARCHAR2(255) NOT NULL,
    telefone_usuario VARCHAR2(30) NOT NULL,
    id_tipo_usuario INTEGER NOT NULL
);
ALTER TABLE Usuario ADD CONSTRAINT usuario_pk PRIMARY KEY(id_usuario);

-- Tipo_Login
CREATE TABLE Tipo_Login (
    id_tipo_login INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
    desc_tipo_login VARCHAR2(255) NOT NULL
);
ALTER TABLE Tipo_Login ADD CONSTRAINT tipo_login_pk PRIMARY KEY(id_tipo_login);

-- Login
CREATE TABLE Login (
    id_login INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
    email_login VARCHAR2(255) NOT NULL,
    senha_login VARCHAR2(255) NOT NULL,
    data_login TIMESTAMP NOT NULL,
    id_usuario INTEGER NOT NULL,
    id_tipo_login INTEGER NOT NULL
);
ALTER TABLE Login ADD CONSTRAINT login_pk PRIMARY KEY(id_login);

-- Condicao_Animal
CREATE TABLE Condicao_Animal (
    id_condicao INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
    desc_condicao VARCHAR2(255) NOT NULL
);
ALTER TABLE Condicao_Animal ADD CONSTRAINT condicaoanimal_pk PRIMARY KEY(id_condicao);

-- Animal
CREATE TABLE Animal (
    id_animal INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
    nome_animal VARCHAR2(255),
    especie_animal VARCHAR2(255),
    desc_animal VARCHAR2(255),
    id_condicao INTEGER NOT NULL
);
ALTER TABLE Animal ADD CONSTRAINT animal_pk PRIMARY KEY(id_animal);

-- Tipo_Residuo
CREATE TABLE Tipo_Residuo (
    id_tipo_residuo INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
    nome_tipo_residuo VARCHAR2(255) NOT NULL,
    desc_tipo_residuo VARCHAR2(255) NOT NULL
);
ALTER TABLE Tipo_Residuo ADD CONSTRAINT tiporesiduo_pk PRIMARY KEY(id_tipo_residuo);

-- Ocorrencia
CREATE TABLE Ocorrencia (
    id_solicitacao INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL, 
    desc_ocorr VARCHAR2(255),
    tel_ocorr VARCHAR2(255) NOT NULL,
    img_ocorr VARCHAR2(255),
    long_ocorr VARCHAR2(255),
    lat_ocorr VARCHAR2(255),
    data_solicitacao TIMESTAMP NOT NULL,
    condicao_ocorr VARCHAR2(255) NOT NULL,
    id_usuario INTEGER NOT NULL,
    id_animal INTEGER,
    id_tipo_residuo INTEGER
);
ALTER TABLE Ocorrencia ADD CONSTRAINT ocorrencia_pk PRIMARY KEY(id_solicitacao);

-- Investidor
CREATE TABLE Investidor (
    id_investidor INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
    nome_inv VARCHAR2(255) NOT NULL,
    email_inv VARCHAR2(255) NOT NULL,
    telefone_inv VARCHAR2(255) NOT NULL,
    nome_empresa_inv VARCHAR2(255) NOT NULL,
    quantia_contribuida_inv DECIMAL(10, 2) NOT NULL,
    data_investimento_inv TIMESTAMP NOT NULL,
    msg_inv VARCHAR2(255) NOT NULL,
    tipo_investidor_inv VARCHAR2(255) NOT NULL 
);
ALTER TABLE Investidor ADD CONSTRAINT investidor_pk PRIMARY KEY(id_investidor);

-- Form_Feedback
CREATE TABLE Form_Feedback (
    id_feedback INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL, 
    nome_feedback VARCHAR2(255) NOT NULL,
    tel_feedback VARCHAR2(255) NOT NULL,
    email_feedback VARCHAR2(255) NOT NULL,
    desc_feedback VARCHAR2(255) NOT NULL,
    data_feedback TIMESTAMP NOT NULL,
    id_usuario INTEGER NOT NULL
);
ALTER TABLE Form_Feedback ADD CONSTRAINT forms_feedback_pk PRIMARY KEY(id_feedback);

-- Newsletter
CREATE TABLE Newsletter (
    id_news INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
    email_news VARCHAR2(255) NOT NULL,
    data_envio_news TIMESTAMP NOT NULL,
    status_news VARCHAR2(10) NOT NULL
);
ALTER TABLE Newsletter ADD CONSTRAINT newsletter_pk PRIMARY KEY(id_news);

-- Inserindo Foreign Keys
-- FK na tabela Usuario
ALTER TABLE Usuario
ADD CONSTRAINT tipo_usuario_fk FOREIGN KEY (id_tipo_usuario) REFERENCES Tipo_Usuario(id_tipo_usuario);

-- Fks na tabela Login
ALTER TABLE Login ADD CONSTRAINT usuario_fk FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario);
ALTER TABLE Login ADD CONSTRAINT tipo_login_fk FOREIGN KEY (id_tipo_login) REFERENCES Tipo_Login(id_tipo_login);

-- Fk na tabela Animal
ALTER TABLE Animal ADD CONSTRAINT condicao_fk FOREIGN KEY (id_condicao) REFERENCES Condicao_Animal(id_condicao);

-- Fk na tabela Ocorrencia
ALTER TABLE Ocorrencia ADD CONSTRAINT fk_usuario_ocorrencia FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario);
ALTER TABLE Ocorrencia ADD CONSTRAINT fk_animal FOREIGN KEY (id_animal) REFERENCES Animal(id_animal);
ALTER TABLE Ocorrencia ADD CONSTRAINT fk_tipo_residuo FOREIGN KEY (id_tipo_residuo) REFERENCES Tipo_Residuo(id_tipo_residuo);

-- Fk na tabela Form_Feedback
ALTER TABLE Form_Feedback ADD CONSTRAINT fk_usuario_feedback FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario);


-- Inserção de dados

-- Inserção de dados na tabela Tipo_Usuario
INSERT INTO Tipo_Usuario (desc_tipo_usuario) VALUES ('Administrador');
INSERT INTO Tipo_Usuario (desc_tipo_usuario) VALUES ('Usuário');

-- Inserção de dados na tabela Tipo_Login
INSERT INTO Tipo_Login (desc_tipo_login) VALUES ('Email e Senha');
INSERT INTO Tipo_Login (desc_tipo_login) VALUES ('Google');
INSERT INTO Tipo_Login (desc_tipo_login) VALUES ('Facebook');

-- Inserção de dados na tabela Condicao_Animal
INSERT INTO Condicao_Animal (desc_condicao) VALUES ('Saudável');
INSERT INTO Condicao_Animal (desc_condicao) VALUES ('Doente');
INSERT INTO Condicao_Animal (desc_condicao) VALUES ('Ferido');
INSERT INTO Condicao_Animal (desc_condicao) VALUES ('Morto');

-- Inserção de dados na tabela Tipo_Residuo
INSERT INTO Tipo_Residuo (nome_tipo_residuo, desc_tipo_residuo) VALUES ('Plástico', 'Resíduos plásticos');
INSERT INTO Tipo_Residuo (nome_tipo_residuo, desc_tipo_residuo) VALUES ('Metal', 'Resíduos metálicos');
INSERT INTO Tipo_Residuo (nome_tipo_residuo, desc_tipo_residuo) VALUES ('Vidro', 'Resíduos de vidro');
INSERT INTO Tipo_Residuo (nome_tipo_residuo, desc_tipo_residuo) VALUES ('Papel', 'Resíduos de papel');

COMMIT;

-- Verificando as inserções com SELECT
SELECT * FROM Tipo_Usuario;
SELECT * FROM Tipo_Login;
SELECT * FROM Condicao_Animal;
SELECT * FROM Tipo_Residuo;

-- Exemplos de Atualização de dados (UPDATE)
-- Alteração da descrição do tipo de resíduo de id 1
UPDATE Tipo_Residuo
SET desc_tipo_residuo = 'Resíduos plásticos recicláveis'
WHERE id_tipo_residuo = 1;

COMMIT;

-- Exemplos de Remoção de dados (DELETE)
-- Deletar registros da tabela Tipo_Residuo onde nome_tipo_residuo é 'Papel'
DELETE FROM Tipo_Residuo WHERE nome_tipo_residuo = 'Papel';

COMMIT;
