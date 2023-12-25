package edu.project4.TransformationFunctions;

import edu.project4.Point;
import edu.project4.Transformation;

public class HeartTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        return new Point(
            Math.sqrt(x * x + y * y) * Math.sin(Math.sqrt(x * x + y * y) * Math.atan(y / x)),
            -Math.sqrt(x * x + y * y) * Math.cos(Math.sqrt(x * x + y * y) * Math.atan(y / x))
        );
    }
}
