package br.udesc.curso.proposta;

import br.udesc.curso.enums.Cobertura;
import br.udesc.curso.model.Apolice;
import br.udesc.curso.repository.ApoliceRepository;
import br.udesc.curso.vo.PropostaVO;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropostaService {
    
    @Autowired
    private CoberturaCalculationFactory factory;
    
    @Autowired
    private ApoliceRepository apoliceRepository;
        
    public Apolice calcular(PropostaVO proposta){
        float valor = 0;
        for(Cobertura cobertura: proposta.getCoberturas()){
            valor += factory.build(cobertura).calcular(proposta);
        }
        return efetivar(proposta, valor);
    }
    
    public Apolice efetivar(PropostaVO proposta, float valor){
        Apolice apolice = new Apolice();
        apolice.setCliente(proposta.getCliente());
        apolice.setVeiculo(proposta.getVeiculo());
        apolice.setCoberturas(proposta.getCoberturas());
        apolice.setPreco(valor);
        apolice.setInicioVigencia(new Date());
        apolice.setFimVigencia(new Date());
        
         apoliceRepository.saveAndFlush(apolice);
         
         return apolice;
    }
}