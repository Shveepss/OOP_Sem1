import domain.Bottle;
import domain.HotDrink;
import domain.Product;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(1, "Lays", 132.55, 13);
        Product product2 = new Product(2, "Snikers", 52.10, 14);
        Product product3 = new Product(3, "Nuts", 49.55, 15);
        Product bottle1 = new Bottle(4, "CocaCola", 99.00, 5, 0.5);
        Product capuchino = new HotDrink(5, "Capuchino", 150.00, 1, 80);
        Product latte = new HotDrink(6, "Latte", 160.00, 1, 70);
        Product americano = new HotDrink(7, "Americano", 140.00, 1, 85);

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(bottle1);
        productList.add(capuchino);
        productList.add(latte);
        productList.add(americano);

        SwingUtilities.invokeLater(() -> {
            MainFrame vendingMachineUI = new MainFrame(productList);
            vendingMachineUI.setVisible(true);
        });
    }
}