package ASCIIArt.Image2ImageConvertor

import ASCIIArt.Image.PixelGrid.Pixel.RGBPixel
import ASCIIArt.Image.PixelGrid.PixelGrid
import ASCIIArt.Image.RGBImage
import org.scalatest.FunSuite

class RGB2GreyscaleConvertorTest extends FunSuite {
  test("Correctly converts RGBPixel to GreyscalePixel") {
    val rgbPix = RGBPixel(0, 0, 0)
    val convertor = new RGB2GreyscaleConvertor()

    val greyPix = convertor.ConvertPixel(rgbPix)

    assert(greyPix.brightness == 0)
  }

  test("Correctly converts RGBImage to GreyscaleImage") {
    val rgbPix = RGBPixel(0, 0, 0)
    val rgbImg = new RGBImage(
      new PixelGrid[RGBPixel](
        Vector[Vector[RGBPixel]](Vector[RGBPixel](rgbPix))))
    val convertor = new RGB2GreyscaleConvertor()

    val greyImg = convertor.Convert(rgbImg)

    assert(greyImg.getHeight() == rgbImg.getHeight())
    assert(greyImg.getWidth() == rgbImg.getWidth())
    assert(greyImg.getPixel(0, 0).brightness == 0)
  }

  test("Correctly converts empty RGBImage to an empty GreyscaleImage") {
    val rgbImg = new RGBImage(new PixelGrid[RGBPixel]())
    val convertor = new RGB2GreyscaleConvertor()

    val greyImg = convertor.Convert(rgbImg)

    assert(greyImg.getHeight() == rgbImg.getHeight())
    assert(greyImg.getWidth() == rgbImg.getWidth())
    assert(greyImg.getHeight() == 0)
    assert(greyImg.getWidth() == 0)
  }
}
