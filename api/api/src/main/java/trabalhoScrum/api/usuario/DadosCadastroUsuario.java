package trabalhoScrum.api.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroUsuario(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String senha,

        @NotBlank
        @Pattern(regexp = "\\d{3}.\\d{3}.\\d{3}-\\d{2}")
        String cpf,

        @NotNull
        Cargo cargo
) {
}
