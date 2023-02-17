import java.util.Date;

public class CDVideo extends Video {
    public CDVideo(String title, int priceCode, Date registeredDate) {
        super(title, priceCode, registeredDate);
    }

    @Override
    public int getLateReturnPointPenalty() {
        return 2;
    }

    @Override
    public int getRentedLimit() {
        return 3;
    }
}
