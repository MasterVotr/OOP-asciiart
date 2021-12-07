package ImageImporter.FileImageImporter

import Image.Image
import _root_.Image.PixelGrid.Pixel.GreyscalePixel
import _root_.Image.PixelGrid.PixelGrid
import ImageImporter.ImageImporter

import java.io.File
import javax.imageio.ImageIO
import scala.collection.mutable.ArrayBuffer


class FileImageImporter (path: String) extends ImageImporter {
    override def ImportImage(): Image = {
        val img = ImageIO.read(new File(path))
        if (img == null)
            throw new Exception("File format not supported!")
        val width = img.getWidth()
        val height = img.getHeight()
        var pixelArray = new ArrayBuffer[Array[GreyscalePixel]]()

        val pixelGrid = new PixelGrid(width, height, pixelArray.toArray)
    }
}
