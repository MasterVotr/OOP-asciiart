package ASCIIArt.AsciiGenerator.ImageAsciiGenerator

import ASCIIArt.AsciiGenerator.AsciiGenerator
import ASCIIArt.Image.Image
import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel

class ImageAsciiGenerator(palette: String = "@%#*+=-:. ") extends AsciiGenerator[Image[GreyscalePixel]] {
  override def generateArt(target: Image[GreyscalePixel]): String = {
    var asciiart: String = ""
    val paletteCharSize: Double = 255 / (palette.length - 1)
    for (x <- 0 until target.getWidth()) {
      for (y <- 0 until target.getHeight()) {
        val palettePos = (target.getPixel(y, x).brightness / paletteCharSize).toInt
        asciiart += palette(palettePos)
      }
      asciiart += "\n"
    }
    asciiart
  }
}
