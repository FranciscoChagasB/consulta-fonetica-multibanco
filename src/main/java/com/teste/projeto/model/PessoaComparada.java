package com.teste.projeto.model;

import com.teste.projeto.model.banco1.PessoaBanco1;
import com.teste.projeto.model.banco2.PessoaBanco2;

public class PessoaComparada {
    private PessoaBanco1 pessoaBanco1;
    private PessoaBanco2 pessoaBanco2;

    public PessoaComparada(PessoaBanco1 pessoaBanco1, PessoaBanco2 pessoaBanco2) {
        this.pessoaBanco1 = pessoaBanco1;
        this.pessoaBanco2 = pessoaBanco2;
    }

    public PessoaBanco1 getPessoaBanco1() {
        return pessoaBanco1;
    }

    public void setPessoaBanco1(PessoaBanco1 pessoaBanco1) {
        this.pessoaBanco1 = pessoaBanco1;
    }

    public PessoaBanco2 getPessoaBanco2() {
        return pessoaBanco2;
    }

    public void setPessoaBanco2(PessoaBanco2 pessoaBanco2) {
        this.pessoaBanco2 = pessoaBanco2;
    }
}