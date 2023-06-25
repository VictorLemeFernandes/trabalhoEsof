package trabalhoScrum.api.dto;

import jakarta.validation.constraints.NotNull;
import trabalhoScrum.api.requisitos.StatusRequisito;

public record DadosAtualizacaoRequisitos (@NotNull long id, String comentario, StatusRequisito status) {}