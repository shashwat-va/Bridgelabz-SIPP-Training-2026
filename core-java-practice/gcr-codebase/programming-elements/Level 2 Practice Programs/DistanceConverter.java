import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double distanceFeet = scanner.nextDouble();
        double distanceYards = distanceFeet / 3;
        double distanceMiles = distanceYards / 1760;

        System.out.println("The distance in yards is "
                + distanceYards + " while the distance in miles is " + distanceMiles);

        scanner.close();
    }
}
