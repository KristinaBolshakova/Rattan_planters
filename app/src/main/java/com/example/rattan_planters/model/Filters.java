package com.example.rattan_planters.model;

/**
 * категории фильтров
 */
public class Filters {

    int id;
    String title;

    /**
     *
     * @param id - идентификатор
     * @param title - имя фильтра
     */
    public Filters(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
