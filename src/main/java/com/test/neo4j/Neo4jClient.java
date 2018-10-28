package com.test.neo4j;

import org.neo4j.driver.v1.*;

import java.util.List;

import static org.neo4j.driver.v1.Values.parameters;

public class Neo4jClient {
    public static void main(String[] args) {
        Driver driver = GraphDatabase.driver("bolt://192.168.47.100:7687", AuthTokens.basic("neo4j", "1234567"));
        Session session = driver.session();
         /*
        session.run("CREATE (a:Person {name: {name}, title: {title}})",
                parameters("name", "Arthur", "title", "King"));
         */
         /*
        StatementResult result = session.run("MATCH (a:Person) WHERE a.name = {name} " +
                        "RETURN a.name AS name, a.title AS title",
                parameters("name", "Arthur"));
                */
         StatementResult result=session.run("match(a:Entry)-[:持股]->(b) where b.name='中行' return a.name as name;");
        while (result.hasNext()) {
            Record record = result.next();
            System.out.println(record.get("name"));

            //System.out.println(record.);

        }
        System.out.println("sunhao1");
        session.close();
        driver.close();
    }
}