package ASCIIArt.Image.PixelGrid.Pixel

import org.scalatest.FunSuite

import scala.util.Random

class PixelUtilsTest extends FunSuite {
  test("Correctly combines 1 pixel") {
    val rd = new Random()
    val brightness = rd.nextInt(256)
    val pix = GreyscalePixel(brightness)
    val combinedPix =
      PixelUtils.CombineGreyscalePixels(List[GreyscalePixel](pix))

    assert(combinedPix.brightness == brightness)
  }

  test("Correctly combines multiple pixels") {
    val rd = new Random()
    val brightness1 = rd.nextInt(256)
    val brightness2 = rd.nextInt(256)
    val brightness3 = rd.nextInt(256)
    val brightness4 = rd.nextInt(256)
    val pix1 = GreyscalePixel(brightness1)
    val pix2 = GreyscalePixel(brightness2)
    val pix3 = GreyscalePixel(brightness3)
    val pix4 = GreyscalePixel(brightness4)
    val combinedBrightness = (brightness1 + brightness2 + brightness3 + brightness4) / 4
    val combinedPix = PixelUtils.CombineGreyscalePixels(
      List[GreyscalePixel](pix1, pix2, pix3, pix4))

    assert(combinedPix.brightness == combinedBrightness)
  }

  test("Correctly combines 0 pixels") {
    assertThrows[Exception](
      PixelUtils.CombineGreyscalePixels(List[GreyscalePixel]()))
  }
}
