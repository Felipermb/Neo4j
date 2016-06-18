package com.mycompany.exemploneo4j;

public class Main {
    public static void main(String[] args){
        Transacoes op = new Transacoes();
        Disciplina nova = new Disciplina("Calculo", "CL001");
        Aluno novo = new Aluno("Felipe", 18, 2014213539);
        
        //op.inserirAluno(novo);
        //op.inserirDisciplina(nova);
        //op.buscaAluno();
        //op.buscaDisciplina();
        //op.criaRelacionamento(2014211424, "CL001");
        op.atualizarNome(2014213539, "Felipe Reis Macedo Barbosa");
        //op.deletarTd();
        
        op.fecharbanco();
    }
}
