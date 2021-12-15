package ASCIIArt.Image2ImageConvertor

import ASCIIArt.Image.Image
import ASCIIArt.Image.PixelGrid.Pixel.Pixel

/**
 * Basic trait for Image[P1] to Image[P2] conversion
 * Mathod Convert Pixel is used for
 * @tparam P1
 * @tparam P2
 */
trait Image2ImageConvertor[P1 <: Pixel, P2 <: Pixel] {
  def Convert(image: Image[P1]): Image[P2]

  def ConvertPixel(pixel: P1): P2
}
