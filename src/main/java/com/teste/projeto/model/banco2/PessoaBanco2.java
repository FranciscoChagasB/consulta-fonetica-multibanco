package com.teste.projeto.model.banco2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pessoa_academia")
public class PessoaBanco2 {

    @Id
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String numeroFicha;
    private String plano;
    private String ativo;
    private String instrutorResponsavel;

}
