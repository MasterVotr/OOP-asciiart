package ASCIIArt.ImageFilter.TransformFilter.ScaleFilter

import ASCIIArt.Image.Image
import ASCIIArt.Image.PixelGrid.Pixel.Pixel
import ASCIIArt.ImageFilter.ImageFilter

abstract class ScaleFilter[P <: Pixel](scale: ScalingEnum)
    extends ImageFilter[P] {
  override def apply(image: Image[P]): Image[P] =
    scale match {
      case ScaleHalf   => this.HalfScale(image)
      case ScaleDouble => this.DoubleScale(image)
      case ScaleFull   => image
      case _           => throw new Exception("Unknown scale!")
    }

  def HalfScale(image: Image[P]): Image[P]

  def DoubleScale(image: Image[P]): Image[P]
}
