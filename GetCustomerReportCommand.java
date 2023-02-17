public class GetCustomerReportCommand extends Command {
    private final VRService srv;
    public GetCustomerReportCommand(VRService srv) {
        this.srv = srv;
    }

    @Override
    void execute() {
        srv.getCustomerReport();
    }
}
