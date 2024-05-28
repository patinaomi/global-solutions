# global-solution-2024
Projeto Final do primeiro semestre da Faculdade de ADS


## Banco de dados

# Tabelas Propostas para este Projeto

1. Usuario
id: INT, PRIMARY KEY, AUTO_INCREMENT
nome: VARCHAR(255)
email: VARCHAR(255), UNIQUE
senha: VARCHAR(255)
tipo_usuario: ENUM('login', 'parceiro', 'fornecedor', 'Investidor')
Descrição: Armazena informações dos usuários, incluindo diferentes tipos de usuários:

Usuario padrão: Objetivo é apenas realizar o login.
Financiador: Objetivo é investir na empresa.
Parceiros: Promover a marca, fechar parcerias com ONGs, empresas para atividades como limpeza do ambiente, corridas, etc.

2. TipoUsuario
id: INT, PRIMARY KEY, AUTO_INCREMENT
descricao: VARCHAR(255)
Descrição: Define os tipos de usuários:

ID 1: Usuario comum
ID 2: Investidores
ID 3: Parceiros

3. Login
id: INT, PRIMARY KEY, AUTO_INCREMENT
usuario_id: INT, FOREIGN KEY REFERENCES Usuarios(id)
email: VARCHAR(255)
senha: VARCHAR(255)
data_login: DATE
tipo_login: INT, FOREIGN KEY REFERENCES TipoLogin(id)
status: ENUM('sucesso', 'falha')

Descrição: Registra as informações de logins efetuados pelos usuários, tanto pelos cadastros internos quanto pela plataforma do Google.

4. TipoLogin
id: INT, PRIMARY KEY, AUTO_INCREMENT
descricao: VARCHAR(255)
Descrição: Define os tipos de login:

ID 1: Login pelo cadastro
ID 2: Login pela plataforma do Google

5. SolicitacaoSuporte
id: INT, PRIMARY KEY, AUTO_INCREMENT
usuario_id: INT, FOREIGN KEY REFERENCES Usuarios(id)
tipo_marcacao: ENUM('animal', 'lixo')
descricao: TEXT
localizacao_origem: VARCHAR(255)
data: DATE
animal_id: INT, FOREIGN KEY REFERENCES Animais(id) (opcional, NULL se não for um animal)
lixo_id: INT, FOREIGN KEY REFERENCES TiposLixo(id) (opcional, NULL se não for lixo)

Descrição: Armazena dados de solicitações de suporte, indicando onde um animal está encalhado, onde há lixo que pode poluir uma área, e onde a prefeitura pode atuar com mais rapidez e precisão. Inclui referências às tabelas auxiliares de animais e tipos de lixo para informações detalhadas.

6. Animal
   
id: INT, PRIMARY KEY, AUTO_INCREMENT
nome_comum: VARCHAR(255)
nome_cientifico: VARCHAR(255)
descricao: TEXT

Descrição: Armazena informações detalhadas sobre os animais que podem ser encontrados encalhados.

7. Poluente (incidente que vai mostrar o tipo de lixo)?

id: INT, PRIMARY KEY, AUTO_INCREMENT
tipo: VARCHAR(255)
descricao: TEXT

Descrição: Armazena informações detalhadas sobre os tipos de lixo que podem poluir áreas.

8. Categoria
id: INT, PRIMARY KEY, AUTO_INCREMENT
nome: VARCHAR(255)
descricao: TEXT

Descrição: Armazena diferentes categorias de marcações ou eventos, como tipos específicos de animais, tipos de lixo, tipos de eventos, etc.

9. Parceiro
id: INT, PRIMARY KEY, AUTO_INCREMENT
nome: VARCHAR(255)
contato: VARCHAR(255)
tipo_parceria: VARCHAR(255)
Descrição: Armazena informações sobre parceiros que colaboram com o projeto.

10. Fornecedor
id: INT, PRIMARY KEY, AUTO_INCREMENT
nome: VARCHAR(255)
contato: VARCHAR(255)
tipo_servico: VARCHAR(255)
Descrição: Armazena informações sobre fornecedores que fornecem materiais ou serviços.

11. Investidor
id: INT, PRIMARY KEY, AUTO_INCREMENT
nome: VARCHAR(255)
contato: VARCHAR(255)
quantia_contribuida: DECIMAL(10, 2)
Descrição: Armazena informações sobre financiadores que contribuem financeiramente.

/* Plus */
13. Alerta
id: INT, PRIMARY KEY, AUTO_INCREMENT
usuario_id: INT, FOREIGN KEY REFERENCES Usuarios(id)
tipo_alerta: VARCHAR(255)
mensagem: TEXT
data_enviado: DATE
lido: BOOLEAN

Descrição: Armazena alertas enviados aos usuários sobre novas marcações, eventos ou atualizações importantes. Aqui eu pensei em usarmos a IA com Python para enviar mensagem no telegram avisando de atividades, calamidades, parceirias para todos os usuarios, como e feito nos EUA.

16. Investimento
id: INT, PRIMARY KEY, AUTO_INCREMENT
usuario_id: INT, FOREIGN KEY REFERENCES Usuarios(id)
quantia: DECIMAL(10, 2)
data: DATE

Descrição: Armazena informações sobre investimentos feitos por usuários em eventos.

17. Feedback

id: INT, PRIMARY KEY, AUTO_INCREMENT
usuario_id: INT, FOREIGN KEY REFERENCES Usuarios(id)
descricao: TEXT
data: DATE
Descrição: Armazena informações sobre feedbacks fornecidos pelos usuários.

17. SolicitacaoAjudaAnimal - Complemento da tabela Alerta
    
id: INT, PRIMARY KEY, AUTO_INCREMENT
usuario_id: INT, FOREIGN KEY REFERENCES Usuarios(id)
descricao: TEXT
localizacao: VARCHAR(255)
data_solicitacao: DATE
status: ENUM('pendente', 'em andamento', 'concluído')
Descrição: Armazena informações sobre solicitações de ajuda para animais encalhados.

# DER (Diagrama de Entidade-Relacionamento) 

1. Usuarios:

Cada usuário pode ter várias solicitações de suporte (1
com SolicitacaoSuporte).
Cada usuário pode ter vários logins (1
com Login).
Cada usuário pode ter vários investimentos (1
com Investimentos).
Cada usuário pode receber vários alertas (1
com Alertas).

2. Login:

Cada login pertence a um usuário (N:1 com Usuarios).
Cada login tem um tipo de login (N:1 com TipoLogin).
SolicitacaoSuporte:

Cada solicitação de suporte pertence a um usuário (N:1 com Usuarios).
Cada solicitação de suporte tem um tipo de marcação (animal, lixo, evento).
Categorias:

Pode estar relacionada a várias marcações ou eventos (dependendo da implementação).

3. Eventos:

Cada evento pode ter vários investimentos (1
com Investimentos).

4. Investimentos:

Cada investimento pertence a um usuário (N:1 com Usuarios).
Cada investimento está relacionado a um evento (N:1 com Eventos).
Parceiros, Fornecedores, Financiadores, AtividadesVoluntarias:

5. Alertas:

Cada alerta pertence a um usuário (N:1 com Usuarios).


# UML

+-----------------+
|    Usuario      |
+-----------------+
| - id: int       |
| - nome: string  |
| - email: string |
| - senha: string |
| - tipo_usuario: |
|   string        |
+-----------------+
| +register()     |
| +login()        |
+-----------------+

+-----------------+
|  TipoUsuario    |
+-----------------+
| - id: int       |
| - descricao: string |
+-----------------+
| +getDescription()|
+-----------------+

+-----------------+
|     Login       |
+-----------------+
| - id: int       |
| - usuario_id: int|
| - email: string |
| - senha: string |
| - data_login: date|
| - tipo_login: int|
| - status: string|
+-----------------+
| +createLogin()  |
| +getLoginStatus()|
+-----------------+

+-----------------+
|   TipoLogin     |
+-----------------+
| - id: int       |
| - descricao: string |
+-----------------+
| +getDescription()|
+-----------------+


+-------------------+
|    Categoria      |
+-------------------+
| - id: int         |
| - nome: string    |
| - descricao: string|
+-------------------+
| +getCategoria()   |
+-------------------+

+------------------+
|    Parceiro      |
+------------------+
| - id: int        |
| - nome: string   |
| - contato: string|
| - tipo_parceria: |
|   string         |
+------------------+
| +getParceiro()   |
+------------------+

+-------------------+
|   Fornecedor      |
+-------------------+
| - id: int         |
| - nome: string    |
| - contato: string |
| - tipo_servico:   |
|   string          |
+-------------------+
| +getFornecedor()  |
+-------------------+

+---------------------+
|   Financiador       |
+---------------------+
| - id: int           |
| - nome: string      |
| - contato: string   |
| - quantia_contribuida: float |
+---------------------+
| +getFinanciador()   |
+---------------------+

+----------------------------+
|   AtividadesVoluntarias    |
+----------------------------+
| - id: int                  |
| - nome_atividade: string   |
| - descricao: string        |
| - data: date               |
| - localizacao: string      |
+----------------------------+
| +getAtividade()            |
+----------------------------+

+-----------------+
|     Alerta      |
+-----------------+
| - id: int       |
| - usuario_id: int|
| - tipo_alerta: string|
| - mensagem: string  |
| - data_enviado: date|
| - lido: boolean     |
+-----------------+
| +getAlerta()    |
+-----------------+

+-----------------+
|     Evento      |
+-----------------+
| - id: int       |
| - nome: string  |
| - data: date    |
| - localizacao:  |
|   string        |
| - descricao:    |
|   string        |
+-----------------+
| +getEvento()    |
+-----------------+

+---------------------+
|   Investimento      |
+---------------------+
| - id: int           |
| - usuario_id: int   |
| - evento_id: int    |
| - quantia: float    |
| - data: date        |
+---------------------+
| +getInvestimento()  |
+---------------------+

+-----------------+
|   Feedback      |
+-----------------+
| - id: int       |
| - usuario_id: int|
| - descricao: string |
| - data: date    |
+-----------------+
| +addFeedback()  |
| +getFeedback()  |
+-----------------+

+--------------------------+
| SolicitacaoAjudaAnimais  |
+--------------------------+
| - id: int                |
| - usuario_id: int        |
| - descricao: string      |
| - localizacao: string    |
| - data_solicitacao: date |
| - status: string         |
+--------------------------+
| +createRequest()         |
| +getRequestStatus()      |
+--------------------------+

+----------------------+
|       Animais        |
+----------------------+
| - id: int            | 
| - nome_comum: string | 
| - nome_cientifico: string 
| - descricao: string  | 
+----------------------+
| +addAnimal()         | 
| +getAnimal()         | 
+----------------------+

+----------------------+
|     TiposLixo        |
+----------------------+
| - id: int            | 
| - tipo: string       | 
| - descricao: string  | 
+----------------------+
| +addTipoLixo()       | 
| +getTipoLixo()       | 
+----------------------+

+--------------------------+
| SolicitacaoSuporte       |
+--------------------------+
| - id: int                | 
| - usuario_id: int        | 
| - tipo_marcacao: string  | 
| - descricao: string      | 
| - localizacao_origem: string | 
| - data: date             | 
| - animal_id: int         | 
| - lixo_id: int           | 
+--------------------------+
| +createRequest()         | 
| +getRequestStatus()      | 
+--------------------------+


# Dicionário de Dados

Tabela: Usuarios

Coluna	Tipo	Descrição
id	INT, PRIMARY KEY, AUTO_INCREMENT	Identificador único do usuário
nome	VARCHAR(255)	Nome do usuário
email	VARCHAR(255), UNIQUE	Email do usuário, deve ser único
senha	VARCHAR(255)	Senha do usuário (pode ser NULL para logins via Google)
tipo_usuario	ENUM('login', 'parceiro', 'fornecedor', 'financiador')	Tipo de usuário (login padrão, parceiro, fornecedor, financiador)

Tabela: TipoUsuario
Coluna	Tipo	Descrição
id	INT, PRIMARY KEY, AUTO_INCREMENT	Identificador único do tipo de usuário
descricao	VARCHAR(255)	Descrição do tipo de usuário

Tabela: Login
Coluna	Tipo	Descrição
id	INT, PRIMARY KEY, AUTO_INCREMENT	Identificador único do login
usuario_id	INT, FOREIGN KEY REFERENCES Usuarios(id)	Referência ao usuário que fez o login
email	VARCHAR(255)	Email usado para o login
senha	VARCHAR(255)	Senha usada para o login (pode ser NULL para logins via Google)
data_login	DATE	Data e hora do login
tipo_login	INT, FOREIGN KEY REFERENCES TipoLogin(id)	Tipo de login (cadastro ou Google)
status	ENUM('sucesso', 'falha')	Status do login (sucesso ou falha)

Tabela: TipoLogin
Coluna	Tipo	Descrição
id	INT, PRIMARY KEY, AUTO_INCREMENT	Identificador único do tipo de login
descricao	VARCHAR(255)	Descrição do tipo de login

SolicitacaoSuporte
Coluna	Tipo	Descrição
id	INT, PRIMARY KEY, AUTO_INCREMENT	Identificador único da solicitação de suporte
usuario_id	INT, FOREIGN KEY REFERENCES Usuarios(id)	Referência ao usuário que fez a solicitação
tipo_marcacao	ENUM('animal', 'lixo', 'evento')	Tipo de marcação (animal, lixo, evento)
descricao	TEXT	Descrição da solicitação
localizacao_origem	VARCHAR(255)	Localização de origem da solicitação
data	DATE	Data da solicitação
animal_id	INT, FOREIGN KEY REFERENCES Animais(id)	Referência ao animal (NULL se não for um animal)
lixo_id	INT, FOREIGN KEY REFERENCES TiposLixo(id)	Referência ao tipo de lixo (NULL se não for lixo)

Tabela: Categorias
Coluna	Tipo	Descrição
id	INT, PRIMARY KEY, AUTO_INCREMENT	Identificador único da categoria
nome	VARCHAR(255)	Nome da categoria
descricao	TEXT	Descrição da categoria

Tabela: Parceiros
Coluna	Tipo	Descrição
id	INT, PRIMARY KEY, AUTO_INCREMENT	Identificador único do parceiro
nome	VARCHAR(255)	Nome do parceiro
contato	VARCHAR(255)	Contato do parceiro
tipo_parceria	VARCHAR(255)	Tipo de parceria

Tabela: Fornecedores
Coluna	Tipo	Descrição
id	INT, PRIMARY KEY, AUTO_INCREMENT	Identificador único do fornecedor
nome	VARCHAR(255)	Nome do fornecedor
contato	VARCHAR(255)	Contato do fornecedor
tipo_servico	VARCHAR(255)	Tipo de serviço fornecido

Tabela: Financiadores
Coluna	Tipo	Descrição
id	INT, PRIMARY KEY, AUTO_INCREMENT	Identificador único do financiador
nome	VARCHAR(255)	Nome do financiador
contato	VARCHAR(255)	Contato do financiador
quantia_contribuida	DECIMAL(10, 2)	Quantia contribuída pelo financiador

Tabela: AtividadesVoluntarias
Coluna	Tipo	Descrição
id	INT, PRIMARY KEY, AUTO_INCREMENT	Identificador único da atividade voluntária
nome_atividade	VARCHAR(255)	Nome da atividade
descricao	TEXT	Descrição da atividade
data	DATE	Data da atividade
localizacao	VARCHAR(255)	Localização da atividade

Tabela: Alertas
Coluna	Tipo	Descrição
id	INT, PRIMARY KEY, AUTO_INCREMENT	Identificador único do alerta
usuario_id	INT, FOREIGN KEY REFERENCES Usuarios(id)	Referência ao usuário que recebeu o alerta
tipo_alerta	VARCHAR(255)	Tipo de alerta
mensagem	TEXT	Mensagem do alerta
data_enviado	DATE	Data e hora do envio do alerta
lido	BOOLEAN	Indicador se o alerta foi lido (TRUE/FALSE)

Tabela: Eventos
Coluna	Tipo	Descrição
id	INT, PRIMARY KEY, AUTO_INCREMENT	Identificador único do evento
nome	VARCHAR(255)	Nome do evento
data	DATE	Data do evento
localizacao	VARCHAR(255)	Localização do evento
descricao	TEXT	Descrição do evento

Tabela: Investimentos
Coluna	Tipo	Descrição
id	INT, PRIMARY KEY, AUTO_INCREMENT	Identificador único do investimento
usuario_id	INT, FOREIGN KEY REFERENCES Usuarios(id)	Referência ao usuário que fez o investimento
evento_id	INT, FOREIGN KEY REFERENCES Eventos(id)	Referência ao evento no qual foi feito o investimento
quantia	DECIMAL(10, 2)	Quantia investida
data	DATE	Data do investimento

Relacionamentos finais para confrontar quando eu fazer no sistema.
Usuarios - TipoUsuario: Usuarios.tipo_usuario refere-se a TipoUsuario.id
Login - Usuarios: Login.usuario_id refere-se a Usuarios.id
Login - TipoLogin: Login.tipo_login refere-se a TipoLogin.id
SolicitacaoSuporte - Usuarios: SolicitacaoSuporte.usuario_id refere-se a Usuarios.id
Investimentos - Usuarios: Investimentos.usuario_id refere-se a Usuarios.id
Investimentos - Eventos: Investimentos.evento_id refere-se a Eventos.id
Alertas - Usuarios: Alertas.usuario_id refere-se a Usuarios.id

Tabela: Feedbacks
Coluna	Tipo	Descrição
id	INT, PRIMARY KEY, AUTO_INCREMENT	Identificador único do feedback
usuario_id	INT, FOREIGN KEY REFERENCES Usuarios(id)	Referência ao usuário que forneceu o feedback
descricao	TEXT	Descrição do feedback
data	DATE	Data do feedback

Tabela: SolicitacaoAjudaAnimais
Coluna	Tipo	Descrição
id	INT, PRIMARY KEY, AUTO_INCREMENT	Identificador único da solicitação
usuario_id	INT, FOREIGN KEY REFERENCES Usuarios(id)	Referência ao usuário que fez a solicitação
descricao	TEXT	Descrição da solicitação
localizacao	VARCHAR(255)	Localização onde o animal está encalhado
data_solicitacao	DATE	Data da solicitação
status	ENUM('pendente', 'em andamento', 'concluído')	Status da solicitação


Tabela: Animais
Coluna	Tipo	Descrição
id	INT, PRIMARY KEY, AUTO_INCREMENT	Identificador único do animal
nome_comum	VARCHAR(255)	Nome comum do animal
nome_cientifico	VARCHAR(255)	Nome científico do animal
descricao	TEXT	Descrição do animal

Tabela: TiposLixo
Coluna	Tipo	Descrição
id	INT, PRIMARY KEY, AUTO_INCREMENT	Identificador único do tipo de lixo
tipo	VARCHAR(255)	Tipo de lixo
descricao	TEXT	Descrição do tipo de lixo

# DDL

-- Criação da tabela Usuarios
CREATE TABLE Usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    senha VARCHAR(255),
    tipo_usuario ENUM('login', 'parceiro', 'fornecedor', 'Investidor') NOT NULL
);

-- Criação da tabela TipoUsuario
CREATE TABLE TipoUsuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL
);

-- Criação da tabela Login
CREATE TABLE Login (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255),
    data_login DATE NOT NULL,
    tipo_login INT NOT NULL,
    status ENUM('sucesso', 'falha') NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(id),
    FOREIGN KEY (tipo_login) REFERENCES TipoLogin(id)
);

-- Criação da tabela TipoLogin
CREATE TABLE TipoLogin (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL
);

-- Criação da tabela SolicitacaoSuporte
CREATE TABLE SolicitacaoSuporte (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    tipo_marcacao ENUM('animal', 'lixo', 'evento') NOT NULL,
    descricao TEXT NOT NULL,
    localizacao_origem VARCHAR(255) NOT NULL,
    data DATE NOT NULL,
    animal_id INT,
    lixo_id INT,
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(id),
    FOREIGN KEY (animal_id) REFERENCES Animais(id),
    FOREIGN KEY (lixo_id) REFERENCES TiposLixo(id)
);

-- Criação da tabela Animais
CREATE TABLE Animais (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_comum VARCHAR(255) NOT NULL,
    nome_cientifico VARCHAR(255),
    descricao TEXT
);

-- Criação da tabela TiposLixo
CREATE TABLE TiposLixo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(255) NOT NULL,
    descricao TEXT
);

-- Criação da tabela Categorias
CREATE TABLE Categorias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT
);

-- Criação da tabela Parceiros
CREATE TABLE Parceiros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    contato VARCHAR(255),
    tipo_parceria VARCHAR(255)
);

-- Criação da tabela Fornecedores
CREATE TABLE Fornecedores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    contato VARCHAR(255),
    tipo_servico VARCHAR(255)
);

-- Criação da tabela Financiadores
CREATE TABLE Financiadores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    contato VARCHAR(255),
    quantia_contribuida DECIMAL(10, 2)
);

-- Criação da tabela AtividadesVoluntarias
CREATE TABLE AtividadesVoluntarias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_atividade VARCHAR(255) NOT NULL,
    descricao TEXT,
    data DATE,
    localizacao VARCHAR(255)
);

-- Criação da tabela Alertas
CREATE TABLE Alertas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    tipo_alerta VARCHAR(255) NOT NULL,
    mensagem TEXT,
    data_enviado DATE NOT NULL,
    lido BOOLEAN,
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(id)
);

-- Criação da tabela Eventos
CREATE TABLE Eventos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    data DATE NOT NULL,
    localizacao VARCHAR(255) NOT NULL,
    descricao TEXT
);

-- Criação da tabela Investimentos
CREATE TABLE Investimentos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    evento_id INT NOT NULL,
    quantia DECIMAL(10, 2) NOT NULL,
    data DATE NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(id),
    FOREIGN KEY (evento_id) REFERENCES Eventos(id)
);

-- Criação da tabela Feedbacks
CREATE TABLE Feedbacks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    descricao TEXT NOT NULL,
    data DATE NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(id)
);

-- Criação da tabela SolicitacaoAjudaAnimais
CREATE TABLE SolicitacaoAjudaAnimais (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    descricao TEXT NOT NULL,
    localizacao VARCHAR(255) NOT NULL,
    data_solicitacao DATE NOT NULL,
    status ENUM('pendente', 'em andamento', 'concluído') NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(id)
);

# DML: Imputação de Dados

Usuario
2. INSERT INTO Usuarios (nome, email, senha, tipo_usuario) VALUES
('Alice', 'alice@example.com', 'Senha123!', 'login'),
('Bob', 'bob@example.com', 'Senha123!', 'parceiro'),
('Charlie', 'charlie@example.com', 'Senha123!', 'fornecedor'),
('Dave', 'dave@example.com', 'Senha123!', 'financiador'),
('Eve', 'eve@example.com', 'Senha123!', 'login');

TipoUsuario



