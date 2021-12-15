package ASCIIArt.AsciiGenerator.ImageAsciiGenerator

import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import ASCIIArt.Image.PixelGrid.PixelGrid
import ASCIIArt.Image.{GreyscaleImage, Image}
import org.scalatest.FunSuite

class ImageAsciiGeneratorTest extends FunSuite {
  test("Correctly converts image to ascii") {
    var img: Image[GreyscalePixel] = new GreyscaleImage(
      new PixelGrid[GreyscalePixel](
        Vector[Vector[GreyscalePixel]](
          Vector[GreyscalePixel](
            GreyscalePixel(0)
          )
        )
      )
    )
    val asciiGen = new ImageAsciiGenerator()
    val art = asciiGen.generateArt(img)

    assert(art == "@\n")
  }
}
