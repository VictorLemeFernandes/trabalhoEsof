package trabalhoScrum.api.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario(
    @NotNull
    Long id,

    String senha,
    
    Cargo cargo
){}