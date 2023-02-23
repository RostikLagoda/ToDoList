package ShopsSQLConnection.Entity;

public class Product {

    private int prodId;
    private String name;
    private int price;
    private int shopId;

    public Product() {
    }

    public Product(String name, int price, int shopId) {
        this.name = name;
        this.price = price;
        this.shopId = shopId;
    }

    public int getId() {
        return prodId;
    }

    public void setId(int id) {
        this.prodId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + prodId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", shopId=" + shopId +
                '}';
    }
}
