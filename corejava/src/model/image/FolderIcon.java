package model.image;

public class FolderIcon implements Icon {
    private String color;  // Intrinsic state: color of the folder icon
    private String imageName;  // Intrinsic state: image name specific to the folder icon

    public FolderIcon(String color, String imageName) {
        this.color = color;
        this.imageName = imageName;
    }

    @Override
    public void draw(int x, int y) {
        // Simulated logic to load and draw image
        System.out.println("Drawing folder icon with color " + color + " and image " + imageName + " at position (" + x + ", " + y + ")");
    }
}
