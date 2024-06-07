"use client";
import React, { useState } from "react";
import Link from "next/link";
import { useRouter } from "next/navigation";
import { signIn } from "next-auth/react";
import imagem from "../../public/assets/Login/login_imagegradiente.png";

const Login: React.FC = () => {
  const [formData, setFormData] = useState({ email: "", password: "" });
  const [errors, setErrors] = useState({ email: "", password: "" });
  const router = useRouter();

  const validateForm = (): boolean => {
    let valid = true;
    const newErrors = { email: "", password: "" };

    if (!formData.email) {
      newErrors.email = "E-mail é obrigatório";
      valid = false;
    } else {
      newErrors.email = "";
    }

    if (!formData.password) {
      newErrors.password = "Senha é obrigatória";
      valid = false;
    } else {
      newErrors.password = "";
    }

    setErrors(newErrors);
    return valid;
  };

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    if (validateForm()) {
      try {
        const response = await fetch(
          "http://localhost:8080/projetoMilotech/rest/login/autenticar",
          {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({
              email: formData.email,
              senha: formData.password, // ajuste aqui para enviar os campos corretos
            }),
          }
        );

        if (response.ok) {
          const result = await response.json();
          console.log("Login bem-sucedido:", result);
          // Redirecionar ou realizar outras ações após login bem-sucedido
          router.push("/PaginaLogada");
        } else {
          const result = await response.json();
          console.error("Erro no login:", result);
          alert(result.message || "Erro ao realizar login");
          // Tratar erro de login
        }
      } catch (error) {
        console.error("Erro:", error);
        alert("Erro ao realizar login. Tente novamente mais tarde.");
      }
    }
  };


  return (
    
    <div className="grid md:flex justify-center items-center min-h-screen bg-[#F5EAE8] p-6">
      <div
        className="md:w-[50%] h-[80vh] bg-cover bg-center"
        style={{ backgroundImage: `url(${imagem.src})` }}
      >
        <div className="flex flex-col justify-center h-full p-10">
          <h1 className="text-4xl md:text-6xl font-montserrat font-extrabold text-left text-white mb-10 mt-20 md:mt-0">
            bem-vindo <br/>
            de volta!
          </h1>
          <p className="text-left text-white font-montserrat font-medium md:mt-4 md:leading-10 text-sm">
            Se você já faz parte da nossa comunidade, estamos <br /> felizes em
            vê-lo de volta! Insira suas credenciais ao <br /> lado para
            continuar acessando o site e contribuir para <br /> a conservação
            marinha. Seu engajamento é essencial <br /> para ajudar a proteger a
            vida marinha.
          </p>
        </div>
      </div>

      <div className="bg-white h-[100vh] md:h-[80vh] md:w-[30%] p-10 flex flex-col items-center">
        <div className="w-full">
          <h1 className="text-2xl font-montserrat font-bold text-[#F1A027] text-center">
            LOGIN
          </h1>
          <p className="text-center text-black font-montserrat font-normal mt-4">
            Insira seus dados nos campos abaixo ou utilize o acesso rápido com o
            Google para facilitar o processo.
          </p>
        </div>

        <form className="w-full mt-6 space-y-6" onSubmit={handleSubmit}>
          <div className="flex flex-col space-y-2">
            <input
              type="email"
              name="email"
              id="email"
              value={formData.email}
              onChange={handleChange}
              className="w-full p-3 border border-gray-300 rounded bg-[#B9E2E0] text-[#057872] placeholder-[#057872]"
              placeholder="E-mail"
            />
            {errors.email && (
              <p className="text-red-500 text-sm">{errors.email}</p>
            )}
          </div>

          <div className="flex flex-col space-y-2">
            <input
              type="password"
              name="password"
              id="password"
              value={formData.password}
              onChange={handleChange}
              className="w-full p-3 border border-gray-300 rounded bg-[#B9E2E0] text-[#057872] placeholder-[#057872]"
              placeholder="Senha"
            />
            {errors.password && (
              <p className="text-red-500 text-sm">{errors.password}</p>
            )}
          </div>

          <div className="flex justify-end w-full">
            <a href="#" className="text-black text-sm">
              Esqueceu sua senha?
            </a>
          </div>

          <div className="flex justify-between w-full">
            <button
              type="submit"
              className="w-1/2 py-2 px-4 bg-[#20A19A] text-white rounded hover:bg-[#1B807A] mr-2"
            >
              Login
            </button>
            <button
              type="button"
              className="w-1/2 py-2 px-4 bg-gray-200 text-black flex items-center justify-center rounded hover:bg-gray-300"
              onClick={() => signIn("google", { callbackUrl: "/PaginaLogada" })}
            >
              <span className="mr-2">Google</span>
            </button>
          </div>
        </form>

        <div className="min-w-full">
          <p className="text-center text-black font-montserrat font-normal mt-4">
            Se não possui cadastro, faça agora.
          </p>
          <div className="flex justify-center items-center w-full mt-5">
            <button className="w-full py-2 px-4 bg-[#20A19A] text-white rounded hover:bg-[#1B807A] mr-2">
              <Link href="/Cadastro">cadastre-se</Link>
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;