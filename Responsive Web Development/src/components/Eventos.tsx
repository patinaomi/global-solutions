import React, { useState } from 'react';
import Image from 'next/image';

import imagem from "../../public/assets/Carrosel/imagem1.png";
import imagem1 from "../../public/assets/Carrosel/imagem2.png";
import imagem2 from "../../public/assets/Carrosel/imagem3.png";

const Eventos: React.FC = () => {
  const [currentIndex, setCurrentIndex] = useState(0);

  const slides = [
    { id: 1, content: <Image src={imagem} alt="Slide 1" width={600} height={400} /> },
    { id: 2, content: <Image src={imagem1} alt="Slide 2" width={600} height={400} /> },
    { id: 3, content: <Image src={imagem2} alt="Slide 3" width={600} height={400} /> },
  ];

  const nextSlide = () => {
    setCurrentIndex((prevIndex) =>
      prevIndex === slides.length - 1 ? 0 : prevIndex + 1
    );
  };

  const prevSlide = () => {
    setCurrentIndex((prevIndex) =>
      prevIndex === 0 ? slides.length - 1 : prevIndex - 1
    );
  };

  return (
    <div className="w-full relative h-[700px] bg-gradient-to-b from-white to-[#007871]  dark:bg-gray-900 dark:text-white">
      
      <div className="flex h-full justify-center items-center md:pb-20 dark:bg-gray-900">
        {/* Mobile view: Show only one slide */}
        <div className="w-full flex justify-center items-center p-4 transition-transform duration-500 md:hidden dark:bg-gray-900 dark:text-white">
          {slides[currentIndex].content}
        </div>
        
        {/* Desktop view: Show three slides */}
        <div className="hidden md:flex h-full justify-center items-center dark:bg-gray-900">
          {slides.map((slide, index) => (
            <div
              key={slide.id}
              className={`w-1/3 dark:bg-gray-900 flex-shrink-0 p-4 transition-transform duration-500 ${index !== currentIndex && 'hidden md:flex'}`}
            >
              <div className="rounded-2xl h-76 flex justify-center items-center mb-10">
                {slide.content}
              </div>
            </div>
          ))}
        </div>
      </div>
      
      <div className="absolute bottom-12 left-1/2 transform -translate-x-1/2 flex space-x-4 dark:bg-gray-900">
        
        <button
          onClick={prevSlide}
          className="p-2 flex justify-center items-center border border-solid border-white w-12 h-12 transition-all duration-500 rounded-full hover:bg-[#F1A027] "
        >
          <svg
            className="h-5 w-5 text-white group-hover:text-white dark:bg-gray-900"
            xmlns="http://www.w3.org/2000/svg"
            width="16"
            height="16"
            viewBox="0 0 16 16"
            fill="none"
          >
            <path
              d="M10.0002 11.9999L6 7.99971L10.0025 3.99719"
              stroke="currentColor"
              strokeWidth="1.6"
              strokeLinecap="round"
              strokeLinejoin="round"
            />
          </svg>
        </button>

        <button
          onClick={nextSlide}
          className="p-2 flex justify-center items-center border border-solid border-white w-12 h-12 transition-all duration-500 rounded-full hover:bg-[#F1A027] "
        >
          <svg
            className="h-5 w-5 text-white group-hover:text-white"
            xmlns="http://www.w3.org/2000/svg"
            width="16"
            height="16"
            viewBox="0 0 16 16"
            fill="none"
          >
            <path
              d="M5.99984 4.00012L10 8.00029L5.99748 12.0028"
              stroke="currentColor"
              strokeWidth="1.6"
              strokeLinecap="round"
              strokeLinejoin="round"
            />
          </svg>
        </button>
      </div>

    </div>
  );
};

export default Eventos;
