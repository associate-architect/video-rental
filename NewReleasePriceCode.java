public class NewReleasePriceCode extends PriceCode {
    @Override
    public double getCharge(double eachCharge, int daysRented) {
        eachCharge = daysRented * 3;
        return eachCharge;
    }

    @Override
    public int getPriceCode() {
        return 2;
    }
}
