package model.TV;

import java.util.function.Consumer;

public class TurnOnCommand implements Command {
    private Consumer<Void> deviceAction;

    public TurnOnCommand(Consumer<Void> deviceAction) {
        this.deviceAction = deviceAction;
    }

    @Override
    public void execute() {
        deviceAction.accept(null);
    }
}
