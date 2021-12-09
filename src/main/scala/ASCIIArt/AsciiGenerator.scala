package ASCIIArt

import ASCIIArt.Image.GreyscaleImage

class AsciiGenerator(palette: String = "@%#*+=-:. ") {
  def Generate(image: GreyscaleImage): String = {
    var asciiart: String = ""
    val paletteCharSize: Double = 255 / (palette.length - 1)
    for (x <- 0 until image.getWidth()) {
      for (y <- 0 until image.getHeight()) {
        val palettePos =
          (image.getPixel(y, x).brightness / paletteCharSize).toInt
        asciiart += palette(palettePos)
      }
      asciiart += "\n"
    }
    asciiart
  }
}
