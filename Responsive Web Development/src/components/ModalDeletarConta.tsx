import React from 'react';
import { useSession, signOut } from 'next-auth/react';

interface ModalDeletarContaProps {
  isOpen: boolean;
  onClose: () => void;
  canDelete: boolean;
}

interface User {
  idUsuario: string;
  name?: string | null;
  email?: string | null;
  image?: string | null;
}

interface Session {
  user?: User;
}

const ModalDeletarConta: React.FC<ModalDeletarContaProps> = ({ isOpen, onClose, canDelete }) => {
  const { data: sessionData } = useSession();
  const session = sessionData as Session;

  if (!isOpen) return null;

  const handleDeleteAccount = async () => {

    // Inclui a nota (rating) no formData
    const dataToSend = { ...useSession };

    // Adiciona o console.log para verificar os dados
    console.log('Dados enviados para o back', dataToSend);

    if (!session || !session.user || !session.user.idUsuario) {
      console.error('Usuário não autenticado ou ID de usuário não disponível.');
      return;
    }

    const idUsuario = session.user.idUsuario;
    const confirmDelete = confirm('Tem certeza de que deseja deletar sua conta? Esta ação é irreversível.');

    if (confirmDelete) {
      try {
        const response = await fetch(`http://localhost:8080/projetoMilotech/rest/usuario/deletar/${idUsuario}`, {
          method: 'DELETE',
        });

        if (response.ok) {
          console.log('Conta deletada com sucesso');
          signOut(); // Deslogar o usuário após deletar a conta
        } else {
          console.error('Erro ao deletar a conta');
        }
      } catch (error) {
        console.error('Erro:', error);
      }
    }
  };

  return (

    <div className="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50 z-50">

      <div className="flex flex-col max-w-md gap-2 p-6 rounded-md shadow-md bg-white text-gray-800">
        <h2 className="flex items-center gap-2 text-xl font-montserrat font-semibold leading-tight tracking-wide">
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" className="w-6 h-6 fill-current shrink-0 text-[#F1A027]">
            <path d="M451.671,348.569,408,267.945V184c0-83.813-68.187-152-152-152S104,100.187,104,184v83.945L60.329,348.568A24,24,0,0,0,81.432,384h86.944c-.241,2.636-.376,5.3-.376,8a88,88,0,0,0,176,0c0-2.7-.135-5.364-.376-8h86.944a24,24,0,0,0,21.1-35.431ZM312,392a56,56,0,1,1-111.418-8H311.418A55.85,55.85,0,0,1,312,392ZM94.863,352,136,276.055V184a120,120,0,0,1,240,0v92.055L417.137,352Z"></path>
            <rect width="32" height="136" x="240" y="112"></rect>
            <rect width="32" height="32" x="240" y="280"></rect>
          </svg>
          Deletar Conta
        </h2>

        {canDelete ? (
          <>
            <p className="flex-1 font-montserrat font-normal">
              Entendemos que pode haver motivos para encerrar sua conta. Se decidir que não deseja mais usar nosso serviço, você pode deletar sua conta aqui. Lembre-se de que esta ação é irreversível e resultará na perda de todos os seus dados armazenados.
            </p>
            <div className="flex flex-col justify-end gap-3 mt-6 sm:flex-row font-montserrat font-medium">
              <button className="px-6 py-2 rounded-sm" onClick={onClose}>Cancelar</button>
              <button className="px-6 py-2 rounded-sm shadow-sm bg-[#F1A027] text-gray-50" onClick={handleDeleteAccount}>Deletar Conta</button>
            </div>
          </>
        ) : (
          <div className="flex-1 font-montserrat font-normal text-black">
            
            <div>
              <p>A exclusão de conta não está disponível para usuários logados pelo Google.</p>
            </div>

            <div className="flex justify-center gap-3 mt-6 sm:flex-row font-montserrat font-medium bg-[#F1A027] text-white">
              <button className="px-6 py-2 rounded-sm" onClick={onClose}>Cancelar</button>
            </div>
          </div>
        )}
      </div>
    </div>
  );
};

export default ModalDeletarConta;
