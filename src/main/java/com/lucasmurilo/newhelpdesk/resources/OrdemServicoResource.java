package com.lucasmurilo.newhelpdesk.resources;

import com.lucasmurilo.newhelpdesk.dtos.OrdemServicoDTO;
import com.lucasmurilo.newhelpdesk.services.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/os")
public class OrdemServicoResource {

    @Autowired
    private OrdemServicoService service;

    @GetMapping
    public ResponseEntity<List<OrdemServicoDTO>> findAll(){
        List<OrdemServicoDTO> list = service.findAll().stream().map(obj -> new OrdemServicoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrdemServicoDTO> findById(@PathVariable Integer id){
        OrdemServicoDTO obj = new OrdemServicoDTO(service.findById(id));
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<OrdemServicoDTO> insert(@RequestBody OrdemServicoDTO objDTO){
        OrdemServicoDTO newObj = new OrdemServicoDTO(service.insert(objDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<OrdemServicoDTO> update(@RequestBody OrdemServicoDTO objDTO){
        OrdemServicoDTO newObj = new OrdemServicoDTO(service.update(objDTO));
        return ResponseEntity.ok().body(newObj);
    }

}
