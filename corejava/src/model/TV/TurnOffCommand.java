package model.TV;

import java.util.function.Consumer;

public class TurnOffCommand implements Command {
    private Consumer<Void> deviceAction;

    public TurnOffCommand(Consumer<Void> deviceAction) {
        this.deviceAction = deviceAction;
    }

    @Override
    public void execute() {
        deviceAction.accept(null);
    }
}
