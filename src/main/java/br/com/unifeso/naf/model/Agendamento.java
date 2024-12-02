package br.com.unifeso.naf.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataHora;
    private String idContato;
    private Boolean stAtivo;

    @ManyToOne
    @JoinColumn (name = "contato_id")
    private Contato contato;

}
