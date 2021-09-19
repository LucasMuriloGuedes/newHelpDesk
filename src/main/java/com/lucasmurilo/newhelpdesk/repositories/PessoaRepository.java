package com.lucasmurilo.newhelpdesk.repositories;

import com.lucasmurilo.newhelpdesk.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    @Query("SELECT obj FROM Pessoa obj where obj.cpf =:cpf")
    Pessoa findByCPF(@Param("cpf") String cpf);
}
