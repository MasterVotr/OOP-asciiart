package ASCIIArt.ImageFilter.TransformFilter.RotateFilter

import ASCIIArt.Image.Image
import ASCIIArt.Image.PixelGrid.Pixel.Pixel
import ASCIIArt.ImageFilter.ImageFilter

/**
 * General abstract class for image rotation filters
 * Rotates images given amount of degrees
 * @param rotation
 * @tparam P
 */
abstract class RotateFilter[P <: Pixel](rotation: RotationEnum)
    extends ImageFilter[P] {

  /**
   * Uses rotation to determine the amount of degrees to rotate
   * @param image
   *  @return
   */
  override def apply(image: Image[P]): Image[P] =
    rotation match {
      case Rot90 => Rotate90deg(image)
      case Rot180 =>
        Rotate90deg(Rotate90deg(image))
      case Rot270 =>
        Rotate90deg(Rotate90deg(Rotate90deg(image)))
      case _ => throw new Exception("Unknown rotation!")
    }

  /**
   * Rotates an image 90 degrees
   * @param image
   * @return
   */
  def Rotate90deg(image: Image[P]): Image[P]
}
