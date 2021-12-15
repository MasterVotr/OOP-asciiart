package ASCIIArt.Controller.Command

import ASCIIArt.Controller.Command.FilterCommand.FlipCmd
import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import ASCIIArt.Image.PixelGrid.PixelGrid
import ASCIIArt.Image.{GreyscaleImage, Image}
import org.scalatest.FunSuite

class FlipCmdTest extends FunSuite {
  test("Correctly executes FlipCmd using flip filter") {
    val pix1 = GreyscalePixel(0)
    val pix2 = GreyscalePixel(1)
    var img: Image[GreyscalePixel] = new GreyscaleImage(
      new PixelGrid[GreyscalePixel](
        Vector[Vector[GreyscalePixel]](
          Vector[GreyscalePixel](pix1, pix2)
        )
      )
    )
    val flipCmd = new FlipCmd("y")
    img = flipCmd.Execute(img)

    assert(pix1 == img.getPixel(1, 0))
    assert(pix2 == img.getPixel(0, 0))
  }

  test("Throws an exception when input axis is not one of defined axes") {
    val img = new GreyscaleImage(new PixelGrid())
    assertThrows[Exception](new FlipCmd("kenobi").Execute(img))
  }
}
