
--AQUI SERA O CODIGO OFICIAL PARA A ENTREGA

-- INTEGRANTES

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


-- DDL -- Data Definition Language

-- Criação das tabelas

-- TipoUsuario
CREATE TABLE TIPOUSUARIO (
    id_tipo_usuario INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1) NOT NULL,
    descricao VARCHAR2(255) NOT NULL,
    CONSTRAINT tipousuario_pk PRIMARY KEY(id_tipo_usuario)
);

-- Usuario
CREATE TABLE USUARIO (
    id_usuario INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1) NOT NULL,
    nome VARCHAR2(255) NOT NULL,
    sobrenome VARCHAR2(255) NOT NULL,
    email VARCHAR2(255) CONSTRAINT email_unique UNIQUE NOT NULL,
    senha VARCHAR2(255) NOT NULL,
    telefone VARCHAR2(255) NOT NULL,
    id_tipo_usuario INTEGER NOT NULL,
    CONSTRAINT usuario_pk PRIMARY KEY(id_usuario)
);
ALTER TABLE USUARIO ADD CONSTRAINT fk_tipo_usuario FOREIGN KEY (id_tipo_usuario) REFERENCES TIPOUSUARIO(id_tipo_usuario);


-- TipoLogin
CREATE TABLE TIPOLOGIN (
    id_tipo_login INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1) NOT NULL,
    descricao VARCHAR2(255) NOT NULL,
    CONSTRAINT tipologin_pk PRIMARY KEY(id_tipo_login)
);

-- Login
CREATE TABLE LOGIN (
    id_login INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1) NOT NULL,
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
    id_condicao INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1) NOT NULL,
    condicao VARCHAR2(255) NOT NULL,
    CONSTRAINT condicaoanimal_pk PRIMARY KEY(id_condicao)
);

-- Animal
CREATE TABLE ANIMAL (
    id_animal INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1) NOT NULL,
    nome_animal VARCHAR2(255),
    especie_animal VARCHAR2(255),
    descricao_animal VARCHAR2(255),
    id_condicao INTEGER,
    CONSTRAINT animal_pk PRIMARY KEY(id_animal)
);
ALTER TABLE ANIMAL ADD CONSTRAINT fk_id_condicao FOREIGN KEY (id_condicao) REFERENCES CONDICAOANIMAL(id_condicao);


-- TipoResiduo
CREATE TABLE TIPORESIDUO (
    id_tipo_residuo INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1) NOT NULL,
    tipo VARCHAR2(255) NOT NULL,
    descricao VARCHAR2(255) NOT NULL,
    CONSTRAINT tiporesiduo_pk PRIMARY KEY(id_tipo_residuo)
);

-- Ocorrencia
CREATE TABLE OCORRENCIA (
    id_solicitacao INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1) NOT NULL,
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
    id_investidor INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1) NOT NULL,
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
    id_feedback INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1) NOT NULL,
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
    id_news INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1) NOT NULL,
    email VARCHAR2(255) NOT NULL,
    data_envio DATE NOT NULL,
    status VARCHAR2(255) NOT NULL,
    CONSTRAINT newsletter_pk PRIMARY KEY(id_news)
);

COMMIT;

-- DML -- Data Manipulation Language

-- Inserção de dados

-- Inserção de dados na tabela TipoUsuario
INSERT INTO TIPOUSUARIO (descricao) VALUES ('Administrador');
INSERT INTO TIPOUSUARIO (descricao) VALUES ('Usuário');
INSERT INTO TIPOUSUARIO (descricao) VALUES ('Moderador');
INSERT INTO TIPOUSUARIO (descricao) VALUES ('Visitante');
INSERT INTO TIPOUSUARIO (descricao) VALUES ('Gerente');
INSERT INTO TIPOUSUARIO (descricao) VALUES ('Analista');
INSERT INTO TIPOUSUARIO (descricao) VALUES ('Desenvolvedor');
INSERT INTO TIPOUSUARIO (descricao) VALUES ('Tester');
INSERT INTO TIPOUSUARIO (descricao) VALUES ('Designer');
INSERT INTO TIPOUSUARIO (descricao) VALUES ('Support');

-- Inserção de dados na tabela TipoLogin
INSERT INTO TIPOLOGIN (descricao) VALUES ('Email e Senha');
INSERT INTO TIPOLOGIN (descricao) VALUES ('Google');
INSERT INTO TIPOLOGIN (descricao) VALUES ('Facebook');
INSERT INTO TIPOLOGIN (descricao) VALUES ('Twitter');
INSERT INTO TIPOLOGIN (descricao) VALUES ('LinkedIn');
INSERT INTO TIPOLOGIN (descricao) VALUES ('GitHub');
INSERT INTO TIPOLOGIN (descricao) VALUES ('Microsoft');
INSERT INTO TIPOLOGIN (descricao) VALUES ('Apple');
INSERT INTO TIPOLOGIN (descricao) VALUES ('Yahoo');
INSERT INTO TIPOLOGIN (descricao) VALUES ('Amazon');

-- Inserção de dados na tabela CondicaoAnimal
INSERT INTO CONDICAOANIMAL (condicao) VALUES ('Saudável');
INSERT INTO CONDICAOANIMAL (condicao) VALUES ('Doente');
INSERT INTO CONDICAOANIMAL (condicao) VALUES ('Ferido');
INSERT INTO CONDICAOANIMAL (condicao) VALUES ('Morto');
INSERT INTO CONDICAOANIMAL (condicao) VALUES ('Resgatado');
INSERT INTO CONDICAOANIMAL (condicao) VALUES ('Reabilitado');
INSERT INTO CONDICAOANIMAL (condicao) VALUES ('Em Tratamento');
INSERT INTO CONDICAOANIMAL (condicao) VALUES ('Adotado');
INSERT INTO CONDICAOANIMAL (condicao) VALUES ('Desaparecido');
INSERT INTO CONDICAOANIMAL (condicao) VALUES ('Em Perigo');

-- Inserção de dados na tabela Animal
INSERT INTO ANIMAL (nome_animal, especie_animal, descricao_animal, id_condicao) VALUES ('Tartaruga', 'Chelonia mydas', 'Tartaruga verde', 1);
INSERT INTO ANIMAL (nome_animal, especie_animal, descricao_animal, id_condicao) VALUES ('Golfinho', 'Delphinus delphis', 'Golfinho comum', 2);
INSERT INTO ANIMAL (nome_animal, especie_animal, descricao_animal, id_condicao) VALUES ('Baleia', 'Balaenoptera musculus', 'Baleia azul', 3);
INSERT INTO ANIMAL (nome_animal, especie_animal, descricao_animal, id_condicao) VALUES ('Foca', 'Phoca vitulina', 'Foca comum', 4);
INSERT INTO ANIMAL (nome_animal, especie_animal, descricao_animal, id_condicao) VALUES ('Peixe-boi', 'Trichechus manatus', 'Peixe-boi marinho', 5);
INSERT INTO ANIMAL (nome_animal, especie_animal, descricao_animal, id_condicao) VALUES ('Pinguim', 'Aptenodytes forsteri', 'Pinguim-imperador', 6);
INSERT INTO ANIMAL (nome_animal, especie_animal, descricao_animal, id_condicao) VALUES ('Tubarão', 'Carcharodon carcharias', 'Tubarão-branco', 7);
INSERT INTO ANIMAL (nome_animal, especie_animal, descricao_animal, id_condicao) VALUES ('Polvo', 'Octopus vulgaris', 'Polvo comum', 8);
INSERT INTO ANIMAL (nome_animal, especie_animal, descricao_animal, id_condicao) VALUES ('Caranguejo', 'Callinectes sapidus', 'Caranguejo-azul', 9);
INSERT INTO ANIMAL (nome_animal, especie_animal, descricao_animal, id_condicao) VALUES ('Camarão', 'Litopenaeus vannamei', 'Camarão-branco', 10);

-- Inserção de dados na tabela TipoResiduo
INSERT INTO TIPORESIDUO (tipo, descricao) VALUES ('Plástico', 'Resíduos plásticos');
INSERT INTO TIPORESIDUO (tipo, descricao) VALUES ('Metal', 'Resíduos metálicos');
INSERT INTO TIPORESIDUO (tipo, descricao) VALUES ('Vidro', 'Resíduos de vidro');
INSERT INTO TIPORESIDUO (tipo, descricao) VALUES ('Papel', 'Resíduos de papel');
INSERT INTO TIPORESIDUO (tipo, descricao) VALUES ('Orgânico', 'Resíduos orgânicos');
INSERT INTO TIPORESIDUO (tipo, descricao) VALUES ('Eletrônico', 'Resíduos eletrônicos');
INSERT INTO TIPORESIDUO (tipo, descricao) VALUES ('Madeira', 'Resíduos de madeira');
INSERT INTO TIPORESIDUO (tipo, descricao) VALUES ('Têxtil', 'Resíduos têxteis');
INSERT INTO TIPORESIDUO (tipo, descricao) VALUES ('Borracha', 'Resíduos de borracha');
INSERT INTO TIPORESIDUO (tipo, descricao) VALUES ('Misto', 'Resíduos mistos');

-- Inserção de dados na tabela Usuario
INSERT INTO USUARIO (nome, sobrenome, email, senha, id_tipo_usuario, telefone) VALUES ('João', 'Silva', 'joao.silva@example.com', 'senha123', 1, '123456789');
INSERT INTO USUARIO (nome, sobrenome, email, senha, id_tipo_usuario, telefone) VALUES ('Maria', 'Oliveira', 'maria.oliveira@example.com', 'senha456', 2, '987654321');
INSERT INTO USUARIO (nome, sobrenome, email, senha, id_tipo_usuario, telefone) VALUES ('Pedro', 'Santos', 'pedro.santos@example.com', 'senha789', 3, '456789123');
INSERT INTO USUARIO (nome, sobrenome, email, senha, id_tipo_usuario, telefone) VALUES ('Ana', 'Costa', 'ana.costa@example.com', 'senha101', 4, '321654987');
INSERT INTO USUARIO (nome, sobrenome, email, senha, id_tipo_usuario, telefone) VALUES ('Carlos', 'Pereira', 'carlos.pereira@example.com', 'senha202', 5, '654321789');
INSERT INTO USUARIO (nome, sobrenome, email, senha, id_tipo_usuario, telefone) VALUES ('Fernanda', 'Lima', 'fernanda.lima@example.com', 'senha303', 6, '987123654');
INSERT INTO USUARIO (nome, sobrenome, email, senha, id_tipo_usuario, telefone) VALUES ('Ricardo', 'Alves', 'ricardo.alves@example.com', 'senha404', 7, '789654123');
INSERT INTO USUARIO (nome, sobrenome, email, senha, id_tipo_usuario, telefone) VALUES ('Paula', 'Mendes', 'paula.mendes@example.com', 'senha505', 8, '123789456');
INSERT INTO USUARIO (nome, sobrenome, email, senha, id_tipo_usuario, telefone) VALUES ('Bruno', 'Souza', 'bruno.souza@example.com', 'senha606', 9, '654987321');
INSERT INTO USUARIO (nome, sobrenome, email, senha, id_tipo_usuario, telefone) VALUES ('Juliana', 'Rodrigues', 'juliana.rodrigues@example.com', 'senha707', 10, '321987654');

-- Inserção de dados na tabela Login
INSERT INTO LOGIN (id_usuario, email, senha, data_login, id_tipo_login) VALUES (1, 'joao.silva@example.com', 'senha123', SYSDATE, 1);
INSERT INTO LOGIN (id_usuario, email, senha, data_login, id_tipo_login) VALUES (2, 'maria.oliveira@example.com', 'senha456', SYSDATE, 2);
INSERT INTO LOGIN (id_usuario, email, senha, data_login, id_tipo_login) VALUES (3, 'pedro.santos@example.com', 'senha789', SYSDATE, 3);
INSERT INTO LOGIN (id_usuario, email, senha, data_login, id_tipo_login) VALUES (4, 'ana.costa@example.com', 'senha101', SYSDATE, 4);
INSERT INTO LOGIN (id_usuario, email, senha, data_login, id_tipo_login) VALUES (5, 'carlos.pereira@example.com', 'senha202', SYSDATE, 5);
INSERT INTO LOGIN (id_usuario, email, senha, data_login, id_tipo_login) VALUES (6, 'fernanda.lima@example.com', 'senha303', SYSDATE, 6);
INSERT INTO LOGIN (id_usuario, email, senha, data_login, id_tipo_login) VALUES (7, 'ricardo.alves@example.com', 'senha404', SYSDATE, 7);
INSERT INTO LOGIN (id_usuario, email, senha, data_login, id_tipo_login) VALUES (8, 'paula.mendes@example.com', 'senha505', SYSDATE, 8);
INSERT INTO LOGIN (id_usuario, email, senha, data_login, id_tipo_login) VALUES (9, 'bruno.souza@example.com', 'senha606', SYSDATE, 9);
INSERT INTO LOGIN (id_usuario, email, senha, data_login, id_tipo_login) VALUES (10, 'juliana.rodrigues@example.com', 'senha707', SYSDATE, 10);

-- Inserção de dados na tabela Ocorrencia
INSERT INTO OCORRENCIA (id_usuario, descricao, telefone, imagem, longitude, latitude, data_solicitacao, id_animal, id_tipo_residuo, condicao) VALUES (1, 'Animal ferido na praia', '123456789', 'imagem1.jpg', '45.123', '-23.456', SYSDATE, 1, 1, 'Em Perigo');
INSERT INTO OCORRENCIA (id_usuario, descricao, telefone, imagem, longitude, latitude, data_solicitacao, id_animal, id_tipo_residuo, condicao) VALUES (2, 'Resíduos plásticos no mar', '987654321', 'imagem2.jpg', '46.789', '-22.123', SYSDATE, 2, 2, 'Em Perigo');
INSERT INTO OCORRENCIA (id_usuario, descricao, telefone, imagem, longitude, latitude, data_solicitacao, id_animal, id_tipo_residuo, condicao) VALUES (3, 'Animal doente na praia', '456789123', 'imagem3.jpg', '47.456', '-21.789', SYSDATE, 3, 3, 'Doente');
INSERT INTO OCORRENCIA (id_usuario, descricao, telefone, imagem, longitude, latitude, data_solicitacao, id_animal, id_tipo_residuo, condicao) VALUES (4, 'Resíduos de vidro na areia', '321654987', 'imagem4.jpg', '48.123', '-20.456', SYSDATE, 4, 4, 'Em Perigo');
INSERT INTO OCORRENCIA (id_usuario, descricao, telefone, imagem, longitude, latitude, data_solicitacao, id_animal, id_tipo_residuo, condicao) VALUES (5, 'Animal morto encontrado', '654321789', 'imagem5.jpg', '49.789', '-19.123', SYSDATE, 5, 5, 'Morto');
INSERT INTO OCORRENCIA (id_usuario, descricao, telefone, imagem, longitude, latitude, data_solicitacao, id_animal, id_tipo_residuo, condicao) VALUES (6, 'Resíduos metálicos na praia', '987123654', 'imagem6.jpg', '50.456', '-18.789', SYSDATE, 6, 6, 'Em Perigo');
INSERT INTO OCORRENCIA (id_usuario, descricao, telefone, imagem, longitude, latitude, data_solicitacao, id_animal, id_tipo_residuo, condicao) VALUES (7, 'Animal resgatado', '789654123', 'imagem7.jpg', '51.123', '-17.456', SYSDATE, 7, 7, 'Resgatado');
INSERT INTO OCORRENCIA (id_usuario, descricao, telefone, imagem, longitude, latitude, data_solicitacao, id_animal, id_tipo_residuo, condicao) VALUES (8, 'Resíduos orgânicos na praia', '123789456', 'imagem8.jpg', '52.789', '-16.123', SYSDATE, 8, 8, 'Em Perigo');
INSERT INTO OCORRENCIA (id_usuario, descricao, telefone, imagem, longitude, latitude, data_solicitacao, id_animal, id_tipo_residuo, condicao) VALUES (9, 'Animal desaparecido', '654987321', 'imagem9.jpg', '53.456', '-15.789', SYSDATE, 9, 9, 'Desaparecido');
INSERT INTO OCORRENCIA (id_usuario, descricao, telefone, imagem, longitude, latitude, data_solicitacao, id_animal, id_tipo_residuo, condicao) VALUES (10, 'Resíduos mistos na praia', '321987654', 'imagem10.jpg', '54.123', '-14.456', SYSDATE, 10, 10, 'Em Perigo');

-- Inserção de dados na tabela Investidor
INSERT INTO INVESTIDOR (nome, email, telefone, tipo_investidor, nome_empresa, quantia_contribuida, data_investimento, mensagem) VALUES ('João Pimenta', 'joao.pimenta@example.com', '123456789', 'Anjo', 'Tech Solutions', 10000.00, SYSDATE, 'Investindo no futuro');
INSERT INTO INVESTIDOR (nome, email, telefone, tipo_investidor, nome_empresa, quantia_contribuida, data_investimento, mensagem) VALUES ('Maria Oliveira', 'maria.oliveira@example.com', '987654321', 'Venture Capital', 'Startup Inc', 20000.00, SYSDATE, 'Acreditamos em inovação');
INSERT INTO INVESTIDOR (nome, email, telefone, tipo_investidor, nome_empresa, quantia_contribuida, data_investimento, mensagem) VALUES ('Pedro Santos', 'pedro.santos@example.com', '456789123', 'Seed', 'New Ventures', 15000.00, SYSDATE, 'Apoiando novas ideias');
INSERT INTO INVESTIDOR (nome, email, telefone, tipo_investidor, nome_empresa, quantia_contribuida, data_investimento, mensagem) VALUES ('Ana Costa', 'ana.costa@example.com', '321654987', 'Private Equity', 'Investment Group', 50000.00, SYSDATE, 'Investindo em crescimento');
INSERT INTO INVESTIDOR (nome, email, telefone, tipo_investidor, nome_empresa, quantia_contribuida, data_investimento, mensagem) VALUES ('Carlos Pereira', 'carlos.pereira@example.com', '654321789', 'Corporate', 'Big Corp', 30000.00, SYSDATE, 'Parceria estratégica');
INSERT INTO INVESTIDOR (nome, email, telefone, tipo_investidor, nome_empresa, quantia_contribuida, data_investimento, mensagem) VALUES ('Fernanda Lima', 'fernanda.lima@example.com', '987123654', 'Anjo', 'Innovators', 25000.00, SYSDATE, 'Apoiando startups');
INSERT INTO INVESTIDOR (nome, email, telefone, tipo_investidor, nome_empresa, quantia_contribuida, data_investimento, mensagem) VALUES ('Ricardo Alves', 'ricardo.alves@example.com', '789654123', 'Venture Capital', 'Future Fund', 40000.00, SYSDATE, 'Investindo em tecnologia');
INSERT INTO INVESTIDOR (nome, email, telefone, tipo_investidor, nome_empresa, quantia_contribuida, data_investimento, mensagem) VALUES ('Paula Mendes', 'paula.mendes@example.com', '123789456', 'Seed', 'Early Stage', 12000.00, SYSDATE, 'Apoiando a inovação');
INSERT INTO INVESTIDOR (nome, email, telefone, tipo_investidor, nome_empresa, quantia_contribuida, data_investimento, mensagem) VALUES ('Bruno Souza', 'bruno.souza@example.com', '654987321', 'Private Equity', 'Equity Partners', 35000.00, SYSDATE, 'Investindo no crescimento');
INSERT INTO INVESTIDOR (nome, email, telefone, tipo_investidor, nome_empresa, quantia_contribuida, data_investimento, mensagem) VALUES ('Juliana Rodrigues', 'juliana.rodrigues@example.com', '321987654', 'Corporate', 'Tech Giants', 45000.00, SYSDATE, 'Parceria estratégica');

-- Inserção de dados na tabela Forms_Feedback
INSERT INTO FORMS_FEEDBACK (usuario_id, nome, telefone, email, descricao, data_feedback) VALUES (1, 'João Pimenta', '123456789', 'joao.pimenta@example.com', 'Ótimo serviço!', SYSDATE);
INSERT INTO FORMS_FEEDBACK (usuario_id, nome, telefone, email, descricao, data_feedback) VALUES (2, 'Maria Oliveira', '987654321', 'maria.oliveira@example.com', 'Muito bom!', SYSDATE);
INSERT INTO FORMS_FEEDBACK (usuario_id, nome, telefone, email, descricao, data_feedback) VALUES (3, 'Pedro Santos', '456789123', 'pedro.santos@example.com', 'Satisfatório', SYSDATE);
INSERT INTO FORMS_FEEDBACK (usuario_id, nome, telefone, email, descricao, data_feedback) VALUES (4, 'Ana Costa', '321654987', 'ana.costa@example.com', 'Excelente', SYSDATE);
INSERT INTO FORMS_FEEDBACK (usuario_id, nome, telefone, email, descricao, data_feedback) VALUES (5, 'Carlos Pereira', '654321789', 'carlos.pereira@example.com', 'Pode melhorar', SYSDATE);
INSERT INTO FORMS_FEEDBACK (usuario_id, nome, telefone, email, descricao, data_feedback) VALUES (6, 'Fernanda Lima', '987123654', 'fernanda.lima@example.com', 'Muito bom serviço', SYSDATE);
INSERT INTO FORMS_FEEDBACK (usuario_id, nome, telefone, email, descricao, data_feedback) VALUES (7, 'Ricardo Alves', '789654123', 'ricardo.alves@example.com', 'Satisfatório', SYSDATE);
INSERT INTO FORMS_FEEDBACK (usuario_id, nome, telefone, email, descricao, data_feedback) VALUES (8, 'Paula Mendes', '123789456', 'paula.mendes@example.com', 'Excelente serviço', SYSDATE);
INSERT INTO FORMS_FEEDBACK (usuario_id, nome, telefone, email, descricao, data_feedback) VALUES (9, 'Bruno Souza', '654987321', 'bruno.souza@example.com', 'Pode melhorar um pouco', SYSDATE);
INSERT INTO FORMS_FEEDBACK (usuario_id, nome, telefone, email, descricao, data_feedback) VALUES (10, 'Juliana Rodrigues', '321987654', 'juliana.rodrigues@example.com', 'Ótimo serviço, recomendo', SYSDATE);

-- Inserção de dados na tabela Newsletter
INSERT INTO NEWSLETTER (email, data_envio, status) VALUES ('joao.silva@example.com', SYSDATE, 'Enviado');
INSERT INTO NEWSLETTER (email, data_envio, status) VALUES ('maria.oliveira@example.com', SYSDATE, 'Enviado');
INSERT INTO NEWSLETTER (email, data_envio, status) VALUES ('pedro.santos@example.com', SYSDATE, 'Enviado');
INSERT INTO NEWSLETTER (email, data_envio, status) VALUES ('ana.costa@example.com', SYSDATE, 'Enviado');
INSERT INTO NEWSLETTER (email, data_envio, status) VALUES ('carlos.pereira@example.com', SYSDATE, 'Enviado');
INSERT INTO NEWSLETTER (email, data_envio, status) VALUES ('fernanda.lima@example.com', SYSDATE, 'Enviado');
INSERT INTO NEWSLETTER (email, data_envio, status) VALUES ('ricardo.alves@example.com', SYSDATE, 'Enviado');
INSERT INTO NEWSLETTER (email, data_envio, status) VALUES ('paula.mendes@example.com', SYSDATE, 'Enviado');
INSERT INTO NEWSLETTER (email, data_envio, status) VALUES ('bruno.souza@example.com', SYSDATE, 'Enviado');
INSERT INTO NEWSLETTER (email, data_envio, status) VALUES ('juliana.rodrigues@example.com', SYSDATE, 'Enviado');

COMMIT;

-- DQL - Relatóros

-- Listar todos os usuários ordenados pelo nome em ordem crescente
SELECT * 
FROM USUARIO
ORDER BY nome ASC;

-- 2. Relatório usando BETWEEN e LIKE

-- Listar ocorrências entre duas datas e que contenham a palavra 'Animal' na descrição
SELECT * 
FROM OCORRENCIA
WHERE data_solicitacao BETWEEN TO_DATE('2024-01-01', 'YYYY-MM-DD') AND TO_DATE('2024-12-31', 'YYYY-MM-DD')
AND descricao LIKE '%Animal%';

-- 3. Relatório usando função de caractere

-- Listar os emails dos usuários em letras maiúsculas
SELECT UPPER(email) AS email_maiusculo
FROM USUARIO;

-- 4. Relatório usando função de data

-- Listar os usuários e a diferença em dias desde o último login
SELECT u.nome, u.sobrenome, l.data_login, 
       ROUND(SYSDATE - l.data_login) AS dias_desde_ultimo_login
FROM USUARIO u
JOIN LOGIN l ON u.id_usuario = l.id_usuario
ORDER BY dias_desde_ultimo_login DESC;


-- 5. Relatório usando GROUP BY

-- Contagem de ocorrências por condição
SELECT condicao, COUNT(*) AS quantidade
FROM OCORRENCIA
GROUP BY condicao
ORDER BY quantidade DESC;


-- 6. Relatório usando junção de equivalência

-- Listar todas as ocorrências com informações do usuário
SELECT o.id_solicitacao, o.descricao, u.nome, u.sobrenome, u.email
FROM OCORRENCIA o
JOIN USUARIO u ON o.id_usuario = u.id_usuario;


-- 7. Relatório usando junção de diferença

-- Listar todos os usuários que não têm ocorrências registradas
SELECT u.id_usuario, u.nome, u.sobrenome, u.email
FROM USUARIO u
LEFT JOIN OCORRENCIA o ON u.id_usuario = o.id_usuario
WHERE o.id_usuario IS NULL;
