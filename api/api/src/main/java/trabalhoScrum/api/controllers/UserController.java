package trabalhoScrum.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trabalhoScrum.api.usuario.DadosCadastroUsuario;
import trabalhoScrum.api.usuario.Usuario;
import trabalhoScrum.api.usuario.UsuarioRepository;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UsuarioRepository repository;

    @Transactional
    @PostMapping
    public void cadastrar(@Valid @RequestBody DadosCadastroUsuario dados) {
        repository.save(new Usuario(dados));
    }
}
