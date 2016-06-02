
package com.mycompany.exemploneo4j;

import java.io.File;
import org.neo4j.cypher.internal.ExecutionEngine;
import org.neo4j.cypher.internal.ExecutionResult;
import org.neo4j.cypher.javacompat.internal.GraphDatabaseCypherService;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.kernel.GraphDatabaseQueryService;


public class Main {
    
    public enum NodeType implements Label{
        Aluno, Disciplina;
    }
    //Os tipos de nós que iremos utilizar
    public enum RelationType implements RelationshipType{
        Cursa;
    }
    //OS tipos de realações que iremos utilizar
    
    public void inserirAluno(Aluno novo){
        String end = "C:\\Users\\Felipe\\Documents\\Neo4j\\Exemplo.db";
        File arquivo = new File(end);
        GraphDatabaseFactory db = new GraphDatabaseFactory();
        GraphDatabaseService banco_dados = db.newEmbeddedDatabase(arquivo);
        GraphDatabaseQueryService query = new GraphDatabaseCypherService(banco_dados);
                
        try(Transaction tx = banco_dados.beginTx()){
            org.neo4j.graphdb.Node noNew = banco_dados.createNode(NodeType.Aluno);
            noNew.setProperty("Nome", novo.getNome());
            noNew.setProperty("Idade", novo.getIdade());
            noNew.setProperty("Matricula", novo.getMatricula());
            //Inserindo valores no novo NÓ.
            
            ExecutionEngine noSql = new ExecutionEngine(query, null);
            ExecutionResult resultado;
            resultado = noSql.execute("match (n:Disciplina) ");   
            
            tx.success();
        }
        banco_dados.shutdown();
    }
    
    public static void main(String[] args){
        String end = "C:\\Users\\Felipe\\Documents\\Neo4j\\Exemplo.db";
        File arquivo = new File(end);
        GraphDatabaseFactory db = new GraphDatabaseFactory();
        GraphDatabaseService banco_dados = db.newEmbeddedDatabase(arquivo);
        
        try(Transaction tx = banco_dados.beginTx()){
            org.neo4j.graphdb.Node noFelipe = banco_dados.createNode(NodeType.Pessoa);
            noFelipe.setProperty("Nome", "Felipe");
            noFelipe.setProperty("Idade", 18);
            
            org.neo4j.graphdb.Node noComp = banco_dados.createNode(NodeType.Curso);
            noComp.setProperty("Nome", "Ciência da Computação");
            
            noFelipe.createRelationshipTo(noComp, RelationType.Cursa);
            
            tx.success();
        }
        banco_dados.shutdown();
    } 
}
