package br.udesc.curso.model;

import br.udesc.curso.enums.Cobertura;
import br.udesc.curso.enums.Servico;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Apolice {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    @JoinColumn(name="cllienteid", referencedColumnName="id")
    private Cliente cliente;
    
    @Embedded
    private Veiculo veiculo;
    
    @ElementCollection(targetClass=Cobertura.class)
    @Enumerated(EnumType.STRING)
    private Set<Cobertura> coberturas;
    
    private float preco;
    
    @Column(insertable = false)
    private Date inicioVigencia;
    
    @Column(insertable = false)
    private Date fimVigencia;
    
}
