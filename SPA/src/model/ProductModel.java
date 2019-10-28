package model;

public class ProductModel {
    private int id_product;
    private String name_product;
    private double original_price;
    private double price;
    private int amount;
    private int category_id;
    private String image;
    private String description;
    private int quantityInCart =0;

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    private double totalMoney =0;
    public int getQuantityInCart() {
        return quantityInCart;
    }

    public void setQuantityInCart(int quantityInCart) {
        this.quantityInCart = quantityInCart;
    }


    public ProductModel(){}

    public ProductModel(String name_product, double original_price, double price, int amount, int category_id, String image, String description) {
        this.name_product = name_product;
        this.original_price = original_price;
        this.price = price;
        this.amount = amount;
        this.category_id = category_id;
        this.image = image;
        this.description = description;
    }

    public ProductModel(int id_product, String name_product, double original_price,
                        double price, int amount, int category_id, String image,
                        String description) {
        this.id_product = id_product;
        this.name_product = name_product;
        this.original_price = original_price;
        this.price = price;
        this.amount = amount;
        this.category_id = category_id;
        this.image = image;
        this.description = description;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public double getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(double original_price) {
        this.original_price = original_price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
