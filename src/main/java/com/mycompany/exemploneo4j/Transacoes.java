package com.mycompany.exemploneo4j;

import java.beans.Statement;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.ResourceIterable;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class Transacoes {

    String end = "C:\\Users\\Felipe\\Documents\\Neo4j\\Exemplo.db";
    File arquivo = new File(end);
    GraphDatabaseFactory db = new GraphDatabaseFactory();
    GraphDatabaseService banco_dados = db.newEmbeddedDatabase(arquivo);

    public enum NodeType implements Label {
        Aluno, Disciplina;
    }
    //Os tipos de nós que iremos utilizar

    public enum RelationType implements RelationshipType {
        Cursa;
    }
    //OS tipos de realações que iremos utilizar

    public void inserirAluno(Aluno novo) {
        try (Transaction tx = banco_dados.beginTx()) {
            Node node_aluno = banco_dados.createNode(NodeType.Aluno);
            node_aluno.setProperty("nome", novo.getNome());
            node_aluno.setProperty("idade", novo.getIdade());
            node_aluno.setProperty("matricula", novo.getMatricula());
//            Node node_disciplina = banco_dados.createNode(Main.NodeType.Disciplina);
//            node_disciplina.setProperty("nome", nova.getNome());
//
//            Relationship relacao = node_aluno.createRelationshipTo(node_disciplina, Main.RelationType.Cursa);
//            relacao.setProperty("periodo", "1º");
            tx.success();
        }
    }

    public void inserirDisciplina(Disciplina nova) {
        try (Transaction tx = banco_dados.beginTx()) {
            Node node_disciplina = banco_dados.createNode(NodeType.Disciplina);
            node_disciplina.setProperty("nome", nova.getNome());
            node_disciplina.setProperty("codigo", nova.getCodigo());
            tx.success();
        }
//        Relationship relacao = node_aluno.createRelationshipTo(node_disciplina, Main.RelationType.Cursa);
//        relacao.setProperty("periodo", "1º");
    }

    public void buscaAluno() {
        Result execResult = banco_dados.execute("match (n:Aluno) return n.nome");
        String results = execResult.resultAsString();
        System.out.println(results);
        String recebe[] = results.split("\"");

        for (int i = 1; i < recebe.length; i = i + 2) {
            System.out.println(recebe[i]);
        }

    }

    public void buscaDisciplina() {
        Result execResult = banco_dados.execute("match (n:Disciplina) return n.nome");
        String results = execResult.resultAsString();
        System.out.println(results);
        String recebe[] = results.split("\"");

        for (int i = 1; i < recebe.length; i = i + 2) {
            System.out.println(recebe[i]);
        }
    }
    
    public void criaRelacionamento(int matricula, String codigo){
        banco_dados.execute("match (a:Aluno {matricula: "+matricula+"}), (d:Disciplina {codigo: \""+codigo+"\"}) "
                + "create (a)-[:Cursa]->(d)");
    }
    
    public void atualizarNome(int matricula, String nome_novo){
        banco_dados.execute("match (n:Aluno) where n.matricula = "+matricula+" \n set n.nome = \""+nome_novo+"\"");
    }
    
    public void deletarAluno(int matricula) {
        Result execResult = banco_dados.execute("match (n:Aluno) where n.matricula = "+matricula+" \n "
                + "match (n)-[rel:Cursa]->(b) return b.nome");
        String results = execResult.resultAsString();
        String recebe[] = results.split("\"");
        //System.out.println(recebe.length);
        if(recebe.length == 1){
            banco_dados.execute("match (n:Aluno) where n.matricula = "+matricula+" \n delete n");
        }else{
            System.out.println("Existe relacionamento,\n Não pode deletar");
        }
    }

    public void deletarTd() {
        Result execResult = banco_dados.execute("match (n) detach delete n");
    }

    public void fecharbanco() {
        banco_dados.shutdown();
    }
}
