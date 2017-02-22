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
import model.Category;

/**
 * Class for inserting and selecting data about categories from the database
 *
 * @author 
 * @version 1.0
 */
public final class CategoryDAO {
    
    /**
     * Gets all the existing categories from the database
     * 
     * @return the list of categories as objects of Category class
     */
    public static List<Category> getCategories() {
        try {
            List<Category> list = new ArrayList<>();
            Connection connection = Connector.getConnection();
            if (connection != null) {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM Categories");
                while (rs.next()) {
                    list.add(new Category(rs.getInt("categoryId"), rs.getString("categoryName")));
                }
            }
            return list;
        } catch (SQLException e) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    /**
     * Gets category's name by given unique id
     *
     * @param id is the id of searched category
     * @return category's name if exists, null if not
     */
    public static Category getCategoryByID(int id) {
        try {
            Statement statement = Connector.getConnection().createStatement();
            String query = "SELECT * FROM Categories WHERE categoryId = " + id + "";
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                return new Category(rs.getInt(1), rs.getString(2));
            } else {
                return null;
            }
        } catch (SQLException e) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    /**
     * Gets category's id by its name
     *
     * @param name is the name of searched category
     * @return category's id if exists, zero if not
     */
    public static Category getCategoryByName(String name) {
        try {
            Statement statement = Connector.getConnection().createStatement();
            String query = "SELECT * FROM Categories WHERE categoryName = '" + name + "'";
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                return new Category(rs.getInt(1), rs.getString(2));
            } else {
                return null;
            }
        } catch (SQLException e) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    /**
     * Adds new category do the database
     * 
     * @param name is new category's name
     * @return true if successfully added, false if not
     */
    public static boolean addCategory(String name) {
        Connector.getConnection();
        try {
            Statement statement = Connector.getConnection().createStatement();
            String query = "INSERT INTO Categories (categoryName) VALUES "
                    + "('" + name + "')";
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    
}
