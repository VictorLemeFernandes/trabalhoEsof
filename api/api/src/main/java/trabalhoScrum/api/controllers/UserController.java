package trabalhoScrum.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trabalhoScrum.api.dto.DadosCadastroUsuario;
import trabalhoScrum.api.usuario.Cargo;
import trabalhoScrum.api.usuario.Usuario;
import trabalhoScrum.api.usuario.UsuarioRepository;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/users/")
public class UserController {
    @Autowired
    private UsuarioRepository repository;

    @Transactional
    @PostMapping("/cadastrar") // FUNCIONANDO CORRETAMENTE
    public void cadastrar(@Valid @RequestBody DadosCadastroUsuario dados) {
        repository.save(new Usuario(dados));
    }

    @GetMapping("/login") // FUNCIONANDO CORRETAMENTE(?)
    public long logar(@RequestParam String email, String senha) {
        var usr = repository.findByEmail(email);
        if (!usr.isEmpty()) {
            if (usr.get(0).getSenha().equals(senha)){
                return usr.get(0).getId(); // > 0 -> id do usuario
            } else {
                return -1; // Senha invalida
            }
        } else {
            return -2; // Email inválido
        }
    }

    @GetMapping("/verificaCadastro") // FUNCIONANDO CORRETAMENTE(?)
    public long logar(@RequestParam long id) {
        var usr = repository.findById(id);
        if (usr.get().getCargo() == Cargo.PRODUCT_OWNER) {
            return (long) 1;
        } else {
            return (long) 0; // Email inválido
        }
    }

//    @PutMapping
//    @Transactional
//    public void atualizar(@RequestBody @Valid DadosAtualizacaoUsuario dados){
//        var usr = repository.findByEmail(dados.email());
//        usr.get(0).atualizaDadosUsuario(dados);
//    }
}
