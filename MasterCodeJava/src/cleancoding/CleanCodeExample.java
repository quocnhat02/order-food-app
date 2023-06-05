package cleancoding;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class CleanCodeExample {

    private static final double DISTANCE_THRESHOLD = 3.0;

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, -2));
        points.add(new Point(-1, 3));
        points.add(new Point(2, 0));
        points.add(new Point(1, 1));
        int cntOfPointsCloserThanThreshold = 0;
        for (int i = 0; i < points.size(); i++) {
            int x = points.get(i).x, y = points.get(i).y;
            double distanceFromOrigin = Math.sqrt(x*x + y*y);
            if (distanceFromOrigin < DISTANCE_THRESHOLD) {
                cntOfPointsCloserThanThreshold++;
            }
        }
        System.out.println(cntOfPointsCloserThanThreshold);
    }

    public static class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
