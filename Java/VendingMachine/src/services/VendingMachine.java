package services;

import domain.Product;
import java.util.List;

public class VendingMachine {
    private Holder holder;
    private Display display;
    private CoinDispenser coinDispenser;
    private List<Product> products;

    public Holder getHolder() {
        return holder;
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public CoinDispenser getCoinDispenser() {
        return coinDispenser;
    }

    public void setCoinDispenser(CoinDispenser coinDispenser) {
        this.coinDispenser = coinDispenser;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public VendingMachine(Holder holder, Display display, CoinDispenser coinDispenser, List<Product> products) {
        this.holder = holder;
        this.display = display;
        this.coinDispenser = coinDispenser;
        this.products = products;

    }

    /**
     * @apiNote добавление продукта в аппарат
     * @param product объект добавляемого продукта
     */
    public void addProduct(Product product){
        if (product.getPrice() <= 0){
            product.setPrice(100);
        }
        this.products.add(product);
    }
}
