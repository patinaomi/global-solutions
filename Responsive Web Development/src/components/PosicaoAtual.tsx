// PosicaoAtual.js
import React, { useEffect } from 'react';

interface Coordinates {
  lat: number;
  lng: number;
}

interface PosicaoAtualProps {
  onLocationFound: (location: Coordinates) => void;
}

const PosicaoAtual: React.FC<PosicaoAtualProps> = ({ onLocationFound }) => {
  useEffect(() => {
    navigator.geolocation.getCurrentPosition(
      (position) => {
        const newPosition = {
          lat: position.coords.latitude,
          lng: position.coords.longitude,
        };
        onLocationFound(newPosition); // Passa a localização para o componente pai
      },
      (error) => {
        console.error('Erro ao obter a localização', error);
      },
      { enableHighAccuracy: true, timeout: 20000, maximumAge: 1000 }
    );
  }, [onLocationFound]);

  return null; // Este componente não precisa renderizar nada visível
};

export default PosicaoAtual;
