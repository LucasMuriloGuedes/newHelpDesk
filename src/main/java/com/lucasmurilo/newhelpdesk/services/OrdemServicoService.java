package com.lucasmurilo.newhelpdesk.services;

import com.lucasmurilo.newhelpdesk.domain.Cliente;
import com.lucasmurilo.newhelpdesk.domain.OrdemServico;
import com.lucasmurilo.newhelpdesk.domain.Tecnico;
import com.lucasmurilo.newhelpdesk.domain.enums.Prioridade;
import com.lucasmurilo.newhelpdesk.domain.enums.Status;
import com.lucasmurilo.newhelpdesk.dtos.OrdemServicoDTO;
import com.lucasmurilo.newhelpdesk.repositories.OrdemServicoRepository;
import com.lucasmurilo.newhelpdesk.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository repository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private TecnicoService tecnicoService;

    public List<OrdemServico> findAll(){
        return repository.findAll();
    }

    public OrdemServico findById(Integer id) {
        Optional<OrdemServico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Ordem de servico não encontrado! Verifique o Id: " + id
        ));
    }

    public OrdemServico insert(OrdemServicoDTO objDTO) {
        return repository.save(fromDTO(objDTO));
    }

    private OrdemServico fromDTO(OrdemServicoDTO objDTO) {
        OrdemServico newObj = new OrdemServico();
        newObj.setDataAbertura(LocalDateTime.now());
        newObj.setId(objDTO.getId());
        newObj.setObservacao(objDTO.getObservacao());
        newObj.setPrioridade(Prioridade.toEnum(objDTO.getPrioridade()));
        newObj.setStatus(Status.toEnum(objDTO.getStatus()));
        Cliente cli = clienteService.findById(objDTO.getCliente());
        Tecnico tec = tecnicoService.findById(objDTO.getTecnico());
        newObj.setCliente(cli);
        newObj.setTecnico(tec);
        if(newObj.getStatus().getCod().equals(3)){
            newObj.setDataFechamento(LocalDateTime.now());
        }
        return newObj;
    }

    public OrdemServico update(OrdemServicoDTO objDTO) {
        findById(objDTO.getId());
        return fromDTO(objDTO);
    }
}
