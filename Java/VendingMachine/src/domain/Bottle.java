package domain;

public class Bottle extends Product{
    private double bottleVolume;

    public double getBottleVolume() {
        return bottleVolume;
    }

    public void setBottleVolume(double bottleVolume) {
        this.bottleVolume = bottleVolume;
    }

    @Override
    public String toString() {
        return "Bottle{" +
                super.toString() + " " +
                "bottleVolume=" + bottleVolume +
                '}';
    }

    public Bottle(long id, String name, double price, int place, double bottleVolume) {
        super(id, name, price, place);
        this.bottleVolume = bottleVolume;
    }
}
