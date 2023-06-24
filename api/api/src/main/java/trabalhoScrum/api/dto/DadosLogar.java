package trabalhoScrum.api.dto;

import jakarta.validation.constraints.NotNull;

public record DadosLogar (
    @NotNull
    String email,

    @NotNull
    String senha
){}
