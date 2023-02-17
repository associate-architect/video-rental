public class InitCommand extends Command {
    public InitCommand(VRUI ui) {
        super(ui);
    }

    @Override
    void execute() {
        ui.init();
    }
}