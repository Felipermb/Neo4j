package com.mycompany.exemploneo4j;

public class Principal {
    public static void main(String[] args){
        Main op = new Main();
        Disciplina nova = new Disciplina("Cálculo");
        Aluno novo = new Aluno("Felipe", 18, 2014213539, nova);
        
        //op.inserirAluno(novo,nova);
        op.buscas();
    }
}
