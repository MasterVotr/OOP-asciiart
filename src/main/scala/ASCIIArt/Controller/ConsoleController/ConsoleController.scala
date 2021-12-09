package ASCIIArt.Controller.ConsoleController

import ASCIIArt.Controller.Command.ExportCommand.{ConsoleOutputCmd, ExportCommand, FileOutputCmd}
import ASCIIArt.Controller.Command.FilterCommand._
import ASCIIArt.ImageImporter.FileImageImporter.FileImageImporter
import ASCIIArt.ImageImporter.ImageImporter

import scala.collection.mutable.ArrayBuffer

object ConsoleController {
  def parseArgs(args: List[String])
    : (ImageImporter, Array[FilterCommand], Array[ExportCommand]) = {
    val filterCommands = ArrayBuffer[FilterCommand]()
    val exportCommands = ArrayBuffer[ExportCommand]()
    var imageImporter = new FileImageImporter("")
    var argumentsLeft = args

    while (argumentsLeft != Nil) argumentsLeft match {
      case "--image" :: path :: tail =>
        val format = path.takeRight(3)
        format match {
          case "jpg" | "png" | "gif" =>
            imageImporter = new FileImageImporter(path)
          case _ => throw new Exception("Unsupported image format")
        }
        argumentsLeft = tail
      case "--brightness" :: value :: tail =>
        filterCommands.addOne(new BrightnessCmd(value.toInt))
        argumentsLeft = tail
      case "--flip" :: value :: tail =>
        filterCommands.addOne(new FlipCmd(value))
        argumentsLeft = tail
      case "--inverse" :: value :: tail =>
        filterCommands.addOne(new InverseCmd())
        argumentsLeft = tail
      case "--rotate" :: value :: tail =>
        filterCommands.addOne(new RotateCmd(value.toInt))
        argumentsLeft = tail
      case "--scale" :: value :: tail =>
        filterCommands.addOne(new ScaleCmd(value.toInt))
        argumentsLeft = tail
      case "--output-console" :: tail =>
        exportCommands.addOne(new ConsoleOutputCmd)
        argumentsLeft = tail
      case "--output-file" :: path :: tail =>
        exportCommands.addOne(new FileOutputCmd(path))
        argumentsLeft = tail
      case option :: tail =>
        throw new Exception("Unknown option: " + option)

    }
    (imageImporter, filterCommands.toArray, exportCommands.toArray)
  }
}
