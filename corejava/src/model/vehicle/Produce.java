package model.vehicle;

public class Produce implements Workshop {
    @Override
    public void work()
    {
        System.out.print("Produced");
    }
}
