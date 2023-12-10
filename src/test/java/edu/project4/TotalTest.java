package edu.project4;

import edu.project4.TransformationFunctions.HeartTransformation;
import edu.project4.TransformationFunctions.LinearTransformation;
import edu.project4.TransformationFunctions.SinusoidalTransformation;
import edu.project4.TransformationFunctions.SphereTransformation;
import org.junit.jupiter.api.Test;
import java.util.List;

public class TotalTest {
    @Test
    void thisProject_shouldGenerateFractalFlame() {
        SimpleRender render = new SimpleRender();
        List<Transformation> variations = List.of(new HeartTransformation(), new SinusoidalTransformation(),
            new LinearTransformation(), new SphereTransformation()
        );

        FractalImage fractal = render.render(
            variations,
            1920,
            1080,
            300000,
            500,
            10,
            1,
            true
        );

        ImageUtils.save(fractal, "png");
    }

    @Test
    void thisProject_shouldGenerateFractalFlameWithConcurrency() {
        ConcurrentRender render = new ConcurrentRender();
        List<Transformation> variations = List.of(new HeartTransformation(), new SinusoidalTransformation(),
            new LinearTransformation(), new SphereTransformation()
        );

        FractalImage fractal = render.render(
            variations,
            1920,
            1080,
            300000,
            500,
            10,
            1,
            true
        );

        ImageUtils.save(fractal, "png");
    }
}