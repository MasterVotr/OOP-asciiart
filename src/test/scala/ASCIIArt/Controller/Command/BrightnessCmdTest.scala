package ASCIIArt.Controller.Command

import ASCIIArt.Controller.Command.FilterCommand.BrightnessCmd
import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import ASCIIArt.Image.PixelGrid.PixelGrid
import ASCIIArt.Image.{GreyscaleImage, Image}
import org.scalatest.FunSuite

class BrightnessCmdTest extends FunSuite {
  test("Correctly executes BrightnessCmd using brightness filter") {
    val brightness: Int = 0
    var img: Image[GreyscalePixel] = new GreyscaleImage(
      new PixelGrid[GreyscalePixel](
        Vector[Vector[GreyscalePixel]](
          Vector[GreyscalePixel](
            GreyscalePixel(brightness)
          )
        )
      )
    )
    val brightnessCmd = new BrightnessCmd("10")
    img = brightnessCmd.Execute(img)

    assert(img.getPixel(0, 0).brightness == brightness + 10)
  }

  test("Throws an exception when input change cannot be converted to Int") {
    val img = new GreyscaleImage(new PixelGrid())
    assertThrows[NumberFormatException](
      new BrightnessCmd("kenobi").Execute(img))
  }
}
