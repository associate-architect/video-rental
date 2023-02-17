import java.util.Date;

public class DVDVideo extends Video {
    public DVDVideo(String title, int priceCode, Date registeredDate) {
        super(title, priceCode, registeredDate);
    }

    @Override
    public int getLateReturnPointPenalty() {
        return 3;
    }

    @Override
    public int getRentedLimit() {
        return 2;
    }
}
