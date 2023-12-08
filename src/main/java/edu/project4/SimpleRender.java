package edu.project4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimpleRender implements Render {
    private final double XMIN = -1.777;
    private final double XMAX = 1.777;
    private final double YMIN = -1;
    private final double YMAX = 1;

    private int random(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    private double random(double min, double max) {
        Random random = new Random();
        return random.nextDouble(max - min) + min;
    }

    private List<TransformationCoefficientSet> generateTransformations(int numberOfTransformations) {
        List<TransformationCoefficientSet> coeff = new ArrayList<>();
        for (int i = 0; i < numberOfTransformations; i++) {
            coeff.add(new TransformationCoefficientSet());
        }
        return coeff;
    }

    public static Point rotate(Point p, double angle) {
        double x = p.x();
        double y = p.y();
        double cosAngle = Math.cos(angle);
        double sinAngle = Math.sin(angle);
        double newX = x * cosAngle - y * sinAngle;
        double newY = x * sinAngle + y * cosAngle;
        return new Point(newX, newY);
    }

    @Override
    public FractalImage render(
        List<Transformation> variations,
        int width,
        int height,
        int samples,
        int iterPerSample,
        int numberOfTransformations,
        int symmetry,
        boolean correction
    ) {
        Pixel[][] data = new Pixel[width][height];
        List<TransformationCoefficientSet> coeff = generateTransformations(numberOfTransformations);

        for (int num = 0; num < samples; ++num) {
            Point pw = new Point(random(XMIN, XMAX), random(YMIN, YMAX));

            for (int step = 0; step < iterPerSample; ++step) {
                int i = random(0, numberOfTransformations);

                double x = coeff.get(i).a() * pw.x() + coeff.get(i).b() * pw.y() + coeff.get(i).c();
                double y = coeff.get(i).d() * pw.x() + coeff.get(i).e() * pw.y() + coeff.get(i).f();

                double theta2 = 0.0;
                Transformation variation = variations.get(random(0, variations.size()));
                pw = variation.apply(new Point(x, y));

                for (int s = 0; s < symmetry; theta2 += Math.PI * 2 / symmetry, ++s) {
                    if (symmetry > 1) {
                        var pwr = rotate(pw, theta2);
                        x = pwr.x();
                        y = pwr.y();
                    }

                    if (XMIN < x && x < XMAX && YMIN < y && y < YMAX) {
                        //Вычисляем координаты точки, а затем задаем цвет

                        int x1 = width - (int) (((XMAX - x) / (XMAX - XMIN)) * width);
                        int y1 = height - (int) (((YMAX - y) / (YMAX - YMIN)) * height);

                        //Если точка попала в область изображения
                        if (y1 < height && x1 < width) {
                            //то проверяем, первый ли раз попали в нее
                            if (data[x1][y1] == null) {
                                //Попали в первый раз, берем стартовый цвет у соответствующего аффинного преобразования
                                int red = coeff.get(i).red();
                                int green = coeff.get(i).green();
                                int blue = coeff.get(i).blue();
                                data[x1][y1] = new Pixel(red, green, blue, 1);
                            } else {
                                //Попали не в первый раз, считаем так:
                                int red = (data[x1][y1].r() + coeff.get(i).red()) / 2;
                                int green = (data[x1][y1].g() + coeff.get(i).green()) / 2;
                                int blue = (data[x1][y1].b() + coeff.get(i).blue()) / 2;
                                int hits = data[x1][y1].hitCount();
                                data[x1][y1] = new Pixel(red, green, blue, hits + 1);
                            }
                        }
                    }
                }
            }
        }
        FractalImage fractal = new FractalImage(data, width, height);
        if(correction){
            GammaCorrection gammaCorrection = new GammaCorrection();
            gammaCorrection.process(fractal);
        }

        return fractal;
    }
}
