package ASCIIArt.ImageFilter.PixelFilterer.PixelFilter

import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import org.scalatest.FunSuite

import scala.util.Random

class InvertPixelFilterTest extends FunSuite {
  test("Correctly inverts a pixel") {
    val rd = new Random()
    val brightness = rd.nextInt(256)
    var pix = GreyscalePixel(brightness)
    val filter = new InvertPixelFilter()

    pix = filter(pix)

    assert(pix.brightness == 255 - brightness)
  }
}
