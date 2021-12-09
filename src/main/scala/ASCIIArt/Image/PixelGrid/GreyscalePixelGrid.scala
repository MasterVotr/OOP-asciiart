package ASCIIArt.Image.PixelGrid

import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel

class GreyscalePixelGrid(
  _width: Int,
  _height: Int,
  _pixels: Array[Array[GreyscalePixel]])
    extends PixelGrid[GreyscalePixel](_width, _height, _pixels) {

  override def CombinePixels(pixels: List[GreyscalePixel]): GreyscalePixel = {
    var sumBrightness = 0
    for (pixel <- pixels)
      sumBrightness += pixel.brightness
    new GreyscalePixel(sumBrightness / pixels.length)
  }
}
