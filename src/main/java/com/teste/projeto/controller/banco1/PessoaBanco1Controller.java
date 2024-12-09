package com.teste.projeto.controller.banco1;

import com.teste.projeto.dto.PessoaAgrupadaDTO;
import com.teste.projeto.model.banco1.PessoaBanco1;
import com.teste.projeto.service.banco1.PessoaBanco1Service;
import com.teste.projeto.service.banco2.PessoaBanco2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/banco1")
public class PessoaBanco1Controller {

    @Autowired
    private PessoaBanco1Service pessoaBanco1Service;

    @Autowired
    private PessoaBanco2Service pessoaBanco2Service;


    @GetMapping
    public List<PessoaBanco1> getAll() {
        return pessoaBanco1Service.getAll();
    }

    @GetMapping("/comparar")
    public List<PessoaAgrupadaDTO> getAllDiferentes() {
        return pessoaBanco2Service.getPessoasAgrupadas();
    }

    @GetMapping("/divergencias/{cpf}")
    public ResponseEntity<Map<String, Object>> getPessoaPorCpf(@PathVariable String cpf) {
        Map<String, Object> response = pessoaBanco2Service.obterDivergenciasPorCpf(cpf);
        return ResponseEntity.ok(response);
    }

}
