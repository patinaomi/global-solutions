import React, { useState } from "react";

import imagem from '../../public/assets/Cadastro/Cadastro_background.png'
import imagem2 from '../../public/assets/Cadastro/glass.png'

export default function Cadastro() {
  const [formData, setFormData] = useState({
    nome: "",
    sobrenome: "",
    telefone: "",
    email: "",
    confirmEmail: "",
    senha: "",
    confirmSenha: "",
  });

  const [errors, setErrors] = useState({
    nome: "",
    sobrenome: "",
    telefone: "",
    email: "",
    confirmEmail: "",
    senha: "",
    confirmSenha: "",
  });

  const validate = () => {
    let valid = true;
    const newErrors = { ...errors };

    // Validação dos campos
    if (!formData.nome) {
      newErrors.nome = "Nome é obrigatório";
      valid = false;
    } else {
      newErrors.nome = "";
    }

    if (!formData.sobrenome) {
      newErrors.sobrenome = "Sobrenome é obrigatório";
      valid = false;
    } else {
      newErrors.sobrenome = "";
    }

    if (!formData.telefone) {
      newErrors.telefone = "Telefone é obrigatório";
      valid = false;
    } else {
      newErrors.telefone = "";
    }

    if (!formData.email) {
      newErrors.email = "E-mail é obrigatório";
      valid = false;
    } else {
      newErrors.email = "";
    }

    if (formData.email !== formData.confirmEmail) {
      newErrors.confirmEmail = "Os e-mails não coincidem";
      valid = false;
    } else {
      newErrors.confirmEmail = "";
    }

    if (!formData.confirmEmail) {
      newErrors.confirmEmail = "Confirmação de e-mail é obrigatória";
      valid = false;
    }

    if (!formData.senha) {
      newErrors.senha = "Senha é obrigatória";
      valid = false;
    } else if (
      !/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!*@#$%^&+=])(?=\S+$).{6,}$/.test(
        formData.senha
      )
    ) {
      newErrors.senha =
        "A senha deve conter no mínimo 6 caracteres, incluindo pelo menos um número, uma letra maiúscula, uma letra minúscula e um caractere especial";
      valid = false;
    } else {
      newErrors.senha = "";
    }

    if (formData.senha !== formData.confirmSenha) {
      newErrors.confirmSenha = "As senhas não coincidem";
      valid = false;
    } else {
      newErrors.confirmSenha = "";
    }

    if (!formData.confirmSenha) {
      newErrors.confirmSenha = "Confirmação é obrigatória";
      valid = false;
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

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    if (validate()) {
      try {
        const response = await fetch(
          "http://localhost:8080/projetoMilotech/rest/usuario/criar",
          {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify({
              nome: formData.nome,
              sobrenome: formData.sobrenome,
              telefone: formData.telefone.replace(/\D/g, ""), // Remove caracteres não numéricos
              email: formData.email,
              senha: formData.senha,
            }),
          }
        );
        if (response.ok) {
          alert("Cadastro realizado com sucesso!");
          setFormData({
            nome: "",
            sobrenome: "",
            telefone: "",
            email: "",
            confirmEmail: "",
            senha: "",
            confirmSenha: "",
          });
        } else {
          const result = await response.json();
          alert("Erro ao cadastrar: " + result.message);
        }
      } catch (error) {
        console.error("Erro:", error);
        alert(
          "Ocorreu um erro ao realizar o cadastro. Tente novamente mais tarde."
        );
      }
    }
  };

  return (

    <div className="relative mx-auto w-full min-h-screen bg-[#B9E2E0]" style={{ backgroundImage: `url(${imagem.src})` }}>
      <div className="absolute inset-0 bg-white bg-opacity-40"></div>

      <div className="relative flex flex-col items-center justify-center min-h-screen p-4">
        <div className="grid md:flex border h-auto p-0 bg-white shadow-lg w-full max-w-6xl gap-0">
          
          <div className="w-full flex flex-col justify-center p-10 text-white" style={{ backgroundImage: `url(${imagem2.src})` }}>
            <h2 className="font-montserrat font-extrabold text-6xl mb-10 text-left ">
              crie sua <br /> conta
            </h2>

            <p className="font-montserrat font-medium text-lg text-left max-w-2xl leading-10">
              Se você ainda não faz parte da nossa comunidade, <br /> junte-se
              hoje e comece a fazer a diferença! O cadastro <br /> é rápido e
              fácil. Preencha o formulário ao lado para <br /> começar a sua
              jornada na conservação marinha.
            </p>
          </div>

          <div className="w-full p-10">
            <h2 className="text-[#F1A027] font-montserrat text-2xl font-bold mb-6 text-center">
              DIGITE SEUS DADOS
            </h2>

            <form className="space-y-6 w-full" onSubmit={handleSubmit}>
              <div className="flex flex-col space-y-2 font-montserrat font-normal">
                <input
                  type="text"
                  name="nome"
                  value={formData.nome}
                  onChange={handleChange}
                  className="w-full p-2 rounded"
                  placeholder="Nome"
                />
                {errors.nome && (
                  <p className="text-red-500 text-sm">{errors.nome}</p>
                )}
                <div className="h-[2px] bg-[#8E99AB]"></div>
              </div>

              <div className="flex flex-col space-y-2">
                <input
                  type="text"
                  name="sobrenome"
                  value={formData.sobrenome}
                  onChange={handleChange}
                  className="w-full p-2 rounded"
                  placeholder="Sobrenome"
                />
                {errors.sobrenome && (
                  <p className="text-red-500 text-sm">{errors.sobrenome}</p>
                )}
                <div className="h-[2px] bg-[#8E99AB]"></div>
              </div>

              <div className="flex flex-col space-y-2">
                <input
                  type="text"
                  name="telefone"
                  value={formData.telefone}
                  onChange={handleChange}
                  className="w-full p-2 rounded"
                  placeholder="Telefone"
                />
                {errors.telefone && (
                  <p className="text-red-500 text-sm">{errors.telefone}</p>
                )}
                <div className="h-[2px] bg-[#8E99AB]"></div>
              </div>

              <div className="flex flex-col space-y-2">
                <input
                  type="email"
                  name="email"
                  value={formData.email}
                  onChange={handleChange}
                  className="w-full p-2  rounded"
                  placeholder="E-mail"
                />
                {errors.email && (
                  <p className="text-red-500 text-sm">{errors.email}</p>
                )}
                <div className="h-[2px] bg-[#8E99AB]"></div>
              </div>

              <div className="flex flex-col space-y-2">
                <input
                  type="email"
                  name="confirmEmail"
                  value={formData.confirmEmail}
                  onChange={handleChange}
                  className="w-full p-2 rounded"
                  placeholder="Confirme seu E-mail"
                />
                {errors.confirmEmail && (
                  <p className="text-red-500 text-sm">{errors.confirmEmail}</p>
                )}
                <div className="h-[2px] bg-[#8E99AB]"></div>
              </div>

              <div className="grid md:grid-cols-2 gap-3">
                <div className="flex flex-col space-y-2">
                  <input
                    type="password"
                    name="senha"
                    value={formData.senha}
                    onChange={handleChange}
                    className="w-full p-2 rounded"
                    placeholder="Senha"
                  />
                  {errors.senha && (
                    <p className="text-red-500 text-sm">{errors.senha}</p>
                  )}
                  <div className="h-[2px] bg-[#8E99AB]"></div>
                </div>

                <div className="flex flex-col space-y-2">
                  <input
                    type="password"
                    name="confirmSenha"
                    value={formData.confirmSenha}
                    onChange={handleChange}
                    className="w-full p-2 rounded"
                    placeholder="Confirme sua Senha"
                  />
                  {errors.confirmSenha && (
                    <p className="text-red-500 text-sm">
                      {errors.confirmSenha}
                    </p>
                  )}
                  <div className="h-[2px] bg-[#8E99AB]"></div>
                </div>
              </div>

              <div className="flex justify-center mt-6">
                <button
                  className="bg-[#007871] text-white rounded-full py-2 px-8"
                  type="submit"
                >
                  Criar Conta
                </button>
              </div>
            </form>
          </div>

        </div>
      </div>
    </div>
  );
}