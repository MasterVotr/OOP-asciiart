package ASCIIArt.Controller.Command.ExportCommand

import ASCIIArt.AsciiGenerator.ImageAsciiGenerator.ImageAsciiGenerator
import ASCIIArt.Image.Image
import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import ASCIIArt.TextExporter.ConsoleTextExporter.ConsoleTextExporter

class ConsoleOutputCmd extends ExportCommand {
  override def Execute(target: Image[GreyscalePixel]): Image[GreyscalePixel] = {
    val asciigen = new ImageAsciiGenerator()
    val output = asciigen.generateArt(target)
    val exporter = new ConsoleTextExporter
    exporter.ExportText(output)
    target
  }
}
