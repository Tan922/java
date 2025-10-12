package model.vendingMachine;

public enum VendingMachineState {
    Ready {
        @Override
        public void handleRequest() {
            System.out.println("Ready state: Please select a product.");
        }
    },
    ProductSelected {
        @Override
        public void handleRequest() {
            System.out.println("Product selected state: Processing payment.");
        }
    },
    PaymentPending {
        @Override
        public void handleRequest() {
            System.out.println("Payment pending state: Dispensing product.");
        }
    },
    OutOfStock {
        @Override
        public void handleRequest() {
            System.out.println("Out of stock state: Product unavailable. Please select another product.");
        }
    };
    public abstract void handleRequest();
}
