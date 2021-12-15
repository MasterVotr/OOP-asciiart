package ASCIIArt.Controller.Command

import ASCIIArt.Controller.Command.FilterCommand.ScaleCmd
import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import ASCIIArt.Image.PixelGrid.PixelGrid
import ASCIIArt.Image.{GreyscaleImage, Image}
import org.scalatest.FunSuite

class ScaleCmdTest extends FunSuite {
  test("Correctly executes ScaleCmd using scale filter") {
    var img: Image[GreyscalePixel] = new GreyscaleImage(
      new PixelGrid[GreyscalePixel](
        Vector[Vector[GreyscalePixel]](
          Vector[GreyscalePixel](
            GreyscalePixel(0)
          )
        )
      )
    )
    val imgScaled: Image[GreyscalePixel] = new GreyscaleImage(
      new PixelGrid[GreyscalePixel](
        Vector[Vector[GreyscalePixel]](
          Vector[GreyscalePixel](
            GreyscalePixel(0),
            GreyscalePixel(0)
          ),
          Vector[GreyscalePixel](
            GreyscalePixel(0),
            GreyscalePixel(0)
          )
        )
      )
    )
    val scaleCmd = new ScaleCmd("4")
    img = scaleCmd.Execute(img)

    assert(img == imgScaled)
  }

  test("Throws an exception when input scale is not one of the defined scales") {
    val img = new GreyscaleImage(new PixelGrid())
    assertThrows[Exception](new ScaleCmd("420").Execute(img))
  }
}
