public class RegisterVideoCommand extends Command {

    public RegisterVideoCommand(VRUI ui) {
        super(ui);
    }

    @Override
    void execute() {
        ui.registerVideo();
    }
}