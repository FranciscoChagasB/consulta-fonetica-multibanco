package com.teste.projeto.model.banco1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pessoa_escola")
public class PessoaBanco1 {

    @Id
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String matricula;
    private String curso;
    private String anoEscolar;
    private String isProfessor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getAnoEscolar() {
        return anoEscolar;
    }

    public void setAnoEscolar(String anoEscolar) {
        this.anoEscolar = anoEscolar;
    }

    public String isProfessor() {
        return isProfessor;
    }

    public void setProfessor(String professor) {
        isProfessor = professor;
    }
}
