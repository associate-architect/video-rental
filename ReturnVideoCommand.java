public class ReturnVideoCommand extends Command {
    public ReturnVideoCommand(VRUI ui) {
        super(ui);
    }

    @Override
    void execute() {
        ui.returnVideo();
    }
}