'use client';
import React, { useState } from 'react';
import Link from 'next/link';
import imagem from '../../public/assets/FormOcorrencia/mapa.png';
import icone from '../../public/assets/FormOcorrencia/Released Fish.png';
import Image from 'next/image';
import OcorrenciaPoluente from '../components/OcorrenciaPoluente';

const OcorrenciasPoluente: React.FC = () => {
  const [selection, setSelection] = useState<string>('poluente');
  const [step, setStep] = useState<number>(1);

  return (
    <div className='flex justify-center items-center min-h-screen bg-[#F5EAE8] p-6'>
      <div className='w-full md:w-1/2 p-3'>
        <Image src={imagem.src} alt="Mapa" className="w-full h-full object-cover rounded-lg" width={200} height={100} />
      </div>

      <div className="bg-white rounded-xl min-h-[100vh] md:h-auto w-full md:w-1/2 p-10 flex flex-col items-center">
        <div className="bg-[#F1A027] h-[180px] flex flex-col items-center justify-center rounded-md mb-6 relative w-full">
          <Image src={icone.src} alt="Ícone" className="absolute top-4 left-4 w-16 h-16" width={100} height={100}/>
          <h1 className="text-2xl font-bold text-white">Registrar Ocorrência</h1>
        </div>

        <div className="flex justify-center gap-5 w-full bg-gray-200 p-3">
          
          <button onClick={() => { setSelection('animal'); setStep(1); }} className={`py-2 px-4 rounded w-full ${selection === 'animal' ? 'bg-white text-black' : 'bg-gray-200 text-black'}`}>
            <Link href='/OcorrenciasAnimal'>Encalhe</Link>
          </button>

          <button onClick={() => { setSelection('poluente'); setStep(1); }} className={`py-2 px-4 rounded w-full ${selection === 'poluente' ? 'bg-white text-black' : 'bg-gray-200 text-black'}`}>
            Poluente (Lixo)
          </button>
        </div>

        <div className="w-full mt-6">
          {selection === 'poluente' && <OcorrenciaPoluente step={step} setStep={setStep} />}
          {/* Adicionar o componente de formulário para animais se necessário */}
        </div>
      </div>
    </div>
  );
};

export default OcorrenciasPoluente;
