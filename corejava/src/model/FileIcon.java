package model;

public class FileIcon implements Icon {
    private String type;  // Intrinsic state: type of file icon
    private String imageName;  // Intrinsic state: image name specific to the file icon

    public FileIcon(String type, String imageName) {
        this.type = type;
        this.imageName = imageName;
    }

    @Override
    public void draw(int x, int y) {
        // Simulated logic to load and draw image
        System.out.println("Drawing " + type + " icon with image " + imageName + " at position (" + x + ", " + y + ")");
    }
}
