package ASCIIArt.TextExporter.ConsoleTextExporter

import ASCIIArt.TextExporter.TextExporter

/**
 * Specialized class for exporting Strings to the console
 */
class ConsoleTextExporter extends TextExporter {
  override def ExportText(text: String): Unit =
    println(text)
}
