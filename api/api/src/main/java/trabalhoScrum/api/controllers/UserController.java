package trabalhoScrum.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import trabalhoScrum.api.usuario.DadosAtualizacaoUsuario;
import trabalhoScrum.api.usuario.DadosCadastroUsuario;
import trabalhoScrum.api.usuario.DadosLogar;
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

    @GetMapping
    public boolean logar(@RequestBody @Valid DadosLogar dados){
        var usr = repository.findByEmail(dados.email());
        System.out.println(usr);

        if (!usr.isEmpty() && usr.get(0).getSenha().equals(dados.senha())){
            return true;
        }
        return false;

    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoUsuario dados){
        var usr = repository.findByEmail(dados.email());
        usr.get(0).atualizaDadosUsuario(dados);
    }
}
