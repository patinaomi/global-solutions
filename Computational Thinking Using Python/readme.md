# Sprint 3 - Challenge Salesforce

## Descrição

Este projeto desenvolvido em Python oferece uma solução de gerenciamento para um sistema de CRM (Salesforce). Possui funcionalidades de login, gestão de usuários e gerenciamento de leads através de uma interface de linha de comando. Além disso, o projeto inclui a funcionalidade de armazenamento de informações em três arquivos JSON separados.

## Funcionalidades

-   **Login de Usuário**: Acesso seguro com sistema de recuperação de senha.
-   **Gestão de Usuários**: Permite a criação, alteração, visualização e desativação de usuários.
-   **Gerenciamento de Leads**: Inclui a adição, listagem, edição e exclusão de leads do site.
    

## Uso do Programa

### Menu Principal

-   **[1] Realizar Login**: Acessa o sistema utilizando as credenciais do usuário.
-   **[2] Esqueci a senha**: Permite recuperar a senha através do e-mail cadastrado.
-   **[0] Sair do programa**: Encerra a aplicação.

### Submenus e Funcionalidades CRUD

Após o login, o usuário terá acesso a funcionalidades específicas baseadas no seu cargo (Admin, Consultor ou Analista), incluindo a gestão de outros usuários e o gerenciamento de leads.

### Funções
-   **Admin**: Responsável pela administração completa dos usuários do sistema. Isso inclui a capacidade de adicionar novos usuários, modificar dados existentes, alterar cargos e até desativar usuários conforme necessário. O Admin possui controle total sobre as permissões de acesso e funções de cada usuário dentro do sistema.
    
-   **Consultor**: O papel do Consultor é focado na interação com potenciais clientes. Eles têm a responsabilidade de monitorar, analisar e responder às mensagens deixadas no formulário de contato do site. Após a interação com o lead e a resolução das dúvidas ou demandas, o Consultor pode alterar o status do ticket para "finalizado", assegurando que todas as consultas sejam devidamente atendidas e arquivadas.
    
-   **Analista**: Especializado na análise de dados dos leads, o Analista desempenha um papel crucial na organização e no entendimento das informações de potenciais clientes. Eles têm a capacidade de cadastrar novos leads, listar todos os leads registrados, editar informações para manter os dados atualizados e deletar registros quando necessário. Este papel é vital para manter a qualidade e a relevância do banco de dados de clientes, facilitando estratégias de marketing e vendas mais eficazes.

## Tratamento de Erros

O sistema foi projetado para assegurar uma experiência de usuário mais confiável através de camadas de validação e tratamento de erros. Através da implementação de funções especializadas, cada entrada de dados é submetida a verificações para garantir sua integridade e conformidade com as regras estabelecidas.

Uma dessas funções é a validação de e-mails, implementada através de uma expressão regular (regex), que certifica que o e-mail fornecido pelo usuário segue um formato adequado, contendo os caracteres necessários como '@' e '.', garantindo assim que o e-mail seja válido e possa ser usado para comunicações futuras.

Para a criação e modificação de senhas, uma função dedicada à validação assegura que todas as senhas criadas tenham pelo menos 6 dígitos.
Outro aspecto importante é a verificação de campos obrigatórios. Para prevenir a submissão de formulários incompletos, foi implementada uma função que verifica se os campos foram deixados em aberto. Caso um campo obrigatório não seja preenchido, o sistema notifica o usuário, solicitando o preenchimento de todas as informações necessárias antes de prosseguir. 

O tratamento de exceções é realizado através do uso de blocos try-except, uma prática que contribui significativamente para a estabilidade do sistema. Essa estratégia é utilizada para lidar com erros inesperados e exceções, garantindo que o sistema permaneça resiliente e funcional mesmo diante de entradas inválidas ou ações imprevistas dos usuários. Ao capturar e tratar exceções de maneira adequada, o sistema evita interrupções e garante uma experiência de usuário suave e contínua.

Esses mecanismos de validação e tratamento de erros são essenciais para a manutenção de um ambiente seguro e confiável, onde os usuários podem interagir com o sistema de maneira eficiente, garantindo a qualidade e a precisão dos dados coletados e armazenados.

## Autores

-   Claudio Bispo - RM553472
-   Patricia Naomi - RM552981
-   Sara Ingrid - RM554021
