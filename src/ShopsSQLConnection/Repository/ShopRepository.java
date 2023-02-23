package ShopsSQLConnection.Repository;

import ShopsSQLConnection.Entity.Shop;
import ShopsSQLConnection.JDBCConnection.JDBCConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ShopsSQLConnection.JDBCConnection.UserConstantQuery.*;

public class ShopRepository {

    public void add(String name, int rating){
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test","root","root");
            PreparedStatement preparedStatement = JDBCConnector.getConnection().prepareStatement(INSERT_SHOP);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,rating);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void updateById (int id, String name, int rating){
        try {
            PreparedStatement preparedStatement = JDBCConnector.getConnection().prepareStatement(UPDATE_SHOP);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, rating);
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Shop> getAll(){
        try {
            Statement statement = JDBCConnector.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL_SHOPS);
            return getShopsFromRs(rs);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    private List<Shop> getShopsFromRs(ResultSet rs) throws SQLException{
        List<Shop> shops = new ArrayList<>();
        while(rs.next()){
            Shop shop = new Shop();
            shop.setId(rs.getInt(1));
            shop.setName(rs.getString(2));
            shop.setRating(rs.getInt(3));
            shops.add(shop);
        }
        rs.close();
        return shops;
    }
}
