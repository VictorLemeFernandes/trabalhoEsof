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

import trabalhoScrum.api.dto.DadosAtualizacaoUsuario;
import trabalhoScrum.api.dto.DadosCadastroUsuario;
import trabalhoScrum.api.dto.DadosLogar;
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
    public Long logar(@RequestBody @Valid DadosLogar dados){
        var usr = repository.findByEmail(dados.email());

        if (!usr.isEmpty()){
            if(usr.get(0).getSenha().equals(dados.senha())){
                return usr.get(0).getId();
            }else{
                return (long) -1;
            }
        }
        return (long) 0;
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoUsuario dados){
        var usr = repository.findByEmail(dados.email());
        usr.get(0).atualizaDadosUsuario(dados);
    }
}
