public abstract class Command {
    protected VRUI ui;

    public Command(VRUI ui) {
        this.ui = ui;
    }

    abstract void execute();
}
