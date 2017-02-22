package model;

/**
 * Model for containing information about creators and artists
 *
 * @author 
 * @version 1.0
 */
public final class Creator {
    
    /**
     * Creator's id
     */
    private int id;
    
    /**
     * Creator's name
     */
    private String name;
    
    /**
     * Constructor which takes all the needed parameters and assigns them
     * 
     * @param id is the id to set
     * @param name is the name to set
     */
    public Creator(int id, String name) {
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
     * Sets the name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the name
     * @param name is the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
