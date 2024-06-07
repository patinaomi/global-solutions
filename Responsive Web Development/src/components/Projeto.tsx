import React from 'react';

const roadmapData = [
  {
    title: "PESQUISA E PLANEJAMENTO",
    description: "Gerar os dados e estatísticas que serão utilizados para demonstrar o que será desenvolvido neste projeto.",
    color: "#F1A027"
  },
  {
    title: "EDUCAÇÃO E TREINAMENTOS",
    description: "Produção de vídeos e conteúdos que orientarão usuários e parceiros sobre os procedimentos adequados, incluindo contatos relevantes e recursos disponíveis para casos de animais encalhados ou acúmulos de lixo.",
    color: "#20A19A"
  },
  {
    title: "MARKETING E DIVULGAÇÃO",
    description: "Divulgar nosso projeto em diversas redes sociais e promover boas práticas para proteger os animais e garantir o descarte adequado de resíduos.",
    color: "#F1A027"
  },
  {
    title: "RECOMPENSA",
    description: "As políticas e práticas de recompensa devem ser claramente delineadas e aplicadas a todos os usuários, parceiros e investidores que superam os objetivos da organização.",
    color: "#20A19A"
  },
  {
    title: "DESENVOLVIMENTO DO PROTÓTIPO",
    description: "Desenvolvimento de um site que identifica os locais onde animais e resíduos estão encalhados ou depositados. Este site será acessível a todos os públicos e compatível com diversos dispositivos.",
    color: "#F1A027"
  },
  {
    title: "MONITORAR DESEMPENHO",
    description: "Implementação de Business Intelligence para permitir que parceiros, investidores e usuários monitorem serviços em aberto, número de ocorrências e regiões afetadas.",
    color: "#20A19A"
  },
  {
    title: "INTEGRAÇÃO",
    description: "Integração do site com APIs do Google Maps, Gmail e Telegram, simplificando a usabilidade e oferecendo a oportunidade de desenvolver diversas soluções voltadas para a preservação do nosso planeta.",
    color: "#F1A027"
  },
  {
    title: "FEEDBACK VISUAL",
    description: "Desenvolvimento de um formulário para captar opiniões, sugestões e críticas relacionadas ao projeto.",
    color: "#20A19A"
  },
];

const Projeto: React.FC = () => {
  return (
    <div className="bg-[#F5EAE8] min-h-screen py-10 dark:bg-gray-900 dark:text-white" id="Roadmap">
      <div className="md:text-center mb-12">
        <div className="relative flex justify-center items-center mt-20 mb-20">
          <h1 className="relative text-[#F1A027] font-montserrat font-bold text-5xl md:text-7xl md:before:absolute md:before:content-[''] md:before:w-[336px] md:before:h-[3px] md:before:bg-[#F1A027] md:before:top-1/2 md:before:left-[-360px] md:after:absolute md:after:content-[''] md:after:w-[336px] md:after:h-[3px] after:bg-[#F1A027] md:after:top-1/2 md:after:right-[-360px]">
            roadmap
          </h1>
        </div>
        <p className="text-[#000] font-montserrat font-extralight text-2xl md:m-20 p-10 md:p-0 dark:text-white">
          Descubra o caminho que estamos trilhando para tornar a conservação marinha mais acessível e eficaz. Nosso roadmap destaca os principais marcos e etapas futuras para o desenvolvimento e aprimoramento do aplicativo MiloTech.
        </p>
      </div>

      <div className="relative container mx-auto p-10">
        {roadmapData.map((item, index) => (
          <div
            key={index}
            className={`mb-8 w-full flex flex-col items-center ${index % 2 === 0 ? 'md:flex-row' : 'md:flex-row-reverse'} md:justify-between`}
          >
            <div className="order-1 w-full md:w-5/12"></div>
            <div className={`order-1 w-full md:w-5/12 px-1 py-4 bg-white rounded-lg shadow-md border-l-8`} style={{ borderColor: item.color }}>
              <h3 className="font-montserrat font-extrabold text-2xl p-5" style={{ color: item.color }}>{item.title}</h3>
              <p className="text-sm font-montserrat font-extralight leading-snug tracking-wide text-gray-900 text-opacity-100 p-5">{item.description}</p>
            </div>
            <div className="order-1 md:flex justify-center items-center w-24 h-24 bg-white border-2 border-gray-200 rounded-full z-10 shadow-xl hidden">
              <h1 className="mx-auto text-white font-semibold text-lg" style={{ color: item.color }}>{index + 1}</h1>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Projeto;
