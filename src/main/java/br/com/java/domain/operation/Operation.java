package br.com.java.domain.operation;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "SERVICO")
@Entity
@Getter
@Setter
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "DESC")
    private String description;
    @Column(name = "VALOR")
    private BigDecimal value;

}
