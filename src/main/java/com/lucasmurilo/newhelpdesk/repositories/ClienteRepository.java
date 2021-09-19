package com.lucasmurilo.newhelpdesk.repositories;

import com.lucasmurilo.newhelpdesk.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
