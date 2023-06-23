window.onload = verificaId()
window.onload = console.log(localStorage)

function criarRequisitos() {
    let dadosCadastro= {
        idResponsavel: localStorage.getItem("ID"),
        titulo: document.querySelector('#titulo').value,
        conteudo: document.querySelector('#conteudo').value,
        email_funcionario: document.querySelector('#email-funcionario').value,
        status: document.querySelector('#status').value
    };

    fetch("http://localhost:8080/users/cadastrarRequisito",
        {
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            method: "POST",
            body: JSON.stringify(
                {
                    id_responsavel: dadosCadastro.idResponsavel,
                    titulo: dadosCadastro.titulo,
                    conteudo: dadosCadastro.conteudo,
                    email_funcionario: dadosCadastro.email_funcionario,
                    status: dadosCadastro.status
                }
            )
        })
        .then(function (res){
            console.log(res);
        })
        .catch(function (res) {
            console.log(res)
    })
}

function verificaId() {
    id = localStorage.getItem("ID")
    fetch(`http://localhost:8080/users/verificaCadastro?id=${id}`)
        .then(response => response.json())
        .then(data => {
            console.log(data)
            if (data == 1) {
                document.getElementById("cadastrar-requisito").removeAttribute("hidden")
            }
        })
        .catch(error => { console.error(error) })
}

const openModalBtn = document.getElementById('openModalBtn');
const modal = document.getElementById('modal');
const closeBtn = document.getElementsByClassName('close')[0];

function openModal() {
  modal.style.display = 'block';
}

function closeModal() {
  modal.style.display = 'none';
}

openModalBtn.addEventListener('click', openModal);

closeBtn.addEventListener('click', closeModal);