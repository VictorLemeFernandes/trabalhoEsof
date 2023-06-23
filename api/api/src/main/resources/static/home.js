window.onload = verificaId()

function criarRequisitos() {
    fetch('http://localhost:3000/requisitos')
        .then(response => response.json())
        .then(data => {
            console.log(data);
        })
        .catch(error => {
            console.error('Erro:', error);
        });
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