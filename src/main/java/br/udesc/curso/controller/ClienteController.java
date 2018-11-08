package br.udesc.curso.controller;

import br.udesc.curso.model.Cidade;
import br.udesc.curso.model.Cliente;
import br.udesc.curso.repository.CidadeRepository;
import br.udesc.curso.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private CidadeRepository cidadeRepository;
    
    @PostMapping("/salvar")
    public Cliente salvar(@RequestBody Cliente cliente){
        long cidadeId = cliente.getCidade().getId();
        Cidade cidade = cidadeRepository.findById(cidadeId).get();
        cliente.setCidade(cidade);
        return clienteRepository.saveAndFlush(cliente);
    }
    
    @GetMapping("/encontrar/{id}")
    public Cliente find(@PathVariable("id") long id){
        return clienteRepository.findById(id).get();
    }
    
    //Implementar Exlcuir e Listar;
    //Criar fornecedor;
}
