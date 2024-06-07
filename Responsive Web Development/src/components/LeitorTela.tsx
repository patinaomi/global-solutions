import React from 'react';

interface TextReaderProps  {
    text: string;
    children: React.ReactNode;
}

const LeitorTela: React.FC<TextReaderProps> = ({text, children  }) => {
  
  /* Precisa ser acionado ao clicar com o botão do mouse */
  const handleClick  = () => {
    
    console.log('Texto para ser lido:', text);

    // Checa se o navegador suporta a síntese de fala
    if ('speechSynthesis' in window) {

      // Cria uma nova instância de SpeechSynthesisUtterance
      const utterance = new SpeechSynthesisUtterance(text);

      // Define a língua da fala (exemplo em inglês)
      utterance.lang = 'pt-BR';

      // Inicia a fala
      window.speechSynthesis.speak(utterance);

    } else {
      console.error('Seu navegador não suporta a síntese de fala.');
    }
  };

  /* Acionar quando eu apertar a tecla TAB */
  const handleFocus = () => {
    handleClick();
  };


  return (
    <div 
    onClick={handleClick} 
    // onFocus={handleFocus}
    style={{ cursor: 'pointer' }}
    tabIndex={0}>
    
    {children }
    </div>
  );
};

export default LeitorTela;
