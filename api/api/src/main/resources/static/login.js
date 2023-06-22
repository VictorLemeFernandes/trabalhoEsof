function fazerLogin(){
    let dados = { 
        usuario: document.querySelector('#user').value, 
        senha: document.querySelector('#password').value 
    };
    
    let formData = JSON.stringify(dados);
    
    var xhr = new XMLHttpRequest();
    var url = "https://localhost:8080/users/logar"; // Substitua pela URL do seu endpoint do Spring
    
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.onreadystatechange = function() {
    if (xhr.readyState === 4 && xhr.status === 200){
        // A requisição foi bem-sucedida
        var response = JSON.parse(xhr.responseText);
        // Faça algo com a resposta do backend
        if(response){
            console.log(response)
        }
    }
    };

    xhr.send(formData);    
}
