package ASCIIArt.Image.PixelGrid

import ASCIIArt.Image.PixelGrid.Pixel.RGBPixel

class RGBPixelGrid extends PixelGrid[RGBPixel] {

  override def CombinePixels(pixels: List[RGBPixel]): RGBPixel = {
    var sumRed = 0
    var sumGreen = 0
    var sumBlue = 0
    for (pixel <- pixels) {
      sumRed += pixel.red
      sumGreen += pixel.green
      sumBlue += pixel.blue
    }
    val pixelsLength = pixels.length

    new RGBPixel(
      sumRed / pixelsLength,
      sumGreen / pixelsLength,
      sumBlue / pixelsLength)
  }
}
