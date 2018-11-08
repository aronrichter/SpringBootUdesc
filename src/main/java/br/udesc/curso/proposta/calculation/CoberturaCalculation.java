package br.udesc.curso.proposta.calculation;

import br.udesc.curso.model.Veiculo;
import br.udesc.curso.vo.PropostaVO;
import org.springframework.stereotype.Component;

@Component
public abstract class CoberturaCalculation {
    
    public float calcular(PropostaVO proposta){
        Veiculo veiculo = proposta.getVeiculo();
        return calcularValor(proposta) 
                + (calcularPercentualVeiculo(proposta) * veiculo.getValor());
    }
    
    abstract float calcularValor(PropostaVO proposta);
    abstract float calcularPercentualVeiculo(PropostaVO proposta);
}
