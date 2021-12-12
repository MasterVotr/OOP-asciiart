package ASCIIArt.ImageFilter.PixelFilterer

import ASCIIArt.Image.{GreyscaleImage, Image}
import ASCIIArt.Image.PixelGrid.PixelGrid
import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import ASCIIArt.ImageFilter.PixelFilterer.PixelFilter.PixelFilter

class GreyscalePixelFilterer(pixelFilter: PixelFilter[GreyscalePixel]) extends PixelFilterer[GreyscalePixel](pixelFilter) {
  override def apply(image: Image[GreyscalePixel]): Image[GreyscalePixel] = {
    var newPixelGrid = new PixelGrid[GreyscalePixel]()
    for (y <- 0 until image.getHeight()) {
      var newPixelLine = Vector[GreyscalePixel]()
      for (x <- 0 until image.getWidth()) {
        newPixelLine = newPixelLine.appended(pixelFilter.apply(image.getPixel(x, y)))
      }
      newPixelGrid = newPixelGrid.appended(newPixelLine)
    }
    GreyscaleImage(newPixelGrid)
  }
}