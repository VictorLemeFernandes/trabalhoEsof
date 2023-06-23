package trabalhoScrum.api.requisitos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "requisitos")
@Entity(name = "Requisito")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Requisito {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long id_responsavel;
    private String titulo;
    private String conteudo;
    private String email_funcionario;
    private String comentario;

    @Enumerated(EnumType.STRING)
    private StatusRequisito status;

    public Requisito(DadosCadastroRequisitos dados) {
        this.id_responsavel = dados.id_responsavel();
        this.titulo = dados.titulo();
        this.conteudo = dados.conteudo();
        this.email_funcionario = dados.email_funcionario();
        this.comentario = dados.comentario();
        this.status = dados.status();
    }
}
