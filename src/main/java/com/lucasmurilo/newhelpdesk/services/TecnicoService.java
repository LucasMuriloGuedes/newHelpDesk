package com.lucasmurilo.newhelpdesk.services;

import com.lucasmurilo.newhelpdesk.domain.Pessoa;
import com.lucasmurilo.newhelpdesk.domain.Tecnico;
import com.lucasmurilo.newhelpdesk.dtos.TecnicoDTO;
import com.lucasmurilo.newhelpdesk.repositories.PessoaRepository;
import com.lucasmurilo.newhelpdesk.repositories.TecnicoRepository;
import com.lucasmurilo.newhelpdesk.services.exception.DateIntegrityViolationException;
import com.lucasmurilo.newhelpdesk.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Tecnico> findAll(){
        return repository.findAll();
    }

    public Tecnico findById(Integer id) {
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encotrado! Id: " + id));
    }

    public Tecnico insert(TecnicoDTO objDTO) {
        if(findByCPF(objDTO) != null){
            throw new DateIntegrityViolationException("Cpf já cadastrado na base de dados!");
        }
        Tecnico newObj = new Tecnico(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone());
        return repository.save(newObj);
    }

    private Pessoa findByCPF(TecnicoDTO objDTO){
        Pessoa obj = pessoaRepository.findByCPF(objDTO.getCpf());
        if(obj != null){
            return obj;
        }
        return null;
    }

    public Tecnico update(TecnicoDTO objDTO, Integer id) {
        Tecnico obj = findById(id);
        if(findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id){
            throw new DateIntegrityViolationException("Cpf já cadastrado na base de dados ou não pertece ao id");
        }
        obj.setNome(objDTO.getNome());
        obj.setCpf(obj.getCpf());
        obj.setTelefone(objDTO.getTelefone());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        Tecnico obj = findById(id);
        if(obj.getList().size() > 0){
            throw new DateIntegrityViolationException("O Tecnico possui ordem de servicos associados! Não pode ser excluido");
        }
        repository.delete(obj);
    }
}
