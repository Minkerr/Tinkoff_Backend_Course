package edu.project4;

import edu.project4.TransformationFunctions.HeartTransformation;
import edu.project4.TransformationFunctions.LinearTransformation;
import edu.project4.TransformationFunctions.SinusoidalTransformation;
import edu.project4.TransformationFunctions.SphereTransformation;
import java.util.List;

public class Main {
    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) {
        SimpleRender render = new SimpleRender();
        List<Transformation> variations = List.of(new HeartTransformation(), new SinusoidalTransformation(),
            new LinearTransformation(), new SphereTransformation()
        );

        FractalImage fractal = render.render(
            variations,
            1920,
            1080,
            1000000,
            20,
            4,
            1,
            true
        );

        ImageUtils.save(fractal, "png");

    }

    private Main() {

    }
}
