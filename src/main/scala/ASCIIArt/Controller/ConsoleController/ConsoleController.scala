package ASCIIArt.Controller.ConsoleController

import ASCIIArt.Controller.Command.ExportCommand.{ConsoleOutputCmd, ExportCommand, FileOutputCmd}
import ASCIIArt.Controller.Command.FilterCommand._
import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import ASCIIArt.ImageFilter.ImageFilter
import ASCIIArt.ImageImporter.FileImageImporter.{FileImageImporter, GIFFileImageImporter, JPGFileImageImporter, PNGFileImageImporter}
import ASCIIArt.ImageImporter.ImageImporter
import ASCIIArt.ImageImporter.RandomImageImporter.RandomImageImporter

import scala.collection.mutable.ArrayBuffer

object ConsoleController {
  def parseArgs(args: List[String])
    : (ImageImporter, List[FilterCommand], List[ExportCommand]) = {
    val filterCommands = List[FilterCommand]()
    val exportCommands = List[ExportCommand]()
    var imageImporter: ImageImporter = new RandomImageImporter()
    var argumentsLeft = args
    var imageSetFlag = false

    while (argumentsLeft != Nil) argumentsLeft match {
      case "--image-random" :: tail =>
        if (imageSetFlag) throw new Exception("Image already set!")
        imageSetFlag = true
        imageImporter = new RandomImageImporter()
      case "--image" :: path :: tail =>
        if (imageSetFlag) throw new Exception("Image already set!")
        imageSetFlag = true
        val format = path.takeRight(path.lastIndexOf('.'))
        format match {
          case "jpg" => imageImporter = new JPGFileImageImporter(path)
          case "png" => imageImporter = new PNGFileImageImporter(path)
          case "gif" => imageImporter = new GIFFileImageImporter(path)
          case _ => throw new Exception("Unsupported image format!")
        }
        argumentsLeft = tail
      case "--brightness" :: value :: tail =>
        filterCommands.appended(new BrightnessCmd(value.toInt))
        argumentsLeft = tail
      case "--flip" :: value :: tail =>
        filterCommands.appended(new FlipCmd(value))
        argumentsLeft = tail
      case "--inverse" :: tail =>
        filterCommands.appended(new InverseCmd())
        argumentsLeft = tail
      case "--rotate" :: value :: tail =>
        filterCommands.appended(new RotateCmd(value.toInt))
        argumentsLeft = tail
      case "--scale" :: value :: tail =>
        filterCommands.appended(new ScaleCmd(value.toInt))
        argumentsLeft = tail
      case "--output-console" :: tail =>
        exportCommands.appended(new ConsoleOutputCmd)
        argumentsLeft = tail
      case "--output-file" :: path :: tail =>
        exportCommands.appended(new FileOutputCmd(path))
        argumentsLeft = tail
      case option :: tail =>
        throw new Exception("Unknown option: " + option + "!")

    }
    (imageImporter, filterCommands, exportCommands)
  }
}
