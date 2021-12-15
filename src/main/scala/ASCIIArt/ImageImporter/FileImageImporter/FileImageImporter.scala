package ASCIIArt.ImageImporter.FileImageImporter

import ASCIIArt.Image.RGBImage
import ASCIIArt.ImageImporter.ImageImporter

/**
 * Abstracs class for importing images from files
 * @param path
 */
abstract class FileImageImporter(path: String) extends ImageImporter {
  override def ImportImage(): RGBImage
}
