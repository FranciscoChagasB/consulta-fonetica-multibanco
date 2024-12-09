package com.teste.projeto.controller.banco2;

import com.teste.projeto.model.banco2.PessoaBanco2;
import com.teste.projeto.service.banco2.PessoaBanco2Service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banco2")
public class PessoaBanco2Controller {

    private final PessoaBanco2Service pessoaBanco2Service;

    @Autowired
    public PessoaBanco2Controller(PessoaBanco2Service pessoaBanco2Service) {
        this.pessoaBanco2Service = pessoaBanco2Service;
    }

    @GetMapping
    public List<PessoaBanco2> getAll() {
        return pessoaBanco2Service.getAll();
    }

}
