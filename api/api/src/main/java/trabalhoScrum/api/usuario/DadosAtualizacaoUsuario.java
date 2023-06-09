package trabalhoScrum.api.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario(
    @NotNull
    String email,

    String senha,
    
    Cargo cargo
){}