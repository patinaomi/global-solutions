import React, { useState } from 'react';

interface FormData {
  nome: string;
  email: string;
  telefone: string;
  mensagem: string;
  nota: number;
}

const StarIcon: React.FC<{ filled: boolean; onClick: () => void }> = ({ filled, onClick }) => (
  <svg
    onClick={onClick}
    className={`h-10 w-10 cursor-pointer ${filled ? 'text-yellow-500' : 'text-gray-300'}`}
    fill={filled ? 'currentColor' : 'none'}
    viewBox="0 0 24 24"
    stroke="currentColor"
    xmlns="http://www.w3.org/2000/svg"
  >
    <path
      strokeLinecap="round"
      strokeLinejoin="round"
      strokeWidth="2"
      d="M11.049 2.927c.3-.921 1.603-.921 1.902 0l2.073 6.36h6.704c.969 0 1.371 1.24.588 1.81l-5.396 3.928 2.073 6.36c.3.921-.755 1.683-1.54 1.193l-5.396-3.928-5.396 3.928c-.785.49-1.84-.272-1.54-1.193l2.073-6.36-5.396-3.928c-.783-.57-.38-1.81.588-1.81h6.704l2.073-6.36z"
    />
  </svg>
);

const FormularioFeedback: React.FC = () => {
  const [rating, setRating] = useState(0);
  const [formData, setFormData] = useState<FormData>({
    nome: '',
    email: '',
    telefone: '',
    mensagem: '',
    nota: 0, // Inicializamos a nota como 0
  });

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmitFeedback = async (e: React.FormEvent) => {
    e.preventDefault();

    // Inclui a nota (rating) no formData
    const dataToSend = { ...formData, nota: rating };

    // Adiciona o console.log para verificar os dados
    console.log('Dados enviados:', dataToSend);

    const response = await fetch('http://localhost:8080/projetoMilotech/rest/feedback/enviar', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(dataToSend),
    });
    const result = await response.json();
    console.log('Feedback enviado:', result);

  };

  const handleSetRating = (index: number) => {
    setRating(index + 1);
  };

  return (
    <form
      name="form-feedback"
      id="form-feedback"
      onSubmit={handleSubmitFeedback}
      className="absolute top-[280px] left-[118px] w-[711px] h-[413px] space-y-4 mt-20 font-montserrat font-medium"
    >
      <div className="flex space-x-4">
        <div className="w-[350px] h-[57px] rounded-full bg-[#B9E2E0] p-4">
          <input
            type="text"
            id="nome"
            name="nome"
            value={formData.nome}
            onChange={handleInputChange}
            placeholder="Nome"
            required
            className="w-full bg-transparent focus:outline-none text-lg font-medium text-[#057872]"
          />
        </div>

        <div className="w-[350px] h-[57px] rounded-full bg-[#B9E2E0] p-4">
          <input
            type="text"
            id="telefone"
            name="telefone"
            value={formData.telefone}
            onChange={handleInputChange}
            placeholder="Telefone"
            required
            className="w-full bg-transparent focus:outline-none text-lg font-medium text-teal-700"
          />
        </div>
      </div>

      <div className="w-full h-[57px] rounded-full bg-[#B9E2E0] p-4">
        <input
          type="email"
          id="email"
          name="email"
          value={formData.email}
          onChange={handleInputChange}
          placeholder="E-mail"
          required
          className="w-full bg-transparent focus:outline-none text-lg font-medium text-teal-700"
        />
      </div>

      <div className="w-full h-[182px] rounded-[25px] bg-[#B9E2E0] p-4">
        <textarea
          id="mensagem"
          name="mensagem"
          value={formData.mensagem}
          onChange={handleInputChange}
          placeholder="Mensagem"
          required
          className="w-full h-full bg-transparent focus:outline-none text-lg font-medium text-teal-700"
        />
      </div>

      <div className="w-full flex items-center justify-between">
        <div className="flex flex-grow space-x-1 justify-around">
          {[...Array(5)].map((_, index) => (
            <StarIcon key={index} filled={index < rating} onClick={() => handleSetRating(index)} />
          ))}
        </div>

        <button
          type="submit"
          className="w-[342px] h-[57px] rounded-full bg-teal-700 flex items-center justify-center text-lg font-medium text-white"
        >
          enviar mensagem
        </button>
      </div>
    </form>
  );
};

export default FormularioFeedback;
