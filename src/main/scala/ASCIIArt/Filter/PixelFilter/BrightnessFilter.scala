package ASCIIArt.Filter.PixelFilter

import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel

class BrightnessFilter(val amount: Int) extends PixelFilter[GreyscalePixel] {
  override def applyFiler(pixel: GreyscalePixel): Unit = {
    pixel.brightness += amount
    pixel.clamp()
  }
}
