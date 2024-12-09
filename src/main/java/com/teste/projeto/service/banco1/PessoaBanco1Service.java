package com.teste.projeto.service.banco1;

import com.teste.projeto.model.banco1.PessoaBanco1;
import com.teste.projeto.repository.banco1.PessoaBanco1Repository;
import com.teste.projeto.service.StringUtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaBanco1Service {

    @Autowired
    private PessoaBanco1Repository pessoaBanco1Repository;

    public List<PessoaBanco1> getAll() {

        List<PessoaBanco1> pessoas = pessoaBanco1Repository.findAll();
        pessoas.forEach(p -> p.setNome(StringUtilsService.normalize(p.getNome())));
        return pessoas;

    }
}
