import java.util.Date;

public abstract class Video {
    private String title;
    public static final int REGULAR = 1;
    public static final int NEW_RELEASE = 2;
    public static final int VHS = 1;
    public static final int CD = 2;
    public static final int DVD = 3;

    private Date registeredDate;
    private boolean rented;

    PriceCode priceCode;

    public static Video createVideo(String title, int videoType, int priceCode, Date registeredDate) {
        Video video = null;
        switch (videoType) {
            case VHS:
                video = new VHSVideo(title, priceCode, registeredDate);
                break;
            case CD:
                video = new CDVideo(title, priceCode, registeredDate);
                break;
            case DVD:
                video = new DVDVideo(title, priceCode, registeredDate);
                break;
        }

        return video;
    }


    void setPriceCode(int pcode) {
        PriceCode priceCode = null;
        switch (pcode) {
            case REGULAR:
                priceCode = new RegularPriceCode();
                break;

            case NEW_RELEASE:
                priceCode = new NewReleasePriceCode();
                break;
        }

        this.priceCode = priceCode;
    }

    public Video(String title, int priceCode, Date registeredDate) {
        this.setTitle(title);
        this.setPriceCode(priceCode);
        this.registeredDate = registeredDate;
    }

    public abstract int getLateReturnPointPenalty();

    public int getPriceCode() {
        return priceCode.getPriceCode();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public abstract int getRentedLimit();

    double getCharge(double eachCharge, int daysRented) {
        return priceCode.getCharge(eachCharge, daysRented);
    }
}
