package TextExporter.ConsoleTextExporter

import TextExporter.TextExporter

class ConsoleTextExporter extends TextExporter{
    override def ExportText(text: String): Unit = {
        println(text)
    }
}
