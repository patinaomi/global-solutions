import React from 'react'

export default function Funcionalidades() {
  return (

    <section className="bg-[#F5EAE8] dark:bg-gray-900 dark:text-white" id='funcionalidades'>
	
		<div className="container max-w-xl p-6 py-12 mx-auto space-y-24 lg:px-8 lg:max-w-7xl">

			<div className="grid lg:gap-8 lg:grid-cols-2 lg:items-center">
				
				<div>
					<h1 className="text-2xl md:text-6xl font-bold tracking-tight text-[#20A19A] dark:text-white">funcionalidades</h1>
					
					<div className="mt-12 space-y-12">
						
						<div className="flex">
							<div className="flex-shrink-0">
								
								<div className="flex items-center justify-center w-12 h-12 rounded-md">
									<img src="/assets/funcionalidades/imagem1.png" alt='imagem de uma cauda de peixe'></img>
								</div>
							</div>

							<div className="ml-4">

								<h4 className="text-lg font-medium leading-6 dark:text-white">Registro de Incidentes</h4>
								
								<p className="mt-2 dark:text-white">Utilize o aplicativo para registrar não só encalhes de animais marinhos, mas também ocorrências de resíduos poluentes e desastres ambientais marítimos, incluindo a localização exata, detalhes do incidente e fotos.</p>

							</div>

						</div>

						<div className="flex">
							<div className="flex-shrink-0">
								<div className="flex items-center justify-center w-12 h-12 rounded-md">
									<img src="/assets/funcionalidades/imagem2.png" alt="imagem de uma mapa" />
								</div>
							</div>
							<div className="ml-4">
								<h4 className="text-lg font-medium leading-6 dark:text-white">Mapa Interativo</h4>
								<p className="mt-2 dark:text-white">O aplicativo oferece um mapa interativo que mostra todos os encalhes reportados em tempo real, permitindo aos usuários visualizar e monitorar a situação nas suas proximidades ou em escala global.</p>
							</div>
						</div>
						
					</div>
				</div>
				<div aria-hidden="true" className="mt-10 lg:mt-0">
					<img src="/assets/funcionalidades/mockup-cel-1.png" alt="" className="mx-auto" />
				</div>
			</div>

			<div>
				<div className="grid lg:gap-8 lg:grid-cols-2 lg:items-center">
					
					<div className="lg:col-start-2">
						
						<div className="mt-12 space-y-12">
							
							<div className="flex">
								<div className="flex-shrink-0">
									<div className="flex items-center justify-center w-12 h-12 rounded-md">
										<img src="/assets/funcionalidades/imagem3.png" alt="" />
									</div>
								</div>

								<div className="ml-4">
									<h4 className="text-lg font-medium leading-6 dark:text-white">Alertas e Notificações</h4>
									<p className="mt-2 dark:text-white">Receba alertas sobre novos encalhes, avistamentos de resíduos poluentes, ou desastres ambientais nas suas proximidades, baseados em suas configurações de localização e preferências.</p>
								</div>
							</div>
							<div className="flex">
								<div className="flex-shrink-0">
									<div className="flex items-center justify-center w-12 h-12 rounded-md">
										<img src="/assets/funcionalidades/imagem4.png" alt="" />
									</div>
								</div>
								<div className="ml-4">
									<h4 className="text-lg font-medium leading-6 dark:text-white">Educação e Recursos</h4>
									<p className="mt-2 dark:text-white">Acesse uma variedade de recursos educativos que abordam desde a biologia marinha até técnicas para lidar com poluição e resgate de animais, enriquecendo seu conhecimento sobre o meio ambiente marinho e práticas de sustentabilidade.</p>
								</div>
							</div>

							<div>
								<button type="button" className="px-8 py-3 font-semibold rounded bg-[#F1A027] text-white w-full">faça seu cadastro</button>
							</div>
							
						</div>

						
					</div>
					
					<div className="mt-10 lg:mt-0 lg:col-start-1 lg:row-start-1">
						<img src="/assets/funcionalidades/mockup-cel-2.png" alt="" className="mx-auto" />
					</div>

				</div>
			</div>
		</div>

	</section>

  )
}
