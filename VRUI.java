import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VRUI {
    private boolean quit = false ;
    private static final VRService srv = new VRService();
	private static Scanner scanner = new Scanner(System.in) ;

    public static void main(String[] args) {
        VRUI ui = new VRUI();

        while (!ui.quit) {
            ui.createCommand().execute();
        }
        System.out.println("Bye");
    }

    void quit() {
        quit = true;
    }

    Command createCommand() {
        int inputCommand = showCommand();
        Command command;
        switch (inputCommand) {
            case 0:
                command = new QuitCommand(this);
                break;
            case 1:
                command = new ListCustomersCommand(srv);
                break;
            case 2:
                command = new ListVideosCommand(srv);
                break;
            case 3:
                command = new RegisterCommand(srv, "customer");
                break;
            case 4:
                command = new RegisterCommand(srv, "video");
                break;
            case 5:
                command = new RentVideoCommand(srv);
                break;
            case 6:
                command = new ReturnVideoCommand(srv);
                break;
            case 7:
                command = new GetCustomerReportCommand(srv);
                break;
            case 8:
                command = new ClearRentalsCommand(srv);
                break;
            case -1:
                command = new InitCommand(srv);
                break;
            default:
                command = new DefaultCommand(srv);
                break;
        }

        return command;
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

		int command = scanner.nextInt() ;

		return command ;

	}
}
