package ASCIIArt.Image.PixelGrid.Pixel

import org.scalatest.FunSuite

import scala.util.Random

class RGBPixelTest extends FunSuite {
  test("Correctly constructs a pixel from Int, Int, Int") {
    val rd = new Random()
    val red = rd.nextInt(256)
    val green = rd.nextInt(256)
    val blue = rd.nextInt(256)
    val pix = RGBPixel(red, green, blue)

    assert(pix.red == red)
    assert(pix.green == green)
    assert(pix.blue == blue)
  }

  test("Correctly constructs a pixel from Color Int") {
    val rd = new Random()
    val colour = rd.nextInt(Int.MaxValue)
    val pix = new RGBPixel(colour)

    assert(pix.red == (colour & 0xff0000) >> 16)
    assert(pix.green == (colour & 0x00ff00) >> 8)
    assert(pix.blue == (colour & 0x0000ff))
  }

  test("Correctly clamp value in <0;255>") {
    val rd = new Random()
    val red = rd.nextInt(256)
    val green = rd.nextInt(256)
    val blue = rd.nextInt(256)
    val pix = RGBPixel(red, green, blue)

    assert(pix.red == red)
    assert(pix.green == green)
    assert(pix.blue == blue)
  }

  test("Correctly clamp value < 0") {
    val rd = new Random()
    val red = rd.nextInt(256) - 256
    val green = rd.nextInt(256)
    val blue = rd.nextInt(256)
    var pix = RGBPixel(red, green, blue)
    pix = pix.clamp()

    assert(pix.red <= 255)
    assert(pix.red >= 0)
  }

  test("Correctly clamp value in > 255") {
    val rd = new Random()
    val red = rd.nextInt(256) + 256
    val green = rd.nextInt(256)
    val blue = rd.nextInt(256)
    var pix = RGBPixel(red, green, blue)
    pix = pix.clamp()

    assert(pix.red <= 255)
    assert(pix.red >= 0)
  }
}
