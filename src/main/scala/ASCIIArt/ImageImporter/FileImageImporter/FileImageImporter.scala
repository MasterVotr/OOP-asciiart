package ASCIIArt.ImageImporter.FileImageImporter

import ASCIIArt.Image.PixelGrid.Pixel.RGBPixel
import ASCIIArt.Image.PixelGrid.RGBPixelGrid
import ASCIIArt.Image.RGBImage
import ASCIIArt.ImageImporter.ImageImporter

import java.io.File
import javax.imageio.ImageIO
import scala.collection.mutable.ArrayBuffer

class FileImageImporter(path: String) extends ImageImporter {
  override def ImportImage(): RGBImage = {
    val img = ImageIO.read(new File(path))
    if (img == null)
      throw new Exception("File format not supported!")
    val width = img.getWidth()
    val height = img.getHeight()
    val pixelArray = new ArrayBuffer[Array[RGBPixel]]()
    for (y <- 0 until height) {
      val pixelLine = new ArrayBuffer[RGBPixel]()
      for (x <- 0 until width)
        pixelLine.addOne(new RGBPixel(img.getRGB(x, y)))
      pixelArray.addOne(pixelLine.toArray)
    }
    val pixelGrid = RGBPixelGrid(width, height, pixelArray.toArray)
    new RGBImage(pixelGrid)
  }
}
