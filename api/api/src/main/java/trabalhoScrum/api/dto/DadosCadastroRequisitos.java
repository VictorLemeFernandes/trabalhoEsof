package trabalhoScrum.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import trabalhoScrum.api.requisitos.StatusRequisito;

public record DadosCadastroRequisitos(
        @NotNull
        long id_responsavel,

        @NotBlank
        String titulo,

        @NotBlank
        String conteudo,

        @NotBlank
        String email_funcionario,

        String comentario,

        @NotNull
        StatusRequisito status) {
}
