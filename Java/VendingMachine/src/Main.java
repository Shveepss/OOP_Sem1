import domain.Bottle;
import domain.Product;
import services.CoinDispenser;
import services.Display;
import services.Holder;
import services.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(1, "Lays", 132.55, 13);
        Product product2 = new Product(2, "Snikers", 52.10, 14);
        Product product3 = new Product(3, "Nuts", 49.55, 15);
        Product bottle1 = new Bottle(4, "CocaCola", 99.00, 5, 0.5);

        List<Product> ourList = new ArrayList<>();
        ourList.add(product1);
        ourList.add(product2);
        ourList.add(product3);
        ourList.add(bottle1);

        Holder holder = new Holder();
        Display display = new Display();
        CoinDispenser coinDispenser = new CoinDispenser();

        VendingMachine machine = new VendingMachine(holder, display, coinDispenser, ourList);

        for (Product item : machine.getProducts()) {
            System.out.println(item);
        }

    }
}