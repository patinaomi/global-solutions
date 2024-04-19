CREATE TABLE contato (
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

ALTER TABLE contato ADD CONSTRAINT contato_pk PRIMARY KEY ( id_con );

CREATE TABLE estado (
    id_est    INTEGER NOT NULL,
    sigla_est CHAR(2) NOT NULL
);

ALTER TABLE estado ADD CONSTRAINT estado_pk PRIMARY KEY ( id_est );

CREATE TABLE genero (
    id_gen   INTEGER NOT NULL,
    desc_gen VARCHAR2(60) NOT NULL
);

ALTER TABLE genero ADD CONSTRAINT genero_pk PRIMARY KEY ( id_gen );

CREATE TABLE login (
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

ALTER TABLE login ADD CONSTRAINT login_pk PRIMARY KEY ( id_login );

CREATE TABLE produto (
    id_prod   INTEGER NOT NULL,
    nome_prod VARCHAR2(80) NOT NULL,
    desc_prod VARCHAR2(600) NOT NULL,
    cat_prod  VARCHAR2(80) NOT NULL
);

ALTER TABLE produto ADD CONSTRAINT produto_pk PRIMARY KEY ( id_prod );

CREATE TABLE questionario (
    id_ques            INTEGER NOT NULL,
    nome_ques          VARCHAR2(80),
    tel_ques           NUMBER(20),
    seg_ques           VARCHAR2(80),
    conhece_sales_ques CHAR(1),
    nec_emp_ques       VARCHAR2(300),
    produto_id_prod    INTEGER NOT NULL
);

ALTER TABLE questionario ADD CONSTRAINT questionario_pk PRIMARY KEY ( id_ques );

CREATE TABLE tamanho_empresa (
    id_tam_emp   INTEGER NOT NULL,
    desc_tam_emp VARCHAR2(40) NOT NULL
);

ALTER TABLE tamanho_empresa ADD CONSTRAINT tamanho_empresa_pk PRIMARY KEY ( id_tam_emp );

CREATE TABLE visitante (
    id_visit        INTEGER NOT NULL,
    tempo_ent_visit TIMESTAMP(0) NOT NULL,
    tempo_sai_visit TIMESTAMP(0) NOT NULL
);

ALTER TABLE visitante ADD CONSTRAINT visitante_pk PRIMARY KEY ( id_visit );

ALTER TABLE contato
    ADD CONSTRAINT contato_estado_fk FOREIGN KEY ( estado_id_est )
        REFERENCES estado ( id_est );

ALTER TABLE contato
    ADD CONSTRAINT contato_produto_fk FOREIGN KEY ( produto_id_prod )
        REFERENCES produto ( id_prod );

ALTER TABLE contato
    ADD CONSTRAINT contato_tamanho_empresa_fk FOREIGN KEY ( tamanho_empresa_id_tam_emp )
        REFERENCES tamanho_empresa ( id_tam_emp );

ALTER TABLE contato
    ADD CONSTRAINT contato_visitante_fk FOREIGN KEY ( visitante_id_visit )
        REFERENCES visitante ( id_visit );

ALTER TABLE login
    ADD CONSTRAINT login_estado_fk FOREIGN KEY ( estado_id_est )
        REFERENCES estado ( id_est );

ALTER TABLE login
    ADD CONSTRAINT login_genero_fk FOREIGN KEY ( genero_id_gen )
        REFERENCES genero ( id_gen );

ALTER TABLE login
    ADD CONSTRAINT login_tamanho_empresa_fk FOREIGN KEY ( tamanho_empresa_id_tam_emp )
        REFERENCES tamanho_empresa ( id_tam_emp );

ALTER TABLE login
    ADD CONSTRAINT login_visitante_fk FOREIGN KEY ( visitante_id_visit )
        REFERENCES visitante ( id_visit );

ALTER TABLE questionario
    ADD CONSTRAINT questionario_produto_fk FOREIGN KEY ( produto_id_prod )
        REFERENCES produto ( id_prod );