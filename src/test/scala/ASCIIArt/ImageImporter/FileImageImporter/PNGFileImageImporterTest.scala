package ASCIIArt.ImageImporter.FileImageImporter

import ASCIIArt.Image.PixelGrid.Pixel.RGBPixel
import org.scalatest.FunSuite

import javax.imageio.IIOException

class PNGFileImageImporterTest extends FunSuite {
  test("Correctly imports an image") {
    val importer = new GIFFileImageImporter("resources/test_gradient.png")
    val img = importer.ImportImage()

    assert(img.getHeight() == 1)
    assert(img.getWidth() == 10)
    for (y <- 0 until img.getHeight())
      for (x <- 0 until img.getWidth())
        assert(img.getPixel(x, y).isInstanceOf[RGBPixel])
  }

  test("Throws when image not found") {
    val importer = new GIFFileImageImporter("resources/kenobi.png")
    assertThrows[IIOException](importer.ImportImage())
  }
}
