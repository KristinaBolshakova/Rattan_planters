package com.example.rattan_planters.model;

/**
 * класс товары
 */
public class Products {
    int id, filter;
    String img, pageImage, title, volume, price, description, colorProduct, height, lowerDiameter, maxDiameter;

    /**
     * @param id            - идентификатор, порядковый номер
     * @param img           - изображение товара для главной страницы
     * @param pageImage     - изображение товара для страницы товара
     * @param title         - наазвание изделия
     * @param volume        - объем изделия
     * @param description   - описание изделия
     * @param price         - цена
     * @param colorProduct  - цвет изделия
     * @param height        - высота изделия
     * @param lowerDiameter - нижний диаметр изделия
     * @param maxDiameter   - максимальное значение диаметра (ширина) изделия
     */
    public Products(int id, String img, String pageImage, String title, String volume, String description,
                    String price, String colorProduct, String height, String lowerDiameter, String maxDiameter, int filter) {
        this.id = id;
        this.img = img;
        this.pageImage = pageImage;
        this.title = title;
        this.volume = volume;
        this.description = description;
        this.price = price;
        this.colorProduct = colorProduct;
        this.height = height;
        this.lowerDiameter = lowerDiameter;
        this.maxDiameter = maxDiameter;
        this.filter = filter;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilter() {
        return filter;
    }

    public void setFilter(int filter) {
        this.filter = filter;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPageImage() {
        return pageImage;
    }

    public void setPageImage(String pageImage) {
        this.pageImage = pageImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColorProduct() {
        return colorProduct;
    }

    public void setColorProduct(String colorProduct) {
        this.colorProduct = colorProduct;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getLowerDiameter() {
        return lowerDiameter;
    }

    public void setLowerDiameter(String lowerDiameter) {
        this.lowerDiameter = lowerDiameter;
    }

    public String getMaxDiameter() {
        return maxDiameter;
    }

    public void setMaxDiameter(String maxDiameter) {
        this.maxDiameter = maxDiameter;
    }
}
