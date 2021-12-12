package ASCIIArt.ImageFilter.TransformFilter.RotateFilter

import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import ASCIIArt.Image.PixelGrid.PixelGrid
import ASCIIArt.Image.{GreyscaleImage, Image}

class GreyscaleRotateFilter(deg: RotationEnum)
    extends RotateFilter[GreyscalePixel](deg) {
  override def Rotate90deg(
    image: Image[GreyscalePixel]): Image[GreyscalePixel] = {
    var newPixelGrid = new PixelGrid[GreyscalePixel]()
    for (x <- 0 until image.getWidth()) {
      var newPixelLine = Vector[GreyscalePixel]()
      for (y <- 0 until image.getHeight())
        newPixelLine =
          newPixelLine.appended(image.getPixel(x, image.getHeight() - y - 1))
      newPixelGrid = newPixelGrid.appended(newPixelLine)
    }
    GreyscaleImage(newPixelGrid)
  }
}
