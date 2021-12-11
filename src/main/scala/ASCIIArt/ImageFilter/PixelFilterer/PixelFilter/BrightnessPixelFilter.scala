package ASCIIArt.ImageFilter.PixelFilterer.PixelFilter

import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel

class BrightnessPixelFilter(val amount: Int) extends PixelFilter[GreyscalePixel] {
  override def apply(pixel: GreyscalePixel): GreyscalePixel = {
    val newBrightness = pixel.brightness + amount
    GreyscalePixel(newBrightness).clamp()
  }
}
