package ASCIIArt.ImageFilter.TransformFilter.FlipFilter

import ASCIIArt.Image.{GreyscaleImage, Image}
import ASCIIArt.Image.PixelGrid.GreyscalePixelGrid
import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel

class GreyscaleFlipFilter(axis: FlipAxisEnum) extends FlipFilter[GreyscalePixel](axis) {
  override def XFlip(image: Image[GreyscalePixel]): Image[GreyscalePixel] = {
    val newPixelGrid = new GreyscalePixelGrid()
    for (y <- 0 until image.getHeight()) {
      val newPixelLine = Vector[GreyscalePixel]()
      for (x <- 0 until image.getWidth()) {
        newPixelLine.appended(image.getPixel(x, image.getHeight() - y - 1))
      }
      newPixelGrid.appended(newPixelLine)
    }
    new GreyscaleImage(newPixelGrid)
  }

  override def YFlip(image: Image[GreyscalePixel]): Image[GreyscalePixel] = {
    val newPixelGrid = new GreyscalePixelGrid()
    for (y <- 0 until image.getHeight()) {
      val newPixelLine = Vector[GreyscalePixel]()
      for (x <- 0 until image.getWidth()) {
        newPixelLine.appended(image.getPixel(image.getWidth() - x - 1, y))
      }
      newPixelGrid.appended(newPixelLine)
    }
    new GreyscaleImage(newPixelGrid)
  }
}
