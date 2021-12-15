package ASCIIArt.ImageFilter.PixelFilterer.PixelFilter

import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import org.scalatest.FunSuite

import scala.util.Random

class BrightnessPixelFilterTest extends FunSuite {
  test("Correctly modifies brightness") {
    val rd = new Random()
    val brightness = rd.nextInt(100)
    val change = rd.nextInt(10)
    var pix = GreyscalePixel(brightness)
    val filter = new BrightnessPixelFilter(change)

    pix = filter.apply(pix)

    assert(pix.brightness == brightness + change)
  }

  test("Correctly modifies brightness with 0 change") {
    val rd = new Random()
    val brightness = rd.nextInt(100)
    val change = 0
    var pix = GreyscalePixel(brightness)
    val filter = new BrightnessPixelFilter(change)

    pix = filter.apply(pix)

    assert(pix.brightness == brightness)
  }

  test("Correctly modifies brightness with maxInt change") {
    val rd = new Random()
    val brightness = rd.nextInt(100)
    val change = Int.MaxValue
    var pix = GreyscalePixel(brightness)
    val filter = new BrightnessPixelFilter(change)

    pix = filter.apply(pix)

    assert(pix.brightness == 255)
  }
}
