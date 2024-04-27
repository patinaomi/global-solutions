-- INTEGRANTES
-- Claudio Bispo RM: 553472
-- Patricia Naomi RM:552981
-- Sara Ingrid RM: 554021

-- Caso a tabela já exista ele será deletada
DROP TABLE Contato CASCADE CONSTRAINTS;
DROP TABLE Estado CASCADE CONSTRAINTS;
DROP TABLE Genero CASCADE CONSTRAINTS;
DROP TABLE Login CASCADE CONSTRAINTS;
DROP TABLE Produto CASCADE CONSTRAINTS;
DROP TABLE Questionario CASCADE CONSTRAINTS;
DROP TABLE Tamanho_Empresa CASCADE CONSTRAINTS;
DROP TABLE Visitante CASCADE CONSTRAINTS;

-- Criação das tabelas

-- Criação da tabela Contato
CREATE TABLE Contato (
    id_con                     INTEGER NOT NULL,
    nome_con                   VARCHAR2(60) NOT NULL,
    email_con                  VARCHAR2(70) NOT NULL,
    tel_con                    NUMBER(20),
    seg_con                    VARCHAR2(70),
    cargo_con                  VARCHAR2(80),
    msg_con                    VARCHAR2(600),
    produto_id_prod            INTEGER NOT NULL,
    visitante_id_visit         INTEGER NOT NULL,
    estado_id_est              INTEGER NOT NULL,
    tamanho_empresa_id_tam_emp INTEGER NOT NULL
);

-- Primary Key da tabela Contato
ALTER TABLE Contato ADD CONSTRAINT contato_pk PRIMARY KEY ( id_con );

-- Criação da tabela Estado
CREATE TABLE Estado (
    id_est    INTEGER NOT NULL,
    sigla_est CHAR(2) NOT NULL
);

-- Primary Key da tabela Estado
ALTER TABLE Estado ADD CONSTRAINT estado_pk PRIMARY KEY ( id_est );

-- Criação da tabela Genero
CREATE TABLE Genero (
    id_gen   INTEGER NOT NULL,
    desc_gen VARCHAR2(60) NOT NULL
);

-- Primary Key da tabela Genero
ALTER TABLE Genero ADD CONSTRAINT genero_pk PRIMARY KEY ( id_gen );

-- Criação da tabela Login
CREATE TABLE Login (
    id_login                   INTEGER NOT NULL,
    nome_login                 VARCHAR2(60) NOT NULL,
    sobrenome_login            VARCHAR2(60) NOT NULL,
    email_login                VARCHAR2(60) NOT NULL,
    emp_login                  VARCHAR2(60) NOT NULL,
    funcao_login               VARCHAR2(60) NOT NULL,
    senha_login                VARCHAR2(60) NOT NULL,
    tamanho_empresa_id_tam_emp INTEGER NOT NULL,
    estado_id_est              INTEGER NOT NULL,
    genero_id_gen              INTEGER NOT NULL,
    visitante_id_visit         INTEGER NOT NULL
);

-- Primary Key da tabela Login
ALTER TABLE Login ADD CONSTRAINT login_pk PRIMARY KEY ( id_login );

-- Criação da tabela Produto
CREATE TABLE Produto (
    id_prod   INTEGER NOT NULL,
    nome_prod VARCHAR2(80) NOT NULL,
    desc_prod VARCHAR2(600) NOT NULL,
    cat_prod  VARCHAR2(80) NOT NULL
);

-- Primary Key da tabela Produto
ALTER TABLE Produto ADD CONSTRAINT produto_pk PRIMARY KEY ( id_prod );

-- Criação da tabela Questionario
CREATE TABLE Questionario (
    id_ques            INTEGER NOT NULL,
    nome_ques          VARCHAR2(80),
    tel_ques           NUMBER(20),
    seg_ques           VARCHAR2(80),
    conhece_sales_ques CHAR(1),
    nec_emp_ques       VARCHAR2(300),
    produto_id_prod    INTEGER NOT NULL
);

-- Primary Key da tabela Questionario
ALTER TABLE Questionario ADD CONSTRAINT questionario_pk PRIMARY KEY ( id_ques );

-- Criação da tabela Tamanho_Empresa
CREATE TABLE Tamanho_Empresa (
    id_tam_emp   INTEGER NOT NULL,
    desc_tam_emp VARCHAR2(40) NOT NULL
);

-- Primary Key da tabela Tamanho_Empresa
ALTER TABLE Tamanho_Empresa ADD CONSTRAINT tamanho_empresa_pk PRIMARY KEY ( id_tam_emp );

-- Criação da tabela Visitante
CREATE TABLE Visitante (
    id_visit        INTEGER NOT NULL,
    tempo_ent_visit TIMESTAMP(0) NOT NULL,
    tempo_sai_visit TIMESTAMP(0) NOT NULL
);

-- Primary Key da tabela Visitante
ALTER TABLE Visitante ADD CONSTRAINT visitante_pk PRIMARY KEY ( id_visit );

-- Inserção de Foreign Key nas tabelas

-- FK da tabela Contato
ALTER TABLE Contato
    ADD CONSTRAINT contato_estado_fk FOREIGN KEY ( estado_id_est )
        REFERENCES Estado ( id_est );

ALTER TABLE Contato
    ADD CONSTRAINT contato_produto_fk FOREIGN KEY ( produto_id_prod )
        REFERENCES Produto ( id_prod );

ALTER TABLE Contato
    ADD CONSTRAINT contato_tamanho_empresa_fk FOREIGN KEY ( tamanho_empresa_id_tam_emp )
        REFERENCES Tamanho_Empresa ( id_tam_emp );

ALTER TABLE Contato
    ADD CONSTRAINT contato_visitante_fk FOREIGN KEY ( visitante_id_visit )
        REFERENCES Visitante ( id_visit );

ALTER TABLE Login
    ADD CONSTRAINT login_estado_fk FOREIGN KEY ( estado_id_est )
        REFERENCES Estado ( id_est );

ALTER TABLE Login
    ADD CONSTRAINT login_genero_fk FOREIGN KEY ( genero_id_gen )
        REFERENCES Genero ( id_gen );

ALTER TABLE Login
    ADD CONSTRAINT login_tamanho_empresa_fk FOREIGN KEY ( tamanho_empresa_id_tam_emp )
        REFERENCES Tamanho_Empresa ( id_tam_emp );

ALTER TABLE Login
    ADD CONSTRAINT login_visitante_fk FOREIGN KEY ( visitante_id_visit )
        REFERENCES Visitante ( id_visit );

ALTER TABLE Questionario
    ADD CONSTRAINT questionario_produto_fk FOREIGN KEY ( produto_id_prod )
        REFERENCES Produto ( id_prod );

