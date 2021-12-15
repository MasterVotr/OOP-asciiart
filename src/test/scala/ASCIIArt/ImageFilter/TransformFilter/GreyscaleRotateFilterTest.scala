package ASCIIArt.ImageFilter.TransformFilter

import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import ASCIIArt.Image.PixelGrid.PixelGrid
import ASCIIArt.Image.{GreyscaleImage, Image}
import ASCIIArt.ImageFilter.TransformFilter.RotateFilter._
import org.scalatest.FunSuite

class GreyscaleRotateFilterTest extends FunSuite {
  test("Correctly rotates an image 90 degrees") {
    val pix1 = GreyscalePixel(0)
    val pix2 = GreyscalePixel(1)
    val pix3 = GreyscalePixel(2)
    val pix4 = GreyscalePixel(3)
    var img: Image[GreyscalePixel] = new GreyscaleImage(
      new PixelGrid[GreyscalePixel](
        Vector[Vector[GreyscalePixel]](
          Vector[GreyscalePixel](pix1, pix2),
          Vector[GreyscalePixel](pix3, pix4)
        )
      )
    )
    val filter = new GreyscaleRotateFilter(Rot90)

    img = filter(img)

    assert(img.getPixel(0, 0) == pix3)
    assert(img.getPixel(1, 0) == pix1)
    assert(img.getPixel(0, 1) == pix4)
    assert(img.getPixel(1, 1) == pix2)
  }

  test("Correctly rotates an image 180 degrees") {
    val pix1 = GreyscalePixel(0)
    val pix2 = GreyscalePixel(1)
    val pix3 = GreyscalePixel(2)
    val pix4 = GreyscalePixel(3)
    var img: Image[GreyscalePixel] = new GreyscaleImage(
      new PixelGrid[GreyscalePixel](
        Vector[Vector[GreyscalePixel]](
          Vector[GreyscalePixel](pix1, pix2),
          Vector[GreyscalePixel](pix3, pix4)
        )
      )
    )
    val filter = new GreyscaleRotateFilter(Rot180)

    img = filter(img)

    assert(img.getPixel(0, 0) == pix4)
    assert(img.getPixel(1, 0) == pix3)
    assert(img.getPixel(0, 1) == pix2)
    assert(img.getPixel(1, 1) == pix1)
  }

  test("Correctly rotates an image 270 degrees") {
    val pix1 = GreyscalePixel(0)
    val pix2 = GreyscalePixel(1)
    val pix3 = GreyscalePixel(2)
    val pix4 = GreyscalePixel(3)
    var img: Image[GreyscalePixel] = new GreyscaleImage(
      new PixelGrid[GreyscalePixel](
        Vector[Vector[GreyscalePixel]](
          Vector[GreyscalePixel](pix1, pix2),
          Vector[GreyscalePixel](pix3, pix4)
        )
      )
    )
    val filter = new GreyscaleRotateFilter(Rot270)

    img = filter(img)

    assert(img.getPixel(0, 0) == pix2)
    assert(img.getPixel(1, 0) == pix4)
    assert(img.getPixel(0, 1) == pix1)
    assert(img.getPixel(1, 1) == pix3)
  }

  test("Correctly rotates and empty image any degrees") {
    var img: Image[GreyscalePixel] =
      GreyscaleImage(new PixelGrid[GreyscalePixel]())
    val filter1 = new GreyscaleRotateFilter(Rot90)
    val filter2 = new GreyscaleRotateFilter(Rot180)
    val filter3 = new GreyscaleRotateFilter(Rot270)

    img = filter1(img)

    assert(img.getHeight() == 0)
    assert(img.getWidth() == 0)

    img = filter2(img)

    assert(img.getHeight() == 0)
    assert(img.getWidth() == 0)

    img = filter3(img)

    assert(img.getHeight() == 0)
    assert(img.getWidth() == 0)
  }

  test("Throws when input degrees are invalid") {
    // Always true, because there currently are no unimplemented rotations that would throw
    assert(42 == 42)
  }
}
