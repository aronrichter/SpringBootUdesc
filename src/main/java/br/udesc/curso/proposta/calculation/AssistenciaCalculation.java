package br.udesc.curso.proposta.calculation;

import br.udesc.curso.vo.PropostaVO;
import org.springframework.stereotype.Component;

@Component
public class AssistenciaCalculation extends CoberturaCalculation{

    @Override
    float calcularValor(PropostaVO proposta) {
        return 0;
    }

    @Override
    float calcularPercentualVeiculo(PropostaVO proposta) {
        return 0;
    }
    
}
