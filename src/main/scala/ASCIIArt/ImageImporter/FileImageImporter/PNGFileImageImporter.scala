package ASCIIArt.ImageImporter.FileImageImporter

import ASCIIArt.Image.PixelGrid.Pixel.RGBPixel
import ASCIIArt.Image.PixelGrid.RGBPixelGrid
import ASCIIArt.Image.RGBImage

import java.io.File
import javax.imageio.ImageIO

class PNGFileImageImporter(path: String) extends FileImageImporter(path) {
  override def ImportImage(): RGBImage = {
    val img = ImageIO.read(new File(path))
    if (img == null)
      throw new Exception("File format not supported!")
    val width = img.getWidth()
    val height = img.getHeight()
    val pixelGrid = new RGBPixelGrid()
    for (y <- 0 until height) {
      val pixelLine = Vector[RGBPixel]()
      for (x <- 0 until width)
        pixelLine.appended(new RGBPixel(img.getRGB(x, y)))
      pixelGrid.appended(pixelLine.toArray)
    }
    RGBImage(pixelGrid)
  }
}
