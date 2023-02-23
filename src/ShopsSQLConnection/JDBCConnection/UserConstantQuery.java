package ShopsSQLConnection.JDBCConnection;

public interface UserConstantQuery {

    String INSERT_SHOP = "INSERT INTO test.shop (name, rating) VALUES (?, ?)";
    String UPDATE_SHOP = "UPDATE test.shop SET name = ?, rating = ? WHERE id = ?";
    String SELECT_ALL_SHOPS = "SELECT * FROM test.shop";

    String INSERT_PRODUCT = "INSERT INTO test.product (name, price, shopId) VALUES (?, ?, ?)";
    String UPDATE_PRODUCT = "UPDATE test.product SET name = ?, price = ?, shopId = ? WHERE prodId = ?";
    String SELECT_ALL_PRODUCTS = "SELECT * FROM test.product";
}
