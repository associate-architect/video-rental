public class ListCustomersCommand extends Command {
    public ListCustomersCommand(VRUI ui) {
        super(ui);
    }

    @Override
    void execute() {
        ui.listCustomers();
    }
}