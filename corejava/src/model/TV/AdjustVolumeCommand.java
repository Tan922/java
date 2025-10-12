package model.TV;

public class AdjustVolumeCommand implements Command {
    private Runnable stereoAction;

    public AdjustVolumeCommand(Runnable stereoAction) {
        this.stereoAction = stereoAction;
    }

    @Override
    public void execute() {
        stereoAction.run();
    }
}
