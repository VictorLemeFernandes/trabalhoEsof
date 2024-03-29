package trabalhoScrum.api.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import trabalhoScrum.api.dto.DadosAtualizacaoUsuario;
import trabalhoScrum.api.dto.DadosCadastroUsuario;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    public Usuario(DadosCadastroUsuario dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
        this.cpf = dados.cpf();
        this.cargo = dados.cargo();
    }

    public void atualizaDadosUsuario(DadosAtualizacaoUsuario dados){
        if(dados.cargo() != null){
            this.cargo = dados.cargo(); 
        }

        if(dados.senha() != null){
            this.senha = dados.senha(); 
        }
    }
}
