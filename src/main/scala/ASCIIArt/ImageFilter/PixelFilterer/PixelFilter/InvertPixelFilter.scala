package ASCIIArt.ImageFilter.PixelFilterer.PixelFilter

import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel

/**
 * Specialized pixel filter for inverting the given pixels brightness
 */
class InvertPixelFilter extends PixelFilter[GreyscalePixel] {
  override def apply(pixel: GreyscalePixel): GreyscalePixel = {
    val newBrightness = 255 - pixel.brightness
    GreyscalePixel(newBrightness)
  }
}
