package com.produtos.apirest.models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name="produto")
public class Produto implements Serializable  {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;

    private BigDecimal quantidade;

    private BigDecimal valor;

    public String getNome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public Produto setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Produto setValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }
}
