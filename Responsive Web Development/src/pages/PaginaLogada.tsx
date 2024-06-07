'use client';
import React, { useState } from 'react';
import Link from 'next/link';
import { useSession, signOut } from 'next-auth/react';
import { useRouter } from 'next/navigation';
import { PieChart, Pie, Cell, ResponsiveContainer, BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, Legend, LineChart, Line } from 'recharts';
import ModalDeletarConta from '../components/ModalDeletarConta';

interface User {
  idUsuario: string;
  name?: string | null;
  email?: string | null;
  image?: string | null;
}

interface Session {
  user?: User;
}

const PaginaLogada: React.FC = () => {
  const { data: sessionData } = useSession();
  const session = sessionData as Session;
  const [isModalOpen, setIsModalOpen] = useState(false);
  const canDelete = session?.user?.idUsuario ? true : false;

  // Dados de exemplo para gráficos e tabelas
  const dataPieChart = [
    { name: 'Category A', value: 400 },
    { name: 'Category B', value: 300 },
    { name: 'Category C', value: 300 },
    { name: 'Category D', value: 200 },
  ];

  const dataBarChart = [
    { name: 'Page A', uv: 4000, pv: 2400, amt: 2400 },
    { name: 'Page B', uv: 3000, pv: 1398, amt: 2210 },
    { name: 'Page C', uv: 2000, pv: 9800, amt: 2290 },
    { name: 'Page D', uv: 2780, pv: 3908, amt: 2000 },
    { name: 'Page E', uv: 1890, pv: 4800, amt: 2181 },
    { name: 'Page F', uv: 2390, pv: 3800, amt: 2500 },
    { name: 'Page G', uv: 3490, pv: 4300, amt: 2100 },
  ];

  const dataLineChart = [
    { name: 'Jan', uv: 4000, pv: 2400, amt: 2400 },
    { name: 'Feb', uv: 3000, pv: 1398, amt: 2210 },
    { name: 'Mar', uv: 2000, pv: 9800, amt: 2290 },
    { name: 'Apr', uv: 2780, pv: 3908, amt: 2000 },
    { name: 'May', uv: 1890, pv: 4800, amt: 2181 },
    { name: 'Jun', uv: 2390, pv: 3800, amt: 2500 },
    { name: 'Jul', uv: 3490, pv: 4300, amt: 2100 },
  ];

  const dataTable = [
    { name: 'John Doe', email: 'john.doe@example.com', status: 'Active' },
    { name: 'Jane Doe', email: 'jane.doe@example.com', status: 'Inactive' },
    { name: 'Sam Smith', email: 'sam.smith@example.com', status: 'Active' },
    { name: 'Mary Johnson', email: 'mary.johnson@example.com', status: 'Inactive' },
  ];

  const COLORS = ['#0088FE', '#00C49F', '#FFBB28', '#FF8042'];

  return (
    <div className="grid md:flex min-h-screen">
      {/* Barra lateral esquerda com filtros */}
      
      <aside className="max-w-[86%] md:w-1/4 bg-gray-200 p-4">
        
        <h2 className="text-xl font-bold mb-4">Filtros</h2>
        
        <div className="space-y-4">
          
          <input type="text" placeholder="Filtrar por nome" className="w-full p-2 border border-gray-300 rounded" />
          <input type="text" placeholder="Filtrar por status" className="w-full p-2 border border-gray-300 rounded" />
          <button className="w-full py-2 px-4 bg-blue-500 text-white rounded">Aplicar Filtros</button>
        </div>

      </aside>

      {/* Conteúdo principal */}
      <main className="md:w-3/4 p-6 bg-white mb-20 max-w-[86%]">
        
        <header className="flex justify-end space-x-4 mb-6">
          
          <button className="py-2 px-4 bg-green-500 text-white rounded"><Link href='/AtualizarCadastro'>Alterar Cadastro</Link></button>
          <button className="py-2 px-4 bg-red-500 text-white rounded" onClick={() => setIsModalOpen(true)}>Excluir Conta</button>
          <button className="py-2 px-4 bg-gray-500 text-white rounded" onClick={() => signOut({ callbackUrl: '/' })}>Logout</button>
        </header>

        {/* Tabelas */}
        <section className="grid gap-6 mb-6">
          <div>
            <h2 className="text-lg font-bold mb-2">Tabela 1</h2>
            <table className="w-full border-collapse border border-gray-300">
              <thead>
                <tr>
                  <th className="border border-gray-300 p-2">Nome</th>
                  <th className="border border-gray-300 p-2">E-mail</th>
                  <th className="border border-gray-300 p-2">Status</th>
                </tr>
              </thead>
              <tbody>
                {dataTable.map((item, index) => (
                  <tr key={index}>
                    <td className="border border-gray-300 p-2">{item.name}</td>
                    <td className="border border-gray-300 p-2">{item.email}</td>
                    <td className="border border-gray-300 p-2">{item.status}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>

          <div>
            <h2 className="text-sm md:text-lg font-bold mb-2 text-wrap">Tabela 2</h2>
            <table className="w-full border-collapse border border-gray-300">
              <thead>
                <tr>
                  <th className="border border-gray-300 p-2">Nome</th>
                  <th className="border border-gray-300 p-2">E-mail</th>
                  <th className="border border-gray-300 p-2">Status</th>
                </tr>
              </thead>

              <tbody>
                {dataTable.map((item, index) => (
                  <tr key={index}>
                    <td className="border border-gray-300 p-2">{item.name}</td>
                    <td className="border border-gray-300 p-2">{item.email}</td>
                    <td className="border border-gray-300 p-2">{item.status}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </section>

        {/* Gráficos */}
        <section className="grid gap-6">
          <div className="w-full h-64">
            <h2 className="text-lg font-bold mb-2">Gráfico de Pizza</h2>
            <ResponsiveContainer width="100%" height="100%">
              <PieChart>
                <Pie
                  data={dataPieChart}
                  cx="50%"
                  cy="50%"
                  labelLine={false}
                  label={({ name, percent }) => `${name} (${(percent * 100).toFixed(0)}%)`}
                  outerRadius={80}
                  fill="#8884d8"
                  dataKey="value"
                >
                  {dataPieChart.map((entry, index) => (
                    <Cell key={`cell-${index}`} fill={COLORS[index % COLORS.length]} />
                  ))}
                </Pie>
              </PieChart>
            </ResponsiveContainer>
          </div>

          <div className="w-full h-64">
            <h2 className="text-lg font-bold mb-2">Gráfico de Barras</h2>
            <ResponsiveContainer width="100%" height="100%">
              <BarChart data={dataBarChart}>
                <CartesianGrid strokeDasharray="3 3" />
                <XAxis dataKey="name" />
                <YAxis />
                <Tooltip />
                <Legend />
                <Bar dataKey="pv" fill="#8884d8" />
                <Bar dataKey="uv" fill="#82ca9d" />
              </BarChart>
            </ResponsiveContainer>
          </div>

          <div className="w-full h-64">
            <h2 className="text-lg font-bold mb-2">Gráfico de Linhas</h2>
            <ResponsiveContainer width="100%" height="100%">
              <LineChart data={dataLineChart}>
                <CartesianGrid strokeDasharray="3 3" />
                <XAxis dataKey="name" />
                <YAxis />
                <Tooltip />
                <Legend />
                <Line type="monotone" dataKey="pv" stroke="#8884d8" />
                <Line type="monotone" dataKey="uv" stroke="#82ca9d" />
              </LineChart>
            </ResponsiveContainer>
          </div>
        </section>
      </main>

      <ModalDeletarConta isOpen={isModalOpen} onClose={() => setIsModalOpen(false)} canDelete={canDelete} />
    </div>
  );
};

export default PaginaLogada;
