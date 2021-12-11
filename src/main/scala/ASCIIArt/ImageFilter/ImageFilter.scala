package ASCIIArt.ImageFilter

import ASCIIArt.Image.Image
import ASCIIArt.Image.PixelGrid.Pixel.Pixel

trait ImageFilter[P <: Pixel] {
  def apply(image: Image[P]): Image[P]
}
