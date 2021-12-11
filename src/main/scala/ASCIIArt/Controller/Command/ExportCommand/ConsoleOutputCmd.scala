package ASCIIArt.Controller.Command.ExportCommand

import ASCIIArt.AsciiGenerator.ImageAsciiGenerator.ImageAsciiGenerator
import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import ASCIIArt.Image.{GreyscaleImage, Image}
import ASCIIArt.TextExporter.ConsoleTextExporter.ConsoleTextExporter

class ConsoleOutputCmd extends ExportCommand {
  override def Execute(target: Image[GreyscalePixel]): Image[GreyscalePixel] = {
    val asciigen = new ImageAsciiGenerator()
    val output = asciigen.Generate(target)
    val exporter = new ConsoleTextExporter
    exporter.ExportText(output)
    target
  }
}
