package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import database.Connector;
import model.Creator;

/**
 * Class for inserting and selecting data about creators from the database
 *
 * @author 
 * @version 1.0
 */
public class CreatorDAO {
    
    /**
     * Gets all the existing categories from the database
     * 
     * @return the list of categories as objects of Category class
     */
    public static List<Creator> getCreators() {
        try {
            List<Creator> list = new ArrayList<>();
            Connection connection = Connector.getConnection();
            if (connection != null) {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM Creators");
                while (rs.next()) {
                    list.add(new Creator(rs.getInt("creatorId"), rs.getString("creatorName")));
                }
            }
            return list;
        } catch (SQLException e) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    /**
     * Gets creator's name by given unique id
     *
     * @param id is the id of searched creator
     * @return creator's name
     */
    public static Creator getCreatorByID(int id) {
        try {
            Statement statement = Connector.getConnection().createStatement();
            String query = "SELECT * FROM Creators WHERE creatorId = " + id + "";
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                return new Creator(rs.getInt(1), rs.getString(2));
            } else {
                return null;
            }
        } catch (SQLException e) {
            Logger.getLogger(CreatorDAO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    /**
     * Gets creator's id by its name
     *
     * @param name is the name of searched creator
     * @return creator's id
     */
    public static Creator getCreatorByName(String name) {
        try {
            Statement statement = Connector.getConnection().createStatement();
            String query = "SELECT * FROM Creators WHERE creatorName = '" + name + "'";
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                return new Creator(rs.getInt(1), rs.getString(2));
            } else {
                return null;
            }
        } catch (SQLException e) {
            Logger.getLogger(CreatorDAO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    /**
     * Adds new creator do the database
     * 
     * @param name is new creator's name
     * @return true if successfully added, false if not
     */
    public static boolean addCreator(String name) {
        Connector.getConnection();
        try {
            Statement statement = Connector.getConnection().createStatement();
            String query = "INSERT INTO Creators (creatorName) "
                    + " VALUES('" + name + "')";
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            Logger.getLogger(ArtDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
}
