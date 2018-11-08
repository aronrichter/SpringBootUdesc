package br.udesc.curso.proposta;

import br.udesc.curso.enums.Cobertura;
import br.udesc.curso.proposta.calculation.CoberturaCalculation;
import br.udesc.curso.proposta.calculation.PerdaTotalCalculation;
import br.udesc.curso.proposta.calculation.VidroCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoberturaCalculationFactory {
    
    @Autowired
    private PerdaTotalCalculation perdaTotalCalculation;
    
    @Autowired
    private VidroCalculation vidroCalculation;
    
    public CoberturaCalculation build(Cobertura cobertura){
        switch (cobertura){
            case PERDA_TOTAL:
                return perdaTotalCalculation;
            case VIDROS:
                return vidroCalculation;
            default:
                throw new IllegalArgumentException("Calculo para cobertura " + cobertura + "não implementado!");
        }
    }
}
