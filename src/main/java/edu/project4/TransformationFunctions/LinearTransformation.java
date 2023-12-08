package edu.project4.TransformationFunctions;

import edu.project4.Point;
import edu.project4.Transformation;
public class LinearTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        return point;
    }
}
