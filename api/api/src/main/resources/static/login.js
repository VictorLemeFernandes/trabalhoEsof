function fazerLogin(){
    let dadosLogin = {
        email: document.querySelector('#user').value,
        senha: document.querySelector('#password').value
    };
    fetch("http://localhost:8080/users/login",
        {
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            method: "POST",
            body: JSON.stringify(
                {
                    email: dadosLogin.email,
                    senha: dadosLogin.senha
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

function fazerCadastro(){
    let dadosCadastro = {
        nome: document.getElementById('name').value,
        email: document.querySelector('#email').value,
        senha: document.querySelector('#password1').value,
        cpf: document.querySelector('#cpf').value,
        cargo: document.querySelector('#cargo').value
    };
    console.log(dadosCadastro.cargo)
    console.log(dadosCadastro.nome)
    fetch("http://localhost:8080/users/cadastrar",
        {
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            method: "POST",
            body: JSON.stringify(
                {
                    nome: dadosCadastro.nome,
                    email: dadosCadastro.email,
                    senha: dadosCadastro.senha,
                    cpf: dadosCadastro.cpf,
                    cargo: dadosCadastro.cargo
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
