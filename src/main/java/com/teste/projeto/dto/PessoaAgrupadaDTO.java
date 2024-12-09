package com.teste.projeto.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class PessoaAgrupadaDTO {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private List<String> origens = new ArrayList<>(); // Identifica de qual banco os dados vieram
    private String detalhesBanco1; // Detalhes específicos do banco 1
    private String detalhesBanco2; // Detalhes específicos do banco 2

    public PessoaAgrupadaDTO(String nome, String cpf, String email, String telefone, String origem) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.origens.add(origem);
    }

    public void addOrigem(String origem) {
        if (!this.origens.contains(origem)) {
            this.origens.add(origem);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<String> getOrigens() {
        return origens;
    }

    public void setOrigens(List<String> origens) {
        this.origens = origens;
    }

    public String getDetalhesBanco1() {
        return detalhesBanco1;
    }

    public void setDetalhesBanco1(String detalhesBanco1) {
        this.detalhesBanco1 = detalhesBanco1;
    }

    public String getDetalhesBanco2() {
        return detalhesBanco2;
    }

    public void setDetalhesBanco2(String detalhesBanco2) {
        this.detalhesBanco2 = detalhesBanco2;
    }
}