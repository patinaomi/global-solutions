import React from 'react';
import Image from 'next/image';
import Link from 'next/link';

import imagem from '../../public/assets/Projeto/_3sobreoprojeto_play.png';
import imagem1 from '../../public/assets/Projeto/video.png';

export default function SobreProjeto() {
  return (

    <div className="mx-auto w-full min-h-screen bg-white md:py-10 dark:bg-gray-900 dark:text-white" id='sobreProjeto'>
      
      <h1 className="top-10 text-[#F1A027] dark:text-white font-montserrat font-extrabold text-7xl md:text-8xl md:leading-[126px] md:text-center p-10 md:p-0 mt-20 md:mt-0">
        sobre o projeto
      </h1>

      <div className='flex flex-col md:flex-row justify-between'>

        <div className="flex-col justify-start items-center pl-5 w-full md:p-10">
          
          <h2 className="text-[#20A19A] font-montserrat font-bold text-[40px] leading-[60px] p-5 md:p-0 dark:text-white">
            apresentação
          </h2>

          <p className="mt-4 text-black font-montserrat text-[20px] leading-[40px] p-5 md:p-0 dark:text-white">
            Estamos entusiasmados em apresentar nosso pitch, onde detalhamos a visão e a missão do projeto. Esta apresentação irá levá-lo através dos objetivos fundamentais do nosso aplicativo, como ele funciona, e o impacto significativo que esperamos alcançar na conservação marinha. Acompanhe para descobrir como estamos transformando a paixão pelo oceano em ações práticas para proteger a vida marinha.
          </p>

          <p className='pt-10 text-[#20A19A] dark:text-white'><a href="https://youtu.be/S0LE24cNHBY?si=k0JXk9OdfuKp8sNX" target='_blank'>Clique aqui e veja o pitch sobre o site</a></p>


        </div>
        
        <a href='https://www.youtube.com/watch?v=8i8KAik3cs8' target='_blank'>
        
        <div className="flex justify-center items-center p-5 md:p-10">
          
          <div className="relative w-[100vh] h-[60vh] bg-gray-200 bg-cover" style={{ backgroundImage: `url(${imagem1.src})` }}>
            <Image className="absolute inset-0 m-auto" src={imagem.src} alt="Play" width={130} height={100}/>
          </div>

        </div>
        </a>

      </div>
    </div>
  );
}
