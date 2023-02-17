import java.util.Date;

public abstract class Video {
    private String title;

    private int priceCode;
    public static final int REGULAR = 1;
    public static final int NEW_RELEASE = 2;

    private int videoType;
    public static final int VHS = 1;
    public static final int CD = 2;
    public static final int DVD = 3;

    private Date registeredDate;
    private boolean rented;

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

    public Video(String title, int priceCode, Date registeredDate) {
        this.setTitle(title);
        this.setPriceCode(priceCode);
        this.registeredDate = registeredDate;
    }

    public abstract int getLateReturnPointPenalty();

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
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

    double getCharge(double eachCharge, int daysRented, Rental rental) {
        switch (rental.getVideo().getPriceCode()) {
            case REGULAR:
                eachCharge += 2;
                if (daysRented > 2)
                    eachCharge += (daysRented - 2) * 1.5;
                break;
            case NEW_RELEASE:
                eachCharge = daysRented * 3;
                break;
        }
        return eachCharge;
    }
}
