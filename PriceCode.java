public abstract class PriceCode {
    public PriceCode() {
    }

    public abstract double getCharge(double eachCharge, int daysRented);

    public abstract int getPriceCode();
    public abstract int getEachPoint(int eachPoint);
}
