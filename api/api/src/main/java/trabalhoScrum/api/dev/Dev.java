package trabalhoScrum.api.dev;

import jakarta.persistence.*;
import trabalhoScrum.api.usuario.Usuario;

@Table(name = "usuarios")
@Entity
public class Dev extends Usuario {

    public Dev(DadosCadastroDev dados) {
        super(dados.nome(), dados.email(), dados.senha(), dados.cpf(), dados.cargo());
    }

    public Dev() {
        // O @Entity obriga a criacao desse construtor sem funcionalidade.
    }

}
