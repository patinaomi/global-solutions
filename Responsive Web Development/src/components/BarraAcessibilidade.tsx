import React, { useState, useEffect } from 'react';
import {
  FolderMinusIcon,
  MoonIcon,
  ArrowUpIcon,
  ArrowDownIcon,
  ChatBubbleBottomCenterIcon,
  MegaphoneIcon,
  ComputerDesktopIcon,
  ShareIcon,
  SignalIcon
} from '@heroicons/react/20/solid';
import { useTheme } from './ThemeContext';

const solutions = [
  { name: 'Documentação', description: 'Conheça o que foi criado e como utilizar cada recurso para acessibilidade', href: '/DocumentacaoAcessibilidade', icon: FolderMinusIcon },
  { name: 'Tema', description: 'Defina entre claro ou escuro', href: '#', icon: MoonIcon, action: 'toggleDarkMode' },
  { name: 'Aumentar fonte', description: 'Defina o tamanho da fonte usando a seta para cima para aumentar a fonte', href: '#', icon: ArrowUpIcon, action: 'toggleFontIncrease' },
  { name: 'Diminuir fonte', description: 'Defina o tamanho da fonte usando seta para baixo para diminuir a fonte', href: '#', icon: ArrowDownIcon, action: 'toggleFontDecrease' },
  { name: 'Chat', description: 'Contato 24 horas por dia pelo Telegram, sobre qualquer assunto, faça até seu cadastro', href: 'https://t.me/global_MiloBot', icon: ChatBubbleBottomCenterIcon, action: 'CustomChat' },
  { name: 'Suporte Fala', description: 'Desative o suporte de fala', href: '#', icon: MegaphoneIcon, action: 'toggleStopText' },
  { name: 'Login pelo Google', description: 'Desative o suporte de fala', href: '#', icon: ComputerDesktopIcon, action: 'toggleStopText' },
  { name: 'Localização em tempo real', description: 'Desative o suporte de fala', href: '#', icon: SignalIcon, action: 'toggleStopText' },
  { name: 'Pesquisar do endereço - Maps', description: 'Desative o suporte de fala', href: '#', icon: ShareIcon, action: 'toggleStopText' },
];

const BarraAcessibilidade: React.FC = () => {
  const [isMobile, setIsMobile] = useState(false);
  const [expanded, setExpanded] = useState(false);
  const { toggleDarkMode } = useTheme();

  useEffect(() => {
    const handleResize = () => {
      setIsMobile(window.innerWidth < 768);
    };

    handleResize();
    window.addEventListener('resize', handleResize);

    return () => {
      window.removeEventListener('resize', handleResize);
    };
  }, []);

  const handleClick = (action: string | undefined, href: string | undefined) => {
    if (action) {
      switch (action) {
        case 'toggleDarkMode':
          toggleDarkMode();
          break;
        // Outros casos aqui
        default:
          console.log('Ação não reconhecida:', action);
      }
    }

    if (href && href.startsWith('http')) {
      window.open(href, '_blank');
    }
  };

  return (
    <nav
      className={`z-50 fixed ${isMobile ? 'bottom-0 left-0 w-full flex justify-between' : 'top-0 right-0'} bg-[#F5EAE8] p-4 ${isMobile ? 'md:hidden' : 'hidden md:flex md:flex-col md:justify-start md:h-full'}`}
      onMouseEnter={() => !isMobile && setExpanded(true)}
      onMouseLeave={() => !isMobile && setExpanded(false)}
    >
      {solutions.map((item, index) => (
        <a
          key={index}
          href={item.href}
          className="text-[#20A19A] flex items-center p-2 hover:bg-gray-700"
          onClick={(e) => {
            e.preventDefault();
            handleClick(item.action, item.href);
          }}
          target={item.href.startsWith('http') ? '_blank' : '_self'}
          rel="noopener noreferrer"
        >
          <item.icon className="h-6 w-6 mr-2" />
          <span className={expanded && !isMobile ? 'block' : 'hidden'}>{item.name}</span>
        </a>
      ))}
    </nav>
  );
};

export default BarraAcessibilidade;
