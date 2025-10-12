package model.vehicle;

public class VehicleFactoryClient {
    private Vehicle pVehicle;

    public VehicleFactoryClient(VehicleFactory factory) {
        pVehicle = factory.createVehicle();
    }

    public Vehicle getVehicle() {
        return pVehicle;
    }
}
