package br.udesc.curso.model;

import br.udesc.curso.enums.EstadoCivil;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
   @Id
   @GeneratedValue
   private long id; 
   
   @Column(length=11, updatable=false, nullable=false, unique=true)
   private String cpf;
   
   @Column(length=100)
   private String nome;
   
   @Temporal(TemporalType.DATE)
   private Date nascimento;
   
   @Enumerated(EnumType.STRING)
   private EstadoCivil estadoCivil;
           
   private String email;
           
   private boolean resideComFaixaRisco;
   
   @ManyToOne
   @JoinColumn(name="cidadeid", referencedColumnName="id")
   private Cidade cidade;
   
   @Embedded
   private CNH cnh;
}
