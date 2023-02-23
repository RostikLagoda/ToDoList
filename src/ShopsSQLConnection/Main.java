package ShopsSQLConnection;

import ShopsSQLConnection.Repository.ProductRepository;
import ShopsSQLConnection.Repository.ShopRepository;

public class Main {
    public static void main(String[] args) {
        ProductRepository pr = new ProductRepository();
        ShopRepository sr = new ShopRepository();
        sr.add("ABC", 5);
        sr.add("QWER", 4);
        sr.add("FGH", 3);
        sr.add("KFC", 5);
        pr.add("Hleb",100,1);
        pr.add("Moloko", 80,1);
        pr.add("Colbosa", 400, 2);
        pr.add("Egurt", 70,2);
        pr.add("Seledka", 200, 3);
        pr.add("Ananas", 150, 3);
        pr.add("Tvorog", 200, 4);
        pr.add("Kartoha", 50, 4);
    }


}
