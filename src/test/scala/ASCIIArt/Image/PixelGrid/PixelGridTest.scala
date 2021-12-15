package ASCIIArt.Image.PixelGrid

import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import org.scalatest.FunSuite

class PixelGridTest extends FunSuite {
  test("Correctly constructs from an existing IndexedSeq[IndexedSeq[Pixel]]") {
    val pix1 = GreyscalePixel(0)
    val pix2 = GreyscalePixel(1)
    val pix3 = GreyscalePixel(2)
    val pix4 = GreyscalePixel(3)
    val pixelVector = Vector[Vector[GreyscalePixel]](
      Vector[GreyscalePixel](pix1, pix2),
      Vector[GreyscalePixel](pix3, pix4)
    )
    val grid = new PixelGrid[GreyscalePixel](pixelVector)

    assert(grid.getPixel(0, 0) == pix1)
    assert(grid.getPixel(1, 0) == pix2)
    assert(grid.getPixel(0, 1) == pix3)
    assert(grid.getPixel(1, 1) == pix4)
  }

  test("Correctly constructs an empty grid") {
    val grid = new PixelGrid[GreyscalePixel]()

    assert(grid.getWidth() == 0)
    assert(grid.getHeight() == 0)
  }

  test("Correctly appends a new line of pixels") {
    val pix1 = GreyscalePixel(0)
    val pix2 = GreyscalePixel(1)
    val pix3 = GreyscalePixel(2)
    val pix4 = GreyscalePixel(3)
    val pixelVector = Vector[Vector[GreyscalePixel]](
      Vector[GreyscalePixel](pix1, pix2)
    )
    val newPixelLine = Vector[GreyscalePixel](pix3, pix4)
    var grid = new PixelGrid[GreyscalePixel](pixelVector)
    grid = grid.appended(newPixelLine)

    assert(grid.getPixel(0, 0) == pix1)
    assert(grid.getPixel(1, 0) == pix2)
    assert(grid.getPixel(0, 1) == pix3)
    assert(grid.getPixel(1, 1) == pix4)
  }

  test(
    "Throws when trying to append a new line of pixels with the wrong length") {
    val grid = new PixelGrid[GreyscalePixel](
      Vector[Vector[GreyscalePixel]](Vector[GreyscalePixel](GreyscalePixel(0))))
    assertThrows[Exception](grid.appended(Vector[GreyscalePixel]()))
  }
}
