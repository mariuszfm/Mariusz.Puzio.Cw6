package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import database.Connector;

/**
 * Class which is run when the server starts.
 * It creates default tables for the database to work properly.
 * If some tables are already created, the rest is initialized anyway.
 *
 * @author 
 * @version 1.0
 */
public final class Start extends HttpServlet {
    
    /**
     * Conects with the database
     */
    private Connection connection = null;
    
    /**
     * {@inheritDoc}
     * Creates the initial database
     * 
     * @throws ServletException if problem with servlet occured
     */
    @Override
    public void init() throws ServletException {
        if (Connector.getConnection() == null) {
            if (Connector.setConnection(this.getServletContext())) {
                this.connection = Connector.getConnection();
                // create initial tables
                this.createArtsTable();
                this.createCreatorsTable();
                this.createCategoriesTable();
            }
        }
    }
    
    /**
     * Creates a new table based on the given query
     * 
     * @param query a base for creating a new table
     */
    private void createTable(String query) {
        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            // table already exists, do nothing
        }
    }
    
    /**
     * Creates default arts table
     */
    private void createArtsTable() {
        this.createTable("CREATE TABLE Arts ( "
                + " artId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + " artTitle VARCHAR(50) NOT NULL, "
                + " artExtension VARCHAR(100) NOT NULL, "
                + " creatorId INTEGER NOT NULL, "
                + " categoryId INTEGER NOT NULL, "
                + " PRIMARY KEY (artId) "
                + ")");
    }
    
    /**
     * Creates default creators table
     */
    private void createCreatorsTable() {
        this.createTable("CREATE TABLE Creators ( "
                + " creatorId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + " creatorName VARCHAR(50) NOT NULL, "
                + " PRIMARY KEY (creatorId) "
                + ")");
    }
    
    /**
     * Creates default categories table
     */
    private void createCategoriesTable() {
        this.createTable("CREATE TABLE Categories ( "
                + " categoryId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + " categoryName VARCHAR(50) NOT NULL, "
                + " PRIMARY KEY (categoryId) "
                + ")");
    }
    
}
