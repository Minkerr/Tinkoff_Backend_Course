package edu.project4.TransformationFunctions;

import edu.project4.Point;
import edu.project4.Transformation;

public class SphereTransformation implements Transformation {

    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        return new Point(
            x / (x*x + y*y),
            y / (x*x + y*y)
        );
    }
}
