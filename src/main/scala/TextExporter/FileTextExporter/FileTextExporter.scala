package TextExporter.FileTextExporter

import TextExporter.TextExporter

import java.io.{BufferedWriter, FileWriter}

class FileTextExporter (path: String) extends TextExporter {
    override def ExportText(text: String): Unit = {
        val fw = new FileWriter(path)
        val bw = new BufferedWriter(fw)
        bw.write(text)
        bw.close()
    }
}