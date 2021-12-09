package ASCIIArt.Controller.Command.ExportCommand

import ASCIIArt.AsciiGenerator
import ASCIIArt.Image.GreyscaleImage
import ASCIIArt.TextExporter.ConsoleTextExporter.ConsoleTextExporter

class ConsoleOutputCmd extends ExportCommand {
  override def Execute(target: GreyscaleImage): Unit = {
    val asciigen = new AsciiGenerator()
    val output = asciigen.Generate(target)
    val exporter = new ConsoleTextExporter
    exporter.ExportText(output)
  }
}
