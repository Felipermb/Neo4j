package com.mycompany.exemploneo4j;

public class Main {
    public static void main(String[] args){
        Transacoes op = new Transacoes();
        Disciplina nova = new Disciplina("Cálculo");
        Aluno novo = new Aluno("Felipe", 18, 2014213539, nova);
        
        //op.inserirAluno(novo);
        //op.inserirDisciplina(nova);
        //op.buscaSimples();
        //op.deletarTd();
        
        op.fecharbanco();
    }
}
