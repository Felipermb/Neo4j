package com.mycompany.exemploneo4j;

import java.io.File;
import org.neo4j.cypher.internal.ExecutionEngine;
import org.neo4j.cypher.internal.ExecutionResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class Main {

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

    public void inserirAluno(Aluno novo, Disciplina nova) {
        try (Transaction tx = banco_dados.beginTx()) {
            Node node_aluno = banco_dados.createNode(NodeType.Aluno);
            node_aluno.setProperty("nome", novo.getNome());
            node_aluno.setProperty("idade", novo.getIdade());
            node_aluno.setProperty("matricula", novo.getMatricula());

            Node node_disciplina = banco_dados.createNode(NodeType.Disciplina);
            node_disciplina.setProperty("nome", nova.getNome());

            Relationship relacao = node_aluno.createRelationshipTo(node_disciplina, RelationType.Cursa);
            relacao.setProperty("periodo", "1º");

            tx.success();
        }
        banco_dados.shutdown();
    }

    public void buscas() {
        Result execResult = banco_dados.execute("match (n:Aluno) where n.matricula= 2014213539   return n.nome");
        String results = execResult.resultAsString();
        System.out.println(results);
    }
}
