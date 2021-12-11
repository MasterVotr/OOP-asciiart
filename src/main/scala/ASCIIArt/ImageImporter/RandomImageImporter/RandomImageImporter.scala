package ASCIIArt.ImageImporter.RandomImageImporter

import ASCIIArt.Image.PixelGrid.Pixel.RGBPixel
import ASCIIArt.Image.PixelGrid.RGBPixelGrid
import ASCIIArt.Image.RGBImage
import ASCIIArt.ImageImporter.ImageImporter

import scala.util.Random

class RandomImageImporter extends ImageImporter{
  override def ImportImage(): RGBImage = {
    val rng = new Random()
    val height = rng.nextInt(400) + 200
    val width = rng.nextInt(400) + 400
    val pixelGrid = new RGBPixelGrid()
    for (y <- 0 until height) {
      val pixelLine = Vector[RGBPixel]()
      for (x <- 0 until width) {
        val pixel = RGBPixel(rng.nextInt(255), rng.nextInt(255), rng.nextInt(255))
        pixelLine.appended(pixel)
      }
      pixelGrid.appended(pixelLine)
    }
    RGBImage(pixelGrid)
  }
}
