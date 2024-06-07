import React, { useState } from 'react';
import Image from 'next/image';
import Link from 'next/link';
import { useRouter } from 'next/router';
import FocusableComponent from './NavegacaoAcessibilidade';

const Menu: React.FC = () => {
  const [menuOpen, setMenuOpen] = useState(false);
  const router = useRouter();

  const toggleMenu = () => {
    setMenuOpen(!menuOpen);
  };

  const closeMenu = () => {
    setMenuOpen(false);
  };

  
  const handleNavigation = (path: string) => {
    if (router.pathname === '/') {
      document.querySelector(path)?.scrollIntoView({ behavior: 'smooth' });
    } else {
      router.push('/' + path);
    }
    closeMenu();
  };


  return (
    
    <section className="relative flex justify-center items-center w-full h-[80px] bg-[#077B74] dark:bg-gray-900 dark:text-white">
      
      <div className="absolute top-0 left-0 w-full h-[80px] flex items-center bg-transparent px-10">
        <div className="flex justify-between items-center w-full max-w-screen-xl mx-auto">

        <FocusableComponent id="text0" tabIndex={0}>
          <div className="flex-shrink-0">
            <Link href="/">
              <Image
                src="/assets/Header/logo-image.png"
                alt="Logo do grupo MiloTechs"
                width={70}
                height={80}
              />
            </Link>
          </div>

          </FocusableComponent>

          <div className="hidden lg:flex items-center space-x-8">
            
            <ul className="flex space-x-8 font-montserrat font-semibold">
              <li id="text1" tabIndex={1} className="text-white font-semibold text-lg cursor-pointer" onClick={() => handleNavigation('#sobreProjeto')}>
                sobre o projeto
              </li>

              <li id="text2" tabIndex={2} className="text-white font-semibold text-lg cursor-pointer" onClick={() => handleNavigation('#funcionalidades')}>
                funcionalidades
              </li>

              <li id="text3" tabIndex={3} className="text-white font-semibold text-lg">
                <Link href="/Investimentos">crowdfunding</Link>
              </li>

              <li id="text4" tabIndex={4} className="text-white font-semibold text-lg cursor-pointer" onClick={() => handleNavigation('#Roadmap')}>
                roadmap
              </li>

              <li id="text5" tabIndex={5}  className="text-white font-semibold text-lg cursor-pointer" onClick={() => handleNavigation('#Educacao')}>
                educação
              </li>

              <li id="text6" tabIndex={6}  className="text-white font-semibold text-lg">
                <Link href="/Contato">contato</Link>
              </li>

              <li id="text7" tabIndex={7}  className="text-white font-semibold text-lg">
                <Link href="/Login">Login</Link>
              </li>

            </ul>

          </div>

          <div className="hidden lg:flex gap-5">
            <div className="flex items-center space-x-6">
              
              <button className="border border-white p-2">
                <span className="text-white font-semibold text-lg">
                  <Link id="text8" tabIndex={8}  href="/Cadastro">apoie nossa missão</Link>
                </span>
              </button>

            </div>
          </div>

          <button className="lg:hidden p-4 text-white" onClick={toggleMenu}>
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" className="w-6 h-6">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M4 6h16M4 12h16M4 18h16" />
            </svg>
          </button>
        </div>
      </div>

      {menuOpen && (
        <div className="fixed inset-0 bg-[#B9E2E0] z-50 flex flex-col items-center justify-center lg:hidden">
          <ul className="flex flex-col items-center space-y-8 font-montserrat font-semibold">
            <li className="text-black font-semibold text-lg cursor-pointer" onClick={() => handleNavigation('#sobreProjeto')}>
              sobre o projeto
            </li>
            <li className="text-black font-semibold text-lg cursor-pointer" onClick={() => handleNavigation('#Funcionalidades')}>
              funcionalidades
            </li>
            <li className="text-black font-semibold text-lg">
              <Link href="/Investimentos" onClick={closeMenu}>crowdfunding</Link>
            </li>
            <li className="text-black font-semibold text-lg cursor-pointer" onClick={() => handleNavigation('#Roadmap')}>
              roadmap
            </li>
            <li className="text-black font-semibold text-lg cursor-pointer" onClick={() => handleNavigation('#Educacao')}>
              educação
            </li>
            <li className="text-black font-semibold text-lg">
              <Link href="/Contato" onClick={closeMenu}>contato</Link>
            </li>
            <div className="flex flex-col space-y-4 items-center">
              <button className="p-2 w-full text-center bg-[#F1A027] rounded-md text-white">
                <span className=" font-semibold text-lg">
                  <Link href="/Cadastro" onClick={closeMenu}>apoie nossa missão</Link>
                </span>
              </button>
              <button className="p-2 w-full text-center bg-[#007871] rounded-md text-white">
                <span className="font-semibold text-lg">
                  <Link href="/Login" onClick={closeMenu}>Login</Link>
                </span>
              </button>
            </div>
            <li className="text-black font-semibold text-lg">
              <button onClick={closeMenu} className="w-full text-center">Fechar</button>
            </li>
          </ul>
        </div>
      )}
    </section>
  );
};

export default Menu;
