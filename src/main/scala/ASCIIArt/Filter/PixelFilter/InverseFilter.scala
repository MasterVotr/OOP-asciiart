package ASCIIArt.Filter.PixelFilter

import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel

class InverseFilter extends PixelFilter[GreyscalePixel] {
  override def applyFiler(pixel: GreyscalePixel): Unit =
    pixel.brightness = 255 - pixel.brightness
}
