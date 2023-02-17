public class ReturnVideoCommand extends Command {
    private final VRService srv;
    public ReturnVideoCommand(VRService srv) {
        this.srv = srv;
    }

    @Override
    void execute() {
        srv.returnVideo();
    }
}