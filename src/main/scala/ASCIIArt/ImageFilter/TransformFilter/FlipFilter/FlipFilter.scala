package ASCIIArt.ImageFilter.TransformFilter.FlipFilter

import ASCIIArt.Image.Image
import ASCIIArt.Image.PixelGrid.Pixel.Pixel
import ASCIIArt.ImageFilter.ImageFilter

abstract class FlipFilter[P <: Pixel](axis: FlipAxisEnum)
    extends ImageFilter[P] {
  override def apply(image: Image[P]): Image[P] =
    axis match {
      case FlipX => this.XFlip(image)
      case FlipY => this.YFlip(image)
      case _     => throw new Exception("Unknown flip!")
    }

  def XFlip(image: Image[P]): Image[P]

  def YFlip(image: Image[P]): Image[P]
}
