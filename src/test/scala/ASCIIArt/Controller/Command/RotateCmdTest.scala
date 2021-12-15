package ASCIIArt.Controller.Command

import ASCIIArt.Controller.Command.FilterCommand.RotateCmd
import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import ASCIIArt.Image.PixelGrid.PixelGrid
import ASCIIArt.Image.{GreyscaleImage, Image}
import org.scalatest.FunSuite

class RotateCmdTest extends FunSuite {
  test("Correctly executes RotateCmd using rotate filter") {
    val pix1 = GreyscalePixel(0)
    val pix2 = GreyscalePixel(1)
    var img: Image[GreyscalePixel] = new GreyscaleImage(
      new PixelGrid[GreyscalePixel](
        Vector[Vector[GreyscalePixel]](
          Vector[GreyscalePixel](pix1, pix2)
        )
      )
    )
    val rotateCmd = new RotateCmd("180")
    img = rotateCmd.Execute(img)

    assert(pix1 == img.getPixel(1, 0))
    assert(pix2 == img.getPixel(0, 0))
  }

  test("Correctly convert input deg if is a multiple of 90") {
    val pix1 = GreyscalePixel(0)
    val pix2 = GreyscalePixel(1)
    var img: Image[GreyscalePixel] = new GreyscaleImage(
      new PixelGrid[GreyscalePixel](
        Vector[Vector[GreyscalePixel]](
          Vector[GreyscalePixel](pix1, pix2)
        )
      )
    )
    val rotateCmd = new RotateCmd("720")
    img = rotateCmd.Execute(img)

    assert(pix1 == img.getPixel(0, 0))
    assert(pix2 == img.getPixel(1, 0))
  }

  test("Correctly convert if input deg is 0") {
    val pix1 = GreyscalePixel(0)
    val pix2 = GreyscalePixel(1)
    var img: Image[GreyscalePixel] = new GreyscaleImage(
      new PixelGrid[GreyscalePixel](
        Vector[Vector[GreyscalePixel]](
          Vector[GreyscalePixel](pix1, pix2)
        )
      )
    )
    val rotateCmd = new RotateCmd("0")
    img = rotateCmd.Execute(img)

    assert(pix1 == img.getPixel(0, 0))
    assert(pix2 == img.getPixel(1, 0))
  }

  test("Throws an exception when input deg are not multiples of 90") {
    val img = new GreyscaleImage(new PixelGrid())
    assertThrows[Exception](new RotateCmd("420").Execute(img))
  }

  test("Throws an exception when input deg cannot be converted to Int") {
    val img = new GreyscaleImage(new PixelGrid())
    assertThrows[NumberFormatException](new RotateCmd("kenobi").Execute(img))
  }
}
