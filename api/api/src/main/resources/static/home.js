window.onload = verificaId()
window.onload = pegarRequisitos()

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
            if (data == 1) {
                document.getElementById("cadastrar-requisito").removeAttribute("hidden")
            }
        })
        .catch(error => { console.error(error) })
}

function pegarRequisitos(){
    id = localStorage.getItem("ID")
    fetch(`http://localhost:8080/users/pegarRequisito?id=${id}`)
        .then(response => response.json())
        .then(data => {
            if(data.length == 0){
                var node = document.createElement('h3');
                node.appendChild(document.createTextNode("Não existem requisitos atribuidos a você"))
                document.querySelector('ul').appendChild(node)
            }else{
                for(i = 0;i < data.length;i++){
                    var node = document.createElement('li');
                    node.appendChild(document.createTextNode("Requisito " + (i+1) + " " + data[i].titulo + ":"))
                    node.appendChild(document.createElement("br"))
                    node.appendChild(document.createTextNode("Conteudo: " + data[i].conteudo))
                    node.appendChild(document.createElement("br"))
                    node.appendChild(document.createTextNode("Status: " + data[i].status))
                    node.appendChild(document.createElement("br"))
                    if(data[i].comentario == null){
                        node.appendChild(document.createTextNode("Comentário: Sem comentario"))
                    }else{
                        node.appendChild(document.createTextNode("Comentário: " + data[i].comentario))
                    }
                    
    
                    document.querySelector('ul').appendChild(node)
                }
            }  
        })
        .catch(error => { console.error(error) })
}

function pegarRequisitoCriados(){
    id = localStorage.getItem("ID")
    fetch(`http://localhost:8080/users/pegarRequisitoCriados?id=${id}`)
        .then(response => response.json())
        .then(data => {
            console.log(data)
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