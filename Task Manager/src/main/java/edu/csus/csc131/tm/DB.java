package edu.csus.csc131.tm;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class DB
{

    public Connection connect()
    {
        Connection c = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TM.sqlite");
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
            System.out.println("Opened insert database successfully");
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
    public String result()
    {
        Connection c = null;
        Statement stmt = null;
        String output="";
        try {
            c = connect();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM task_info;" );
           // output=rs.toString();

            while ( rs.next() ) {
                String  name = rs.getString("name");
                int age  = rs.getInt("age");
                String  address = rs.getString("address");
                float salary = rs.getFloat("salary");

                System.out.println( "NAME = " + name );
                System.out.println( "AGE = " + age );
                System.out.println( "ADDRESS = " + address );
                System.out.println( "SALARY = " + salary );
                System.out.println();
            }
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
            System.out.println("Opened Updatae database successfully");
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

}