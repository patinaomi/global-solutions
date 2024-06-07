import React, { useState } from 'react';
import Image from 'next/image';

/* Importações das imagens */
import imagem from '../../public/assets/Carrosel/_2misso_carouselimage.png';
import imagem4 from '../../public/assets/Carrosel/_2misso_arrowfoward.png';
import imagem5 from '../../public/assets/Carrosel/_2misso_arrowback.png';
import imagem6 from '../../public/assets/Carrosel/_2misso_contbackground.png';
import imagem7 from '../../public/assets/Carrosel/_2misso_Address.png';
import imagem8 from '../../public/assets/Carrosel/_2misso_Storytelling.png';
import imagem9 from '../../public/assets/Carrosel/_2misso_Alarm.png';
import imagem10 from '../../public/assets/Carrosel/imagem5.png';
import imagem11 from '../../public/assets/Carrosel/imagem6.png';
import imagem12 from '../../public/assets/Carrosel/imagem7.png';

export default function Missao() {
  const [currentSlide, setCurrentSlide] = useState(0);
  const totalSlides = 4;

  const slides = [
    {
      image: imagem.src,
      text: 'A missão do MarVida é capacitar cidadãos e comunidades a agir rapidamente diante de encalhes de animais marinhos, utilizando tecnologia para facilitar o monitoramento e a resposta. Encalhes podem ser desastrosos para as espécies afetadas, muitas vezes resultando em mortes que poderiam ser evitadas com ações imediatas.'
    },
    {
      image: imagem10.src,
      text: 'Encalhes ocorrem quando animais marinhos, como baleias, golfinhos, ou tartarugas, ficam presos em praias ou águas rasas. As causas variam desde doenças, lesões até desorientação provocada por interferências humanas como poluição sonora submarina.'
    },
    {
      image: imagem11.src,
      text: 'Através do aplicativo MarVida, qualquer pessoa pode se tornar um observador ativo. Ao reportar rapidamente um encalhe, você ajuda não apenas a salvar a vida do animal, mas também fornece dados valiosos que contribuem para a pesquisa e preservação de espécies marinhas.'
    },
    {
      image: imagem12.src,
      text: 'Participando do MarVida, você se junta a uma rede de conservação marinha que já ajudou a salvar centenas de vidas. Seu engajamento faz uma diferença real.'
    }
  ];

  const handleNext = () => {
    setCurrentSlide((prev) => (prev + 1) % totalSlides);
  };

  const handlePrev = () => {
    setCurrentSlide((prev) => (prev - 1 + totalSlides) % totalSlides);
  };

  return (

    <div className="bg-[#F5EAE8] relative mx-auto w-full min-h-screen flex flex-col items-center dark:bg-gray-900 dark:text-white">
      <Image className="absolute top-0 left-0 w-full h-[70px] object-cover" src={imagem6.src} alt="background" width={100} height={100} />

      <h1 className='md:hidden font-montserrat font-extrabold text-6xl pt-[130px] p-10 text-[#F1A027] leading-[90%]'>conheça um pouco <br /> sobre nossa <br /> missão</h1>

      <div className="flex flex-col md:flex-row items-center justify-center w-full mt-20  md:pt-0 space-y-10 md:space-y-0 md:space-x-10 relative">
        
        <div className=" w-[300px] md:w[350px] h-[357px] bg-white bg-opacity-10 border border-white rounded-[40px] p-4 flex flex-col items-center">
          <Image className="w-[80px] h-[80px] object-cover" src={imagem7.src} alt="Address" width={80} height={80} />
          <h2 id="text13" tabIndex={13}  className="mt-[47px] text-[#048E8C] dark:text-white font-montserrat font-bold text-[20px]">Reporte Instantâneo</h2>
          <p id="text14" tabIndex={14}  className="mt-[12px] text-center text-[#048E8C] font-montserrat font-medium text-[18px] leading-[27px] dark:text-white">
            Marque rapidamente a localização de encalhes e alerte as autoridades locais com apenas alguns toques.
          </p>
        </div>

        <div className="w-[300px] md:w[350px] h-[357px] bg-white bg-opacity-10 border border-white rounded-[40px] p-4 flex flex-col items-center">
          <Image className="w-[80px] h-[80px] object-cover" src={imagem9.src} alt="Alarm" width={80} height={80} />
          <h2 id="text15" tabIndex={15}  className="mt-[47px] text-[#048E8C] dark:text-white font-montserrat font-bold text-[20px]">Fique Informado</h2>
          <p className="mt-[12px] text-center text-[#048E8C] dark:text-white font-montserrat font-medium text-[18px] leading-[27px]">
            Receba notificações em tempo real sobre encalhes próximos e eventos de conservação marinha.
          </p>
        </div>

        <div className="w-[300px] md:w[350px] h-[357px]  bg-white bg-opacity-10 border border-white rounded-[40px] p-4 flex flex-col items-center">
          <Image className="w-[80px] h-[80px] object-cover" src={imagem8.src} alt="Storytelling" width={80} height={80} />
          <h2 id="text16" tabIndex={16}  className="mt-[47px] text-[#048E8C] dark:text-white font-montserrat font-bold text-[20px]">Aprenda e Contribua</h2>
          <p id="text17" tabIndex={17}  className="mt-[12px] text-center text-[#048E8C] dark:text-white font-montserrat font-medium text-[18px] leading-[27px]">
            Acesse materiais educativos e saiba como suas ações podem fazer a diferença na conservação dos oceanos.
          </p>
        </div>
      </div>

      <div className="relative w-full md:w-[95%] h-auto mt-20 md:h-[600px] p-4 md:p-0 mb-20">
        
        <div className="md:block hidden">

          <Image className="absolute object-cover rounded-xl w-full h-full opacity-90" src={slides[currentSlide].image} alt="carousel image" width={1400} height={800} />

          <div className="absolute w-full h-full flex justify-between items-center p-4">
            
            <button onClick={handlePrev} className="bg-white bg-opacity-50 p-2 rounded-full">
              <Image src={imagem5.src} alt="arrow back" width={40} height={40} />
            </button>

            <button onClick={handleNext} className="bg-white bg-opacity-50 p-2 rounded-full">
              <Image src={imagem4.src} alt="arrow forward" width={40} height={40} />
            </button>

          </div>
        </div>

        <p id="text18" tabIndex={18}  className="w-full bg-black bg-opacity-30 md:bg-opacity-10 text-white text-center py-6 font-montserrat text-[18px] md:text-[24px] font-medium leading-[27px] md:leading-[36px] mt-4 md:absolute md:bottom-0 md:mt-0 p-5 h-86 md:h-60">
          {slides[currentSlide].text}
        </p>
        
        <div className="flex justify-center mt-4 md:hidden">
          
          <button onClick={handlePrev} className="bg-[#20A19A] p-2 rounded-full mx-2">
            <Image src={imagem5.src} alt="arrow back" width={40} height={40} />
          </button>

          <button onClick={handleNext} className="bg-[#20A19A] p-2 rounded-full mx-2">
            <Image src={imagem4.src} alt="arrow forward" width={40} height={40} />
          </button>

        </div>
      </div>

    </div>
  );
}
