## Documentação Geral do nosso porjeto e explicação dos componentes.

### Grupo MiloTech

# Integrantes

Claudio Bispo RM553472
Patricia Naomi RM552981
Sabrina Café RM553568

# Link do Vercel
https://global-solution-front-end.vercel.app/

# Link do vídeo - Projeto Geral
https://www.youtube.com/watch?v=8i8KAik3cs8

# Link do Pitch sobre o site




# Componente Menu

Objetivo Geral
O componente Menu é um menu de navegação responsivo para um site em Next.js. Ele oferece navegação tanto em dispositivos desktop quanto móveis, com suporte a rolagem suave para seções específicas da página ou redirecionamento para outras páginas.

Instalação e Dependências
Para utilizar este componente, certifique-se de ter as seguintes dependências instaladas no seu projeto:

next
react
react-dom
Funcionamento
Estado menuOpen: Controla a visibilidade do menu móvel.
Função toggleMenu: Alterna a visibilidade do menu móvel.
Função closeMenu: Fecha o menu móvel.
Função handleNavigation: Navega para uma seção específica da página com rolagem suave ou redireciona para outra página.
Classes e Estilos
O componente utiliza Tailwind CSS para aplicar estilos responsivos e personalização. As classes CSS são aplicadas para controlar o layout e a aparência do menu em diferentes tamanhos de tela.

Navegação
Links Internos: Usam next/link para navegação entre páginas.
Scroll Suave: Usa document.querySelector e scrollIntoView para rolagem suave até seções específicas.
Considerações Adicionais
Compatibilidade com SEO: Utiliza Next.js para renderização no lado do servidor, melhorando o SEO.
Responsividade: Menu responsivo que se adapta a diferentes tamanhos de tela, utilizando Tailwind CSS para estilização.


# Componente SessaoPrincipal

Objetivo Geral
O componente SessaoPrincipal é a seção principal de uma página, oferecendo uma introdução ao site com uma imagem de fundo, título, descrição e botões de ação. É ideal para a página inicial de um site que visa engajar os usuários e incentivá-los a registrar ocorrências ou aprender mais sobre o projeto.

Instalação e Dependências
Para utilizar este componente, certifique-se de ter as seguintes dependências instaladas no seu projeto:

next
react
react-dom
Funcionamento
Imagem de Fundo: Usa uma imagem de fundo que cobre toda a tela, com um gradiente sobreposto para melhorar a legibilidade do texto.
Título e Descrição: Exibe um título principal e uma descrição que apresenta a missão do site.
Botões de Ação: Inclui botões para "Registrar ocorrência" e "Saiba mais", direcionando para páginas específicas do site.
Classes e Estilos
O componente utiliza Tailwind CSS para aplicar estilos responsivos e personalização. As classes CSS são aplicadas para controlar o layout e a aparência dos elementos em diferentes tamanhos de tela.

Navegação
Links Internos: Usam next/link para navegação entre páginas, permitindo redirecionamento ao clicar nos botões.
Considerações Adicionais
Responsividade: A seção é responsiva e se adapta a diferentes tamanhos de tela, utilizando Tailwind CSS para estilização.
Gradiente: Um gradiente é aplicado sobre a imagem de fundo para melhorar a legibilidade do texto.

# Componente Missao

Objetivo Geral
O componente Missao apresenta a missão do projeto MarVida, utilizando um carrossel de imagens e texto para descrever a importância da participação na conservação marinha. Ele oferece informações educativas e incentiva o engajamento dos usuários.

Instalação e Dependências
Para utilizar este componente, certifique-se de ter as seguintes dependências instaladas no seu projeto:

next
react
react-dom
Funcionamento
Estado currentSlide: Controla o slide atual do carrossel.
Função handleNext: Avança para o próximo slide.
Função handlePrev: Volta para o slide anterior.
Estrutura do Carrossel
Slides: O carrossel contém quatro slides, cada um com uma imagem e um texto descritivo sobre a missão do MarVida.
Controle de Navegação: Botões de navegação para avançar e retroceder os slides.
Seções Informativas
O componente também inclui três seções informativas sobre os recursos do MarVida:

Reporte Instantâneo: Marcar rapidamente a localização de encalhes e alertar as autoridades locais.
Fique Informado: Receber notificações em tempo real sobre encalhes e eventos de conservação marinha.
Aprenda e Contribua: Acessar materiais educativos sobre conservação dos oceanos.
Classes e Estilos
O componente utiliza Tailwind CSS para aplicar estilos responsivos e personalização. As classes CSS são aplicadas para controlar o layout e a aparência dos elementos em diferentes tamanhos de tela.

Navegação
Links Internos: Usam next/link para navegação entre páginas.
Imagens: Utiliza next/image para otimização das imagens.
Considerações Adicionais
Responsividade: O componente é responsivo e se adapta a diferentes tamanhos de tela, utilizando Tailwind CSS para estilização.
Carrossel: Um carrossel de imagens com textos descritivos para engajar os usuários e educá-los sobre a missão do MarVida.

# Componente SobreProjeto

Objetivo Geral
O componente SobreProjeto apresenta uma visão geral do projeto, incluindo um pitch que detalha a visão e a missão do aplicativo. Ele é ideal para fornecer uma introdução e engajar os visitantes com as metas e o impacto do projeto na conservação marinha.

Instalação e Dependências
Para utilizar este componente, certifique-se de ter as seguintes dependências instaladas no seu projeto:

next
react
react-dom
Funcionamento
Título e Subtítulo: Exibe o título "Sobre o Projeto" e o subtítulo "Apresentação" com estilos distintos.
Parágrafo Descritivo: Fornece uma descrição detalhada do projeto e sua importância.
Imagem de Fundo com Botão de Play: Inclui uma imagem de fundo representando um vídeo com um ícone de play sobreposto, sugerindo uma apresentação em vídeo.
Classes e Estilos
O componente utiliza Tailwind CSS para aplicar estilos responsivos e personalização. As classes CSS são aplicadas para controlar o layout e a aparência dos elementos em diferentes tamanhos de tela.

Navegação
Seção Alvo: O componente possui um ID (#sobreProjeto) para navegação direta dentro da página.
Considerações Adicionais
Responsividade: O componente é responsivo e se adapta a diferentes tamanhos de tela, utilizando Tailwind CSS para estilização.
Design Atraente: Utiliza cores e fontes específicas para criar um design visualmente atraente e consistente com o restante do site.


# Componente Funcionalidades

Objetivo Geral
O componente Funcionalidades descreve as principais funcionalidades do aplicativo, fornecendo uma visão detalhada dos recursos e benefícios para os usuários. Ele é ideal para informar os visitantes sobre o que o aplicativo oferece e incentivá-los a se cadastrarem.

Instalação e Dependências
Para utilizar este componente, certifique-se de ter as seguintes dependências instaladas no seu projeto:

next
react
react-dom
Funcionamento
Título e Subtítulos: Exibe o título "Funcionalidades" e subtítulos para cada funcionalidade descrita.
Descrição das Funcionalidades: Fornece uma descrição detalhada de cada funcionalidade do aplicativo, incluindo:
Registro de Incidentes: Permite registrar encalhes de animais marinhos, resíduos poluentes e desastres ambientais.
Mapa Interativo: Mostra todos os encalhes reportados em tempo real em um mapa interativo.
Alertas e Notificações: Envia alertas sobre novos encalhes e desastres ambientais.
Educação e Recursos: Disponibiliza recursos educativos sobre biologia marinha e práticas de sustentabilidade.
Botão de Cadastro
Inclui um botão para os usuários se cadastrarem, incentivando a participação ativa no projeto.
Classes e Estilos
O componente utiliza Tailwind CSS para aplicar estilos responsivos e personalização. As classes CSS são aplicadas para controlar o layout e a aparência dos elementos em diferentes tamanhos de tela.

Navegação
Seção Alvo: O componente possui um ID (#funcionalidades) para navegação direta dentro da página.
Considerações Adicionais
Responsividade: O componente é responsivo e se adapta a diferentes tamanhos de tela, utilizando Tailwind CSS para estilização.
Imagens Representativas: Utiliza imagens para ilustrar cada funcionalidade, tornando a apresentação mais visual e atraente.


# Componente Dados

Objetivo Geral
O componente Dados apresenta estatísticas importantes sobre encalhes de animais marinhos, oferecendo uma visão quantitativa dos dados coletados. É ideal para fornecer informações rápidas e impactantes sobre o impacto e a atividade do projeto.

Instalação e Dependências
Para utilizar este componente, certifique-se de ter as seguintes dependências instaladas no seu projeto:

next
react
react-dom
Funcionamento
Estatísticas: Exibe três estatísticas principais, cada uma com um valor destacado e uma descrição:
Animais encontrados encalhados no litoral Paranaense.
Encalhes registrados durante o mês de agosto no Paraná.
Porcentagem de encalhes que envolveram a espécie pinguim-de-magalhães.
Estrutura
Array de Estatísticas: Contém os dados das estatísticas que serão exibidas.
Mapeamento de Estatísticas: Utiliza .map() para iterar sobre o array de estatísticas e renderizar cada uma delas.
Classes e Estilos
O componente utiliza Tailwind CSS para aplicar estilos responsivos e personalização. As classes CSS são aplicadas para controlar o layout e a aparência dos elementos em diferentes tamanhos de tela.

Navegação
Design Atraente: Utiliza cores e fontes específicas para criar um design visualmente atraente e consistente com o restante do site.
Considerações Adicionais
Responsividade: O componente é responsivo e se adapta a diferentes tamanhos de tela, utilizando Tailwind CSS para estilização.
Apresentação Centralizada: As estatísticas são centralizadas na página, facilitando a leitura e a compreensão das informações.

# Componente SobreMissao

Objetivo Geral
O componente SobreMissao é uma seção dedicada a incentivar os visitantes a apoiarem o projeto através de financiamento coletivo. Ele explica a importância do apoio financeiro e como as contribuições ajudam a tornar o aplicativo uma realidade.

Instalação e Dependências
Para utilizar este componente, certifique-se de ter as seguintes dependências instaladas no seu projeto:

next
react
react-dom
Funcionamento
Título Principal: Exibe o título "Apoie Nossa Missão" em destaque.
Descrição: Fornece uma explicação sobre a importância do financiamento coletivo e como ele ajuda no desenvolvimento do aplicativo.
Instruções de Contribuição: Orienta os visitantes sobre como participar da campanha de financiamento coletivo.
Recompensas: Detalha as recompensas oferecidas aos apoiadores.
Estrutura
Título e Subtítulos: Utiliza títulos em diferentes níveis para estruturar a informação.
Parágrafos Informativos: Contém texto explicativo sobre a missão, a campanha de financiamento coletivo e as recompensas.
Botão de Contribuição: Inclui um botão para incentivar as doações.
Classes e Estilos
O componente utiliza Tailwind CSS para aplicar estilos responsivos e personalização. As classes CSS são aplicadas para controlar o layout e a aparência dos elementos em diferentes tamanhos de tela.

Navegação
Seção de Contribuição: Destaca como contribuir e as recompensas para os apoiadores.
Considerações Adicionais
Responsividade: O componente é responsivo e se adapta a diferentes tamanhos de tela, utilizando Tailwind CSS para estilização.
Design Atraente: Utiliza cores e fontes específicas para criar um design visualmente atraente e consistente com o restante do site.


# Componente Eventos

Objetivo Geral
O componente Eventos exibe um carrossel de imagens, apresentando diferentes slides que podem ser navegados pelos usuários. Ele é ideal para mostrar eventos ou destaques visuais de forma interativa e atraente.

Instalação e Dependências
Para utilizar este componente, certifique-se de ter as seguintes dependências instaladas no seu projeto:

next
react
react-dom
Funcionamento
Estado currentIndex: Controla o índice do slide atual exibido.
Função nextSlide: Avança para o próximo slide.
Função prevSlide: Volta para o slide anterior.
Slides: Contém as imagens dos slides que serão exibidos no carrossel.
Estrutura
Array de Slides: Contém os dados dos slides, incluindo a imagem e o ID.
Botões de Navegação: Permite navegar entre os slides usando os botões "Anterior" e "Próximo".
Classes e Estilos
O componente utiliza Tailwind CSS para aplicar estilos responsivos e personalização. As classes CSS são aplicadas para controlar o layout e a aparência dos elementos em diferentes tamanhos de tela.

Navegação
Visualização Mobile: Mostra apenas um slide por vez em dispositivos móveis.
Visualização Desktop: Mostra três slides simultaneamente em dispositivos desktop.
Considerações Adicionais
Responsividade: O componente é responsivo e se adapta a diferentes tamanhos de tela, utilizando Tailwind CSS para estilização.
Design Atraente: Utiliza cores e fontes específicas para criar um design visualmente atraente e consistente com o restante do site.
Animações de Transição: Inclui animações suaves para transição entre os slides.

# Componente Projeto

Objetivo Geral
O componente Projeto apresenta o roadmap do projeto, destacando os principais marcos e etapas futuras. Ele fornece uma visão clara das fases de desenvolvimento e planejamento, incentivando a transparência e o envolvimento dos stakeholders.

Instalação e Dependências
Para utilizar este componente, certifique-se de ter as seguintes dependências instaladas no seu projeto:

next
react
react-dom
Funcionamento
Roadmap: O componente exibe uma lista de marcos importantes do projeto, organizados de forma visualmente atraente.
Estrutura de Dados: Utiliza um array de objetos roadmapData para armazenar os detalhes de cada marco, incluindo o título, a descrição e a cor associada.
Estrutura
Título e Descrição do Roadmap: Exibe o título "roadmap" e uma descrição introdutória sobre o objetivo e a importância do roadmap.
Itens do Roadmap: Cada item do roadmap é exibido com um título, descrição e uma borda colorida para destacar a fase correspondente. A ordem dos itens alterna entre esquerda e direita para uma apresentação visual equilibrada.
Classes e Estilos
O componente utiliza Tailwind CSS para aplicar estilos responsivos e personalização. As classes CSS são aplicadas para controlar o layout e a aparência dos elementos em diferentes tamanhos de tela. A borda colorida de cada item é determinada pela propriedade color no array roadmapData.

Navegação
Seção Alvo: O componente possui um ID (#Roadmap) para navegação direta dentro da página.
Considerações Adicionais
Responsividade: O componente é responsivo e se adapta a diferentes tamanhos de tela, utilizando Tailwind CSS para estilização.
Design Atraente: Utiliza cores e fontes específicas para criar um design visualmente atraente e consistente com o restante do site.
Visualização Alternada: Alterna a disposição dos itens do roadmap para uma apresentação mais dinâmica e envolvente.

# Componente Educacao

Objetivo Geral
O componente Educacao fornece informações e orientações educativas sobre como lidar com situações de animais encalhados ou poluentes na praia. Ele permite que os usuários expandam seus conhecimentos sobre como agir em situações críticas relacionadas à vida marinha e ao meio ambiente costeiro.

Instalação e Dependências
Para utilizar este componente, certifique-se de ter as seguintes dependências instaladas no seu projeto:

next
react
react-dom
Funcionamento
Estado activeIndex: Controla o índice da seção ativa exibida.
Função toggle: Alterna a visibilidade da seção selecionada.
Estrutura
Títulos das Seções: Exibe títulos interativos para cada seção de educação, que podem ser expandidos para revelar mais informações.
Conteúdo das Seções: Fornece detalhes específicos sobre como agir ao encontrar animais encalhados (vivos ou mortos) e poluentes na praia.
Divisores: Inclui divisores visuais entre as seções para melhor organização e clareza.
Classes e Estilos
O componente utiliza Tailwind CSS para aplicar estilos responsivos e personalização. As classes CSS são aplicadas para controlar o layout e a aparência dos elementos em diferentes tamanhos de tela.

Navegação
Seção Alvo: O componente possui um ID (#Educacao) para navegação direta dentro da página.
Considerações Adicionais
Responsividade: O componente é responsivo e se adapta a diferentes tamanhos de tela, utilizando Tailwind CSS para estilização.
Design Atraente: Utiliza cores e fontes específicas para criar um design visualmente atraente e consistente com o restante do site.
Conteúdo Interativo: Fornece uma experiência interativa, permitindo que os usuários expandam e contraiam seções conforme necessário.

# Componente Rodape

Objetivo Geral
O componente Rodape é o rodapé do site, fornecendo links de navegação, informações sobre a equipe, e links para redes sociais. Ele também exibe o logotipo e a marca da empresa, além de um aviso de direitos autorais.

Instalação e Dependências
Para utilizar este componente, certifique-se de ter as seguintes dependências instaladas no seu projeto:

next
react
react-dom
next/image
next/link
Funcionamento
Informações da Empresa: Exibe o nome e o logotipo da empresa.
Links de Navegação: Fornece links para seções importantes do site, como "Sobre o projeto", "Ocorrência", e "Fale Conosco".
Equipe: Lista os membros da equipe com seus respectivos nomes.
Redes Sociais: Inclui ícones e links para as redes sociais da empresa.
Direitos Autorais: Exibe uma mensagem de direitos autorais no final do rodapé.
Estrutura
Nome e Logotipo da Empresa: Inclui o nome "MiloTech" e o logotipo da empresa.
Links da Equipe: Lista os membros da equipe.
Links de Navegação: Inclui links para diferentes páginas do site.
Redes Sociais: Exibe ícones de redes sociais como Facebook, Twitter, e Instagram.
Aviso de Direitos Autorais: Mostra uma mensagem de direitos autorais.
Classes e Estilos
O componente utiliza Tailwind CSS para aplicar estilos responsivos e personalização. As classes CSS são aplicadas para controlar o layout e a aparência dos elementos em diferentes tamanhos de tela.

Navegação
Links Internos: Usam next/link para navegação entre páginas.
Redes Sociais: Links para redes sociais utilizando ícones SVG.
Considerações Adicionais
Responsividade: O componente é responsivo e se adapta a diferentes tamanhos de tela, utilizando Tailwind CSS para estilização.
Design Atraente: Utiliza cores e fontes específicas para criar um design visualmente atraente e consistente com o restante do site.

# Componente Investimentos

Objetivo Geral
O componente Investimentos é um formulário para que interessados possam se tornar investidores do projeto. Ele coleta informações de contato e detalhes sobre o interesse dos investidores, facilitando a comunicação entre a equipe do projeto e os potenciais apoiadores.

Instalação e Dependências
Para utilizar este componente, certifique-se de ter as seguintes dependências instaladas no seu projeto:

next
react
react-dom
axios
Funcionamento
Estado formData: Armazena os dados do formulário, incluindo nome, e-mail, telefone, nome da empresa, quantia a ser contribuída e mensagem.
Função handleChange: Atualiza o estado formData conforme o usuário preenche os campos do formulário.
Função handleSubmit: Valida os campos do formulário e envia os dados para o backend usando uma requisição POST com axios.
Estrutura
Título e Descrição: Exibe um título convidando os usuários a apoiarem a missão e um texto explicativo sobre como se tornar um investidor.
Campos do Formulário: Inclui campos para nome, e-mail, telefone, nome da empresa, quantia a ser contribuída e uma mensagem.
Botão de Envio: Um botão para enviar os dados do formulário.
Classes e Estilos
O componente utiliza Tailwind CSS para aplicar estilos responsivos e personalização. As classes CSS são aplicadas para controlar o layout e a aparência dos elementos em diferentes tamanhos de tela.

Navegação
Links Internos: Usam next/link para navegação entre páginas.
Validação: Inclui validação básica para garantir que todos os campos sejam preenchidos antes do envio.
Considerações Adicionais
Responsividade: O componente é responsivo e se adapta a diferentes tamanhos de tela, utilizando Tailwind CSS para estilização.
Design Atraente: Utiliza cores e fontes específicas para criar um design visualmente atraente e consistente com o restante do site.
Interação com Backend: Envia os dados do formulário para o backend usando uma requisição POST com axios.


# Componente Contato

Objetivo Geral
O componente Contato fornece uma interface para que os usuários possam entrar em contato com a equipe do projeto. Ele inclui formulários para feedback e para inscrição em uma newsletter, permitindo que os usuários compartilhem sugestões, dúvidas e se mantenham informados sobre as atividades do projeto.

Instalação e Dependências
Para utilizar este componente, certifique-se de ter as seguintes dependências instaladas no seu projeto:

next
react
react-dom
Funcionamento
Título e Introdução: Exibe um título "Fale Conosco" e uma breve descrição incentivando os usuários a entrarem em contato.
Formulário de Feedback: Inclui um formulário para os usuários enviarem sugestões e dúvidas.
Formulário de Newsletter: Inclui um formulário para os usuários se inscreverem na newsletter do projeto.
Estrutura
Título e Descrição: Exibe um título em destaque e uma descrição abaixo.
Formulários: Inclui dois formulários, FormularioFeedback e FormularioNews, que são componentes separados.
Classes e Estilos
O componente utiliza Tailwind CSS para aplicar estilos responsivos e personalização. As classes CSS são aplicadas para controlar o layout e a aparência dos elementos em diferentes tamanhos de tela.

Navegação
Seção Alvo: O componente é idealmente usado como uma página de contato no site.
Considerações Adicionais
Responsividade: O componente é responsivo e se adapta a diferentes tamanhos de tela, utilizando Tailwind CSS para estilização.
Design Atraente: Utiliza cores e fontes específicas para criar um design visualmente atraente e consistente com o restante do site.
Interatividade: Inclui formulários interativos para coletar feedback e inscrições na newsletter.

# Componente FormularioFeedback

Objetivo Geral
O componente FormularioFeedback permite que os usuários enviem feedback sobre o projeto. Ele coleta informações como nome, e-mail, telefone, mensagem e uma nota (rating) representada por estrelas.

Instalação e Dependências
Para utilizar este componente, certifique-se de ter as seguintes dependências instaladas no seu projeto:

next
react
react-dom
Funcionamento
Estado formData: Armazena os dados do formulário, incluindo nome, e-mail, telefone, mensagem e nota.
Estado rating: Armazena a nota selecionada pelo usuário.
Função handleInputChange: Atualiza o estado formData conforme o usuário preenche os campos do formulário.
Função handleSubmitFeedback: Envia os dados do formulário para o backend usando uma requisição POST.
Função handleSetRating: Atualiza o estado rating com a nota selecionada pelo usuário.
Estrutura
Campos do Formulário: Inclui campos para nome, e-mail, telefone e mensagem.
Avaliação com Estrelas: Permite que os usuários selecionem uma nota de 1 a 5 estrelas.
Botão de Envio: Um botão para enviar os dados do formulário.
Classes e Estilos
O componente utiliza Tailwind CSS para aplicar estilos responsivos e personalização. As classes CSS são aplicadas para controlar o layout e a aparência dos elementos em diferentes tamanhos de tela.

Navegação
Seção Alvo: O componente pode ser usado em uma seção de contato ou feedback no site.
Considerações Adicionais
Responsividade: O componente é responsivo e se adapta a diferentes tamanhos de tela, utilizando Tailwind CSS para estilização.
Interatividade: Inclui um sistema de avaliação com estrelas para tornar a experiência do usuário mais interativa.
Integração com Backend: Envia os dados do formulário para o backend usando uma requisição POST.


# Componente FormularioNews

Objetivo Geral
O componente FormularioNews permite que os usuários se inscrevam na newsletter do projeto, fornecendo seu e-mail para receber atualizações sobre conservação marinha e novidades do projeto.

Instalação e Dependências
Para utilizar este componente, certifique-se de ter as seguintes dependências instaladas no seu projeto:

next
react
react-dom
Funcionamento
Estado formData: Armazena os dados do formulário, especificamente o e-mail do usuário.
Função handleInputChange: Atualiza o estado formData conforme o usuário preenche o campo de e-mail.
Função handleSubmitNewsletter: Envia os dados do formulário para o backend usando uma requisição POST.
Estrutura
Imagem de Fundo: Exibe uma imagem de fundo decorativa.
Campo de E-mail: Inclui um campo para o usuário inserir seu e-mail.
Botão de Envio: Um botão para enviar os dados do formulário.
Classes e Estilos
O componente utiliza Tailwind CSS para aplicar estilos responsivos e personalização. As classes CSS são aplicadas para controlar o layout e a aparência dos elementos em diferentes tamanhos de tela.

Navegação
Seção Alvo: O componente pode ser usado em uma seção de newsletter no site.
Considerações Adicionais
Responsividade: O componente é responsivo e se adapta a diferentes tamanhos de tela, utilizando Tailwind CSS para estilização.
Design Atraente: Utiliza uma imagem de fundo e estilização específica para criar um design visualmente atraente e consistente com o restante do site.
Interação com Backend: Envia os dados do formulário para o backend usando uma requisição POST.

# Componente Cadastro

Objetivo Geral
O componente Cadastro permite que novos usuários criem uma conta no projeto. Ele coleta informações essenciais como nome, sobrenome, telefone, e-mail e senha, e valida os dados antes de enviá-los para o backend.

Instalação e Dependências
Para utilizar este componente, certifique-se de ter as seguintes dependências instaladas no seu projeto:

next
react
react-dom
Funcionamento
Estado formData: Armazena os dados do formulário, incluindo nome, sobrenome, telefone, e-mail, confirmação de e-mail, senha e confirmação de senha.
Estado errors: Armazena as mensagens de erro de validação para cada campo do formulário.
Função validate: Valida os campos do formulário e atualiza o estado errors com as mensagens de erro apropriadas.
Função handleChange: Atualiza o estado formData conforme o usuário preenche os campos do formulário.
Função handleSubmit: Valida os campos do formulário e, se válidos, envia os dados para o backend usando uma requisição POST.
Estrutura
Título e Descrição: Exibe um título e uma descrição convidando os usuários a criar uma conta.
Campos do Formulário: Inclui campos para nome, sobrenome, telefone, e-mail, confirmação de e-mail, senha e confirmação de senha.
Botão de Envio: Um botão para enviar os dados do formulário.
Validação
Nome: Obrigatório.
Sobrenome: Obrigatório.
Telefone: Obrigatório.
E-mail: Obrigatório e deve coincidir com a confirmação de e-mail.
Senha: Obrigatória, deve conter no mínimo 6 caracteres, incluindo pelo menos um número, uma letra maiúscula, uma letra minúscula e um caractere especial.
Confirmação de Senha: Obrigatória e deve coincidir com a senha.
Classes e Estilos
O componente utiliza Tailwind CSS para aplicar estilos responsivos e personalização. As classes CSS são aplicadas para controlar o layout e a aparência dos elementos em diferentes tamanhos de tela.

Navegação
Seção Alvo: O componente pode ser usado em uma página de registro no site.
Considerações Adicionais
Responsividade: O componente é responsivo e se adapta a diferentes tamanhos de tela, utilizando Tailwind CSS para estilização.
Design Atraente: Utiliza imagens de fundo e estilização específica para criar um design visualmente atraente e consistente com o restante do site.
Integração com Backend: Envia os dados do formulário para o backend usando uma requisição POST.

# Componente Login

Objetivo Geral
O componente Login permite que os usuários façam login no site usando suas credenciais ou através do Google. Ele valida os campos de e-mail e senha antes de enviar os dados para o backend.

Instalação e Dependências
Para utilizar este componente, certifique-se de ter as seguintes dependências instaladas no seu projeto:

next
react
react-dom
next-auth/react
Funcionamento
Estado formData: Armazena os dados do formulário, incluindo e-mail e senha.
Estado errors: Armazena as mensagens de erro de validação para cada campo do formulário.
Função validateForm: Valida os campos do formulário e atualiza o estado errors com as mensagens de erro apropriadas.
Função handleChange: Atualiza o estado formData conforme o usuário preenche os campos do formulário.
Função handleSubmit: Valida os campos do formulário e, se válidos, envia os dados para o backend usando uma requisição POST.
Função signIn: Usa o next-auth para autenticação com o Google.
Estrutura
Título e Descrição: Exibe um título e uma descrição convidando os usuários a fazer login.
Campos do Formulário: Inclui campos para e-mail e senha.
Botão de Envio: Um botão para enviar os dados do formulário.
Link para Recuperação de Senha: Inclui um link para recuperação de senha.
Botão para Login com Google: Permite login rápido com a conta do Google.
Link para Cadastro: Inclui um botão/link para redirecionar os usuários para a página de cadastro.
Classes e Estilos
O componente utiliza Tailwind CSS para aplicar estilos responsivos e personalização. As classes CSS são aplicadas para controlar o layout e a aparência dos elementos em diferentes tamanhos de tela.

Navegação
Redirecionamento Após Login: Redireciona os usuários para a página /PaginaLogada após um login bem-sucedido.
Considerações Adicionais
Responsividade: O componente é responsivo e se adapta a diferentes tamanhos de tela, utilizando Tailwind CSS para estilização.
Design Atraente: Utiliza uma imagem de fundo e estilização específica para criar um design visualmente atraente e consistente com o restante do site.
Interação com Backend: Envia os dados do formulário para o backend usando uma requisição POST e valida o login.
Integração com Google Auth: Permite login rápido usando a conta do Google através do next-auth.

# Componente AtualizarCadastro

Objetivo Geral
O componente AtualizarCadastro permite que os usuários atualizem suas informações pessoais. Ele busca os dados do usuário logado a partir da sessão e os exibe em um formulário editável. Após a edição, os dados são enviados para o backend para serem atualizados.

Instalação e Dependências
Para utilizar este componente, certifique-se de ter as seguintes dependências instaladas no seu projeto:

next
react
react-dom
next-auth/react
Funcionamento
Estado formData: Armazena os dados do formulário, incluindo idUsuario, nome, sobrenome, telefone, e-mail e senha.
Estado errors: Armazena as mensagens de erro de validação para cada campo do formulário.
useEffect: Busca os dados do usuário logado na sessão e preenche o formulário.
Função handleChange: Atualiza o estado formData conforme o usuário preenche os campos do formulário.
Função handleSubmit: Envia os dados do formulário para o backend usando uma requisição POST.
Estrutura
Imagem de Fundo: Exibe uma imagem de fundo decorativa.
Campos do Formulário: Inclui campos para nome, sobrenome, telefone, e-mail e senha.
Botão de Envio: Um botão para enviar os dados do formulário.
Validação
Nome: Campo editável, pré-preenchido com dados do usuário.
Sobrenome: Campo editável, pré-preenchido com dados do usuário.
Telefone: Campo editável, pré-preenchido com dados do usuário.
E-mail: Campo editável, pré-preenchido com dados do usuário.
Senha: Campo editável.
Classes e Estilos
O componente utiliza Tailwind CSS para aplicar estilos responsivos e personalização. As classes CSS são aplicadas para controlar o layout e a aparência dos elementos em diferentes tamanhos de tela.

Navegação
Seção Alvo: O componente pode ser usado em uma página de atualização de cadastro no site.
Considerações Adicionais
Responsividade: O componente é responsivo e se adapta a diferentes tamanhos de tela, utilizando Tailwind CSS para estilização.
Design Atraente: Utiliza uma imagem de fundo e estilização específica para criar um design visualmente atraente e consistente com o restante do site.
Interação com Backend: Envia os dados do formulário para o backend usando uma requisição POST e atualiza as informações do usuário.


# Componente ModalDeletarConta

Objetivo Geral
O componente ModalDeletarConta é um modal que permite aos usuários deletarem suas contas. Ele verifica se o usuário pode deletar a conta (por exemplo, não permitir exclusão para usuários logados com Google) e solicita confirmação antes de realizar a exclusão.

Instalação e Dependências
Para utilizar este componente, certifique-se de ter as seguintes dependências instaladas no seu projeto:

next
react
react-dom
next-auth/react
Funcionamento
Propriedades do Componente:
isOpen: Booleano que controla a visibilidade do modal.
onClose: Função que fecha o modal.
canDelete: Booleano que indica se o usuário pode deletar a conta.
useSession: Usa o hook useSession de next-auth/react para obter os dados da sessão do usuário logado.
Função handleDeleteAccount: Solicita confirmação e, se confirmada, envia uma requisição DELETE para o backend para deletar a conta do usuário.
Estrutura
Título e Ícone: Exibe o título "Deletar Conta" com um ícone de alerta.
Descrição: Fornece uma descrição explicando a irreversibilidade da ação de deletar a conta.
Botões de Ação: Inclui botões para cancelar a ação ou confirmar a exclusão da conta.
Classes e Estilos
O componente utiliza Tailwind CSS para aplicar estilos responsivos e personalização. As classes CSS são aplicadas para controlar o layout e a aparência dos elementos em diferentes tamanhos de tela.

Navegação
Seção Alvo: O componente é idealmente usado como um modal que pode ser chamado de qualquer página onde o usuário tenha a opção de deletar sua conta.
Considerações Adicionais
Responsividade: O componente é responsivo e se adapta a diferentes tamanhos de tela, utilizando Tailwind CSS para estilização.
Design Atraente: Utiliza ícones e estilização específica para criar um design visualmente atraente e consistente com o restante do site.
Interação com Backend: Envia os dados para o backend usando uma requisição DELETE e desloga o usuário após a exclusão da conta.
Restrição de Ação: Não permite a exclusão de contas de usuários logados com Google.

# Componente NotFoundPage

Objetivo Geral
O componente NotFoundPage exibe uma página amigável de erro 404 para quando um usuário navega para uma rota que não existe. Ele inclui uma mensagem informativa e um botão para voltar à página inicial.

Instalação e Dependências
Para utilizar este componente, certifique-se de ter as seguintes dependências instaladas no seu projeto:

next
react
react-dom
Funcionamento
Imagem de Fundo: Define uma imagem de fundo para a página de erro 404.
Mensagem de Erro: Exibe uma mensagem informativa indicando que a página não foi encontrada.
Botão para Voltar: Inclui um botão que redireciona o usuário de volta à página inicial.
Estrutura
Imagem de Fundo: Utiliza uma imagem de fundo com um efeito de gradiente para realçar o texto.
Imagem de Erro 404: Exibe uma imagem centralizada representando o erro 404.
Mensagem Informativa: Exibe uma mensagem abaixo da imagem indicando que a página não foi encontrada.
Botão de Redirecionamento: Um botão estilizado que redireciona o usuário de volta à página inicial.
Classes e Estilos
O componente utiliza Tailwind CSS para aplicar estilos responsivos e personalização. As classes CSS são aplicadas para controlar o layout e a aparência dos elementos em diferentes tamanhos de tela.

Navegação
Redirecionamento: O botão "voltar a superfície" redireciona o usuário para a página inicial.
Considerações Adicionais
Responsividade: O componente é responsivo e se adapta a diferentes tamanhos de tela, utilizando Tailwind CSS para estilização.
Design Atraente: Utiliza uma imagem de fundo e estilização específica para criar um design visualmente atraente e consistente com o restante do site.

# Componente OcorrenciaAnimal

Objetivo Geral
O componente OcorrenciaAnimal permite ao usuário registrar ocorrências de animais marinhos encontrados. O formulário é dividido em várias etapas para facilitar a inserção dos dados necessários.

Instalação e Dependências
Para utilizar este componente, certifique-se de ter as seguintes dependências instaladas no seu projeto:

next
react
react-dom
Funcionamento
Propriedades do Componente:
step: Número que representa a etapa atual do formulário.
setStep: Função para atualizar a etapa do formulário.
Estado do Componente:
formData: Objeto que armazena os dados inseridos pelo usuário.
showAddressSearch: Booleano que controla a visibilidade da pesquisa de endereço.
useCurrentLocation: Booleano que indica se a localização atual está sendo usada.
Submissão do Formulário:
Os dados do formulário são enviados ao backend usando uma requisição POST quando o usuário clica em "Enviar".
Estrutura
Etapas do Formulário:
Etapa 1: Coleta o nome, e-mail e telefone do usuário.
Etapa 2: Coleta informações sobre o animal e sua condição.
Etapa 3: Permite ao usuário buscar um endereço ou usar a localização atual.
Etapa 4: Permite anexar uma foto e fornecer uma descrição do ocorrido.
Classes e Estilos
O componente utiliza Tailwind CSS para aplicar estilos responsivos e personalização. As classes CSS são aplicadas para controlar o layout e a aparência dos elementos em diferentes tamanhos de tela.

Navegação
Navegação entre Etapas: Os botões "Próximo" e "Voltar" permitem a navegação entre as diferentes etapas do formulário.
Envio de Dados: Ao clicar no botão "Enviar", os dados do formulário são enviados ao backend.
Considerações Adicionais
Responsividade: O componente é responsivo e se adapta a diferentes tamanhos de tela, utilizando Tailwind CSS para estilização.
Interação com Backend: Envia os dados para o backend usando uma requisição POST e mapeia os nomes dos animais e condições para seus respectivos IDs antes do envio.
Funcionalidade de Localização: Permite ao usuário escolher entre buscar um endereço ou usar a localização atual para preencher os campos de localização automaticamente.
Upload de Arquivos: Permite ao usuário anexar uma foto ao registrar a ocorrência.


# Componente OcorrenciasAnimal

Objetivo Geral
O componente OcorrenciasAnimal permite aos usuários registrar ocorrências de animais marinhos encontrados ou poluentes (lixo) na área. Ele fornece um formulário multi-etapas para coletar todas as informações necessárias sobre a ocorrência.

Instalação e Dependências
Para utilizar este componente, certifique-se de ter as seguintes dependências instaladas no seu projeto:

next
react
react-dom
next/image
Funcionamento
Propriedades do Componente:
Este componente não aceita propriedades diretamente.
Estado do Componente:
selection: String que indica o tipo de ocorrência selecionada ('animal' ou 'poluente').
step: Número que representa a etapa atual do formulário.
Comportamento:
Ao clicar nos botões "Encalhe" ou "Poluente (Lixo)", o estado selection é atualizado para mostrar o formulário apropriado.
O formulário de ocorrência de animais é mostrado como padrão.
Navegação entre as etapas do formulário é controlada pelo estado step.
Estrutura
Layout Principal:
O layout é dividido em duas colunas para telas médias e maiores:
Coluna da Esquerda: Exibe uma imagem de mapa.
Coluna da Direita: Contém o formulário para registrar ocorrências.
Cabeçalho do Formulário:
Inclui um ícone e um título indicando que o usuário está registrando uma ocorrência.
Navegação entre Tipos de Ocorrência:
Dois botões permitem a seleção entre registrar um encalhe de animal ou um poluente (lixo).
Classes e Estilos
O componente utiliza Tailwind CSS para aplicar estilos responsivos e personalização. As classes CSS são aplicadas para controlar o layout e a aparência dos elementos em diferentes tamanhos de tela.

Navegação
Navegação entre Tipos de Ocorrência:
O usuário pode alternar entre registrar um encalhe de animal e um poluente (lixo) clicando nos botões correspondentes.
Formulário Multi-Etapas:
A navegação entre as etapas do formulário de ocorrência de animal é controlada pelos botões "Próximo" e "Voltar".
Considerações Adicionais
Responsividade: O componente é responsivo e se adapta a diferentes tamanhos de tela, utilizando Tailwind CSS para estilização.
Interação com Backend: O formulário de ocorrência de animal envia os dados ao backend usando uma requisição POST.
Imagens e Ícones: Utiliza o componente Image do Next.js para otimização de imagens.
Componentes Relacionados
OcorrenciaAnimal: Formulário multi-etapas para registrar ocorrências de animais.
Possível Extensão: Adicionar um componente para registrar ocorrências de poluentes (lixo) se necessário.


# Componente OcorrenciaPoluente

Objetivo Geral
O componente OcorrenciaPoluente permite aos usuários registrar ocorrências de poluentes (lixo) encontrados na área. Ele fornece um formulário multi-etapas para coletar todas as informações necessárias sobre a ocorrência.

Instalação e Dependências
Para utilizar este componente, certifique-se de ter as seguintes dependências instaladas no seu projeto:

react
next
next/image
tailwindcss
Funcionamento
Propriedades do Componente:
step: Número que representa a etapa atual do formulário.
setStep: Função para atualizar a etapa do formulário.
Estado do Componente:
formData: Objeto que armazena os dados do formulário.
showAddressSearch: Booleano que indica se a busca por endereço deve ser exibida.
useCurrentLocation: Booleano que indica se a localização atual deve ser usada.
Comportamento:
O formulário é dividido em etapas controladas pelo estado step.
A navegação entre as etapas é feita pelos botões "Próximo" e "Voltar".
O formulário permite a busca de endereço ou o uso da localização atual para preencher os dados de localização.
Estrutura
Etapa 1:
Coleta nome, e-mail e telefone do usuário.
Etapa 2:
Coleta tipo de resíduo, quantidade e se a área está em perigo.
Etapa 3:
Permite ao usuário pesquisar um endereço ou usar a localização atual.
Etapa 4:
Permite ao usuário anexar uma foto e fornecer uma descrição do ocorrido.
Campos de Formulário
nome: Nome do usuário.
email: E-mail do usuário.
telefone: Telefone do usuário.
tipoResiduo: Tipo de resíduo encontrado (deve ser mapeado para um ID).
qtdResiduo: Quantidade de resíduo.
areaPerigo: Indica se a área está em perigo (sim ou não).
cep: Código postal.
estado: Estado.
cidade: Cidade.
rua: Rua.
complemento: Complemento do endereço.
mensagem: Descrição do ocorrido.
foto: Foto do ocorrido.
latitude: Latitude da localização.
longitude: Longitude da localização.
Mapeamento de Tipos e Perigos
Tipos de Resíduos:
Plástico: ID 1
Metal: ID 2
Vidro: ID 3
Papel: ID 4
Orgânico: ID 5
Perigos:
Sim: "Sim"
Não: "Não"
Estilo
O componente utiliza Tailwind CSS para aplicar estilos responsivos e personalização. As classes CSS são aplicadas para controlar o layout e a aparência dos elementos em diferentes tamanhos de tela.

Navegação
Navegação entre Etapas:
A navegação entre as etapas do formulário é controlada pelos botões "Próximo" e "Voltar".
Interação com Backend
O formulário envia os dados ao backend usando uma requisição POST para o endpoint /projetoMilotech/rest/ocorrenciaPoluente/criar.

# PesquisarEndereco Component

O componente PesquisarEndereco permite aos usuários pesquisar e selecionar endereços utilizando a API de Places do Google Maps. Quando um endereço é selecionado, os detalhes do endereço são extraídos e passados para o callback onAddressSelect.

Instalação
Certifique-se de ter a biblioteca @react-google-maps/api instalada no seu projeto:

bash
Copiar código
npm install @react-google-maps/api
Dependências Ambientais
NEXT_PUBLIC_GOOGLE_MAPS_API_KEY: Variável de ambiente contendo a chave de API do Google Maps.
Propriedades do Componente
onAddressSelect: Uma função de callback que será chamada quando um endereço for selecionado. Recebe um objeto contendo os detalhes do endereço.