package edu.project4;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.imageio.ImageIO;

public final class ImageUtils {
    private ImageUtils() {
    }

    public static void save(FractalImage image, String format) {
        BufferedImage bufferedImage = new BufferedImage(image.width(), image.height(), BufferedImage.TYPE_INT_BGR);
        if (!format.equals("jpg") && !format.equals("bmp")) {
            format = "png"; // png is default format
        }

        for (int x = 0; x < image.width(); x++) {
            for (int y = 0; y < image.height(); y++) {
                if (image.pixel(x, y) == null) {
                    image.data()[x][y] = new Pixel(0, 0, 0, 0);
                }
                bufferedImage.setRGB(
                    x,
                    y,
                    new Color(
                        image.pixel(x, y).r(),
                        image.pixel(x, y).g(),
                        image.pixel(x, y).b()
                    ).getRGB()
                );
            }
        }

        try {
            Path path = Path.of("src" + File.separator + "main" + File.separator + "java" + File.separator +
                "edu" + File.separator + "project4" + File.separator + "images" + File.separator + "output.bmp");

            int fileNumber = 1;
            while (Files.exists(path)) {
                path = Path.of("src" + File.separator + "main" + File.separator + "java" + File.separator + "edu" +
                    File.separator + "project4" + File.separator + "images" + File.separator
                    + "output" + fileNumber + "." + format);
                fileNumber++;
            }

            File file = Files.createFile(path).toFile();
            ImageIO.write(bufferedImage, format, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
