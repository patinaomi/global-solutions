import React from 'react';
import Link from 'next/link';

import ImgAsset from '../../public/assets/404/_404notfound_background.png';
import imagem from '../../public/assets/404/404.png';

const NotFoundPage: React.FC = () => {
  return (
    <div className="relative w-full min-h-screen overflow-hidden bg-white">
      
      <div className="absolute inset-0 bg-cover bg-center" style={{ backgroundImage: `linear-gradient(0deg, rgba(0,75,70,0.40), rgba(0,75,70,0.40)), url(${'/assets/404/_404notfound_background.png'})` }}></div>
      
      <div className="absolute top-16 left-0 right-0 mx-auto max-w-screen-xl px-6 flex flex-col justify-center items-center text-center">
        
        <div className="text-white mb-8 flex flex-col justify-center items-center">
          
          <img src={imagem.src} alt="" />

          <p className="text-2xl">Oops! Parece que navegamos para águas desconhecidas!</p>
        </div>

        <div className="mt-16 mb-8">
          <button className="relative bg-white text-teal-700 font-bold text-lg py-3 px-8 border border-white shadow-lg">
            <span className="absolute inset-0 bg-transparent border border-white"></span>
            <span className="relative"><Link href="/">voltar a superfície</Link></span>
          </button>
        </div>

      </div>
    </div>
  );
}

export default NotFoundPage;
