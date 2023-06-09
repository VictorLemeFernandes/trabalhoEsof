package trabalhoScrum.api.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosLogar (
    @NotNull
    String email,

    @NotNull
    String senha
){}
