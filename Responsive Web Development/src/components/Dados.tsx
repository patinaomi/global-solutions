import React from 'react';

const stats = [
  { id: 1, name: 'animais encontrados encalhados no litoral Paranaense', value: '1552' },
  { id: 2, name: 'encalhes registrados durante o mês de Agosto no Paraná', value: '457' },
  { id: 3, name: 'dos encalhes registrados  envolveram a espécie pinguim-de-magalhães', value: '80%' },
]

export default function Dados() {
  return (

        <div className="bg-[#B9E2E0] py-24 sm:py-32 md:h-[50vh] dark:bg-gray-900 dark:text-white">
          
          <div className="mx-auto max-w-7xl px-6 lg:px-8">
            
            <dl className="grid grid-cols-1 gap-x-8 gap-y-16 text-center lg:grid-cols-3 ">
              
              {stats.map((stat) => (
                <div key={stat.id} className="mx-auto flex max-w-xs flex-col gap-y-4 dark:text-white">
                  
                  <dd className="order-first text-3xl font-montserrat font-extrabold tracking-tight text-[#007871] sm:text-8xl dark:text-white">
                    {stat.value}
                  </dd>

                  <dt className="text-base leading-7 text-[#007871] dark:text-white">{stat.name}</dt>
                  
                  
                </div>
              ))}
            </dl>

          </div>
          
        </div>
    
  );
}
