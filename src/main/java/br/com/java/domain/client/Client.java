package br.com.java.domain.client;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "CLIENTE")
@Entity
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NOME")
    private String name;
    @Column(name = "CPF")
    private String cpf;

}
