package ASCIIArt.ImageFilter.PixelFilterer

import ASCIIArt.Image.{GreyscaleImage, Image}
import ASCIIArt.Image.PixelGrid.GreyscalePixelGrid
import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import ASCIIArt.ImageFilter.PixelFilterer.PixelFilter.PixelFilter

class GreyscalePixelFilterer(pixelFilter: PixelFilter[GreyscalePixel]) extends PixelFilterer[GreyscalePixel](pixelFilter) {
  override def apply(image: Image[GreyscalePixel]): Image[GreyscalePixel] = {
    val newPixelGrid = new GreyscalePixelGrid()
    for (y <- 0 until image.getHeight()) {
      val newPixelLine = Vector[GreyscalePixel]()
      for (x <- 0 until image.getWidth()) {
        newPixelLine.appended(pixelFilter.apply(image.getPixel(x, y)))
      }
      newPixelGrid.appended(newPixelLine)
    }
    GreyscaleImage(newPixelGrid)
  }
}
