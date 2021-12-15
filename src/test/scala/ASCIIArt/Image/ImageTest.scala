package ASCIIArt.Image

import ASCIIArt.Image.PixelGrid.Pixel.{GreyscalePixel, RGBPixel}
import ASCIIArt.Image.PixelGrid.PixelGrid
import org.scalatest.FunSuite

class ImageTest extends FunSuite {
  test("Correctly constructs from PixelGrid") {
    val grid = new PixelGrid[GreyscalePixel]
    val img = new GreyscaleImage(grid)

    val gridRGB = new PixelGrid[RGBPixel]()
    val imgRGB = new RGBImage(gridRGB)

    assert(img.getWidth() == 0)
    assert(img.getHeight() == 0)
    assert(imgRGB.getWidth() == 0)
    assert(imgRGB.getHeight() == 0)
  }

  test("Correctly return a pixel") {
    val pix = GreyscalePixel(0)
    val grid = new PixelGrid[GreyscalePixel](
      Vector[Vector[GreyscalePixel]](
        Vector[GreyscalePixel](pix)
      ))
    val img = GreyscaleImage(grid)

    assert(img.getPixel(0, 0) == pix)
  }
}
