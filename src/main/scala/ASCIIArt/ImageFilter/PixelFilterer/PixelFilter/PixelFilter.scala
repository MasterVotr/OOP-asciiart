package ASCIIArt.ImageFilter.PixelFilterer.PixelFilter

import ASCIIArt.Image.PixelGrid.Pixel.Pixel

/**
 * A basic trait for pixel filters of type P
 * @tparam P
 */
trait PixelFilter[P <: Pixel] {

  /**
   * Applies the pixel filter to the given pixel of type P and return the result
   * @param pixel
   * @return
   */
  def apply(pixel: P): P
}
