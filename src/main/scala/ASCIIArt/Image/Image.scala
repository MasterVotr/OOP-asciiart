package ASCIIArt.Image

import ASCIIArt.Filter.ImageFilter.TransformFilter._
import ASCIIArt.Filter.PixelFilter.{PixelFilter, PixelFilterable}
import ASCIIArt.Image.PixelGrid.Pixel.Pixel
import ASCIIArt.Image.PixelGrid.PixelGrid

abstract class Image[P <: Pixel](pixelGrid: PixelGrid[P])
    extends Flipable
    with Rotable
    with Scalable
    with PixelFilterable[P] {

  override def Flip(flipAxis: FlipAxisEnum): Unit = pixelGrid.Flip(flipAxis)

  override def Rotate(rotation: RotationEnum): Unit = pixelGrid.Rotate(rotation)

  override def Scale(scale: ScalingEnum): Unit = pixelGrid.Scale(scale)

  override def ApplyPixelFilter(pixelFilter: PixelFilter[P]): Unit =
    pixelGrid.ApplyPixelFilter(pixelFilter)

  def getWidth(): Int =
    pixelGrid.width

  def getHeight(): Int =
    pixelGrid.height

  def getPixel(x: Int, y: Int): P =
    pixelGrid.getPixel(x, y)
}
