package trabalhoScrum.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import trabalhoScrum.api.dto.DadosAtualizacaoUsuario;
import trabalhoScrum.api.dto.DadosCadastroUsuario;
import trabalhoScrum.api.dto.DadosLogar;
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

    @GetMapping("/login") // PRECISAMOS CONSERTAR
    public void logar(@RequestBody DadosLogar dados) {
        var usr = repository.findByEmail(dados.email());

//        if (!usr.isEmpty()){
//            if(usr.get(0).getSenha().equals(dados.senha())){
//                System.out.println("Oi, deu bom");
//                return ResponseEntity.ok(usr.get(0).getId());
//            }else{
//                return ResponseEntity.ok((long) -1);
//            }
//        }
        repository.getReferenceById(usr.get(0).getId());
    }

//    @PutMapping
//    @Transactional
//    public void atualizar(@RequestBody @Valid DadosAtualizacaoUsuario dados){
//        var usr = repository.findByEmail(dados.email());
//        usr.get(0).atualizaDadosUsuario(dados);
//    }
}
