package ASCIIArt.Controller.Command.ExportCommand

import ASCIIArt.AsciiGenerator
import ASCIIArt.Image.GreyscaleImage
import ASCIIArt.TextExporter.FileTextExporter.FileTextExporter

class FileOutputCmd(path: String) extends ExportCommand {
  override def Execute(target: GreyscaleImage): Unit = {
    val asciigen = new AsciiGenerator()
    val output = asciigen.Generate(target)
    val exporter = new FileTextExporter(path)
    exporter.ExportText(output)
  }
}
