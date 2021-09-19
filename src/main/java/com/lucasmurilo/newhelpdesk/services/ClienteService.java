package com.lucasmurilo.newhelpdesk.services;

import com.lucasmurilo.newhelpdesk.domain.Cliente;
import com.lucasmurilo.newhelpdesk.domain.Pessoa;
import com.lucasmurilo.newhelpdesk.dtos.ClienteDTO;
import com.lucasmurilo.newhelpdesk.repositories.ClienteRepository;
import com.lucasmurilo.newhelpdesk.repositories.PessoaRepository;
import com.lucasmurilo.newhelpdesk.services.exception.DateIntegrityViolationException;
import com.lucasmurilo.newhelpdesk.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Cliente> findAll(){
        return repository.findAll();
    }

    public Cliente findById(Integer id){
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Clinte não encotrado! Verifique o Id: " + id
        ));
    }

    public Cliente insert(ClienteDTO objDTO){

        if(findByCPF(objDTO) != null){
            throw new DateIntegrityViolationException("Cpf já cadastrado na base de dados! Verifique o CPF!");
        }

        Cliente obj = new Cliente(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone());
        return repository.save(obj);
    }

    public Pessoa findByCPF(ClienteDTO objDTO){
       Pessoa obj = pessoaRepository.findByCPF(objDTO.getCpf());
       if(obj != null){
           return obj;
       }
       return null;
    }


    public Cliente update(ClienteDTO objDTO, Integer id) {
        Cliente obj = findById(id);
        if(findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id ){
            throw new DateIntegrityViolationException("Cpf já cadastrado na base de dados! Verifique o CPF!");
        }
        obj.setNome(objDTO.getNome());
        obj.setCpf(objDTO.getCpf());
        obj.setTelefone(objDTO.getTelefone());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        Cliente obj = findById(id);
        if(obj.getList().size() > 0){
            throw new DateIntegrityViolationException("Cliente possui Ordem de Servicos associados! Não pode ser excluido!");
        }
        repository.delete(obj);
    }
}
