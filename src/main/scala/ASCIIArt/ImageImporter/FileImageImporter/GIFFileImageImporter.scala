package ASCIIArt.ImageImporter.FileImageImporter

import ASCIIArt.Image.PixelGrid.Pixel.RGBPixel
import ASCIIArt.Image.PixelGrid.PixelGrid
import ASCIIArt.Image.RGBImage

import java.io.File
import javax.imageio.ImageIO

class GIFFileImageImporter(path: String) extends FileImageImporter(path) {
  override def ImportImage(): RGBImage = {
    val img = ImageIO.read(new File(path))
    if (img == null)
      throw new Exception("File not loaded properly!")
    val width = img.getWidth()
    val height = img.getHeight()

    // Check resolution
    if (width < 1 || height< 1)
      throw new Exception("Resolution cannot be <= 0!")

    var pixelGrid = new PixelGrid[RGBPixel]()
    for (y <- 0 until height) {
      var pixelLine = Vector[RGBPixel]()
      for (x <- 0 until width)
        pixelLine = pixelLine.appended(new RGBPixel(img.getRGB(x, y)))
      // Check line length
      if (pixelLine.length != width)
        throw new Exception("Pixels, wrong width!")
      pixelGrid = pixelGrid.appended(pixelLine)
    }
    RGBImage(pixelGrid)
  }
}
