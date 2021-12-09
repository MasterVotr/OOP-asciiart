package ASCIIArt

import ASCIIArt.Controller.ConsoleController.ConsoleController
import ASCIIArt.Image.RGBtoGreyscaleConvertor

object Main extends App {
  // Parse commands
  val (imageImporter, filters, exporters) = ConsoleController.parseArgs(args.toList)
  // Load Image
  val rgbImage = imageImporter.ImportImage()
  // Convert to greyscale
  val convertor = new RGBtoGreyscaleConvertor()
  val greyscaleImage = convertor.ConvertImage(rgbImage)
  // Apply filters
  for (filter <- filters)
    filter.Execute(greyscaleImage)
  // Export ascii art
  for (exporter <- exporters)
    exporter.Execute(greyscaleImage)
}
