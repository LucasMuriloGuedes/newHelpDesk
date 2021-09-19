package com.lucasmurilo.newhelpdesk.config;

import com.lucasmurilo.newhelpdesk.domain.Cliente;
import com.lucasmurilo.newhelpdesk.domain.OrdemServico;
import com.lucasmurilo.newhelpdesk.domain.Tecnico;
import com.lucasmurilo.newhelpdesk.domain.enums.Prioridade;
import com.lucasmurilo.newhelpdesk.domain.enums.Status;
import com.lucasmurilo.newhelpdesk.repositories.ClienteRepository;
import com.lucasmurilo.newhelpdesk.repositories.OrdemServicoRepository;
import com.lucasmurilo.newhelpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Override
    public void run(String... args) throws Exception {

        Tecnico tec1 = new Tecnico(null, "Bod Marley", "284.757.570-73", "(65) 98150-5851");
        Cliente c1 = new Cliente(null, "Paula Fernandez", "816.326.090-45", "(65) 98113-3307");
        OrdemServico os1 = new OrdemServico(null, Prioridade.ALTA, "Teste create OS", Status.ANDAMENTO, c1, tec1);

        tec1.getList().add(os1);
        c1.getList().add(os1);

        tecnicoRepository.save(tec1);
        clienteRepository.save(c1);
        ordemServicoRepository.save(os1);

    }
}
