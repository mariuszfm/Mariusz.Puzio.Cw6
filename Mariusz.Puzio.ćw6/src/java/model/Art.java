package model;

/**
 * Model for containing information about arts
 *
 * @author 
 * @version 1.0
 */
public final class Art {
    
    /**
     * Art's id
     */
    private int id;

    /**
     * Art's title
     */
    private String title;
    
    /**
     * Art's extension
     */
    private String extension;
    
    /**
     * Art's creator id
     */
    private int creatorId;
    
    /**
     * Art's category id
     */
    private int categoryId;
    
    /**
     * Constructor which takes all the needed parameters and assigns them
     * 
     * @param id is the id to set
     * @param title is the title to set
     * @param extension is the extension to set
     * @param creatorId is the creatorId to set
     * @param categoryId is the categoryId to set
     */
    public Art(int id, String title, String extension, int creatorId, int categoryId) {
        this.setId(id);
        this.setTitle(title);
        this.setExtension(extension);
        this.setCreatorId(creatorId);
        this.setCategoryId(categoryId);
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
     * Gets the title
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title
     * @param title is the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the extension
     * @return the extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Sets the extension
     * @param extension is the extension to set
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * Gets the creator's id
     * @return the creatorId
     */
    public int getCreatorId() {
        return creatorId;
    }

    /**
     * Sets the creator's id
     * @param creatorId is the creatorId to set
     */
    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * Gets the category's id
     * @return the categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * Sets the category's id
     * @param categoryId is the categoryId to set
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    
}
