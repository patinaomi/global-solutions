import React, { useState, useCallback } from 'react';
import { LoadScript, StandaloneSearchBox } from '@react-google-maps/api';

const apiKey = process.env.NEXT_PUBLIC_GOOGLE_MAPS_API_KEY || 'YOUR_FALLBACK_API_KEY';

interface AddressSearchProps {
  onAddressSelect: (address: {
    cep: string;
    estado: string;
    cidade: string;
    rua: string;
    complemento?: string;
  }) => void;
}

const PesquisarEndereco: React.FC<AddressSearchProps> = ({ onAddressSelect }) => {
  const [searchBox, setSearchBox] = useState<google.maps.places.SearchBox | null>(null);

  const onLoad = useCallback((ref: google.maps.places.SearchBox) => {
    setSearchBox(ref);
  }, []);

  const onPlacesChanged = useCallback(() => {
    if (!searchBox) return;

    const places = searchBox.getPlaces();
    if (!places || places.length === 0) return;

    const place = places[0];

    const address = {
      cep: '',
      estado: '',
      cidade: '',
      rua: '',
      complemento: '',
    };

    place.address_components?.forEach((component) => {
      const types = component.types;
      if (types.includes('postal_code')) {
        address.cep = component.long_name;
      } else if (types.includes('administrative_area_level_1')) {
        address.estado = component.short_name;
      } else if (types.includes('administrative_area_level_2')) {
        address.cidade = component.long_name;
      } else if (types.includes('route')) {
        address.rua = component.long_name;
      } else if (types.includes('sublocality_level_1') || types.includes('locality')) {
        address.complemento = component.long_name;
      }
    });

    onAddressSelect(address);
  }, [searchBox, onAddressSelect]);

  return (
    <LoadScript googleMapsApiKey={apiKey} libraries={['places']}>
      <StandaloneSearchBox onLoad={onLoad} onPlacesChanged={onPlacesChanged}>
        <input
          type="text"
          placeholder="Digite o endereço"
          className="w-full p-2 border border-gray-300 rounded"
          style={{
            boxSizing: 'border-box',
            border: '1px solid transparent',
            width: '240px',
            height: '32px',
            padding: '0 12px',
            borderRadius: '3px',
            boxShadow: '0 2px 6px rgba(0, 0, 0, 0.3)',
            fontSize: '14px',
            outline: 'none',
            textOverflow: 'ellipsis',
          }}
        />
      </StandaloneSearchBox>
    </LoadScript>
  );
};

export default PesquisarEndereco;
