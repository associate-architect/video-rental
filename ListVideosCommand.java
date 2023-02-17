public class ListVideosCommand extends Command {
    public ListVideosCommand(VRUI ui) {
        super(ui);
    }

    @Override
    void execute() {
        ui.listVideos();
    }
}