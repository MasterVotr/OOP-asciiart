package ASCIIArt.Image.PixelGrid.Pixel

import org.scalatest.FunSuite

import scala.util.Random

class GreyscalePixelTest extends FunSuite {
  test("Correctly constructs a pixel from Int") {
    val rd = new Random()
    val brightness = rd.nextInt(256)
    var pix = GreyscalePixel(brightness)

    assert(pix.brightness == brightness)
  }

  test("Correctly constructs a pixel from List[GreyscalePixel]") {
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
    val combinedPix =
      new GreyscalePixel(List[GreyscalePixel](pix1, pix2, pix3, pix4))

    assert(combinedPix.brightness == combinedBrightness)
  }

  test("Correctly clamp value in <0;255>") {
    val rd = new Random()
    var pix = GreyscalePixel(rd.nextInt(256))
    pix = pix.clamp()

    assert(pix.brightness <= 255)
    assert(pix.brightness >= 0)
  }

  test("Correctly clamp value < 0") {
    val rd = new Random()
    var pix = GreyscalePixel(rd.nextInt(256) - 256)
    pix = pix.clamp()

    assert(pix.brightness <= 255)
    assert(pix.brightness >= 0)
  }

  test("Correctly clamp value in > 255") {
    val rd = new Random()
    var pix = GreyscalePixel(rd.nextInt(256) + 256)
    pix = pix.clamp()

    assert(pix.brightness <= 255)
    assert(pix.brightness >= 0)
  }
}
