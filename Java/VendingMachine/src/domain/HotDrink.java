package domain;

public class HotDrink extends Product{
    private int temperature;

    @Override
    public String toString() {
        return "HotDrink{" +
                super.toString() + " " +
                "temperature=" + temperature +
                '}';
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public HotDrink(long id, String name, double price, int place, int temperature) {
        super(id, name, price, place);
        this.temperature = temperature;
    }
}
