public class ListVideosCommand extends Command {
    private final VRService srv;
    public ListVideosCommand(VRService srv) {
        this.srv = srv;
    }

    @Override
    void execute() {
        srv.listVideos();
    }
}
