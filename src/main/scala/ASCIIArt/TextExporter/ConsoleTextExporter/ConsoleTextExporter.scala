package ASCIIArt.TextExporter.ConsoleTextExporter

import ASCIIArt.TextExporter.TextExporter

class ConsoleTextExporter extends TextExporter {
  override def ExportText(text: String): Unit =
    println(text)
}
