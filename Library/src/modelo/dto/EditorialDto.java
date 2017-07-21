package modelo.dto;

import java.io.Serializable;
import java.util.Iterator;

/*Encapsulacion de valores para la tabla de editorial*/
public class EditorialDto implements Serializable{
    private int editorialId;
    private String editorial;

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
     * @return the editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * @param editorial the editorial to set
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

}