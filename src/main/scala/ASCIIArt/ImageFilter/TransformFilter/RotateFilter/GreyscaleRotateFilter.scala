package ASCIIArt.ImageFilter.TransformFilter.RotateFilter

import ASCIIArt.Image.PixelGrid.GreyscalePixelGrid
import ASCIIArt.Image.{GreyscaleImage, Image}
import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel

class GreyscaleRotateFilter(deg: RotationEnum) extends RotateFilter[GreyscalePixel](deg) {
  override def Rotate90deg(image: Image[GreyscalePixel]): Image[GreyscalePixel] = {
    val newPixelGrid = new GreyscalePixelGrid()
    for (x <- 0 until image.getWidth()) {
      val newPixelLine = Vector[GreyscalePixel]()
      for (y <- 0 until image.getHeight()) {
        newPixelLine.appended(image.getPixel(x, image.getHeight() - y - 1))
      }
      newPixelGrid.appended(newPixelLine)
    }
    new GreyscaleImage(newPixelGrid)
  }
}
