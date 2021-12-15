package ASCIIArt

import ASCIIArt.Controller.ConsoleController.ConsoleController
import ASCIIArt.Image2ImageConvertor.RGB2GreyscaleConvertor
import org.scalatest.FunSuite

import java.io.File
import scala.io.Source

class MainTest extends FunSuite {
  test("Life, Universe and Everything") {
    assert(42 == 42)
  }

  test("Standard application run") {
    val out_path = "output/gradient.txt"
    val testArgs: List[String] = List(
      "--image",
      "resources/test_gradient.png",
      "--scale",
      "4",
      "--rotate",
      "180",
      "--brightness",
      "20",
      "--invert",
      "--flip",
      "x",
      "--scale",
      "0.25",
      "--output-file",
      out_path,
    )
    // Parse test args
    val (i, fs, es) = ConsoleController.parseArgs(testArgs)
    // Import image
    val rgbImg = i.ImportImage()
    // Convert to greyscale
    var greyImg = new RGB2GreyscaleConvertor().Convert(rgbImg)
    // Apply filters
    for (f <- fs)
      greyImg = f.Execute(greyImg)
    // Export
    for (e <- es)
      greyImg = e.Execute(greyImg)

    // Load result
    val bufferedFile = Source.fromFile(out_path)
    var content = ""
    for (line <- bufferedFile.getLines())
      content += line

    // Test result
    assert(content == "@@@%#*+=-:")

    // Cleanup
    // Cleanup
    val tmpFileRef = new File(out_path)
    if (tmpFileRef.exists()) tmpFileRef.delete()
  }
}
