import type { AppProps } from 'next/app';
import { useRouter } from 'next/router';
import { useEffect } from 'react';

/* 
Instalar:
npm install next-auth react
*/
import { SessionProvider, useSession } from "next-auth/react";
import '../globals.css';

// Importações de componentes
import Menu from '../components/Menu'; 
import Rodape from '@/components/Rodape';
import BarraAcessibilidade from '@/components/BarraAcessibilidade';
import { ThemeProvider } from '../components/ThemeContext';





function MyApp({ Component, pageProps: { session, ...pageProps } }: AppProps) {
  const router = useRouter();
  const isHomePage = router.pathname === '/'; // Verifica se está na HomePage

  useEffect(() => {
    const link = document.createElement('link');
    link.rel = 'stylesheet';
    link.href = 'https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css';
    document.head.appendChild(link);

    const script = document.createElement('script');
    script.src = 'https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js';
    script.async = true;
    document.body.appendChild(script);

    return () => {
      document.head.removeChild(link);
      document.body.removeChild(script);
    };
  }, []);

  return (
    <SessionProvider session={session}>

      <ThemeProvider>
      {/*{!isHomePage && <Header />*/}
      <Menu/>
      <BarraAcessibilidade/>
      <Component {...pageProps} />
      <Rodape />

      </ThemeProvider>
    </SessionProvider>
  );
}

export default MyApp;
