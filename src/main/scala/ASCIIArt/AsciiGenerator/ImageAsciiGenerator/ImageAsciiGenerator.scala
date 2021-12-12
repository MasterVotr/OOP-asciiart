package ASCIIArt.AsciiGenerator.ImageAsciiGenerator

import ASCIIArt.AsciiGenerator.AsciiGenerator
import ASCIIArt.Image.Image
import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel

class ImageAsciiGenerator(palette: String = "@%#*+=-:. ") extends AsciiGenerator[Image[GreyscalePixel]] {
  override def generateArt(target: Image[GreyscalePixel]): String = {
    var asciiArt: String = ""
    val CharSizeOnPalette: Double = 255.00 / (palette.length - 1)
    for (y <- 0 until target.getHeight()) {
      for (x <- 0 until target.getWidth()) {
        val palettePos: Int = (target.getPixel(x, y).brightness / CharSizeOnPalette).toInt
        asciiArt += palette(palettePos)
      }
      asciiArt += "\n"
    }
    asciiArt
  }
}
