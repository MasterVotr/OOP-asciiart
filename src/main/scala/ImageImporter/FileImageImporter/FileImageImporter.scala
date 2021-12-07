package ImageImporter.FileImageImporter

import Image.{Image, RGBImage}
import _root_.Image.PixelGrid.Pixel.{GreyscalePixel, RGBPixel}
import _root_.Image.PixelGrid.{PixelGrid, RGBPixelGrid}
import ImageImporter.ImageImporter

import java.io.File
import javax.imageio.ImageIO
import scala.collection.mutable.ArrayBuffer


class FileImageImporter (path: String) extends ImageImporter {
    override def ImportImage(): RGBImage = {
        val img = ImageIO.read(new File(path))
        if (img == null)
            throw new Exception("File format not supported!")
        val width = img.getWidth()
        val height = img.getHeight()
        var pixelArray = new ArrayBuffer[Array[RGBPixel]]()
        for (y <- 0 until height) {
            var pixelLine = new ArrayBuffer[RGBPixel]()
            for (x <- 0 until width) {
                pixelLine.addOne(new RGBPixel(img.getRGB(x, y)))
            }
            pixelArray.addOne(pixelLine.toArray)
        }
        val pixelGrid = new RGBPixelGrid(width, height, pixelArray.toArray)
        new RGBImage(pixelGrid)
    }
}
