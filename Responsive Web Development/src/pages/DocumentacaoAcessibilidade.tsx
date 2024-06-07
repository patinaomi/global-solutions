import TextReader from "../components/LeitorTela";

export default function DocumentacaoAcessibilidade() {
  return (
    <section className="dark:bg-gray-700 dark:text-white px-5 md:p-10 min-h-[100vh] bg-white">
      
      <div className="md:px-4 md:py-16 mx-auto md:space-y-8 flex flex-col justify-center gap-10 mt-10 md:mt-0 ">
        
        <TextReader text="Documentação para acessibilidade">
          <h2 className="text-4xl md:text-6xl font-bold text-[#F1A027] dark:text-white">Documentação para acessibilidade</h2>
        </TextReader>

        <TextReader text="Saiba tudo sobre acessibilidade! Nossa seção de documentação foi desenvolvida para fornecer recursos acessíveis para todos. Você encontrará guias detalhados em texto, com instruções passo a passo para facilitar o aprendizado sobre acessibilidade. Navegue pelo nosso conteúdo e descubra como tornar sua experiência digital inclusiva e acessível para todos os usuários.">
        <p className="font-manrope text-md md:text-2xl leading-7 md:leading-10">
          Saiba tudo sobre acessibilidade! Nossa seção de documentação foi desenvolvida para fornecer recursos acessíveis para todos. Você encontrará guias detalhados em texto, com instruções passo a passo para facilitar o aprendizado sobre acessibilidade. Navegue pelo nosso conteúdo e descubra como tornar sua experiência digital inclusiva e acessível para todos os usuários.
        </p>
        </TextReader>


        <div className="space-y-8 flex flex-col justify-center gap-10">
          {/* Navegação usando TAB */}
          <div>
            <TextReader text="Navegação">
              <h3 className="mb-5 text-2xl md:text-4xl font-bold text-[#F1A027] dark:text-white">Navegação</h3>
            </TextReader>

            <div className="font-manrope text-md leading-7 md:leading-10 flex flex-col gap-5">
             

            <TextReader text="Utilizar a tecla tab para navegação é uma prática comum entre muitos usuários, especialmente aqueles que dependem exclusivamente do teclado para interagir com a web. Manter uma ordem de foco lógica e previsível ao usar a tecla tab torna a navegação mais intuitiva e eficiente. Essa abordagem também beneficia pessoas com deficiência visual, que usam leitores de tela que dependem dessa ordem para proporcionar uma experiência de navegação fluida e clara.">
            <p>
              <strong>Utilizar a tecla tab para navegação</strong> é uma prática comum entre muitos usuários, especialmente aqueles que dependem exclusivamente do teclado para interagir com a web. Manter uma ordem de foco lógica e previsível ao usar a tecla tab torna a navegação mais intuitiva e eficiente. Essa abordagem também beneficia pessoas com deficiência visual, que usam leitores de tela que dependem dessa ordem para proporcionar uma experiência de navegação fluida e clara.
            </p>
            </TextReader>


              <TextReader text="Além disso, a navegação pelo teclado é útil em situações em que o uso do mouse é impraticável ou impossível, como em dispositivos com tela sensível ao toque ou em ambientes de trabalho onde o uso do mouse é desencorajado. Portanto, ter um site que suporte a navegação pelo teclado usando a tecla tab é essencial para garantir que todas as pessoas possam acessar e interagir com o seu conteúdo de forma eficaz e inclusiva.">
                <p>
                  Além disso, a navegação pelo teclado é útil em <strong>situações em que o uso do mouse é impraticável ou impossível</strong>, como em dispositivos com tela sensível ao toque ou em ambientes de trabalho onde o uso do mouse é desencorajado. Portanto, ter um site que suporte a navegação pelo teclado usando a tecla tab é essencial para garantir que todas as pessoas possam acessar e interagir com o seu conteúdo de forma eficaz e inclusiva.
                </p>
              </TextReader>
            </div>
          </div>

          {/* Leitor de tela */}
          <div>
            
            <TextReader text="Leitor de tela">
              <h3 className="mb-5 text-2xl md:text-4xl font-bold text-[#F1A027] dark:text-white">Leitor de tela</h3>
            </TextReader>

            <div className="font-manrope text-md leading-7 md:leading-10 flex flex-col gap-5">
              <TextReader text="A leitura de texto seletiva, também chamada de text-to-speech (TTS) seletivo, permite que os usuários selecionem partes específicas de um texto em uma página da web para serem ouvidas em vez de lidas. Esta funcionalidade é especialmente útil para pessoas com dificuldades de leitura, déficits de atenção ou deficiências visuais.">
                <p>
                  A leitura de texto seletiva, também chamada de text-to-speech (TTS) seletivo, permite que os usuários selecionem partes específicas de um texto em uma página da web para serem ouvidas em vez de lidas. Esta funcionalidade é especialmente útil para pessoas com dificuldades de leitura, déficits de atenção ou deficiências visuais.
                </p>
              </TextReader>

              <TextReader text="De acordo com a Organização Mundial da Saúde (OMS), estima-se que cerca de 2,2 bilhões de pessoas no mundo têm algum tipo de deficiência visual ou cegueira. No Brasil, conforme o último Censo do IBGE, aproximadamente 6,7% da população declarou ter alguma deficiência visual, representando cerca de 13 milhões de pessoas. Estes dados ressaltam a importância de implementar recursos de acessibilidade como a leitura de texto seletiva, para atender às necessidades dessa significativa parcela da população.">
                <p>
                  De acordo com a Organização Mundial da Saúde (OMS), estima-se que cerca de 2,2 bilhões de pessoas no mundo têm algum tipo de deficiência visual ou cegueira. No Brasil, conforme o último Censo do IBGE, aproximadamente 6,7% da população declarou ter alguma deficiência visual, representando cerca de 13 milhões de pessoas. Estes dados ressaltam a importância de implementar recursos de acessibilidade como a leitura de texto seletiva, para atender às necessidades dessa significativa parcela da população.
                </p>
              </TextReader>

              <TextReader text="Inclusão e Acessibilidade: A implementação da leitura de texto seletiva torna o conteúdo mais acessível para pessoas com deficiência visual, dislexia, dificuldades de leitura e outros desafios que podem dificultar a compreensão do texto escrito.">
                <p>
                  <strong>Inclusão e Acessibilidade:</strong> A implementação da leitura de texto seletiva torna o conteúdo mais acessível para pessoas com deficiência visual, dislexia, dificuldades de leitura e outros desafios que podem dificultar a compreensão do texto escrito.
                </p>
              </TextReader>

              <TextReader text="Melhoria da Experiência do Usuário: Oferecer a opção de ouvir o texto selecionado em vez de lê-lo pode melhorar a experiência do usuário, tornando a navegação mais fácil e agradável.">
                <p>
                  <strong>Melhoria da Experiência do Usuário:</strong> Oferecer a opção de ouvir o texto selecionado em vez de lê-lo pode melhorar a experiência do usuário, tornando a navegação mais fácil e agradável.
                </p>
              </TextReader>

              <TextReader text="Atendimento a Diferentes Preferências de Consumo de Conteúdo: Nem todos os usuários preferem ou conseguem consumir conteúdo escrito. O TTS seletivo oferece uma alternativa valiosa para aqueles que preferem ou precisam ouvir o conteúdo.">
                <p>
                  <strong>Atendimento a Diferentes Preferências de Consumo de Conteúdo:</strong> Nem todos os usuários preferem ou conseguem consumir conteúdo escrito. O TTS seletivo oferece uma alternativa valiosa para aqueles que preferem ou precisam ouvir o conteúdo.
                </p>
              </TextReader>
            </div>
          </div>


          {/* Definição do Tema a página */}
          
          <div>
            <TextReader text="Tema">
              <h3 className="mb-5 text-2xl md:text-4xl font-bold text-[#F1A027] dark:text-white">Tema</h3>
            </TextReader>

            <div className="font-manrope text-md leading-7 md:leading-10 flex flex-col gap-5">
              <TextReader text="Implementar um tema claro e escuro em um site é uma prática importante de acessibilidade, permitindo que os usuários escolham o modo de visualização que melhor atende às suas preferências ou necessidades. Aqui estão alguns benefícios dessa implementação:">
                <p>
                  Implementar um tema claro e escuro em um site é uma prática importante de acessibilidade, permitindo que os usuários escolham o modo de visualização que melhor atende às suas preferências ou necessidades. Aqui estão alguns benefícios dessa implementação:
                </p>
              </TextReader>

              <TextReader text="Conforto Visual: Temas escuros podem ser preferidos por usuários que desejam reduzir o brilho da tela, proporcionando mais conforto, especialmente em ambientes com pouca iluminação.">
                <p>
                  <strong>Conforto Visual:</strong> Temas escuros podem ser preferidos por usuários que desejam reduzir o brilho da tela, proporcionando mais conforto, especialmente em ambientes com pouca iluminação.
                </p>
              </TextReader>

              <TextReader text="Economia de Energia: Em dispositivos com telas OLED, o tema escuro pode ajudar a economizar energia, pois os pixels pretos consomem menos energia do que os brancos.">
                <p>
                  <strong>Economia de Energia:</strong> Em dispositivos com telas OLED, o tema escuro pode ajudar a economizar energia, pois os pixels pretos consomem menos energia do que os brancos.
                </p>
              </TextReader>

              <TextReader text="Acessibilidade para Deficiências Visuais: Para usuários com sensibilidade à luz ou deficiências visuais, como cegueira noturna, o tema escuro pode facilitar a leitura e a navegação.">
                <p>
                  <strong>Acessibilidade para Deficiências Visuais:</strong> Para usuários com sensibilidade à luz ou deficiências visuais, como cegueira noturna, o tema escuro pode facilitar a leitura e a navegação.
                </p>
              </TextReader>

              <TextReader text="Preferências do Usuário: Permitir que os usuários escolham entre temas claro e escuro mostra consideração pelas suas preferências, melhorando a experiência e a fidelidade à marca.">
                <p>
                  <strong>Preferências do Usuário:</strong> Permitir que os usuários escolham entre temas claro e escuro mostra consideração pelas suas preferências, melhorando a experiência e a fidelidade à marca.
                </p>
              </TextReader>
            </div>
          </div>

          {/* Aplicação do VLibras para leitura do conteúdo em Libras */}
          <div>
            <TextReader text="Libras">
              <h3 className="mb-5 text-2xl md:text-4xl font-bold text-[#F1A027] dark:text-white">Libras</h3>
            </TextReader>

            <div className="flex justify-start items-center gap-3 mb-5">
              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" className="w-4 h-4 fill-current dark:text-[#3EA0E7]">
                <path d="M426.072,86.928A238.75,238.75,0,0,0,88.428,424.572,238.75,238.75,0,0,0,426.072,86.928ZM257.25,462.5c-114,0-206.75-92.748-206.75-206.75S143.248,49,257.25,49,464,141.748,464,255.75,371.252,462.5,257.25,462.5Z"></path>
                <polygon points="221.27 305.808 147.857 232.396 125.23 255.023 221.27 351.063 388.77 183.564 366.142 160.937 221.27 305.808"></polygon>
              </svg>

              <TextReader text="Curiosidade">
                <h2 className="font-bold text-xl md:text-2xl">Curiosidade</h2>
              </TextReader>
            </div>

            <div className="font-manrope text-md leading-7 md:leading-10 flex flex-col gap-5">
              <TextReader text="A implementação de recursos de acessibilidade, como o VLibras, é essencial para garantir que todos possam acessar e interagir com seu site, independentemente de suas limitações físicas ou cognitivas. Além de ser uma prática inclusiva, esses recursos trazem diversos benefícios, como:">
                <p>
                  A implementação de recursos de acessibilidade, como o VLibras, é essencial para garantir que todos possam acessar e interagir com seu site, independentemente de suas limitações físicas ou cognitivas. Além de ser uma prática inclusiva, esses recursos trazem diversos benefícios, como:
                </p>
              </TextReader>

              <TextReader text="Ampla acessibilidade: A inclusão do VLibras permite que pessoas surdas ou com deficiência auditiva acessem o conteúdo do seu site, ampliando sua audiência e alcance.">
                <p>
                  <strong>Ampla acessibilidade:</strong> A inclusão do VLibras permite que pessoas surdas ou com deficiência auditiva acessem o conteúdo do seu site, ampliando sua audiência e alcance.
                </p>
              </TextReader>

              <TextReader text="Conformidade legal: Em muitos países, incluindo o Brasil, existem leis que exigem acessibilidade digital, como a Lei Brasileira de Inclusão da Pessoa com Deficiência (Lei 13.146/2015 - Estatuto da Pessoa com Deficiência). A implementação do VLibras ajuda a cumprir essas regulamentações.">
                <p>
                  <strong>Conformidade legal:</strong> Em muitos países, incluindo o Brasil, existem leis que exigem acessibilidade digital, como a Lei Brasileira de Inclusão da Pessoa com Deficiência (Lei 13.146/2015 - Estatuto da Pessoa com Deficiência). A implementação do VLibras ajuda a cumprir essas regulamentações.
                </p>
              </TextReader>

              <TextReader text="Melhoria da experiência do usuário: Recursos de acessibilidade beneficiam não apenas pessoas com deficiência, mas também melhoram a experiência de todos os usuários. Por exemplo, legendas em vídeos podem ser úteis em ambientes barulhentos.">
                <p>
                  <strong>Melhoria da experiência do usuário:</strong> Recursos de acessibilidade beneficiam não apenas pessoas com deficiência, mas também melhoram a experiência de todos os usuários. Por exemplo, legendas em vídeos podem ser úteis em ambientes barulhentos.
                </p>
              </TextReader>

              <TextReader text="Censo Demográfico: O último Censo Demográfico do IBGE, em 2010, identificou que aproximadamente 9,7 milhões de brasileiros têm algum tipo de deficiência auditiva. Embora nem todos usem a Libras como principal forma de comunicação, muitos têm essa língua como parte de suas vidas.">
                <p>
                  <strong>Censo Demográfico:</strong> O último Censo Demográfico do IBGE, em 2010, identificou que aproximadamente 9,7 milhões de brasileiros têm algum tipo de deficiência auditiva. Embora nem todos usem a Libras como principal forma de comunicação, muitos têm essa língua como parte de suas vidas.
                </p>
              </TextReader>
            </div>
          </div>


          {/* Login simplificado */}
          
          <div>
            <TextReader text="Login">
              <h3 className="mb-5 text-2xl md:text-4xl font-bold text-[#F1A027] dark:text-white">Login</h3>
            </TextReader>

            <ul className="space-y-4">
              <li className="space-y-1">
                <div className="flex items-center space-x-2">
                  <TextReader text="Faça login de forma rápida e fácil em apenas dois cliques! Use nossas plataformas parceiras para acessar nossos serviços sem a necessidade de se cadastrar na SalesForce. Com apenas dois cliques, você terá um acesso seguro e eficiente, proporcionando uma experiência de login simples e conveniente.">
                    <h4 className="font-manrope text-md leading-7 md:leading-10">
                      Faça login de forma rápida e fácil em apenas dois cliques! Use nossas plataformas parceiras para acessar nossos serviços sem a necessidade de se cadastrar na SalesForce. Com apenas dois cliques, você terá um acesso seguro e eficiente, proporcionando uma experiência de login simples e conveniente.
                    </h4>
                  </TextReader>
                </div>

                <div className="flex items-center space-x-2">

                  <TextReader text="Você sabia?">
                    <h2 className="font-bold text-xl md:text-2xl">Você sabia?</h2>
                  </TextReader>
                </div>

                <TextReader text="Processos de login demorados e complicados tendem a ser abandonados pelos usuários. Oferecendo uma opção de login simplificado, a taxa de abandono diminui significativamente, melhorando a experiência do usuário e aumentando a retenção.">
                  <p className="font-manrope text-md leading-7 md:leading-10">
                    Processos de login demorados e complicados tendem a ser abandonados pelos usuários. Oferecendo uma opção de login simplificado, a taxa de abandono diminui significativamente, melhorando a experiência do usuário e aumentando a retenção.
                  </p>
                </TextReader>
              </li>
            </ul>
          </div>

          {/* Localização com API do Maps */}
          <div>
              <TextReader text="Localização">
                <h3 className="mb-5 text-2xl md:text-4xl font-bold text-[#F1A027] dark:text-white">Localização</h3>
              </TextReader>

              <TextReader text="Usar a API do Google Maps para obter a localização do usuário é uma maneira eficiente de facilitar a interação e a navegação em seu site. Aqui estão alguns benefícios dessa prática:">
                <p className="font-manrope text-md leading-7 md:leading-10">
                  Usar a API do Google Maps para obter a localização do usuário é uma maneira eficiente de facilitar a interação e a navegação em seu site. Aqui estão alguns benefícios dessa prática:
                </p>
              </TextReader>

              <TextReader text="Precisão de Localização: A API do Google Maps fornece coordenadas de localização precisas, permitindo que os serviços oferecidos sejam personalizados de acordo com a localização exata do usuário.">
                <p>
                  <strong>Precisão de Localização:</strong> A API do Google Maps fornece coordenadas de localização precisas, permitindo que os serviços oferecidos sejam personalizados de acordo com a localização exata do usuário.
                </p>
              </TextReader>

              <br />

              <TextReader text="Melhoria da Experiência do Usuário: Ao identificar automaticamente a localização do usuário, a navegação torna-se mais rápida e eficiente, melhorando significativamente a experiência do usuário.">
                <p>
                  <strong>Melhoria da Experiência do Usuário:</strong> Ao identificar automaticamente a localização do usuário, a navegação torna-se mais rápida e eficiente, melhorando significativamente a experiência do usuário.
                </p>
              </TextReader>

              <TextReader text="Facilidade de Uso: A obtenção automática da localização elimina a necessidade de o usuário inserir manualmente seu endereço, tornando o processo mais conveniente e acessível.">
                <p>
                  <strong>Facilidade de Uso:</strong> A obtenção automática da localização elimina a necessidade de o usuário inserir manualmente seu endereço, tornando o processo mais conveniente e acessível.
                </p>
              </TextReader>
            </div>

            
            {/* Preenchimento com base em pesquisa do usuário */}
            <div>

              <TextReader text="Busca de Endereço">
                <h3 className="mb-5 text-2xl md:text-4xl font-bold text-[#F1A027] dark:text-white">Busca de Endereço</h3>
              </TextReader>

              <TextReader text="Utilizar a API do Google Maps para pesquisar endereços é uma funcionalidade poderosa que pode melhorar significativamente a experiência do usuário. Aqui estão alguns benefícios dessa funcionalidade:">
                <p className="font-manrope text-md leading-7 md:leading-10">
                  Utilizar a API do Google Maps para pesquisar endereços é uma funcionalidade poderosa que pode melhorar significativamente a experiência do usuário. Aqui estão alguns benefícios dessa funcionalidade:
                </p>
              </TextReader>

              <br />

              <TextReader text="Precisão e Confiabilidade: A API do Google Maps oferece dados precisos e atualizados, garantindo que os endereços pesquisados sejam corretos e confiáveis.">
                <p>
                  <strong>Precisão e Confiabilidade:</strong> A API do Google Maps oferece dados precisos e atualizados, garantindo que os endereços pesquisados sejam corretos e confiáveis.
                </p>
              </TextReader>
              
              <br />

              <TextReader text="Rapidez e Eficiência: Com a pesquisa automatizada, os usuários podem encontrar rapidamente os endereços que procuram, tornando a navegação mais eficiente e menos demorada.">
                <p>
                  <strong>Rapidez e Eficiência:</strong> Com a pesquisa automatizada, os usuários podem encontrar rapidamente os endereços que procuram, tornando a navegação mais eficiente e menos demorada.
                </p>
              </TextReader>

              <br />

              <TextReader text="Facilidade de Integração: A API do Google Maps é fácil de integrar com outros sistemas, permitindo que a funcionalidade de busca de endereço seja incorporada de forma simples e eficaz.">
                <p>
                  <strong>Facilidade de Integração:</strong> A API do Google Maps é fácil de integrar com outros sistemas, permitindo que a funcionalidade de busca de endereço seja incorporada de forma simples e eficaz.
                </p>
              </TextReader>
          </div>

        {/* Ajuste da fonte com o teclado*/}
        <div>
                
            <TextReader text="Ajuste da fonte com o teclad">
                <h3 className="mb-5 text-2xl md:text-4xl font-bold text-[#F1A027] dark:text-white">Ajuste da fonte com o teclado</h3>
            </TextReader>

                    
            <ul className="space-y-4">

                <div className="flex items-center space-x-2">
                
                <TextReader text="Controle a fonte com facilidade! Ative a opção de aumentar ou diminuir a fonte dos textos usando apenas as teclas do teclado. Com a seta para cima, você aumenta o tamanho da fonte, e com a seta para baixo, você diminui. Uma vez ativada a opção, você terá esse recurso disponível em todas as páginas, permitindo uma experiência de leitura mais confortável e personalizada.">
                    <h4 className="font-manrope text-md leading-7 md:leading-10">Controle a fonte com facilidade! Ative a opção de aumentar ou diminuir a fonte dos textos usando apenas as teclas do teclado. Com a seta para cima, você aumenta o tamanho da fonte, e com a seta para baixo, você diminui. Uma vez ativada a opção, você terá esse recurso disponível em todas as páginas, permitindo uma experiência de leitura mais confortável e personalizada.</h4>
                    </TextReader>

                </div>

                <li className="space-y-1">
                        
                        <div className="flex items-center space-x-2">

                            <TextReader text="Processo">
                            <h4 className="font-bold text-xl md:text-2xl">Processo</h4>
                            </TextReader>

                        </div>

                        <TextReader text="Etapa 1">
                        <p className="pt-5 mb-3"><strong>Etapa 1</strong></p>
                        </TextReader>

                        <TextReader text="Para ativar o recurso de personalizar o tamanho da fonte, tanto para aumentar quanto para diminuir, você terá que utilizar o menu localizado ao lado direito da sua tela.">
                        <p className="font-manrope text-md mb-3">Para ativar o recurso de personalizar o tamanho da fonte, tanto para aumentar quanto para diminuir, você terá que utilizar o menu localizado ao lado direito da sua tela. </p>
                        </TextReader>

                        <TextReader text="Etapa 2">
                        <p className="pt-5 mb-3"><strong>Etapa 2</strong></p>
                        </TextReader>

                        <TextReader text="Selecione a opção com a seta para cima para aumentar a fonte ou com a seta para baixo para diminuir. Após isso, atualize seu navegador (pressionando F5 ou clicando em atualizar) para aplicar as alterações.">
                        <p className="font-manrope text-md mb-3">Selecione a opção com a seta para cima para aumentar a fonte ou com a seta para baixo para diminuir. Após isso, atualize seu navegador (pressionando F5 ou clicando em atualizar) para aplicar as alterações.</p>
                        </TextReader>


                        <TextReader text="Etapa 3">
                        <p className="pt-5 mb-3"><strong>Etapa 3</strong></p>
                        </TextReader>

                        <TextReader text="Por padrão, o navegador já vem configurado para não ajustar a fonte automaticamente, pois isso pode atrapalhar a rolagem da tela caso o usuário utilize apenas o teclado. Por isso, é necessário ativar essa funcionalidade.">
                        <p className="font-manrope text-md mb-3">Por padrão, o navegador já vem configurado para não ajustar a fonte automaticamente, pois isso pode atrapalhar a rolagem da tela caso o usuário utilize apenas o teclado. Por isso, é necessário ativar essa funcionalidade.</p>
                        </TextReader>


                        <TextReader text="Etapa 4">
                        <p className="pt-5 mb-3"><strong>Etapa 4</strong></p>
                        </TextReader>

                        <TextReader text="Agora, basta pressionar a tecla [tecla] e o ajuste será feito de forma dinâmica, aumentando em 2px a fonte a cada clique.">
                        <p className="font-manrope text-md mb-3">Agora, basta pressionar a tecla [tecla] e o ajuste será feito de forma dinâmica, aumentando em 2px a fonte a cada clique.</p>
                        </TextReader>

                </li>


            </ul>
        
        </div>

        </div>
      </div>
    </section>
  );
}
