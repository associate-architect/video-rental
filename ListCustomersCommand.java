public class ListCustomersCommand extends Command {
    private final VRService srv;
    public ListCustomersCommand(VRService srv) {
        this.srv = srv;
    }

    @Override
    void execute() {
        srv.listCustomers();
    }
}