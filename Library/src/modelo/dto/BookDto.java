package modelo.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Iterator;

/*Encapsulacion de valores para la tabla de libros*/
public class BookDto implements Serializable{
    private int bookId;
    private String title;
    private int authorId;
    private String edition;
    private int editorialId;
    private Date printing;
    private int categoryId;
    private String location;
    private int availability;

    /**
     * @return the bookId
     */
    public int getBookId() {
        return bookId;
    }

    /**
     * @param bookId the bookId to set
     */
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the authorId
     */
    public int getAuthorId() {
        return authorId;
    }

    /**
     * @param authorId the authorId to set
     */
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    /**
     * @return the edition
     */
    public String getEdition() {
        return edition;
    }

    /**
     * @param edition the edition to set
     */
    public void setEdition(String edition) {
        this.edition = edition;
    }

    /**
     * @return the editorialId
     */
    public int getEditorialId() {
        return editorialId;
    }

    /**
     * @param editorialId the editorialId to set
     */
    public void setEditorialId(int editorialId) {
        this.editorialId = editorialId;
    }

    /**
     * @return the printing
     */
    public Date getPrinting() {
        return printing;
    }

    /**
     * @param printing the printing to set
     */
    public void setPrinting(Date printing) {
        this.printing = printing;
    }

    /**
     * @return the categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the availability
     */
    public int getAvailability() {
        return availability;
    }

    /**
     * @param availability the availability to set
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }

}