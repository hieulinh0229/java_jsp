package model;

public class CategoriesModel {
    private int id_categories;
    private String name_categories;

    public CategoriesModel(int id_categories, String name_categories) {
        this.id_categories = id_categories;
        this.name_categories = name_categories;
    }

    public int getId_categories() {
        return id_categories;
    }

    public void setId_categories(int id_categories) {
        this.id_categories = id_categories;
    }

    public String getName_categories() {
        return name_categories;
    }

    public void setName_categories(String name_categories) {
        this.name_categories = name_categories;
    }
}
