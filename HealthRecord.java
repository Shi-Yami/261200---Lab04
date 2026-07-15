public class HealthRecord {
    private int height;
    private static final int MIN_PERMITTED_HEIGHT = 50;
    private static final int MAX_PERMITTED_HEIGHT = 175;
    private static final int DEFAULT_HEIGHT = 100;
    private static int tallestHeight = 50;
    private static int shortestHeight = 175;
    private static int counter = 0;      // count number of objects
    private static double averageHeight; // track average height

    public HealthRecord(int height) {
        this.setHeight(height);
        counter++;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        if (height > 50 && height < 175) {
            this.height = height;
        } else {
            this.height = 100;
        }

        if (this.height > tallestHeight) {
            tallestHeight = this.height;
        }

        if (this.height < shortestHeight) {
            shortestHeight = this.height;
        }

        // Update average using: y' = (y*n + x)/(n+1)
        // y = current average, n = current count (before this object), x = new height value
        averageHeight = (averageHeight * counter + this.height) / (counter + 1);
    }

    public static int getTallestHeight() {
        return tallestHeight;
    }

    public static int getShortestHeight() {
        return shortestHeight;
    }

    public static double getAverageHeight() {
        return averageHeight;
    }

    public void displayDetails() {
        System.out.println("Height (cm): " + this.getHeight());
    }

    public static void displayClassDetails() {
        System.out.println("The tallest height (cm): " + getTallestHeight());
        System.out.println("The shortest height (cm): " + getShortestHeight());
        System.out.printf("The average height (cm): %.2f%n", getAverageHeight());
    }
}
