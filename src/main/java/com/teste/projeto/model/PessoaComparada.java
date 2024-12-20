package com.teste.projeto.model;

import com.teste.projeto.model.banco1.PessoaBanco1;
import com.teste.projeto.model.banco2.PessoaBanco2;
import lombok.Data;

@Data
public class PessoaComparada {
    private PessoaBanco1 pessoaBanco1;
    private PessoaBanco2 pessoaBanco2;

    public PessoaComparada(PessoaBanco1 pessoaBanco1, PessoaBanco2 pessoaBanco2) {
        this.pessoaBanco1 = pessoaBanco1;
        this.pessoaBanco2 = pessoaBanco2;
    }
}