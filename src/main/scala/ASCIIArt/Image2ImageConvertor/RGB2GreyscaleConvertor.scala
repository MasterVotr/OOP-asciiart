package ASCIIArt.Image2ImageConvertor

import ASCIIArt.Image.PixelGrid.GreyscalePixelGrid
import ASCIIArt.Image.PixelGrid.Pixel.{GreyscalePixel, RGBPixel}
import ASCIIArt.Image.{GreyscaleImage, Image}

class RGB2GreyscaleConvertor(
  val redScale: Double = 0.3,
  val greenScale: Double = 0.59,
  val blueScale: Double = 0.11) extends Image2ImageConvertor[RGBPixel, GreyscalePixel] {


  override def Convert(image: Image[RGBPixel]): Image[GreyscalePixel] = {
    val newPixelGrid = new GreyscalePixelGrid()
    for (y <- 0 until image.getHeight()) {
      val newPixelLine = Vector[RGBPixel]()
      for (x <- 0 until image.getWidth()) {
        newPixelLine.appended(ConvertPixel(image.getPixel(x, y)))
      }
      newPixelGrid.appended(newPixelLine)
    }
    GreyscaleImage(newPixelGrid)
  }

  def ConvertPixel(pixel: RGBPixel): GreyscalePixel = {
    val red = pixel.red * redScale
    val green = pixel.green * greenScale
    val blue = pixel.blue * blueScale

    GreyscalePixel((red + green + blue).toInt).clamp()
  }
}
