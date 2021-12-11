package ASCIIArt.ImageFilter.PixelFilterer.PixelFilter

import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel

class InversePixelFilter extends PixelFilter[GreyscalePixel] {
  override def apply(pixel: GreyscalePixel): GreyscalePixel = {
      val newBrightness = 255 - pixel.brightness
      GreyscalePixel(newBrightness)
  }
}
