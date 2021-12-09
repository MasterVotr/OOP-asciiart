package ASCIIArt.ImageImporter

import ASCIIArt.Image.RGBImage

trait ImageImporter {
  def ImportImage(): RGBImage
}
