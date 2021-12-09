package ASCIIArt.Filter.PixelFilter

import ASCIIArt.Image.PixelGrid.Pixel.Pixel

trait PixelFilterable[P <: Pixel] {
  def ApplyPixelFilter(pixelFilter: PixelFilter[P]): Unit
}
