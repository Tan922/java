package model;

public class PrinterAdapter implements Printer {
    private LegacyPrinter legacyPrinter = new LegacyPrinter();

    @Override
    public void print() {
        legacyPrinter.printDocument();
    }
}
