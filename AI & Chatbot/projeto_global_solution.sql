-- Criação da tabela Usuarios
CREATE TABLE USUARIO ( 
  id_usuario NUMBER PRIMARY KEY, 
  nome VARCHAR2(255) NOT NULL, 
  sobrenome VARCHAR2(255) NOT NULL, 
  email VARCHAR2(255) CONSTRAINT email_unique UNIQUE NOT NULL, 
  senha VARCHAR2(255) NOT NULL,
  id_tipo_usuario NUMBER NOT NULL,
   telefone VARCHAR2(255) NOT NULL,
  CONSTRAINT fk_tipo_usuario FOREIGN KEY (id_tipo_usuario) REFERENCES TIPOUSUARIO(id_tipo_usuario)
);

-- Criação da tabela TipoUsuario
--CREATE TABLE TIPOUSUARIO (
--  id_tipo_usuario NUMBER PRIMARY KEY,
--descricao VARCHAR2(255) NOT NULL
--);

-- Criação da tabela Login
CREATE TABLE LOGIN ( 
  id_login NUMBER PRIMARY KEY, 
  id_usuario NUMBER NOT NULL, --Chave estrangeira aqui
  email VARCHAR2(255) NOT NULL,  -- Precisa ter a confirmação do back
  senha VARCHAR2(255), -- Precisa ter a confirmação do back
  data_login DATE NOT NULL, 
  id_tipo_login NUMBER NOT NULL, -- Chave estrangeira aqui
  CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES USUARIO(id_usuario),
  CONSTRAINT fk_tipo_login FOREIGN KEY (id_tipo_login) REFERENCES TIPOLOGIN(id_tipo_login)
);

-- Criação da tabela TipoLogin
CREATE TABLE TIPOLOGIN (
  id_tipo_login NUMBER PRIMARY KEY, 
  descricao VARCHAR2(255) NOT NULL
);

-- Criação da tabela Ocorrencia
CREATE TABLE OCORRENCIA (
  id_solicitacao NUMBER PRIMARY KEY,
  id_usuario NUMBER NOT NULL,
  descricao VARCHAR2(255),
  telefone VARCHAR2(255) NOT NULL,
  imagem VARCHAR(255), --armazenar a URL da imagem
  longitude VARCHAR(255),
  latitude VARCHAR(255),
  --localizacao_origem VARCHAR2(255) NOT NULL,
  data_solicitacao TIMESTAMP NOT NULL,
  id_animal NUMBER,
  id_tipo_residuo NUMBER,
  condicao VARCHAR(255) NOT NULL,
  CONSTRAINT fk_usuario_ocorrencia FOREIGN KEY (id_usuario) REFERENCES USUARIO(id_usuario),
  CONSTRAINT fk_animal FOREIGN KEY (id_animal) REFERENCES ANIMAIS(id_animal),
  CONSTRAINT fk_tipo_residuo FOREIGN KEY (id_tipo_residuo) REFERENCES TIPORESIDUO(id_tipo_residuo)
);

-- Criação da tabela Tipos Residuo
--CREATE TABLE TIPORESIDUO (
--  id_tipo_residuo NUMBER PRIMARY KEY,
--  tipo VARCHAR2(255) NOT NULL,
--  descricao VARCHAR2(255) NOT NULL
--);

-- Criação da tabela Animais
CREATE TABLE ANIMAL (
  id_animal NUMBER PRIMARY KEY,
  nome_animal VARCHAR2(255),
  especie_animal VARCHAR2(255),
  descricao_animal VARCHAR2(255),
  CONSTRAINT fk_id_condicao FOREIGN KEY (id_condicao) REFERENCES CONDICAOANIMAL(id_condicao)
);

-- Criação da tabela com a Condição do Animal
CREATE TABLE CONDICAOANIMAL (
id_condicao NUMBER(02) PRIMARY KEY,
condicao VARCHAR(255) NOT NULL
);

-- Criação da tabela Parceiros
--CREATE TABLE PARCEIROS (
--  id_parceiro NUMBER PRIMARY KEY,
--  nome VARCHAR2(255) NOT NULL,
--  contato VARCHAR2(255),
--  tipo_parceria VARCHAR2(255) NOT NULL
--);

-- Criação da tabela Fornecedores
--CREATE TABLE FORNECEDOR (
--  id_fornecedor NUMBER PRIMARY KEY,
--  nome VARCHAR2(255) NOT NULL,
--  contato VARCHAR2(255),
--  tipo_servico VARCHAR2(255) NOT NULL
--);


-- Criação da tabela Investidores
CREATE TABLE INVESTIDOR (
  id_investidor NUMBER PRIMARY KEY,
  nome VARCHAR2(255) NOT NULL,
  email VARCHAR2(255) NOT NULL,
  telefone VARCHAR2(255) NOT NULL,
  tipo_investidor VARCHAR2(255) NOT NULL,
  nome_empresa VARCHAR2(255) NOT NULL,
  quantia_contribuida DECIMAL(10, 2) NOT NULL,
  data_investimento TIMESTAMP NOT NULL,
  mensagem VARCHAR2(255) NOT NULL
);

-- Criação da tabela Alertas
/*
CREATE TABLE ALERTAS (
  id_alerta NUMBER PRIMARY KEY,
  usuario_id NUMBER NOT NULL,
  tipo_alerta VARCHAR2(255) NOT NULL,
  mensagem VARCHAR2(255),
  data_enviado TIMESTAMP NOT NULL,
  id_solicitacao_suporte NUMBER,
  lido NUMBER(1) DEFAULT 0,
  CONSTRAINT fk_usuario_alerta FOREIGN KEY (usuario_id) REFERENCES USUARIO(id_usuario),
  CONSTRAINT fk_solicitacao_suporte FOREIGN KEY (id_solicitacao_suporte) REFERENCES SOLICITACAOSUPORTE(id_solicitacao)
);
*/

-- Criação da tabela Feedbacks
CREATE TABLE FORMS_FEEDBACK (
  id_feedback NUMBER PRIMARY KEY,
  usuario_id NUMBER NOT NULL,
  nome VARCHAR2(255) NOT NULL,
  telefone VARCHAR2(255) NOT NULL,
  email VARCHAR2(255) NOT NULL,
  descricao VARCHAR2(255) NOT NULL,
  data_feedback DATE NOT NULL
  --CONSTRAINT fk_usuario_feedback FOREIGN KEY (usuario_id) REFERENCES USUARIO(id_usuario)
);

-- Tabela suporte das estrelas
/*
CREATE TABLE ESTRELAS (
  id_stars NUMBER PRIMARY KEY,
  quantidade_estrelas NUMBER(1) NOT NULL,
  definicao VARCHAR2(255) NOT NULL
);
*/

-- Criação da tabela NewsLetter
CREATE TABLE NEWSLETTER (
id_news NUMBER(02) PRIMARY KEY NOT NULL,
email VARCHAR2(255) NOT NULL,
data_envio DATE NOT NULL,
status VARCHAR2(255) NOT NULL
);

-- Tabela para armazenar localizações via CEP
/*
CREATE TABLE LOCALIZACAO (
  id_localizacao NUMBER PRIMARY KEY,
  cep VARCHAR2(20),
  estado VARCHAR2(100),
  cidade VARCHAR2(100),
  bairro VARCHAR2(100),
  rua VARCHAR2(255),
  complemento VARCHAR2(255),
  data_cadastro DATE,
  longitude DECIMAL(9, 6),
  latitude DECIMAL(9, 6)
);
*/