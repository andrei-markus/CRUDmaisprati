package com.maisprati.crud;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Pessoa
 */
public class Pessoa {
    private String nome;
    private Integer telefone;
    private LocalDate dataNascimento;
    private LocalDateTime dataCadastro;
    private LocalDateTime ultimaAlteracao;

    Pessoa(String nome, Integer telefone, LocalDate dataNascimento){
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = LocalDateTime.now();
        this.setAlteracao();
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
        this.setAlteracao();
    }

    public int getTelefone() {
        return telefone;
    }
    public void setTelefone(int telefone) {
        this.telefone = telefone;
        this.setAlteracao();
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        this.setAlteracao();
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
        this.setAlteracao();
    }

    public LocalDateTime getUltimaAlteracao() {
        return ultimaAlteracao;
    }

    void setAlteracao(){
        this.ultimaAlteracao = LocalDateTime.now();
    }

}