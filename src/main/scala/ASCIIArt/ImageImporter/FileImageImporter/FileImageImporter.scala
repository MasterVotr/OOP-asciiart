package ASCIIArt.ImageImporter.FileImageImporter

import ASCIIArt.Image.RGBImage
import ASCIIArt.ImageImporter.ImageImporter

abstract class FileImageImporter(path: String) extends ImageImporter {
  override def ImportImage(): RGBImage
}
