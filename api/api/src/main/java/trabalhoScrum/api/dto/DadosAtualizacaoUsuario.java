package trabalhoScrum.api.dto;

import jakarta.validation.constraints.NotNull;
import trabalhoScrum.api.usuario.Cargo;

public record DadosAtualizacaoUsuario(
    @NotNull
    String email,

    String senha,
    
    Cargo cargo
){}