package ASCIIArt.Controller.Command.ExportCommand

import ASCIIArt.AsciiGenerator.ImageAsciiGenerator.ImageAsciiGenerator
import ASCIIArt.Image.Image
import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import ASCIIArt.TextExporter.FileTextExporter.FileTextExporter

/**
 * Exporter commands that uses an AsciiGenerator to generate an AsciiArt and export it using a FileTextExporter with given path
 * @param path
 */
class FileOutputCmd(path: String) extends ExportCommand {
  override def Execute(target: Image[GreyscalePixel]): Image[GreyscalePixel] = {
    val asciigen = new ImageAsciiGenerator()
    val output = asciigen.generateArt(target)
    val exporter = new FileTextExporter(path)
    exporter.ExportText(output)
    target
  }
}
