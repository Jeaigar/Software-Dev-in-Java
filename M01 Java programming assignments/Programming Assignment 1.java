public class Conversion {
    /** Convert from feet to meters */
    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }

    /** Convert from meters to feet */
    public static double meterToFoot(double meter) {
        return 3.279 * meter;
    }

    public static void main(String[] args) {
        System.out.println("Feet \t Meters \t|\t Meters \t Feet");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%4d \t %6.3f", i, footToMeter(i));
            System.out.print("\t|\t");
            System.out.printf("%4d \t %7.3f \n", i * 5, meterToFoot(i * 5));
        }
    }
}