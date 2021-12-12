package ASCIIArt

import ASCIIArt.Controller.ConsoleController.ConsoleController
import ASCIIArt.Image2ImageConvertor.RGB2GreyscaleConvertor

object Main extends App {
  // Parse commands
  val (imageImporter, filters, exporters) = ConsoleController.parseArgs(args.toList)
  // Load Image
  val rgbImage = imageImporter.ImportImage()
  // Convert to greyscale
  var processedImage = new RGB2GreyscaleConvertor().Convert(rgbImage)
  // Apply filters
  for (filter <- filters) {
    processedImage = filter.Execute(processedImage)
  }
  // Export
  for (exporter <- exporters) {
    processedImage = exporter.Execute(processedImage)
  }
}
