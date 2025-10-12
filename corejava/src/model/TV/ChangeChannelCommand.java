package model.TV;


public class ChangeChannelCommand implements Command {
    private Runnable tvAction;

    public ChangeChannelCommand(Runnable tvAction) {
        this.tvAction = tvAction;
    }

    @Override
    public void execute() {
        tvAction.run();
    }
}
