public class RegisterCustomerCommand extends Command {

    public RegisterCustomerCommand(VRUI ui) {
        super(ui);
    }

    @Override
    void execute() {
        ui.registerCustomer();
    }
}