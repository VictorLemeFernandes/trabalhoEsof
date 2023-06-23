// window.onload = alert(localStorage.getItem("ID"))

function requisitos() {
    fetch('http://localhost:3000/requisitos')
        .then(response => response.json())
        .then(data => {
            console.log(data);
        })
        .catch(error => {
            console.error('Erro:', error);
        });
}

function recebeDados(id){
    document.location.href = "home.html"
    console.log(id)
}

function verificaId(id) {
    
}
