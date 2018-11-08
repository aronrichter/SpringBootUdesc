package br.udesc.curso.enums;

import java.util.Arrays;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access=AccessLevel.PRIVATE)
public enum Cobertura {
    PERDA_TOTAL(Servico.GUINCHO, Servico.TAXI, Servico.OFICINA),
    TERCEIRO(Servico.OFICINA),
    ASSISTENCIA(Servico.GUINCHO, Servico.COMBUSTIVEL),
    VIDROS(Servico.PARABRISA, Servico.LANTERNA, Servico.RETROVISOR),
    CARRO_RESERVA(Servico.CARRO_RESERVA);
    
    private List<Servico> servicos;
    
    private Cobertura(Servico...servicos){
        this.servicos = Arrays.asList(servicos);
    }
}
