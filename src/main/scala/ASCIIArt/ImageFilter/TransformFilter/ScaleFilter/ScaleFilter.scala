package ASCIIArt.ImageFilter.TransformFilter.ScaleFilter

import ASCIIArt.Image.Image
import ASCIIArt.Image.PixelGrid.Pixel.Pixel
import ASCIIArt.ImageFilter.ImageFilter

/**
 * General abstract class for image scaling
 * Scales images using the given scale factor
 * @param scale
 * @tparam P
 */
abstract class ScaleFilter[P <: Pixel](scale: ScalingEnum)
    extends ImageFilter[P] {

  /**
   * Uses scale to determine how to scale the image
   * @param image
   *  @return
   */
  override def apply(image: Image[P]): Image[P] =
    scale match {
      case ScaleHalf   => this.HalfScale(image)
      case ScaleDouble => this.DoubleScale(image)
      case ScaleFull   => image
      case _           => throw new Exception("Unknown scale!")
    }

  /**
   * Scales the image to half of its resolution (quarter of its original mass)
   * @param image
   * @return
   */
  def HalfScale(image: Image[P]): Image[P]

  /**
   * Scales the image to double of its resolution (four time of its original mass)
   * @param image
   * @return
   */
  def DoubleScale(image: Image[P]): Image[P]
}
