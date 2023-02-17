public class RentVideoCommand extends Command {
    public RentVideoCommand(VRUI ui) {
        super(ui);
    }

    @Override
    void execute() {
        ui.rentVideo();
    }
}