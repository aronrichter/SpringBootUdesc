package br.udesc.curso.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Cidade {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    private String nome;
}
