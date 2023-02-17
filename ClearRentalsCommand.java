public class ClearRentalsCommand extends Command {
    private final VRService srv;
    public ClearRentalsCommand(VRService srv) {
        this.srv = srv;
    }

    @Override
    void execute() {
        srv.clearRentals();
    }
}