package courser.mussumbaeduca.Models;

import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name="estudantes")
public class Estudante {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long Id;

    @Column(name="nome")
    private String nome;

    @Column(name = "email")
    private String email;
    
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    
    @Column(name = "data_pagamento")
    private Date dataPagamento;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

}
