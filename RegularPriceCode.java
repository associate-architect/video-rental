public class RegularPriceCode extends PriceCode {
    @Override
    public double getCharge(double eachCharge, int daysRented) {
        eachCharge += 2;
        if (daysRented > 2)
            eachCharge += (daysRented - 2) * 1.5;

        return eachCharge;
    }

    @Override
    public int getPriceCode() {
        return 1;
    }

    @Override
    public int getEachPoint(int eachPoint) {
        return eachPoint;
    }
}
