package ASCIIArt.ImageFilter.PixelFilterer.PixelFilter

import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel

/**
 * Specialized pixel filter for increasing brightness by given amount
 * @param amount
 */
class BrightnessPixelFilter(val amount: Int)
    extends PixelFilter[GreyscalePixel] {
  override def apply(pixel: GreyscalePixel): GreyscalePixel =
    GreyscalePixel(pixel.brightness + (amount % 256)).clamp()
}
