package com.lucasmurilo.newhelpdesk.repositories;

import com.lucasmurilo.newhelpdesk.domain.Tecnico;
import com.lucasmurilo.newhelpdesk.dtos.TecnicoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
