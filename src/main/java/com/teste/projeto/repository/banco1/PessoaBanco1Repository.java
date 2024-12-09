package com.teste.projeto.repository.banco1;

import com.teste.projeto.model.banco1.PessoaBanco1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaBanco1Repository extends JpaRepository<PessoaBanco1, Long> {

    List<PessoaBanco1> findByCpf(String cpf);
}
