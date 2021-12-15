package ASCIIArt.TextExporter.FileTextExporter

import org.scalatest.FunSuite

import java.io.File
import scala.io.Source

class FileTextExporterTest extends FunSuite {
  test("Correctly exports a given String") {
    val tragedy = "The tragedy of Darth Plagues the wise"
    val path = "tragedy.txt"
    val exporter = new FileTextExporter(path)
    exporter.ExportText(tragedy)

    val bufferedFile = Source.fromFile(path)
    var content = ""
    for (line <- bufferedFile.getLines())
      content += line

    assert(content == tragedy)

    // Cleanup
    val tmpFileRef = new File(path)
    if (tmpFileRef.exists()) tmpFileRef.delete()
  }
}
