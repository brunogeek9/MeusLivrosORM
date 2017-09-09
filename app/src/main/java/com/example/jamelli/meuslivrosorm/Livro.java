package com.example.jamelli.meuslivrosorm;

import com.orm.SugarRecord;

/**
 * Created by jamelli on 09/09/17.
 */

public class Livro extends SugarRecord{
    String titulo;
    String autor;
    int ano;
    float nota;

    public Livro() {
    }

    public Livro(String titulo, String autor, int ano, float nota) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", ano=" + ano +
                ", nota=" + nota +
                '}';
    }
}
