package trabalhoScrum.api.dev;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "devs")
@Entity(name = "Dev")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Dev {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;

    public Dev(DadosCadastroDev dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
        this.cpf = dados.cpf();
    }

}
