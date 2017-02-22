package model;

/**
 * Model for containing information about categories
 *
 * @author 
 * @version 1.0
 */
public final class Category {
    
    /**
     * Category's id
     */
    private int id;

    /**
     * Category's name
     */
    private String name;
    
    /**
     * Constructor which takes all the needed parameters and assigns them
     * 
     * @param id is the id to set
     * @param name is the name to set
     */
    public Category(int id, String name) {
        this.setId(id);
        this.setName(name);
    }

    /**
     * Gets the id
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id
     * @param id is the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     * @param name is the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
