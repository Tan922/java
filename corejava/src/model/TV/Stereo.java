package model.TV;

public class Stereo implements Device {
    @Override
    public void turnOn() {
        System.out.println("Stereo is now on");
    }

    @Override
    public void turnOff() {
        System.out.println("Stereo is now off");
    }

    @Override
    public void turnOn(Void unused) {
        System.out.println("Stereo is now on");
    }

    @Override
    public void turnOff(Void unused) {
        System.out.println("Stereo is now off");
    }

    public void adjustVolume() {
        System.out.println("Volume adjusted");
    }
}
