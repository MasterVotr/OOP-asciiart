package ASCIIArt.Controller.Command

import ASCIIArt.Controller.Command.FilterCommand.InvertCmd
import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import ASCIIArt.Image.PixelGrid.PixelGrid
import ASCIIArt.Image.{GreyscaleImage, Image}
import org.scalatest.FunSuite

class InvertCmdTest extends FunSuite {
  test("Correctly executes InvertCmd using invert filter") {
    var img: Image[GreyscalePixel] = new GreyscaleImage(
      new PixelGrid[GreyscalePixel](
        Vector[Vector[GreyscalePixel]](
          Vector[GreyscalePixel](
            GreyscalePixel(0)
          )
        )
      )
    )
    assert(img.getWidth() == 1)
    assert(img.getHeight() == 1)
    val invertCmd = new InvertCmd()
    img = invertCmd.Execute(img)

    assert(img.getPixel(0, 0).brightness == 255)
  }

}
