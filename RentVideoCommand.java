public class RentVideoCommand extends Command {
    private final VRService srv;
    public RentVideoCommand(VRService srv) {
        this.srv = srv;
    }

    @Override
    void execute() {
        srv.rentVideo();
    }
}
