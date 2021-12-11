package ASCIIArt.ImageFilter.TransformFilter.RotateFilter

import ASCIIArt.Image.Image
import ASCIIArt.Image.PixelGrid.Pixel.Pixel
import ASCIIArt.Image.PixelGrid.PixelGrid
import ASCIIArt.ImageFilter.ImageFilter

abstract class RotateFilter[P <: Pixel](rotation: RotationEnum) extends ImageFilter[P] {

  override def apply(image: Image[P]): Image[P] = {
    rotation match {
      case Rot90 => Rotate90deg(image)
      case Rot180 =>
        Rotate90deg(image)
        Rotate90deg(image)
      case Rot270 =>
        Rotate90deg(image)
        Rotate90deg(image)
        Rotate90deg(image)
      case _ => throw new Exception("Unknown rotation!")
    }
  }

  def Rotate90deg(image: Image[P]): Image[P]
/*
    val newPixelGrid = Vector[P]()
    for (y <- 0 until image.getHeight()) {
      val newPixelLine = Vector[P]()
      for (x <- 0 until image.getWidth()) {
        val newBrightness = 255 - image.getPixel(x, y).brightness
        newPixelLine.appended(new GreyscalePixel(newBrightness))
      }
      newPixelGrid.appended(newPixelLine)
    }
    new GreyscaleImage(newPixelGrid)
 */
