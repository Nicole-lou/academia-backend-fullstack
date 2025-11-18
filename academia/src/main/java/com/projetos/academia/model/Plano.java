package com.projetos.academia.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data; // Ou importe manualmente getters/setters/construtores

@Entity
@Table(name = "planos")
@Data // Anotação Lombok para getters, setters, toString, etc.
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    // Mapeamento do ENUM para String no banco de dados
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoPlano tipo;

    @Column(name = "preco", nullable = false)
    private Float preco;

    // TEXT (JPA mapeia String para TEXT/VARCHAR(255) automaticamente.
    // Usamos 'columnDefinition' para forçar TEXT se o banco exigir.
    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    // Opções Booleanas
    @Column(name = "opc_av_tecnica", nullable = false)
    private Boolean opcAvTecnica = false;

    @Column(name = "opc_cardio", nullable = false)
    private Boolean opcCardio = false;

    @Column(name = "opc_musculacao", nullable = false)
    private Boolean opcMusculacao = false;

    @Column(name = "opc_coletivas_il", nullable = false)
    private Boolean opcColetivasIl = false;

    @Column(name = "opc_coletivas_15", nullable = false)
    private Boolean opcColetivas15 = false;

    @Column(name = "opc_av_fisica", nullable = false)
    private Boolean opcAvFisica = false;

    @Column(name = "opc_desconto_personal", nullable = false)
    private Boolean opcDescontoPersonal = false;

    // Mapeamento do ENUM para String no banco de dados
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusPlano status = StatusPlano.ON; // Valor padrão 'ON'

    @Column(name = "metadata", columnDefinition = "TEXT")
    private String metadata;

    // Se não estiver usando Lombok, adicione getters, setters, e construtores aqui.


    public enum TipoPlano {
        SESSAO,
        MENSAL,
        SEMESTRAL,
        ANUAL
    }

    public enum StatusPlano {
        ON,
        OFF
    }

}