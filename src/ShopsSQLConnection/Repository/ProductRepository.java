package ShopsSQLConnection.Repository;

import ShopsSQLConnection.Entity.Product;
import ShopsSQLConnection.JDBCConnection.JDBCConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static ShopsSQLConnection.JDBCConnection.UserConstantQuery.*;

public class ProductRepository {

    public void add(String name, int price, int shopId){
        try {
            PreparedStatement preparedStatement = JDBCConnector.getConnection().prepareStatement(INSERT_PRODUCT);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,price);
            preparedStatement.setInt(3,shopId);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void updateById (int prodId, String name, int price, int shopId){
        try {
            PreparedStatement preparedStatement = JDBCConnector.getConnection().prepareStatement(UPDATE_PRODUCT);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, price);
            preparedStatement.setInt(2, shopId);
            preparedStatement.setInt(4, prodId);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Product> getAll(){
        try {
            Statement statement = JDBCConnector.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL_PRODUCTS);
            return getProductsFromRs(rs);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    private List<Product> getProductsFromRs(ResultSet rs) throws SQLException {
        List<Product> products = new ArrayList<>();
        while(rs.next()){
            Product product = new Product();
            product.setId(rs.getInt(1));
            product.setName(rs.getString(2));
            product.setPrice(rs.getInt(3));
            product.setShopId(rs.getInt(4));
            products.add(product);
        }
        rs.close();
        return products;
    }

}
