package com.mycompany.exemploneo4j;

public class Aluno {
    private String nome;
    private int idade;
    private int matricula;
    private Disciplina dc;

    public Aluno(String nome, int idade, int matricula, Disciplina dc) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
        this.dc = dc;
    }

    public Disciplina getDc() {
        return dc;
    }

    public void setDc(Disciplina dc) {
        this.dc = dc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    
}
