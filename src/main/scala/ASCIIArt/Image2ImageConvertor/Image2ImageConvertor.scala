package ASCIIArt.Image2ImageConvertor

import ASCIIArt.Image.Image
import ASCIIArt.Image.PixelGrid.Pixel.Pixel

trait Image2ImageConvertor[P1 <: Pixel, P2 <: Pixel] {
  def Convert(image: Image[P1]): Image[P2]

  def ConvertPixel(pixel: P1): P2
}
