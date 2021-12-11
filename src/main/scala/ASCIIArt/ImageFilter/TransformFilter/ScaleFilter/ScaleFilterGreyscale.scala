package ASCIIArt.ImageFilter.TransformFilter.ScaleFilter

import ASCIIArt.Image.{GreyscaleImage, Image}
import ASCIIArt.Image.PixelGrid.GreyscalePixelGrid
import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel

class ScaleFilterGreyscale(scale: ScalingEnum) extends ScaleFilter[GreyscalePixel](scale) {
  override def HalfScale(image: Image[GreyscalePixel]): Image[GreyscalePixel] = {
    val newPixelGrid = new GreyscalePixelGrid()
    for (y <- 0 until image.getHeight() / 2) {
      val newPixelLine = Vector[GreyscalePixel]()
      for (x <- 0 until image.getWidth() / 2) {
        val pixelsToCombine = List[GreyscalePixel]()
          .appended(image.getPixel((2 * x)    , (2 * y)))
          .appended(image.getPixel((2 * x + 1), (2 * y)))
          .appended(image.getPixel((2 * x)    , (2 * y + 1)))
          .appended(image.getPixel((2 * x + 1), (2 * y + 1)))
        newPixelLine.appended(newPixelGrid.CombinePixels(pixelsToCombine))
      }
      newPixelGrid.appended(newPixelLine)
    }
    GreyscaleImage(newPixelGrid)
  }

  override def DoubleScale(image: Image[GreyscalePixel]): Image[GreyscalePixel] = {
    val newPixelGrid = new GreyscalePixelGrid()
    for (y <- 0 until image.getHeight()) {
      val newPixelLine = Vector[GreyscalePixel]()
      for (x <- 0 until image.getWidth()) {
        newPixelLine.appended(image.getPixel(x, y))
        newPixelLine.appended(image.getPixel(x, y))
      }
      newPixelGrid.appended(newPixelLine)
      newPixelGrid.appended(newPixelLine)
    }
    GreyscaleImage(newPixelGrid)
  }
}
