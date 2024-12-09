package com.teste.projeto.service.banco2;

import com.teste.projeto.dto.PessoaAgrupadaDTO;
import com.teste.projeto.model.PessoaComparada;
import com.teste.projeto.model.banco1.PessoaBanco1;
import com.teste.projeto.model.banco2.PessoaBanco2;
import com.teste.projeto.repository.banco1.PessoaBanco1Repository;
import com.teste.projeto.repository.banco2.PessoaBanco2Repository;
import com.teste.projeto.service.StringUtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PessoaBanco2Service {

    @Autowired
    private PessoaBanco2Repository pessoaBanco2Repository;

    @Autowired
    private PessoaBanco1Repository pessoaBanco1Repository;

    public List<PessoaBanco2> getAll(){
        List<PessoaBanco2> pessoos = pessoaBanco2Repository.findAll();
        pessoos.forEach(p -> p.setNome(StringUtilsService.normalize(p.getNome())));
        return pessoos;
    }

    public List<PessoaComparada> getPessoasIguais() {
        // Obter listas de ambos os repositórios
        List<PessoaBanco1> pessoasBanco1 = pessoaBanco1Repository.findAll();
        List<PessoaBanco2> pessoasBanco2 = pessoaBanco2Repository.findAll();

        // Normalizar os nomes
        pessoasBanco1.forEach(p -> p.setNome(StringUtilsService.normalize(p.getNome())));
        pessoasBanco2.forEach(p -> p.setNome(StringUtilsService.normalize(p.getNome())));

        // Criar uma lista para armazenar as pessoas iguais
        List<PessoaComparada> pessoasIguais = new ArrayList<>();

        for (PessoaBanco1 pessoa1 : pessoasBanco1) {
            // Verifica se existe uma correspondência no banco2
            pessoasBanco2.stream().filter(pessoa2 ->
                    pessoa1.getNome().equals(pessoa2.getNome()) &&
                    pessoa1.getCpf().equals(pessoa2.getCpf()) &&
                    pessoa1.getTelefone().equals(pessoa2.getTelefone())// Exemplo de outro campo
            ).findFirst().ifPresent(pessoa2 -> {
                // Se encontrar uma correspondência, adiciona à lista de iguais
                pessoasIguais.add(new PessoaComparada(pessoa1, pessoa2));
            });
        }

        return pessoasIguais;
    }

    /*
    public List<PessoaAgrupadaDTO> getPessoasAgrupadas() {
        // Obter listas de ambos os repositórios
        List<PessoaBanco1> pessoasBanco1 = pessoaBanco1Repository.findAll();
        List<PessoaBanco2> pessoasBanco2 = pessoaBanco2Repository.findAll();

        // Normalizar os nomes
        pessoasBanco1.forEach(p -> p.setNome(StringUtilsService.normalize(p.getNome())));
        pessoasBanco2.forEach(p -> p.setNome(StringUtilsService.normalize(p.getNome())));

        // Mapa para agrupar pessoas com base em nome + CPF + telefone
        Map<String, PessoaAgrupadaDTO> mapaPessoas = new HashMap<>();

        // Adicionar pessoas do banco 1 ao mapa
        for (PessoaBanco1 pessoa1 : pessoasBanco1) {
            String chave = pessoa1.getNome() + pessoa1.getCpf() + pessoa1.getTelefone();
            mapaPessoas.computeIfAbsent(chave, k -> {
                PessoaAgrupadaDTO dto = new PessoaAgrupadaDTO(
                        pessoa1.getNome(),
                        pessoa1.getCpf(),
                        pessoa1.getEmail(),
                        pessoa1.getTelefone(),
                        "Banco1"
                );
                dto.setDetalhesBanco1("Matrícula: " + pessoa1.getMatricula() + ", Curso: " + pessoa1.getCurso());
                return dto;
            }).addOrigem("Banco1");
        }

        // Adicionar pessoas do banco 2 ao mapa
        for (PessoaBanco2 pessoa2 : pessoasBanco2) {
            String chave = pessoa2.getNome() + pessoa2.getCpf() + pessoa2.getTelefone();
            mapaPessoas.computeIfAbsent(chave, k -> {
                PessoaAgrupadaDTO dto = new PessoaAgrupadaDTO(
                        pessoa2.getNome(),
                        pessoa2.getCpf(),
                        pessoa2.getEmail(),
                        pessoa2.getTelefone(),
                        "Banco2"
                );
                dto.setDetalhesBanco2("Número Ficha: " + pessoa2.getNumeroFicha() + ", Plano: " + pessoa2.getPlano());
                return dto;
            }).addOrigem("Banco2");
        }

        // Retornar lista de pessoas agrupadas
        return new ArrayList<>(mapaPessoas.values());
    }

     */

    public List<PessoaAgrupadaDTO> getPessoasAgrupadas() {
        // Obter listas de ambos os repositórios
        List<PessoaBanco1> pessoasBanco1 = pessoaBanco1Repository.findAll();
        List<PessoaBanco2> pessoasBanco2 = pessoaBanco2Repository.findAll();

        // Normalizar os nomes
        pessoasBanco1.forEach(p -> p.setNome(StringUtilsService.normalize(p.getNome())));
        pessoasBanco2.forEach(p -> p.setNome(StringUtilsService.normalize(p.getNome())));

        // Mapa para agrupar pessoas com base em nome + CPF + telefone
        Map<String, PessoaAgrupadaDTO> mapaPessoas = new HashMap<>();

        // Adicionar pessoas do banco 1 ao mapa
        for (PessoaBanco1 pessoa1 : pessoasBanco1) {
            String chave = pessoa1.getNome() + pessoa1.getCpf() + pessoa1.getTelefone();
            mapaPessoas.computeIfAbsent(chave, k -> {
                PessoaAgrupadaDTO dto = new PessoaAgrupadaDTO(
                        pessoa1.getNome(),
                        pessoa1.getCpf(),
                        pessoa1.getEmail(),
                        pessoa1.getTelefone(),
                        "Banco1"
                );
                dto.setDetalhesBanco1("Matrícula: " + pessoa1.getMatricula() + ", Curso: " + pessoa1.getCurso());
                return dto;
            }).addOrigem("Banco1");
        }

        // Adicionar pessoas do banco 2 ao mapa
        for (PessoaBanco2 pessoa2 : pessoasBanco2) {
            String chave = pessoa2.getNome() + pessoa2.getCpf() + pessoa2.getTelefone();
            mapaPessoas.compute(chave, (k, dto) -> {
                if (dto == null) {
                    // Se a pessoa não existe no mapa, cria um novo DTO com os detalhes do Banco 2
                    dto = new PessoaAgrupadaDTO(
                            pessoa2.getNome(),
                            pessoa2.getCpf(),
                            pessoa2.getEmail(),
                            pessoa2.getTelefone(),
                            "Banco2"
                    );
                    dto.setDetalhesBanco2("Número Ficha: " + pessoa2.getNumeroFicha() + ", Plano: " + pessoa2.getPlano());
                } else {
                    // Se a pessoa já existe, adiciona os detalhes do Banco 2
                    dto.addOrigem("Banco2");
                    if (dto.getDetalhesBanco2() == null) {
                        dto.setDetalhesBanco2("Número Ficha: " + pessoa2.getNumeroFicha() + ", Plano: " + pessoa2.getPlano());
                    }
                }
                return dto;
            });
        }

        // Retornar lista de pessoas agrupadas
        return new ArrayList<>(mapaPessoas.values());
    }

    public Map<String, Object> obterDivergenciasPorCpf(String cpf) {
        List<PessoaBanco1> pessoasBanco1 = pessoaBanco1Repository.findByCpf(cpf);
        List<PessoaBanco2> pessoasBanco2 = pessoaBanco2Repository.findByCpf(cpf);

        // Normalizar os dados
        pessoasBanco1.forEach(p -> p.setNome(StringUtilsService.normalize(p.getNome())));
        pessoasBanco2.forEach(p -> p.setNome(StringUtilsService.normalize(p.getNome())));

        // Mapear divergências
        Map<String, Object> response = new HashMap<>();
        response.put("cpf", cpf);

        // Obter os valores da base 1
        PessoaBanco1 banco1 = pessoasBanco1.isEmpty() ? null : pessoasBanco1.get(0);
        PessoaBanco2 banco2 = pessoasBanco2.isEmpty() ? null : pessoasBanco2.get(0);

        Map<String, Object> detalhes = new HashMap<>();
        detalhes.put("nome", highlightDivergences(banco1 != null ? banco1.getNome() : null, banco2 != null ? banco2.getNome() : null));
        detalhes.put("email", highlightDivergences(banco1 != null ? banco1.getEmail() : null, banco2 != null ? banco2.getEmail() : null));
        detalhes.put("telefone", highlightDivergences(banco1 != null ? banco1.getTelefone() : null, banco2 != null ? banco2.getTelefone() : null));

        response.put("detalhes", detalhes);
        return response;
    }

    private Map<String, Object> highlightDivergences(String valor1, String valor2) {
        Map<String, Object> resultado = new HashMap<>();
        resultado.put("valorBanco1", valor1);
        resultado.put("valorBanco2", valor2);
        resultado.put("divergente", valor1 != null && valor2 != null && !valor1.equals(valor2));
        return resultado;
    }

}
