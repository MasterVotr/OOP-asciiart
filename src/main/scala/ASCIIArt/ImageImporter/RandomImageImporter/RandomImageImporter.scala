package ASCIIArt.ImageImporter.RandomImageImporter

import ASCIIArt.Image.PixelGrid.Pixel.RGBPixel
import ASCIIArt.Image.PixelGrid.PixelGrid
import ASCIIArt.Image.RGBImage
import ASCIIArt.ImageImporter.ImageImporter

import scala.util.Random

class RandomImageImporter extends ImageImporter {
  override def ImportImage(): RGBImage = {
    val rng = new Random()
    val height = rng.nextInt(400) + 200
    val width = rng.nextInt(400) + 400
    var pixelGrid = new PixelGrid[RGBPixel]()
    for (y <- 0 until height) {
      var pixelLine = Vector[RGBPixel]()
      for (x <- 0 until width) {
        val pixel =
          RGBPixel(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256))
        pixelLine = pixelLine.appended(pixel)
      }
      pixelGrid = pixelGrid.appended(pixelLine)
    }
    RGBImage(pixelGrid)
  }
}
