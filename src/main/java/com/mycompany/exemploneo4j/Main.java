package com.mycompany.exemploneo4j;

public class Main {
    public static void main(String[] args){
        Transacoes op = new Transacoes();
        Disciplina nova = new Disciplina("LPTC", "LPTC001");
        Aluno novo = new Aluno("Paulo", 18, 2014211424);
        
        //op.inserirAluno(novo);
        //op.inserirDisciplina(nova);
        //op.buscaAluno();
        op.buscaDisciplina();
        //op.deletarTd();
        
        op.fecharbanco();
    }
}
