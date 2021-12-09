package ASCIIArt.Filter.PixelFilter

import ASCIIArt.Image.PixelGrid.Pixel.Pixel

trait PixelFilter[P <: Pixel] {
  def applyFiler(pixel: P): Unit
}
