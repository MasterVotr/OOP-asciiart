package ASCIIArt.ImageFilter.TransformFilter.ScaleFilter

import ASCIIArt.Image.{GreyscaleImage, Image}
import ASCIIArt.Image.PixelGrid.PixelGrid
import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel

class ScaleFilterGreyscale(scale: ScalingEnum) extends ScaleFilter[GreyscalePixel](scale) {
  override def HalfScale(image: Image[GreyscalePixel]): Image[GreyscalePixel] = {
    var newPixelGrid = new PixelGrid[GreyscalePixel]()
    for (y <- 0 until image.getHeight() / 2) {
      var newPixelLine = Vector[GreyscalePixel]()
      for (x <- 0 until image.getWidth() / 2) {
        val pixelsToCombine = List[GreyscalePixel]()
          .appended(image.getPixel((2 * x)    , (2 * y)))
          .appended(image.getPixel((2 * x + 1), (2 * y)))
          .appended(image.getPixel((2 * x)    , (2 * y + 1)))
          .appended(image.getPixel((2 * x + 1), (2 * y + 1)))
        newPixelLine = newPixelLine.appended(new GreyscalePixel(pixelsToCombine))
      }
      newPixelGrid = newPixelGrid.appended(newPixelLine)
    }
    GreyscaleImage(newPixelGrid)
  }

  override def DoubleScale(image: Image[GreyscalePixel]): Image[GreyscalePixel] = {
    var newPixelGrid = new PixelGrid[GreyscalePixel]()
    for (y <- 0 until image.getHeight()) {
      var newPixelLine = Vector[GreyscalePixel]()
      for (x <- 0 until image.getWidth()) {
        newPixelLine = newPixelLine.appended(image.getPixel(x, y))
        newPixelLine = newPixelLine.appended(image.getPixel(x, y))
      }
      newPixelGrid = newPixelGrid.appended(newPixelLine)
      newPixelGrid = newPixelGrid.appended(newPixelLine)
    }
    GreyscaleImage(newPixelGrid)
  }
}
