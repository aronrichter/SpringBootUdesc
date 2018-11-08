package br.udesc.curso.model;

import br.udesc.curso.enums.CategoriaCNH;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Embeddable
public class CNH {
   @Temporal(TemporalType.DATE)
   private Date emissao;
   
   @Enumerated(EnumType.STRING)
   private CategoriaCNH categoria;
   
   @Temporal(TemporalType.DATE)
   private Date validade;
}
