package com.teste.projeto.repository.banco2;

import com.teste.projeto.model.banco2.PessoaBanco2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaBanco2Repository extends JpaRepository<PessoaBanco2, Long> {

    List<PessoaBanco2> findByCpf(String cpf);

}
