package com.maisprati.crud;

import java.time.LocalDate;

public class Aluno extends Pessoa {
    private float notaFinal;

    Aluno(String nome, Integer telefone, LocalDate dataNascimento, float notaFinal) {
        super(nome, telefone, dataNascimento);
        this.notaFinal = notaFinal;
        super.setAlteracao();
    }

    public float getNotaFinal() {
        return notaFinal;
    }
    public void setNotaFinal(float notaFinal) {
        this.notaFinal = notaFinal;
        super.setAlteracao();
    }
}
