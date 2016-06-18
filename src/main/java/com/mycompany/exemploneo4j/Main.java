package com.mycompany.exemploneo4j;

public class Main {
    public static void main(String[] args){
        Transacoes op = new Transacoes();
        Disciplina nova = new Disciplina("Introdução de programação", "IP001");
        Aluno novo = new Aluno("Marcos", 19, 2014256759);
        
        //op.inserirAluno(novo);
        //op.inserirDisciplina(nova);
        //op.buscaAluno();
        //op.buscaDisciplina();
        //op.criaRelacionamento(2014213539, "LPTC001");
        //op.atualizarNome(2014213539, "Felipe Reis Macedo Barbosa");
        //op.deletarAluno(2014213539);
        //op.deletarDisciplina(nova.getCodigo());
        //op.deletarRelacionamento(2014213539, "LPTC001");
        //op.deletarTd();
        
        op.fecharbanco();
    }
}
