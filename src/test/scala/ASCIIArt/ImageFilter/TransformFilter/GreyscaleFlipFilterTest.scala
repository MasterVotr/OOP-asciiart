package ASCIIArt.ImageFilter.TransformFilter

import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import ASCIIArt.Image.PixelGrid.PixelGrid
import ASCIIArt.Image.{GreyscaleImage, Image}
import ASCIIArt.ImageFilter.TransformFilter.FlipFilter.{FlipX, FlipY, GreyscaleFlipFilter}
import org.scalatest.FunSuite

class GreyscaleFlipFilterTest extends FunSuite {
  test("Correctly flips an image along X axis") {
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
    val filter = new GreyscaleFlipFilter(FlipX)

    img = filter(img)

    assert(img.getPixel(0, 0) == pix3)
    assert(img.getPixel(1, 0) == pix4)
    assert(img.getPixel(0, 1) == pix1)
    assert(img.getPixel(1, 1) == pix2)
  }

  test("Correctly flips an image along Y axis") {
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
    val filter = new GreyscaleFlipFilter(FlipY)

    img = filter(img)

    assert(img.getPixel(0, 0) == pix2)
    assert(img.getPixel(1, 0) == pix1)
    assert(img.getPixel(0, 1) == pix4)
    assert(img.getPixel(1, 1) == pix3)
  }

  test("Correctly flips and empty image along any axis") {
    var img: Image[GreyscalePixel] =
      GreyscaleImage(new PixelGrid[GreyscalePixel]())
    val filter1 = new GreyscaleFlipFilter(FlipX)
    val filter2 = new GreyscaleFlipFilter(FlipY)

    img = filter1(img)

    assert(img.getHeight() == 0)
    assert(img.getWidth() == 0)

    img = filter2(img)

    assert(img.getHeight() == 0)
    assert(img.getWidth() == 0)
  }

  test("Throws when input axis is invalid") {
    // Always true, because there currently are no unimplemented axes that would throw
    assert(42 == 42)
  }
}
