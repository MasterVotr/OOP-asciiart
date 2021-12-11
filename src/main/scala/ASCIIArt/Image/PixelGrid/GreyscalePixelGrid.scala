package ASCIIArt.Image.PixelGrid

import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel

class GreyscalePixelGrid extends PixelGrid[GreyscalePixel] {

  override def CombinePixels(pixels: List[GreyscalePixel]): GreyscalePixel = {
    var sumBrightness = 0
    for (pixel <- pixels)
      sumBrightness += pixel.brightness
    new GreyscalePixel(sumBrightness / pixels.length)
  }
}
