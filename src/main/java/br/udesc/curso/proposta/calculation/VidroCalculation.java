package br.udesc.curso.proposta.calculation;

import br.udesc.curso.vo.PropostaVO;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class VidroCalculation extends CoberturaCalculation{

    @Override
    float calcularValor(PropostaVO proposta) {
        return 0;
    }

    @Override
    float calcularPercentualVeiculo(PropostaVO proposta) {
        int idadeVeiculo = (new Date()).getYear() - proposta.getVeiculo().getAnoFabricacao();
        float percentual = 0;
        
        if (idadeVeiculo < 3)
            percentual = (float) 0.0075;
        if (idadeVeiculo < 5)
            percentual = (float) 0.0055;
        if (idadeVeiculo < 10)
            percentual = (float) 0.0025;
        else
            percentual = (float) 0.0075;
        
        if(proposta.getVeiculo().isBlindado()){
            if(proposta.getVeiculo().isImportado())
                percentual += 0.0075;
            else
                percentual += 0.005;
        }else{
            if(proposta.getVeiculo().isImportado())
                percentual += 0.0065;
        }
         
        return percentual;        
    }
}
