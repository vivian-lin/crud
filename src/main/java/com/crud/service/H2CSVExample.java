package com.crud.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.springframework.stereotype.Component;

@Component
public class H2CSVExample {

    public void seedDb() throws Exception {
        Connection conn = null;
        Statement stmt = null;

        Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection("jdbc:h2:~/test", "", "");
        stmt = conn.createStatement();

        stmt.execute("drop table if exists reports");
        stmt.execute(
                "create table reports (id INT NOT NULL IDENTITY PRIMARY KEY, region varchar(100), year bigint, percentage decimal, source varchar(100));");
        stmt.execute(
                "insert into reports ( region, year, percentage, source) select convert('year', int), convert('percentage', decimal) from CSVREAD( 'classpath:csv.csv', null, null ) ");
        stmt.close();
    }
}
