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

}
