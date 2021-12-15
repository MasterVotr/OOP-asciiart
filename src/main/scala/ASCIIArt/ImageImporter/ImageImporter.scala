package ASCIIArt.ImageImporter

import ASCIIArt.Image.RGBImage

/**
 * Basic trait for importing images
 */
trait ImageImporter {
  def ImportImage(): RGBImage
}
