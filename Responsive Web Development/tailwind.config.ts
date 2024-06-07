import type { Config } from "tailwindcss";

const config: Config = {
  darkMode: 'class', // Adicione esta linha
  content: [
    "./src/pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/components/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
    extend: {
      backgroundImage: {
        "gradient-radial": "radial-gradient(var(--tw-gradient-stops))",
        "gradient-conic":
          "conic-gradient(from 180deg at 50% 50%, var(--tw-gradient-stops))",
      },

      // Definição dos breakpoints
      screens: {
        'ss': '375px',
        'sm': '579px',
        'md': '768px',
        'lg': '1024px',
        'xl': '1280px',
        'xx': '1440px',
        
      },

      fontFamily: {
        montserrat: ['Montserrat', 'sans-serif'],
      },
    },
  },
  plugins: [],
};

export default config;
