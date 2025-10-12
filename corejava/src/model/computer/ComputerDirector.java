package model.computer;

public class ComputerDirector {
    public void construct(ComputerBuilder builder) {
        builder.buildCPU();
        builder.buildRAM();
        builder.buildStorage();
    }
}
