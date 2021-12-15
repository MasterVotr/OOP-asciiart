package ASCIIArt.ImageImporter.RandomImageImporter

import ASCIIArt.Image.PixelGrid.Pixel.RGBPixel
import org.scalatest.FunSuite

class RandomImageImporterTest extends FunSuite {
  test("Correctly generates an image with a random resolution") {
    val importer = new RandomImageImporter()
    val img = importer.ImportImage()

    assert(img.getWidth() >= 10)
    assert(img.getWidth() <= 210)
    assert(img.getHeight() >= 10)
    assert(img.getHeight() <= 210)
    for (y <- 0 until img.getHeight())
      for (x <- 0 until img.getWidth())
        assert(img.getPixel(x, y).isInstanceOf[RGBPixel])
  }
}
