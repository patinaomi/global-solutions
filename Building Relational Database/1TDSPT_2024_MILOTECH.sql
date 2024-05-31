--AQUI SERA O CODIGO OFICIAL PARA A ENTREGA

-- Nome dos Integrantes: 
-- Claudio Silva Bispo RM553472
-- Patricia Naomi Yamagishi RM552981
-- Sabrina da Motta Café RM553568

-- Deletar tabelas caso já existam
DROP TABLE FORMS_FEEDBACK CASCADE CONSTRAINTS;
DROP TABLE INVESTIDOR CASCADE CONSTRAINTS;
DROP TABLE LOGIN CASCADE CONSTRAINTS;
DROP TABLE OCORRENCIA CASCADE CONSTRAINTS;
DROP TABLE ANIMAL CASCADE CONSTRAINTS;
DROP TABLE CONDICAOANIMAL CASCADE CONSTRAINTS;
DROP TABLE NEWSLETTER CASCADE CONSTRAINTS;
DROP TABLE USUARIO CASCADE CONSTRAINTS;
DROP TABLE TIPOLOGIN CASCADE CONSTRAINTS;
DROP TABLE TIPORESIDUO CASCADE CONSTRAINTS;
DROP TABLE TIPOUSUARIO CASCADE CONSTRAINTS;

-- Criação das tabelas

-- TipoUsuario
CREATE TABLE TIPOUSUARIO (
    id_tipo_usuario INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
    descricao VARCHAR2(255) NOT NULL
);
ALTER TABLE TIPOUSUARIO ADD CONSTRAINT tipousuario_pk PRIMARY KEY(id_tipo_usuario);

-- Usuario
CREATE TABLE USUARIO (
    id_usuario INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
    nome VARCHAR2(255) NOT NULL,
    sobrenome VARCHAR2(255) NOT NULL,
    email VARCHAR2(255) CONSTRAINT email_unique UNIQUE NOT NULL,
    senha VARCHAR2(255) NOT NULL,
    id_tipo_usuario INTEGER NOT NULL,
    telefone VARCHAR2(255) NOT NULL,
    CONSTRAINT usuario_pk PRIMARY KEY(id_usuario)
);
ALTER TABLE USUARIO ADD CONSTRAINT fk_tipo_usuario FOREIGN KEY (id_tipo_usuario) REFERENCES TIPOUSUARIO(id_tipo_usuario);

-- TipoLogin
CREATE TABLE TIPOLOGIN (
    id_tipo_login INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
    descricao VARCHAR2(255) NOT NULL
);
ALTER TABLE TIPOLOGIN ADD CONSTRAINT tipologin_pk PRIMARY KEY(id_tipo_login);

-- Login
CREATE TABLE LOGIN (
    id_login INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
    id_usuario INTEGER NOT NULL,
    email VARCHAR2(255) NOT NULL,
    senha VARCHAR2(255) NOT NULL,
    data_login DATE NOT NULL,
    id_tipo_login INTEGER NOT NULL,
    CONSTRAINT login_pk PRIMARY KEY(id_login)
);
ALTER TABLE LOGIN ADD CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES USUARIO(id_usuario);
ALTER TABLE LOGIN ADD CONSTRAINT fk_tipo_login FOREIGN KEY (id_tipo_login) REFERENCES TIPOLOGIN(id_tipo_login);

-- CondicaoAnimal
CREATE TABLE CONDICAOANIMAL (
    id_condicao INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
    condicao VARCHAR2(255) NOT NULL
);
ALTER TABLE CONDICAOANIMAL ADD CONSTRAINT condicaoanimal_pk PRIMARY KEY(id_condicao);

-- Animal
CREATE TABLE ANIMAL (
    id_animal INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
    nome_animal VARCHAR2(255),
    especie_animal VARCHAR2(255),
    descricao_animal VARCHAR2(255),
    id_condicao INTEGER,
    CONSTRAINT animal_pk PRIMARY KEY(id_animal)
);
ALTER TABLE ANIMAL ADD CONSTRAINT fk_id_condicao FOREIGN KEY (id_condicao) REFERENCES CONDICAOANIMAL(id_condicao);

-- TipoResiduo
CREATE TABLE TIPORESIDUO (
    id_tipo_residuo INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
    tipo VARCHAR2(255) NOT NULL,
    descricao VARCHAR2(255) NOT NULL
);
ALTER TABLE TIPORESIDUO ADD CONSTRAINT tiporesiduo_pk PRIMARY KEY(id_tipo_residuo);

-- Ocorrencia
CREATE TABLE OCORRENCIA (
    id_solicitacao INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
    id_usuario INTEGER NOT NULL,
    descricao VARCHAR2(255),
    telefone VARCHAR2(255) NOT NULL,
    imagem VARCHAR2(255),
    longitude VARCHAR2(255),
    latitude VARCHAR2(255),
    data_solicitacao TIMESTAMP NOT NULL,
    id_animal INTEGER,
    id_tipo_residuo INTEGER,
    condicao VARCHAR2(255) NOT NULL,
    CONSTRAINT ocorrencia_pk PRIMARY KEY(id_solicitacao)
);
ALTER TABLE OCORRENCIA ADD CONSTRAINT fk_usuario_ocorrencia FOREIGN KEY (id_usuario) REFERENCES USUARIO(id_usuario);
ALTER TABLE OCORRENCIA ADD CONSTRAINT fk_animal FOREIGN KEY (id_animal) REFERENCES ANIMAL(id_animal);
ALTER TABLE OCORRENCIA ADD CONSTRAINT fk_tipo_residuo FOREIGN KEY (id_tipo_residuo) REFERENCES TIPORESIDUO(id_tipo_residuo);

-- Investidor
CREATE TABLE INVESTIDOR (
    id_investidor INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
    nome VARCHAR2(255) NOT NULL,
    email VARCHAR2(255) NOT NULL,
    telefone VARCHAR2(255) NOT NULL,
    tipo_investidor VARCHAR2(255) NOT NULL,
    nome_empresa VARCHAR2(255) NOT NULL,
    quantia_contribuida DECIMAL(10, 2) NOT NULL,
    data_investimento TIMESTAMP NOT NULL,
    mensagem VARCHAR2(255) NOT NULL,
    CONSTRAINT investidor_pk PRIMARY KEY(id_investidor)
);

-- Forms_Feedback
CREATE TABLE FORMS_FEEDBACK (
    id_feedback INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
    usuario_id INTEGER NOT NULL,
    nome VARCHAR2(255) NOT NULL,
    telefone VARCHAR2(255) NOT NULL,
    email VARCHAR2(255) NOT NULL,
    descricao VARCHAR2(255) NOT NULL,
    data_feedback DATE NOT NULL,
    CONSTRAINT forms_feedback_pk PRIMARY KEY(id_feedback)
);
ALTER TABLE FORMS_FEEDBACK ADD CONSTRAINT fk_usuario_feedback FOREIGN KEY (usuario_id) REFERENCES USUARIO(id_usuario);

-- Newsletter
CREATE TABLE NEWSLETTER (
    id_news INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
    email VARCHAR2(255) NOT NULL,
    data_envio DATE NOT NULL,
    status VARCHAR2(255) NOT NULL,
    CONSTRAINT newsletter_pk PRIMARY KEY(id_news)
);

-- Inserção de dados

-- Inserção de dados na tabela TipoUsuario
INSERT INTO TIPOUSUARIO (descricao) VALUES ('Administrador');
INSERT INTO TIPOUSUARIO (descricao) VALUES ('Usuário');

-- Inserção de dados na tabela TipoLogin
INSERT INTO TIPOLOGIN (descricao) VALUES ('Email e Senha');
INSERT INTO TIPOLOGIN (descricao) VALUES ('Google');
INSERT INTO TIPOLOGIN (descricao) VALUES ('Facebook');

-- Inserção de dados na tabela CondicaoAnimal
INSERT INTO CONDICAOANIMAL (condicao) VALUES ('Saudável');
INSERT INTO CONDICAOANIMAL (condicao) VALUES ('Doente');
INSERT INTO CONDICAOANIMAL (condicao) VALUES ('Ferido');
INSERT INTO CONDICAOANIMAL (condicao) VALUES ('Morto');

-- Inserção de dados na tabela TipoResiduo
INSERT INTO TIPORESIDUO (tipo, descricao) VALUES ('Plástico', 'Resíduos plásticos');
INSERT INTO TIPORESIDUO (tipo, descricao) VALUES ('Metal', 'Resíduos metálicos');
INSERT INTO TIPORESIDUO (tipo, descricao) VALUES ('Vidro', 'Resíduos de vidro');
INSERT INTO TIPORESIDUO (tipo, descricao) VALUES ('Papel', 'Resíduos de papel');

COMMIT;

-- Verificando as inserções com SELECT
SELECT * FROM TIPOUSUARIO;
SELECT * FROM TIPOLOGIN;
SELECT * FROM CONDICAOANIMAL;
SELECT * FROM TIPORESIDUO;

-- Exemplos de Atualização de dados (UPDATE)
-- Alteração da descrição do tipo de resíduo de id 1
UPDATE TIPORESIDUO
SET descricao = 'Resíduos plásticos recicláveis'
WHERE id_tipo_residuo = 1;

COMMIT;

-- Exemplos de Remoção de dados (DELETE)
-- Deletar registros da tabela TipoResiduo onde tipo é 'Papel'
DELETE FROM TIPORESIDUO WHERE tipo = 'Papel';

COMMIT;

