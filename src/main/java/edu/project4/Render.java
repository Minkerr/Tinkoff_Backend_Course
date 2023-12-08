package edu.project4;

import java.util.List;

@FunctionalInterface
public interface Render {
    FractalImage render(
        List<Transformation> variations,
        int wight,
        int height,
        int samples,
        int iterPerSample,
        int numberOfTransformations,
        int symmetry,
        boolean correction
    );
}
