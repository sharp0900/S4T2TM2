package edu.csus.csc131.tm;

import java.sql.*;

public class DB
{

    public Connection connect()
    {
        Connection c = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return c;
    }
    public void createTable(String sql)
    {
        Connection c = null;
        Statement stmt = null;

        try {
            c = connect();
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
    public void insert(String sql)
    {
        Connection c = null;
        Statement stmt = null;

        try {
            c = connect();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }
    public String select(String args)
    {
        Connection c = null;
        Statement stmt = null;
        String output="";
        try {
            c = connect();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
            output=rs.toString();

            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        return output;
    }
    public void update(String sql)
    {
        Connection c = null;
        Statement stmt = null;

        try {
            c = connect();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            stmt.executeUpdate(sql);
            c.commit();

            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
    public void delete(String sql) {
        update(sql);
    }
}