package ASCIIArt.ImageFilter.PixelFilterer.PixelFilter

import ASCIIArt.Image.PixelGrid.Pixel.Pixel

trait PixelFilter[P <: Pixel] {
  def apply(pixel: P): P
}
