public class ClearRentalsCommand extends Command {
    public ClearRentalsCommand(VRUI ui) {
        super(ui);
    }

    @Override
    void execute() {
        ui.clearRentals();
    }
}