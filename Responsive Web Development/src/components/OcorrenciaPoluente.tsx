import React, { useState } from 'react';
import PesquisarEndereco from '../components/PesquisarEndereco';
import PosicaoAtual from '../components/PosicaoAtual';

interface FormProps {
  step: number;
  setStep: (step: number) => void;
}

const OcorrenciaPoluente: React.FC<FormProps> = ({ step, setStep }) => {
  const [formData, setFormData] = useState({
    nome: '',
    email: '',
    telefone: '',
    tipoResiduo: '', // Tem que enviar o ID com as opções
    qtdResiduo: '',
    areaPerigo: '', // Enviar sim ou nao
    cep: '',
    estado: '',
    cidade: '',
    rua: '',
    complemento: '',
    mensagem: '',
    foto: null,
    latitude: '', // string
    longitude: '', // string
  });

  const [showAddressSearch, setShowAddressSearch] = useState(false);
  const [useCurrentLocation, setUseCurrentLocation] = useState(false);

  const residuoOptions = ['Plástico', 'Metal', 'Vidro', 'Papel', 'Orgânico'];
  const perigoOptions = ['Sim', 'Não'];

  const residuoMapping: { [key: string]: string } = {
    'Plástico': '1',
    'Metal': '2',
    'Vidro': '3',
    'Papel': '4',
    'Orgânico': '5',
  };

  const handleAddressSelect = (address: {
    cep: string;
    estado: string;
    cidade: string;
    rua: string;
    complemento?: string;
  }) => {
    setFormData((prevFormData) => ({
      ...prevFormData,
      cep: address.cep,
      estado: address.estado,
      cidade: address.cidade,
      rua: address.rua,
      complemento: address.complemento || '',
    }));
    setShowAddressSearch(false);
  };

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement | HTMLSelectElement>) => {
    const { name, value } = e.target;
    setFormData((prevFormData) => ({
      ...prevFormData,
      [name]: value,
    }));
  };

  const handleFileChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, files } = e.target;
    setFormData((prevFormData) => ({
      ...prevFormData,
      [name]: files ? files[0] : null,
    }));
  };

  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    // Mapear os tipos de resíduos e área de perigo para os IDs correspondentes
    const dataToSend = {
      ...formData,
      tipoResiduo: residuoMapping[formData.tipoResiduo],
      areaPerigo: formData.areaPerigo,
    };

    // Adiciona o console.log para verificar os dados
    console.log('Dados enviados para o back', dataToSend);

    try {
      const response = await fetch('http://localhost:8080/projetoMilotech/rest/ocorrenciaPoluente/criar', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(dataToSend),
      });

      if (response.ok) {
        const result = await response.json();
        console.log('Ocorrência enviada:', result);
      } else {
        console.error('Erro ao enviar ocorrência');
      }
    } catch (error) {
      console.error('Erro:', error);
    }
  };

  const handleLocationFound = (location: { lat: number; lng: number }) => {
    setFormData((prevFormData) => ({
      ...prevFormData,
      latitude: location.lat.toString(),
      longitude: location.lng.toString(),
    }));
    setUseCurrentLocation(true);
  };

  return (
    <form className="space-y-6" onSubmit={handleSubmit}>
      {step === 1 && (
        <>
          <div className="flex flex-col space-y-2">
            <label htmlFor="nome" className="block text-sm font-medium text-gray-700">
              Nome
            </label>
            <input
              type="text"
              name="nome"
              id="nome"
              value={formData.nome}
              onChange={handleInputChange}
              className="w-full p-2 border border-gray-300 rounded"
              placeholder="Nome"
            />
          </div>

          <div className="flex flex-col space-y-2">
            <label htmlFor="email" className="block text-sm font-medium text-gray-700">
              E-mail
            </label>
            <input
              type="email"
              name="email"
              id="email"
              value={formData.email}
              onChange={handleInputChange}
              className="w-full p-2 border border-gray-300 rounded"
              placeholder="E-mail"
            />
          </div>

          <div className="flex flex-col space-y-2">
            <label htmlFor="telefone" className="block text-sm font-medium text-gray-700">
              Telefone
            </label>
            <input
              type="text"
              name="telefone"
              id="telefone"
              value={formData.telefone}
              onChange={handleInputChange}
              className="w-full p-2 border border-gray-300 rounded"
              placeholder="Telefone"
            />
          </div>

          <button type="button" onClick={() => setStep(2)} className="bg-[#20A19A] text-white py-2 px-4 rounded">
            Próximo
          </button>
        </>
      )}

      {step === 2 && (
        <>
          <div className="flex flex-col space-y-2">
            <label htmlFor="tipoResiduo" className="block text-sm font-medium text-gray-700">
              Tipo de Resíduo
            </label>
            <select
              name="tipoResiduo"
              id="tipoResiduo"
              value={formData.tipoResiduo}
              onChange={handleInputChange}
              className="w-full p-2 border border-gray-300 rounded"
            >
              <option value="">Selecione...</option>
              {residuoOptions.map((residuo) => (
                <option key={residuo} value={residuo}>
                  {residuo}
                </option>
              ))}
            </select>
          </div>

          <div className="flex flex-col space-y-2">
            <label htmlFor="qtdResiduo" className="block text-sm font-medium text-gray-700">
              Quantidade
            </label>
            <input
              type="text"
              name="qtdResiduo"
              id="qtdResiduo"
              value={formData.qtdResiduo}
              onChange={handleInputChange}
              className="w-full p-2 border border-gray-300 rounded"
              placeholder="Quantidade"
            />
          </div>

          <div className="flex flex-col space-y-2">
            <label htmlFor="areaPerigo" className="block text-sm font-medium text-gray-700">
              Coloca a Área em Perigo?
            </label>
            <select
              name="areaPerigo"
              id="areaPerigo"
              value={formData.areaPerigo}
              onChange={handleInputChange}
              className="w-full p-2 border border-gray-300 rounded"
            >
              <option value="">Selecione...</option>
              {perigoOptions.map((perigo) => (
                <option key={perigo} value={perigo}>
                  {perigo}
                </option>
              ))}
            </select>
          </div>

          <div className="flex justify-between">
            <button type="button" onClick={() => setStep(1)} className="bg-gray-200 text-black py-2 px-4 rounded">
              Voltar
            </button>
            <button type="button" onClick={() => setStep(3)} className="bg-[#20A19A] text-white py-2 px-4 rounded">
              Próximo
            </button>
          </div>
        </>
      )}

      {step === 3 && (
        <>
          <div className="flex justify-center gap-10 space-y-2 w-full">
            <button type="button" onClick={() => setShowAddressSearch(true)} className="bg-blue-500 text-white py-2 px-4 rounded mt-2 w-full">
              Pesquisar Endereço
            </button>

            <button
              type="button"
              onClick={() => setUseCurrentLocation(true)}
              className="bg-green-500 text-white py-2 px-4 rounded mt-2 w-full"
            >
              Usar Localização Atual
            </button>
          </div>

          {showAddressSearch && (
            <PesquisarEndereco onAddressSelect={handleAddressSelect} />
          )}

          {useCurrentLocation ? (
            <>
              <PosicaoAtual onLocationFound={handleLocationFound} />
              <div className="flex flex-col space-y-2">
                <label htmlFor="latitude" className="block text-sm font-medium text-gray-700">
                  Latitude
                </label>
                <input
                  type="text"
                  name="latitude"
                  id="latitude"
                  value={formData.latitude}
                  onChange={handleInputChange}
                  className="w-full p-2 border border-gray-300 rounded"
                  placeholder="Latitude"
                  readOnly
                />
              </div>

              <div className="flex flex-col space-y-2">
                <label htmlFor="longitude" className="block text-sm font-medium text-gray-700">
                  Longitude
                </label>
                <input
                  type="text"
                  name="longitude"
                  id="longitude"
                  value={formData.longitude}
                  onChange={handleInputChange}
                  className="w-full p-2 border border-gray-300 rounded"
                  placeholder="Longitude"
                  readOnly
                />
              </div>

              <div className="flex flex-col space-y-2">
                <label htmlFor="complemento" className="block text-sm font-medium text-gray-700">
                  Complemento
                </label>
                <input
                  type="text"
                  name="complemento"
                  id="complemento"
                  value={formData.complemento}
                  onChange={handleInputChange}
                  className="w-full p-2 border border-gray-300 rounded"
                  placeholder="Complemento"
                />
              </div>
            </>
          ) : (
            <>
              <div className="flex flex-col space-y-2">
                <label htmlFor="cep" className="block text-sm font-medium text-gray-700">
                  CEP
                </label>
                <input
                  type="text"
                  name="cep"
                  id="cep"
                  value={formData.cep}
                  onChange={handleInputChange}
                  className="w-full p-2 border border-gray-300 rounded"
                  placeholder="CEP"
                />
              </div>

              <div className="flex flex-col space-y-2">
                <label htmlFor="estado" className="block text-sm font-medium text-gray-700">
                  Estado
                </label>
                <input
                  type="text"
                  name="estado"
                  id="estado"
                  value={formData.estado}
                  onChange={handleInputChange}
                  className="w-full p-2 border border-gray-300 rounded"
                  placeholder="Estado"
                />
              </div>

              <div className="flex flex-col space-y-2">
                <label htmlFor="cidade" className="block text-sm font-medium text-gray-700">
                  Cidade
                </label>
                <input
                  type="text"
                  name="cidade"
                  id="cidade"
                  value={formData.cidade}
                  onChange={handleInputChange}
                  className="w-full p-2 border border-gray-300 rounded"
                  placeholder="Cidade"
                />
              </div>

              <div className="flex flex-col space-y-2">
                <label htmlFor="rua" className="block text-sm font-medium text-gray-700">
                  Rua
                </label>
                <input
                  type="text"
                  name="rua"
                  id="rua"
                  value={formData.rua}
                  onChange={handleInputChange}
                  className="w-full p-2 border border-gray-300 rounded"
                  placeholder="Rua"
                />
              </div>
            </>
          )}

          <div className="flex justify-between">
            <button type="button" onClick={() => setStep(2)} className="bg-gray-200 text-black py-2 px-4 rounded">
              Voltar
            </button>
            <button type="button" onClick={() => setStep(4)} className="bg-[#20A19A] text-white py-2 px-4 rounded">
              Próximo
            </button>
          </div>
        </>
      )}

      {step === 4 && (
        <>
          <div className="flex flex-col space-y-2">
            <label htmlFor="foto" className="block text-sm font-medium text-gray-700">
              Anexar Foto
            </label>
            <input
              type="file"
              name="foto"
              id="foto"
              onChange={handleFileChange}
              className="w-full p-2 border border-gray-300 rounded"
            />
          </div>

          <div className="flex flex-col space-y-2">
            <label htmlFor="mensagem" className="block text-sm font-medium text-gray-700">
              Descrição do Ocorrido
            </label>
            <textarea
              name="mensagem"
              id="mensagem"
              rows={4}
              value={formData.mensagem}
              onChange={handleInputChange}
              className="w-full p-2 border border-gray-300 rounded"
              placeholder="Descreva o ocorrido"
            ></textarea>
          </div>

          <div className="flex justify-between">
            <button type="button" onClick={() => setStep(3)} className="bg-gray-200 text-black py-2 px-4 rounded">
              Voltar
            </button>
            <button type="submit" className="bg-[#20A19A] text-white py-2 px-4 rounded">
              Enviar
            </button>
          </div>
        </>
      )}
    </form>
  );
};

export default OcorrenciaPoluente;
