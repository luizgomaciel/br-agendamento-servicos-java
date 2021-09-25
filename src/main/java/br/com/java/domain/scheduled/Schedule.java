package br.com.java.domain.scheduled;

import br.com.java.domain.client.Client;
import br.com.java.domain.operation.Operation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "AGENDAMENTO")
@Entity
@Getter
@Setter
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "DATA_HORA")
    private LocalDateTime dateHour;

    @Column(name = "DSC_AGD")
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CLIENT_FK", referencedColumnName = "ID_CLIENT")
    private Client client;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_OPERATION_FK", referencedColumnName = "ID_OPERATION")
    private Operation operation;

}
