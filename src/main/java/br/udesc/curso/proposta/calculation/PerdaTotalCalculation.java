package br.udesc.curso.proposta.calculation;

import br.udesc.curso.vo.PropostaVO;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class PerdaTotalCalculation extends CoberturaCalculation{

    @Override
    float calcularValor(PropostaVO proposta) {
        return 0;
    }
    
    @Override
    float calcularPercentualVeiculo(PropostaVO proposta) {
        int idadeCliente = (new Date()).getYear() - proposta.getCliente().getNascimento().getYear();
        
        if (idadeCliente < 24)
            return (float) 0.05;
        if (idadeCliente >= 24 && idadeCliente < 40)
            return (float) 0.03;
        else
            return (float) 0.01;       
    }
}
