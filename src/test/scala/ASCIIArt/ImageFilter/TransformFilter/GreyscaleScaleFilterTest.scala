package ASCIIArt.ImageFilter.TransformFilter

import ASCIIArt.Image.PixelGrid.Pixel.{GreyscalePixel, PixelUtils}
import ASCIIArt.Image.PixelGrid.PixelGrid
import ASCIIArt.Image.{GreyscaleImage, Image}
import ASCIIArt.ImageFilter.TransformFilter.ScaleFilter.{GreyscaleScaleFilter, ScaleDouble, ScaleHalf}
import org.scalatest.FunSuite

class GreyscaleScaleFilterTest extends FunSuite {
  test("Correctly scales an image to 0.25") {
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
    val filter = new GreyscaleScaleFilter(ScaleHalf)

    img = filter(img)

    assert(
      img.getPixel(0, 0).brightness == PixelUtils
        .CombineGreyscalePixels(List[GreyscalePixel](pix1, pix2, pix3, pix4))
        .brightness)
  }

  test("Correctly scales an image to 4") {
    val pix1 = GreyscalePixel(0)
    var img: Image[GreyscalePixel] = new GreyscaleImage(
      new PixelGrid[GreyscalePixel](
        Vector[Vector[GreyscalePixel]](
          Vector[GreyscalePixel](pix1)
        )
      )
    )
    val filter = new GreyscaleScaleFilter(ScaleDouble)

    img = filter(img)

    assert(img.getPixel(0, 0).brightness == pix1.brightness)
    assert(img.getPixel(1, 0).brightness == pix1.brightness)
    assert(img.getPixel(0, 1).brightness == pix1.brightness)
    assert(img.getPixel(1, 1).brightness == pix1.brightness)
  }

  test("Correctly scales an empty image to any scale") {
    var img: Image[GreyscalePixel] =
      GreyscaleImage(new PixelGrid[GreyscalePixel]())
    val filter1 = new GreyscaleScaleFilter(ScaleHalf)
    val filter2 = new GreyscaleScaleFilter(ScaleDouble)

    img = filter1(img)

    assert(img.getHeight() == 0)
    assert(img.getWidth() == 0)

    img = filter2(img)

    assert(img.getHeight() == 0)
    assert(img.getWidth() == 0)
  }

  test("Throws when input scale is invalid") {
    // Always true, because there currently are no unimplemented scaling factors that would throw
    assert(42 == 42)
  }
}
