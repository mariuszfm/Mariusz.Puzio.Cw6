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
import model.Art;
import exception.UnableAddCategoryException;
import exception.UnableAddCreatorException;

/**
 * Class for inserting and selecting data about arts from the database
 *
 * @author 
 * @version 1.0
 */
public final class ArtDAO {
    
    /**
     * Gets all the existing arts from the database
     * 
     * @return the list of arts as objects of Art class
     */
    public static List<Art> getArts() {
        try {
            List<Art> list = new ArrayList<>();
            Connection connection = Connector.getConnection();
            if (connection != null) {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM Arts");
                while (rs.next()) {
                    // gets one art and adds it to list
                    list.add(new Art(rs.getInt("artId"), rs.getString("artTitle"), 
                            rs.getString("artExtension"), rs.getInt("creatorId"), 
                            rs.getInt("categoryId")));
                }
            }
            return list;
        } catch (SQLException e) {
        }
        return null;
    }
    
    /**
     * Gets art's title by given unique id
     *
     * @param id is the id of searched art
     * @return art's title if exists, null if not
     */
    public static String getArtNameByID(int id) {
        try {
            Statement statement = Connector.getConnection().createStatement();
            String query = "SELECT * FROM Arts WHERE artId = " + id + "";
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                return rs.getString(2);
            } else {
                return null;
            }
        } catch (SQLException e) {
            Logger.getLogger(ArtDAO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    /**
     * Adds new art do the database
     * 
     * @param title is new art's title
     * @param extension is new art's extension
     * @param creatorId is new art's creator id
     * @param categoryId is new art's category id
     * @return true if successfully added, false if not
     */
    public static boolean addArt(String title, String extension, int creatorId, int categoryId) {
        Connector.getConnection();
        try {
            Statement statement = Connector.getConnection().createStatement();
            String query = "INSERT INTO Arts (artTitle, artExtension, creatorId, categoryId) "
                    + "VALUES('" + title + "', '" + extension + "', " + creatorId + ", " + categoryId + ")";
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            Logger.getLogger(ArtDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    
    /**
     * Adds new art do the database
     * 
     * @param title is new art's title
     * @param extension is new art's extension
     * @param creator is new art's creator
     * @param category is new art's category
     * @return true if successfully added, false if not
     */
    public static boolean addArt(String title, String extension, String creator, String category) {
        try {
            if (CreatorDAO.getCreatorByName(creator) == null) {
                if (!CreatorDAO.addCreator(creator)) {
                    throw new UnableAddCreatorException();
                }
            }
            if (CategoryDAO.getCategoryByName(category) == null) {
                if (!CategoryDAO.addCategory(category)) {
                    throw new UnableAddCategoryException();
                }
            }
            int categoryId = CategoryDAO.getCategoryByName(category).getId();
            int creatorId = CreatorDAO.getCreatorByName(creator).getId();
            Statement statement = Connector.getConnection().createStatement();
            String query = "INSERT INTO Arts (artTitle, artExtension, creatorId, categoryId) "
                    + "VALUES('" + title + "', '" + extension + "', " + creatorId + ", " + categoryId + ")";
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            Logger.getLogger(ArtDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } catch (UnableAddCategoryException | UnableAddCreatorException e) {
            return false;
        }
    }
}
