package trabalhoScrum.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trabalhoScrum.api.dev.DadosCadastroDev;
import trabalhoScrum.api.dev.Dev;
import trabalhoScrum.api.dev.DevRepository;

@RestController
@RequestMapping("/devs")
public class DevsController {
    @Autowired
    private DevRepository repository;

    @Transactional
    @PostMapping
    public void cadastrar(@Valid @RequestBody DadosCadastroDev dados) {
        repository.save(new Dev(dados));
    }

}
