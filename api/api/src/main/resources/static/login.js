function fazerLogin(){
    let dadosLogin = {
        email: document.querySelector('#user').value,
        senha: document.querySelector('#password').value
    };
    fetch(`http://localhost:8080/users/login?email=${dadosLogin.email}&senha=${dadosLogin.senha}`)
        .then(response => response.json())
        .then(data => {
            if(data > 0){
                document.location.href = "home.html";
                localStorage.setItem("ID",data)
                localStorage.setItem("EMAIL",dadosLogin.email)
            }
            console.log(data);
        })
        .catch(error => {console.error(error)})
}