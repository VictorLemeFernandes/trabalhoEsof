package trabalhoScrum.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.io.Console;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import trabalhoScrum.api.dto.DadosAtualizacaoRequisitos;
import trabalhoScrum.api.dto.DadosCadastroUsuario;
import trabalhoScrum.api.requisitos.DadosCadastroRequisitos;
import trabalhoScrum.api.requisitos.Requisito;
import trabalhoScrum.api.requisitos.RequisitoRepository;
import trabalhoScrum.api.usuario.Cargo;
import trabalhoScrum.api.usuario.Usuario;
import trabalhoScrum.api.usuario.UsuarioRepository;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/users/")
public class UserController {
    @Autowired
    private UsuarioRepository repository;
    
    @Autowired
    private RequisitoRepository requisitoRepository;

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

    @Transactional
    @PostMapping("/cadastrarRequisito")
    public void cadastrarRequisito(@Valid @RequestBody DadosCadastroRequisitos dados) {
        requisitoRepository.save(new Requisito(dados));
    }

    @GetMapping("/pegarRequisito") // FUNCIONANDO CORRETAMENTE(?)
    public ArrayList<Requisito> pegarRequisitos(@RequestParam long id) {
        var usr = repository.findById(id).get().getEmail();
        var tam = requisitoRepository.count();
        requisitoRepository.findAll();
        ArrayList <Requisito> retorno = new ArrayList<>();
        for(int i = 1; i <= tam;i++){
            if(requisitoRepository.getReferenceById((long)i).getEmail_funcionario().equals(usr)){
                retorno.add(requisitoRepository.getReferenceById((long)i));
            }
        }
        return retorno;
    }

    @GetMapping("/pegarRequisitoCriados") // FUNCIONANDO CORRETAMENTE(?)
    public ArrayList<Requisito> pegarRequisitosCriados(@RequestParam long id) {;
        var tam = requisitoRepository.count();
        requisitoRepository.findAll();
        ArrayList <Requisito> retorno = new ArrayList<>();
        for(int i = 1; i <= tam;i++){
            if(requisitoRepository.getReferenceById((long)i).getId_responsavel() == id){
                retorno.add(requisitoRepository.getReferenceById((long)i));
            }
        }
        return retorno;
    }

    @Transactional
    @PutMapping("/atualizarRequisito")
    public void atualizar(@Valid @RequestBody DadosAtualizacaoRequisitos dados) {
        System.out.println("terter");
        var requisito = requisitoRepository.getReferenceById(dados.id());
        requisito.atualizarRequisitos(dados);
    }

//    @PutMapping
//    @Transactional
//    public void atualizar(@RequestBody @Valid DadosAtualizacaoUsuario dados){
//        var usr = repository.findByEmail(dados.email());
//        usr.get(0).atualizaDadosUsuario(dados);
//    }
}
