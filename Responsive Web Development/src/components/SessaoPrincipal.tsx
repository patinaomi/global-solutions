import React from 'react';
import Link from 'next/link';
import imagem from '../../public/assets/SessaoPrincipal/Desktop_Rectangle20.png';
import { useTheme } from './ThemeContext';
import TextReader from "../components/LeitorTela";


const SessaoPrincipal: React.FC = () => {
  const { isDarkMode } = useTheme();

  return (

    <div className="relative bg-gray-100 h-[100vh] dark:bg-gray-900 dark:text-white">
      
      <div className={`relative min-h-screen p-4 md:p-20 ${isDarkMode ? 'bg-gray-900' : 'bg-cover bg-center'}`} style={{ backgroundImage: isDarkMode ? 'none' : `linear-gradient(0deg, rgba(0,120,113,0.70), rgba(0,120,113,0.70)), url(${imagem.src})` }}>

        <div className="container mx-auto px-4 py-16 flex justify-start md:justify-end h-[100vh]">

          <div className="text-left md:text-right text-white">

          <TextReader text="Transforme sua paixão">
            
            <h1 id="text9" tabIndex={9}  className="text-4xl md:text-6xl font-montserrat font-extrabold">Transforme <br />sua paixão</h1>

          </TextReader>  

          <TextReader text="pelo mar em ação">
            
            <h2 id="text9" tabIndex={9}  className="text-4xl md:text-6xl font-montserrat font-extrabold">pelo mar em ação</h2>

          </TextReader> 

          <TextReader text="Descubra como cada um de nós pode fazer a diferença. Use nossa plataforma para registrar encalhes, participar de iniciativas de conservação e aprender mais sobre como você pode ajudar a salvar nossos oceanos.">
            
            <p id="text10" tabIndex={10}  className="mt-4 text-2xl font-montserrat font-medium">Descubra como cada um de nós pode fazer a diferença. Use nossa plataforma <br />para registrar encalhes, participar de iniciativas de conservação e aprender mais <br /> sobre como você pode ajudar a salvar nossos oceanos.</p>

          </TextReader> 

            <div className="mt-6 grid gap-5 w-full md:flex md:justify-end items-end">
              <button className="bg-[#F1A027] text-white px-4 py-2 rounded mr-2 font-montserrat font-semibold w-full md:w-[300px]">

            <TextReader text="Registrar ocorrência">
                
                 <Link id="text11" tabIndex={11}  href="/OcorrenciasAnimal">Registrar ocorrência</Link>

              </TextReader> 
              
              </button>

              <button className="bg-transparent text-white px-4 py-2 rounded border border-white font-montserrat font-semibold w-full md:w-[300px]">

              <TextReader text="">
                <Link id="text12" tabIndex={12}  href="/Login">Saiba mais</Link>
              </TextReader> 
              
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default SessaoPrincipal;
