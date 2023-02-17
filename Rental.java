import java.util.Date;

public class Rental {
	private Video video ;
	private int status ; // 0 for Rented, 1 for Returned
	private Date rentDate ;
	private Date returnDate ;

	public Rental(Video video) {
		this.video = video ;
		status = 0 ;
		rentDate = new Date() ;
	}

	public Video getVideo() {
		return video;
	}

	public int getStatus() {
		return status;
	}

	public void returnVideo() {
		if ( status == 1 ) {
			returnDate = new Date() ;
		}
	}
	public Date getRentDate() {
		return rentDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public int getDaysRentedLimit() {
		int limit = 0 ;
		int daysRented ;
		daysRented = getDaysRented();
		if ( daysRented <= 2) return limit ;

		return video.getRentedLimit();
	}

	public int getDaysRented() {
		int daysRented;
		if (getStatus() == 1) { // returned Video
			daysRented = getRented(returnDate);
		} else { // not yet returned
			daysRented = getRented(new Date());
		}
		return daysRented;
}

	private int getRented(Date x) {
		int daysRented;
		long diff = x.getTime() - rentDate.getTime();
		daysRented = (int) (diff / (1000 * 60 * 60 * 24)) + 1;
		return daysRented;
	}

	double calculateCharge(double eachCharge, int daysRented) {
		return video.getCharge(eachCharge, daysRented, this);
	}

}
