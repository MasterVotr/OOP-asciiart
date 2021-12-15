package ASCIIArt.ImageFilter

import ASCIIArt.Image.Image
import ASCIIArt.Image.PixelGrid.Pixel.Pixel

/**
 * Basic trait for image filters
 * Takes in a P pixel type
 * @tparam P
 */
trait ImageFilter[P <: Pixel] {

  /**
   * Applies the filter to a given Image[P] and return the filtered Image[P]
   * @param image
   * @return
   */
  def apply(image: Image[P]): Image[P]
}
