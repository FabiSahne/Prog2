package aufgabe5;

public class Variante1 {

    public static void main(String[] args) {
        StdDraw.setXscale(-5, 5);
        StdDraw.setYscale(-1, 9);
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        // StdDraw.square(0, 0, 1);
        draw(0, 0, 0, 2, 4);
    }

    static void draw(double x, double y, double alpha, double w, int n) {
        if (n >= 0) {
            double s = w * Math.sin(alpha);
            double c = w * Math.cos(alpha);
            double[] xe = {x, x + c, x + c - s, x - s};
            double[] ye = {y, y + s, y + s + c, y + c};
            StdDraw.polygon(xe, ye);
            StdDraw.setPenColor(StdDraw.GREEN);
            double alpha1 = alpha + Math.toRadians(30);
            draw(x - s, y + c, alpha1, w * Math.sqrt(3) / 2, n - 1);
            double alpha2 = alpha1 - Math.PI / 2;
            draw(x - s + w * Math.sqrt(3) / 2 * Math.cos(alpha1), y + c + w * Math.sqrt(3) / 2 * Math.sin(alpha1), alpha2, w / 2, n - 1);

        }
    }

}
