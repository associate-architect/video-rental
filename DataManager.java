import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DataManager {
    private List<Customer> customers = new ArrayList<Customer>() ;
    private List<Video> videos = new ArrayList<Video>() ;

    public DataManager() {
    }

    List<Customer> getCustomers() {
        return Collections.unmodifiableList(customers);
    }

    List<Video> getVideos() {
        return Collections.unmodifiableList(videos);
    }

    void returnVideo(Customer foundCustomer, String videoTitle) {
        List<Rental> customerRentals = foundCustomer.getRentals();
        for (Rental rental : customerRentals) {
            if (rental.getVideo().getTitle().equals(videoTitle) && rental.getVideo().isRented()) {
                rental.returnVideo();
                rental.getVideo().setRented(false);
                break;
            }
        }
    }

    void addCustomer(Customer james) {
        customers.add(james) ;
    }

    Customer getCustomer(String customerName) {
        Customer foundCustomer = null ;
        for ( Customer customer: customers ) {
            if ( customer.getName().equals(customerName)) {
                foundCustomer = customer ;
                break ;
            }
        }
        return foundCustomer;
    }

    void addVideo(Video v1) {
        videos.add(v1) ;
    }

    Video getVideo(String videoTitle) {
        for ( Video video: videos ) {
            if ( video.getTitle().equals(videoTitle) && video.isRented() == false ) {
                return video;
            }
        }
        return null;
    }

    void rentVideo(Customer foundCustomer, Video foundVideo) {
        Rental rental = new Rental(foundVideo) ;
        foundVideo.setRented(true);

        List<Rental> customerRentals = foundCustomer.getRentals() ;
        customerRentals.add(rental);
        foundCustomer.setRentals(customerRentals);
    }

    void clearRentals(Customer foundCustomer) {
        List<Rental> rentals = new ArrayList<Rental>() ;
        foundCustomer.setRentals(rentals);
    }

    Video createVideo(String title, int videoType, int priceCode) {
        Date registeredDate = new Date();
        Video video = Video.createVideo(title, videoType, priceCode, registeredDate) ;
        return video;
    }

    Customer createCustomer(String name) {
        Customer customer = new Customer(name) ;
        return customer;
    }
}