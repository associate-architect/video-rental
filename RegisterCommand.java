public class RegisterCommand extends Command {
    private final VRService srv;
    private String category;

    public RegisterCommand(VRService srv, String category) {
        this.srv = srv;
        this.category = category;
    }

    @Override
    void execute() {
        srv.register(category);
    }
}
