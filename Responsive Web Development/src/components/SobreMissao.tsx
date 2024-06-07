import React from 'react';

export default function SobreMissao() {
  
  return (
    
    <div className="flex flex-col w-full bg-white p-6 md:p-8 justify-end items-center dark:bg-gray-900 dark:text-white">
      
      <div className="w-full flex justify-center mb-8">
        
        <h1 id="text13" tabIndex={13}  className="text-[#007871] dark:text-white font-montserrat text-6xl md:text-8xl font-extrabold">
          apoie nossa missão
        </h1>

      </div>

      <div className="w-full flex justify-center mb-4 p-0">
        <h2 id="text14" tabIndex={14}  className="text-black font-montserrat text-2xl font-extralight md:text-center dark:text-white">
          Para tornar este visionário aplicativo uma realidade, precisamos do seu apoio.
        </h2>
      </div>

      <div className="flex flex-col w-full bg-white md:p-8 justify-end gap-10  md:items-center mt-10 md:mt-0 dark:bg-gray-900 dark:text-white">
        <h2 id="text15" tabIndex={15}  className="text-black font-montserrat text-4xl font-extrabold leading-[50px] md:text-center dark:text-white">
          Contribua para o Nosso <br /> Financiamento Coletivo
        </h2>

        <p id="text16" tabIndex={16}  className='text-black font-montserrat font-extralight text-[20px] leading-[40px] md:text-center dark:text-white'>
          Estamos lançando uma campanha de financiamento coletivo para cobrir os custos de desenvolvimento e implementação do aplicativo. Cada contribuição é vital e nos aproxima de nosso objetivo. Ao apoiar nossa campanha, você não está apenas ajudando a lançar uma solução inovadora para a conservação marinha, mas também se torna parte de uma comunidade comprometida com a proteção dos oceanos.
        </p>
      </div>

      <div className="flex flex-col md:w-[70%] bg-[#B9E2E0] p-8 gap-10 rounded-xl items-center mt-20 md:mt-0 dark:bg-gray-900 dark:text-white">
        <h3 id="text17" tabIndex={17}  className="text-black font-montserrat dark:text-white text-4xl font-extrabold leading-[100%]">
          Como Contribuir
        </h3>

        <p id="text18" tabIndex={18}  className="md:text-center dark:text-white">
          Participar é fácil! Visite nosso formulário de financiamento coletivo para fazer sua <br /> contribuição. Escolha o valor da doação que se encaixa com sua capacidade de <br />apoio e saiba que qualquer valor faz uma diferença significativa.
        </p>
      </div>

      <div className="flex flex-col w-full bg-white md:p-8 gap-10 mt-20 items-center dark:bg-gray-900 dark:text-white">
        <h4 id="text19" tabIndex={19}  className="text-black font-montserrat text-4xl font-extrabold leading-[120%] md:text-center dark:bg-gray-900 dark:text-white">
          Recompensas para Nossos Apoiadores
        </h4>

        <p id="text20" tabIndex={20}  className='text-md md:text-center font-montserrat font-extralight'>
          Acreditamos que cada gesto de apoio merece ser reconhecido. Por isso, <br /> oferecemos recompensas atraentes para agradecer aos nossos doadores:
        </p>
      </div>

      <div id="text21" tabIndex={21}  className="flex flex-col p-5 bg-[#F1A027] w-full md:max-w-[30%] text-center justify-center items-center mt-10 md:mt-5 mb-20 md:mb-0">
        <button className='text-white font-montserrat font-semibold'>faça sua contribuição</button>
      </div>
    </div>
  );
}
