import React, { useState, useEffect, ChangeEvent, FormEvent } from 'react';
import { useSession, signIn, signOut } from 'next-auth/react';

interface User {
  idUsuario: string;
  name?: string | null;
  email?: string | null;
  image?: string | null;
}

interface Session {
  user?: User;
}

export default function AtualizarCadastro() {
  const { data: sessionData } = useSession();
  const session = sessionData as Session;

  const [formData, setFormData] = useState({
    idUsuario: '',
    nome: '',
    sobrenome: '',
    email: '',
    senha: '',
    telefone: ''
  });

  useEffect(() => {
    const fetchUserData = async () => {
      if (session && session.user && session.user.idUsuario) {
        try {
          const response = await fetch(`http://localhost:8080/projetoMilotech/rest/usuario/${session.user.idUsuario}`);
          if (!response.ok) {
            throw new Error('Erro ao buscar dados do usuário');
          }
          const userData = await response.json();
          setFormData({
            idUsuario: session.user.idUsuario,  // Aqui está o idUsuario da sessão
            nome: userData.nome,
            sobrenome: userData.sobrenome,
            email: userData.email,
            senha: '',  // Não preencher a senha por segurança
            telefone: userData.telefone
          });
        } catch (error) {
          console.error('Erro:', error);
        }
      }
    };

    fetchUserData();
  }, [session]);

  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setFormData((prevFormData) => ({
      ...prevFormData,
      [name]: value
    }));
  };

  const handleSubmit = async (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    // Inclui a nota (rating) no formData
    const dataToSend = { ...formData };

    // Adiciona o console.log para verificar os dados
    console.log('Dados enviados para o back', dataToSend);

    
    try {
      const response = await fetch('http://localhost:8080/projetoMilotech/rest/usuario/atualizar', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
      });

      if (!response.ok) {
        throw new Error('Erro ao atualizar os dados');
      }

      const result = await response.json();
      console.log('Dados atualizados com sucesso:', result);
      // Lógica adicional após a atualização bem-sucedida
    } catch (error) {
      console.error('Erro:', error);
      // Lógica de tratamento de erro
    }
  };

  return (
    <div className="flex items-center justify-center min-h-screen bg-[#B9E2E0]">
      <div className="flex flex-col md:flex-row items-center justify-center bg-white bg-opacity-80 shadow-lg w-[80%] h-[90%]">
        <div 
          className="flex flex-col items-center justify-center bg-cover bg-center w-full md:w-1/2 h-[80vh] border border-red-600" 
          style={{ backgroundImage: `linear-gradient(0deg, rgba(0,0,0,0.30), rgba(0,0,0,0.30)), url('/assets/AtualizarCadastro/atualizar.png')` }}>
          <div className="w-full h-full flex flex-col justify-center p-10">
            <h1 className="text-white text-6xl font-montserrat font-extrabold mb-10 text-left">
              Olá, <br />{session?.user?.name ?? session?.user?.email ?? 'Nome'}!
            </h1>
            <p className="text-white text-lg font-montserrat font-medium leading-10 text-left">
              Mantenha suas informações sempre <br /> atualizadas para garantir uma <br />experiência personalizada e <br /> eficiente. Clique no botão ao lado <br /> para editar seus dados pessoais.
            </p>
          </div>
        </div>

        <div className="flex flex-col justify-center p-8 w-full md:w-1/2 h-[80vh] bg-white">
          <span className="text-[#F1A027] font-montserrat text-2xl font-bold mb-6 text-left">MEUS DADOS</span>
          <form className="space-y-6" onSubmit={handleSubmit}>
            <div className="flex flex-col space-y-2">
              <input
                type="text"
                name="nome"
                className="bg-white border-0 border-b-2 border-[#8E99AB] focus:outline-none p-2 w-full font-montserrat font-normal"
                placeholder='Nome'
                value={formData.nome}
                onChange={handleChange}
              />
            </div>

            <div className="flex flex-col space-y-2">
              <input
                type="text"
                name="sobrenome"
                className="border-0 border-b-2 border-[#8E99AB] focus:outline-none p-2 w-full"
                placeholder='Sobrenome'
                value={formData.sobrenome}
                onChange={handleChange}
              />
            </div>
            <div className="flex flex-col space-y-2">
              <input
                type="number"
                name="telefone"
                className="border-0 border-b-2 border-[#8E99AB] focus:outline-none p-2 w-full"
                placeholder='Telefone'
                value={formData.telefone}
                onChange={handleChange}
              />
            </div>

            <div className="flex flex-col space-y-2">
              <input
                type="email"
                name="email"
                className="border-0 border-b-2 border-[#8E99AB] focus:outline-none p-2 w-full"
                placeholder='E-mail'
                value={formData.email}
                onChange={handleChange}
              />
            </div>

            <div className="flex flex-col space-y-2">
              <input
                type="password"
                name="senha"
                className="border-0 border-b-2 border-[#8E99AB] focus:outline-none p-2 w-full"
                placeholder='Senha'
                value={formData.senha}
                onChange={handleChange}
              />
            </div>

            <div className="flex justify-center mt-6 gap-10">
              <button type="submit" className="bg-[#007871] text-white rounded-full py-2 px-8">
                Atualizar Dados
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
}
