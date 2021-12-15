package ASCIIArt.TextExporter.FileTextExporter

import ASCIIArt.TextExporter.TextExporter

import java.io.{BufferedWriter, FileWriter}

/**
 * Specialized class for exporting Strings to files
 * @param path
 */
class FileTextExporter(path: String) extends TextExporter {
  override def ExportText(text: String): Unit = {
    val fw = new FileWriter(path)
    val bw = new BufferedWriter(fw)
    bw.write(text)
    bw.close()
  }
}
