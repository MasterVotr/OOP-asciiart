package Image

import Filter.ImageFilter.TransformFilter.{FlipAxisEnum, Flipable, Rotable, RotationEnum, Scalable, ScalingEnum}
import Image.PixelGrid.Pixel.Pixel
import Image.PixelGrid.PixelGrid

abstract class Image[P <: Pixel] (pixelGrid: PixelGrid[P]) extends Flipable with Rotable with Scalable {
    override def Flip(flipAxis: FlipAxisEnum): Unit = pixelGrid.Flip(flipAxis)

    override def Rotate(rotation: RotationEnum): Unit = pixelGrid.Rotate(rotation)

    override def Scale(scale: ScalingEnum): Unit = pixelGrid.Scale(scale)
}
