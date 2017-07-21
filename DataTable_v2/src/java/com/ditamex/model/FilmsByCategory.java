package com.ditamex.model;

/**
 *
 * @author renecruz
 */
public class FilmsByCategory {
    private String nameCategory;
    private long totalMovies;
    
    public FilmsByCategory(String nameCategory, long totalMovies) {
        this.nameCategory = nameCategory;
        this.totalMovies = totalMovies;
    }

    /**
     * @return the nameCategory
     */
    public String getNameCategory() {
        return nameCategory;
    }

    /**
     * @param nameCategory the nameCategory to set
     */
    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    /**
     * @return the totalMovies
     */
    public long getTotalMovies() {
        return totalMovies;
    }

    /**
     * @param totalMovies the totalMovies to set
     */
    public void setTotalMovies(long totalMovies) {
        this.totalMovies = totalMovies;
    }
}
