package br.udesc.curso.controller;

import br.udesc.curso.model.Apolice;
import br.udesc.curso.proposta.CoberturaCalculationFactory;
import br.udesc.curso.proposta.PropostaService;
import br.udesc.curso.vo.PropostaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("proposta")
public class PropostaController {
    
    @Autowired
    private PropostaService service;
    
    @GetMapping
    public Apolice finalValue(PropostaVO proposta){
        return service.calcular(proposta);
    }
}
