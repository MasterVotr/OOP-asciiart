package ASCIIArt.Filter.ImageFilter

import ASCIIArt.Image.Image
import ASCIIArt.Image.PixelGrid.Pixel.Pixel

trait ImageFilter[P <: Pixel, I <: Image[P]] {
  def apply(image: I): Unit
}
