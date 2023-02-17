import java.util.Date;
import java.util.Scanner;

public class VRUI {
    private static Scanner scanner = new Scanner(System.in);
    private final DataManager dataManager = new DataManager();
    boolean quit = false;

    public static void main(String[] args) {
        VRUI ui = new VRUI();

        while (!ui.quit) {
            ui.createCommand().execute();
        }
        System.out.println("Bye");
    }

    private Command createCommand() {
        int inputCommand = showCommand();
        Command command;
        switch (inputCommand) {
            case 0:
                command = new QuitCommand(this);
                break;
            case 1:
                command = new ListCustomersCommand(this);
                break;
            case 2:
                command = new ListVideosCommand(this);
                break;
            case 3:
                command = new RegisterCustomerCommand(this);
                break;
            case 4:
                command = new RegisterVideoCommand(this);
                break;
            case 5:
                command = new RentVideoCommand(this);
                break;
            case 6:
                command = new ReturnVideoCommand(this);
                break;
            case 7:
                command = new GetCustomerReportCommand(this);
                break;
            case 8:
                command = new ClearRentalsCommand(this);
                break;
            case -1:
                command = new InitCommand(this);
                break;
            default:
                command = new DefaultCommand(this);
                break;
        }

        return command;
    }

    public void clearRentals() {
        Customer foundCustomer = findCustomer();

        if (foundCustomer == null) {
            System.out.println("No customer found");
        } else {
            System.out.println("Name: " + foundCustomer.getName() +
                    "\tRentals: " + foundCustomer.getRentals().size());
            for (Rental rental : foundCustomer.getRentals()) {
                System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ");
                System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode());
            }

            dataManager.clearRentals(foundCustomer);
        }
    }

    public void returnVideo() {
        Customer foundCustomer = findCustomer();
        if (foundCustomer == null) return;

        System.out.println("Enter video title to return: ");
        String videoTitle = scanner.next();

        dataManager.returnVideo(foundCustomer, videoTitle);
    }

    private Customer findCustomer() {
        System.out.println("Enter customer name: ");
        String customerName = scanner.next();

        return dataManager.getCustomer(customerName);
    }

    void init() {
        Customer james = new Customer("James");
        Customer brown = new Customer("Brown");
        dataManager.addCustomer(james);
        dataManager.addCustomer(brown);

        Video v1 = Video.createVideo("v1", Video.CD, Video.REGULAR, new Date());
        Video v2 = Video.createVideo("v2", Video.DVD, Video.NEW_RELEASE, new Date());
        dataManager.addVideo(v1);
        dataManager.addVideo(v2);

        Rental r1 = new Rental(v1);
        Rental r2 = new Rental(v2);

        james.addRental(r1);
        james.addRental(r2);
    }

    void quit() {
        quit = true;
    }

    public void listVideos() {
        System.out.println("List of videos");

        for (Video video : dataManager.getVideos()) {
            System.out.println("Price code: " + video.getPriceCode() + "\tTitle: " + video.getTitle());
        }
        System.out.println("End of list");
    }

    public void listCustomers() {
        System.out.println("List of customers");
        for (Customer customer : dataManager.getCustomers()) {
            System.out.println("Name: " + customer.getName() +
                    "\tRentals: " + customer.getRentals().size());
            for (Rental rental : customer.getRentals()) {
                System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ");
                System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode());
            }
        }
        System.out.println("End of list");
    }

    public void getCustomerReport() {
        Customer foundCustomer = findCustomer();

        if (foundCustomer == null) {
            System.out.println("No customer found");
        } else {
            String result = foundCustomer.getReport();
            System.out.println(result);
        }
    }

    public Video findAvailableVideo() {
        System.out.println("Enter video title to rent: ");
        String videoTitle = scanner.next();

        return dataManager.getVideo(videoTitle);
    }

    public void rentVideo() {
        Customer foundCustomer = findCustomer();
        if (foundCustomer == null) return;

        Video foundVideo = findAvailableVideo();
        if (foundVideo == null) return;

        dataManager.rentVideo(foundCustomer, foundVideo);
    }

    public Video createVideo() {
        System.out.println("Enter video title to register: ");
        String title = scanner.next();

        System.out.println("Enter video type( 1 for VHD, 2 for CD, 3 for DVD ):");
        int videoType = scanner.nextInt();

        System.out.println("Enter price code( 1 for Regular, 2 for New Release ):");
        int priceCode = scanner.nextInt();

        return dataManager.createVideo(title, videoType, priceCode);
    }

    public Customer createCustomer() {
        System.out.println("Enter customer name: ");
        String name = scanner.next();
        return dataManager.createCustomer(name);
    }

    void registerVideo() {
        Video video = createVideo();
        dataManager.addVideo(video);
    }

    void registerCustomer() {
        Customer customer = createCustomer();
        dataManager.addCustomer(customer);
    }

    public int showCommand() {
        System.out.println("\nSelect a command !");
        System.out.println("\t 0. Quit");
        System.out.println("\t 1. List customers");
        System.out.println("\t 2. List videos");
        System.out.println("\t 3. Register customer");
        System.out.println("\t 4. Register video");
        System.out.println("\t 5. Rent video");
        System.out.println("\t 6. Return video");
        System.out.println("\t 7. Show customer report");
        System.out.println("\t 8. Show customer and clear rentals");

        int command = scanner.nextInt();

        return command;

    }
}
