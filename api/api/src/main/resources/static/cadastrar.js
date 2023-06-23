function fazerCadastro(){
    let dadosCadastro = {
        nome: document.getElementById('name').value,
        email: document.querySelector('#email').value,
        senha: document.querySelector('#password1').value,
        cpf: document.querySelector('#cpf').value,
        cargo: document.querySelector('#cargo').value
    };
    
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

const form = document.getElementById("login_form");
    const campos = form.querySelectorAll("input");
    const emailRegex = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    var count = 0;

    function setError(index) {
        campos[index].style.border = '2px solid #e63636';
    }

    function removeError(index) {
        campos[index].style.border = '';
    }

    function nameValidate() {
        const input = document.getElementById("name");
        if (campos[0].value.length == 0) {
            setError(0);
            return 1;
        }
        removeError(0);
        return 0;
    }

    function emailValidate() {
        if (!emailRegex.test(campos[1].value)) {
            setError(1);
            return 1;
        } else {
            removeError(1);
            return 0;
        }
    }

    function passwordValidate() {
        if (campos[2].value != campos[3].value || campos[2].value == '') {
            setError(3);
            return 1;
        } else {
            removeError(3);
            return 0;
        }
    }


    function cpfValidate() {
        if (campos[4].value.length < 14) {
            setError(4);
            return 1;
        }
        for (i = 0; i < campos[4].value.length; i++) {
            if (i == 3 || i == 7 || i == 11) continue;
            var e = (campos[4].value[i]);
            console.log(e + "\n");
            if (isNaN(e)) {
                setError(4);
                return 1;
            } else {
                removeError(4);
            }
        }
        return 0;
    }

    function cargoValidate() {
        var opcSelecionada = document.querySelector('input[name="opcao"]:checked');

        if (opcSelecionada) {
            return 0;
        } else {
            return 1;
        }
    }

    function checkErrors() {
        count = 0
        count += nameValidate();
        count += emailValidate();
        count += passwordValidate();
        count += cpfValidate();
        count += cargoValidate();
        if (count != 0) {
            alert("Verifique os campos e tente novamente!");
        } else {
            alert("Sucesso!");
            window.location.href = "index.html";
        }
    }

    campos[4].addEventListener('keypress', () => {
        let inputLength = campos[4].value.length
        if (inputLength === 3 || inputLength === 7) {
            campos[4].value += '.'
        } else if (inputLength === 11) {
            campos[4].value += '-'
        }
    })