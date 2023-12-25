package edu.project4.TransformationFunctions;

import edu.project4.Point;
import edu.project4.Transformation;

public class SinusoidalTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        return new Point(Math.sin(point.x()), Math.sin(point.y()));
    }

}
