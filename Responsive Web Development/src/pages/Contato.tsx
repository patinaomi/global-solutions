import React from 'react';
import FormularioFeedback from '../components/FormularioFeedback';
import FormularioNews from '../components/FormularioNews';

const Contato: React.FC = () => {
  return (
    <div className="w-full max-w-[1280px] h-[860px] bg-white relative dark:bg-gray-900 dark:text-white">

      <div className="absolute top-0 left-0 bg-[#077B74] dark:bg-gray-900 dark:text-white">
        
        <div className="flex flex-col px-20 justify-center items-center mb-20">
          <span className="text-6xl font-montserrat font-extrabold text-teal-200 leading-[78px] text-center">fale conosco</span>
          <span className="mt-4 text-lg font-montserrat font-medium text-white leading-[27px] text-center">
            Temos interesse em ouvir suas sugestões, dúvidas ou feedback. Entre em contato conosco para saber mais sobre o projeto, nossas atividades de conservação ou como você pode se envolver mais.
          </span>
        </div>
      </div>

          <FormularioFeedback/>

          <FormularioNews/>

    </div>
  );
};

export default Contato;
