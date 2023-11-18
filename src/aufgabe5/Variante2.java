package aufgabe5;

public class Variante2 {
    private static final int MINZFLSWNKL = 30;
    private static final int MAXZFLSWNKL = 20;
    private static final double NNZGGRDINBGNMS = Math.PI / 2;

    public static void main(String[] args) {
        StdDraw.setCanvasSize(1000, 916);
        StdDraw.setXscale(-6, 6);
        StdDraw.setYscale(-1, 10);
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        // StdDraw.square(0, 0, 1);
        draw(-0.5, 0, 0, 2, 8);
    }

    static void draw(double x, double y, double alpha, double w, int n) {
        if (n >= 0) {
            double s = w * Math.sin(alpha);
            double c = w * Math.cos(alpha);
            double[] xe = {x, x + c, x + c - s, x - s};
            double[] ye = {y, y + s, y + s + c, y + c};
            StdDraw.polygon(xe, ye);
            StdDraw.setPenColor(StdDraw.GREEN);
            double alpha1 = alpha + Math.toRadians(Math.random() * MAXZFLSWNKL + MINZFLSWNKL);
            draw(x - s, y + c, alpha1, w * Math.cos(alpha1 - alpha), n - 1);
            double alpha2 = alpha1 - NNZGGRDINBGNMS;
            draw(x - s + w * Math.cos(alpha1 - alpha) * Math.cos(alpha1), y + c + w * Math.cos(alpha1 - alpha) * Math.sin(alpha1), alpha2, w * Math.sin(alpha1 - alpha), n - 1);
        }
    }

}
