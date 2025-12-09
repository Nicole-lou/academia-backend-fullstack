 document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('formCadastro');
    const btnFinalizar = document.getElementById('btnFinalizar');
    const mensagemDiv = document.getElementById('mensagem');
    const cadastroSection = document.getElementById('cadastro');

    // Função principal que verifica todos os campos obrigatórios
    function validarFormulario(formElement) {
        let isValido = true;

        // 1. Pega todos os inputs/selects que possuem o atributo 'required'
        const camposObrigatorios = formElement.querySelectorAll('[required]');

        camposObrigatorios.forEach(campo => {
            // Remove a classe de erro (caso tenha sido aplicada anteriormente)
            campo.classList.remove('is-invalid');

            // 2. Verifica se o campo está vazio (ou se é o select e a opção padrão está selecionada)
            if (campo.value.trim() === '' || (campo.tagName === 'SELECT' && campo.value === '')) {
                // Se estiver vazio, aplica a classe de erro do Bootstrap
                campo.classList.add('is-invalid');
                isValido = false;
            }
        });

        return isValido;
    }

    // 3. Adiciona o listener para o evento de SUBMISSÃO do formulário
    form.addEventListener('submit', function(event) {
        event.preventDefault(); // Impede o envio padrão para o backend (que seria um POST)

        if (validarFormulario(form)) {
            // Se a validação passar, inicia o feedback visual

            // Adiciona a classe 'loading' no botão para feedback visual
            btnFinalizar.classList.add('loading');

            // Simulação de envio para o Backend (simulando um atraso de 1.5s)
            setTimeout(() => {

                // Remove a classe 'loading'
                btnFinalizar.classList.remove('loading');

                // Obtém o nome do usuário para personalizar a mensagem
                const nome = document.getElementById('nome').value;
                const nomePlano = document.getElementById('planoSelect').value;

                // 4. Exibe a mensagem de sucesso no DOM, substituindo o formulário
                const sucessoHTML = `
                    <div class="container py-5">
                        <div class="row justify-content-center">
                            <div class="col-lg-8">
                                <div class="alert alert-success alert-success-custom text-center" role="alert">
                                    <h4 class="alert-heading logo-text text-center">
                                        <i class="bi bi-check-circle-fill"></i>
                                        CADASTRO FINALIZADO!
                                    </h4>
                                    <p class="mt-4">
                                        Parabéns, <span class="fw-bold">${nome}</span>! Sua inscrição no plano
                                        <span class="fw-bold text-primary-color">${nomePlano}</span> foi registrada com sucesso.
                                    </p>
                                    <hr>
                                    <p class="mb-0">
                                        Em breve, nossa equipe entrará em contato via WhatsApp para finalizar sua matrícula.
                                        Sua jornada na Energy Fitness começa agora!
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                `;

                // Substitui todo o conteúdo da seção de cadastro pela mensagem de sucesso
                cadastroSection.innerHTML = sucessoHTML;

            }, 1500); // Atraso de 1.5 segundo para simular o processamento

        } else {
            // Caso falhe a validação
            mensagemDiv.innerHTML = `
                <div class="alert alert-danger" role="alert">
                    Por favor, preencha todos os campos obrigatórios corretamente.
                </div>
            `;
        }
    });
});
