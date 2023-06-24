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
    var listIds = []
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
                    listIds.push(data[i].id)
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
                    
                    node.appendChild(document.createElement("br"))
                    node.appendChild(document.createElement("br"))
    
                    document.querySelector('ul').appendChild(node)
                }

                var btn = document.createElement("button")
                btn.innerHTML = "Atualizar requisito"
                btn.onclick = openModal1
                node.appendChild(btn)
            }  
        })
        .catch(error => { console.error(error) })
}

function atualizaRequisito(){
    let dadosAtualizacao= {
        id: document.querySelector('#id').value,
        comentario: document.querySelector('#comentario').value,
        status: document.querySelector('#status').value
    };

    if(document.querySelector('#status').value == ""){
        console.log("djfhsdjf")
        fetch("http://localhost:8080/users/atualizarRequisito",
        {
            headers: {
                "Content-Type": "application/json"
            },
            method: "PUT",
            body: JSON.stringify(
                {
                    id: dadosAtualizacao.id,
                    comentario: dadosAtualizacao.comentario
                }
            )
        })
        .then(function (res){
            console.log(res);
        })
        .catch(function (res) {
            console.log(res)
        })
    }else if(document.querySelector('#comentario').value == ""){
        fetch("http://localhost:8080/users/atualizarRequisito",
        {
            headers: {
                "Content-Type": "application/json"
            },
            method: "PUT",
            body: JSON.stringify(
                {
                    id: dadosAtualizacao.id,
                    status: dadosAtualizacao.status
                }
            )
        })
        .then(function (res){
            console.log(res);
        })
        .catch(function (res) {
            console.log(res)
        })
    }else{
        fetch("http://localhost:8080/users/atualizarRequisito",
        {
            headers: {
                "Content-Type": "application/json"
            },
            method: "PUT",
            body: JSON.stringify(
                {
                    id: dadosAtualizacao.id,
                    comentario: dadosAtualizacao.comentario,
                    status: dadosAtualizacao.status
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
    window.reload()
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
const modal1 = document.getElementById('modal1');
const closeBtn = document.getElementsByClassName('close')[0];

function openModal() {
  modal.style.display = 'block';
}

function openModal1() {
  modal1.style.display = 'block';
}

function closeModal() {
  modal.style.display = 'none';
}

function closeModal1() {
  modal1.style.display = 'none';
}