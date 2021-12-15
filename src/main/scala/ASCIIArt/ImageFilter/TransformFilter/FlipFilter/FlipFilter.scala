package ASCIIArt.ImageFilter.TransformFilter.FlipFilter

import ASCIIArt.Image.Image
import ASCIIArt.Image.PixelGrid.Pixel.Pixel
import ASCIIArt.ImageFilter.ImageFilter

/**
 * General abstract class for image flipping filters
 * Flips images on the given axis
 * @param axis
 * @tparam P
 */
abstract class FlipFilter[P <: Pixel](axis: FlipAxisEnum)
    extends ImageFilter[P] {

  /**
   * Uses the axis to determine on which axis to flip
   * @param image
   *  @return
   */
  override def apply(image: Image[P]): Image[P] =
    axis match {
      case FlipX => this.XFlip(image)
      case FlipY => this.YFlip(image)
      case _     => throw new Exception("Unknown flip!")
    }

  /**
   * Flips given image on the X axis
   * @param image
   * @return
   */
  def XFlip(image: Image[P]): Image[P]

  /**
   * Flips given image on the Y axis
   * @param image
   * @return
   */
  def YFlip(image: Image[P]): Image[P]
}
