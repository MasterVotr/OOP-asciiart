package ASCIIArt.Image

import ASCIIArt.Image.PixelGrid.Pixel.Pixel
import ASCIIArt.Image.PixelGrid.PixelGrid

/**
 * An abstract image class of given P pixel and pixel grid parameter
 * Serves as a template for more specialized images
 * @param pixelGrid
 * @tparam P
 */
abstract class Image[P <: Pixel](pixelGrid: PixelGrid[P]) {

  def getWidth(): Int =
    pixelGrid.getWidth()

  def getHeight(): Int =
    pixelGrid.getHeight()

  def getPixel(x: Int, y: Int): P =
    pixelGrid.getPixel(x, y)
}
