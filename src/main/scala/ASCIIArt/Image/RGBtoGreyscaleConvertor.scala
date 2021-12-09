package ASCIIArt.Image

import ASCIIArt.Image.PixelGrid.GreyscalePixelGrid
import ASCIIArt.Image.PixelGrid.Pixel.{GreyscalePixel, RGBPixel}

import scala.collection.mutable.ArrayBuffer

class RGBtoGreyscaleConvertor(
  redScale: Double = 0.3,
  greenScale: Double = 0.59,
  blueScale: Double = 0.11) {
  def ConvertImage(rgbImage: RGBImage): GreyscaleImage = {
    val greyscalePixels = ArrayBuffer[Array[GreyscalePixel]]()
    val width = rgbImage.getWidth()
    val height = rgbImage.getHeight()

    for (x <- 0 until width) {
      val pixelLine = ArrayBuffer[GreyscalePixel]()
      for (y <- 0 until height)
        pixelLine.addOne(ConvertPixel(rgbImage.getPixel(x, y)))
      greyscalePixels.addOne(pixelLine.toArray)
    }

    new GreyscaleImage(
      new GreyscalePixelGrid(height, width, greyscalePixels.toArray))
  }

  def ConvertPixel(rgbPixel: RGBPixel): GreyscalePixel = {
    val red = rgbPixel.red * redScale
    val green = rgbPixel.green * greenScale
    val blue = rgbPixel.blue * blueScale

    val greyscalePixel = new GreyscalePixel((red + green + blue).toInt)
    greyscalePixel.clamp()
    greyscalePixel
  }
}
