package ASCIIArt.Controller.ConsoleController

import ASCIIArt.Controller.Command.ExportCommand.{ConsoleOutputCmd, FileOutputCmd}
import ASCIIArt.Controller.Command.FilterCommand._
import ASCIIArt.ImageImporter.FileImageImporter.FileImageImporter
import ASCIIArt.ImageImporter.RandomImageImporter.RandomImageImporter
import org.scalatest.FunSuite

class ConsoleControllerTest extends FunSuite {
  test("Correctly parses png image argument") {
    val testArgs =
      List[String]("--image", "resources/test_gradient.png", "--output-console")
    val (imageLoader, filterCmds, exportCmds) =
      ConsoleController.parseArgs(testArgs)

    assert(imageLoader.isInstanceOf[FileImageImporter])
  }

  test("Correctly parses jpg image argument") {
    val testArgs =
      List[String]("--image", "resources/test_gradient.jpg", "--output-console")
    val (imageLoader, filterCmds, exportCmds) =
      ConsoleController.parseArgs(testArgs)

    assert(imageLoader.isInstanceOf[FileImageImporter])
  }

  test("Correctly parses gif image argument") {
    val testArgs =
      List[String]("--image", "resources/test_gradient.gif", "--output-console")
    val (imageLoader, filterCmds, exportCmds) =
      ConsoleController.parseArgs(testArgs)

    assert(imageLoader.isInstanceOf[FileImageImporter])
  }

  test("Correctly parse wrong args: wrong image format") {
    val testArgs = List[String]("--image", "hello_there.kenobi")
    assertThrows[Exception](ConsoleController.parseArgs(testArgs))
  }

  test("Correctly parses random image argument") {
    val testArgs = List[String]("--image-random", "--output-console")
    val (imageLoader, filterCmds, exportCmds) =
      ConsoleController.parseArgs(testArgs)

    assert(imageLoader.isInstanceOf[RandomImageImporter])
  }

  test("Correctly parses scale argument") {
    val testArgs =
      List[String]("--scale", "4", "--image-random", "--output-console")
    val (imageLoader, filterCmds, exportCmds) =
      ConsoleController.parseArgs(testArgs)

    assert(filterCmds.head.isInstanceOf[ScaleCmd])
  }

  test("Correctly parses rotate argument") {
    val testArgs =
      List[String]("--rotate", "180", "--image-random", "--output-console")
    val (imageLoader, filterCmds, exportCmds) =
      ConsoleController.parseArgs(testArgs)

    assert(filterCmds.head.isInstanceOf[RotateCmd])
  }

  test("Correctly parses invert argument") {
    val testArgs =
      List[String]("--invert", "--image-random", "--output-console")
    val (imageLoader, filterCmds, exportCmds) =
      ConsoleController.parseArgs(testArgs)

    assert(filterCmds.head.isInstanceOf[InvertCmd])
  }

  test("Correctly parses flip argument") {
    val testArgs =
      List[String]("--flip", "y", "--image-random", "--output-console")
    val (imageLoader, filterCmds, exportCmds) =
      ConsoleController.parseArgs(testArgs)

    assert(filterCmds.head.isInstanceOf[FlipCmd])
  }

  test("Correctly parses brightness argument") {
    val testArgs =
      List[String]("--brightness", "10", "--image-random", "--output-console")
    val (imageLoader, filterCmds, exportCmds) =
      ConsoleController.parseArgs(testArgs)

    assert(filterCmds.head.isInstanceOf[BrightnessCmd])
  }

  test("Correctly parses console output argument") {
    val testArgs = List[String]("--output-console", "--image-random")
    val (imageLoader, filterCmds, exportCmds) =
      ConsoleController.parseArgs(testArgs)

    assert(exportCmds.head.isInstanceOf[ConsoleOutputCmd])
  }

  test("Correctly parses file output argument") {
    val testArgs = List[String](
      "--output-file",
      "output/test-gradient.txt",
      "--image-random")
    val (imageLoader, filterCmds, exportCmds) =
      ConsoleController.parseArgs(testArgs)

    assert(exportCmds.head.isInstanceOf[FileOutputCmd])
  }

  test("Correctly parse wrong args: unknown option") {
    val testArgs = List[String]("--Hello_there!")
    assertThrows[Exception](ConsoleController.parseArgs(testArgs))
  }

  test("Correctly parse wrong args: more than one image import specification") {
    val testArgs = List[String](
      "--image",
      "hello_there.png",
      "--image",
      "general_kenobi.jpg",
      "--output-console")
    assertThrows[Exception](ConsoleController.parseArgs(testArgs))
  }

  test("Correctly parse wrong args: image import not set") {
    val testArgs = List[String]("--invert", "--output-console")
    assertThrows[Exception](ConsoleController.parseArgs(testArgs))
  }

  test("Correctly parse wrong args: output not set") {
    val testArgs = List[String]("--invert", "--image-random")
    assertThrows[Exception](ConsoleController.parseArgs(testArgs))
  }
}
