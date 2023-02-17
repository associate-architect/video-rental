public class InitCommand extends Command {
    private final VRService srv;
    public InitCommand(VRService srv) {
        this.srv = srv;
    }

    @Override
    void execute() {
        srv.init();
    }
}