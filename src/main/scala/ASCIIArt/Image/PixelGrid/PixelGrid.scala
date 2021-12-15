package ASCIIArt.Image.PixelGrid

import ASCIIArt.Image.PixelGrid.Pixel.Pixel

/**
 * Class for holding and handling of pixels of given P type
 * Can be constructed using a IndexedSeq[IndexedSeq[P] or empty
 * @param pixels
 * @tparam P
 */
case class PixelGrid[P <: Pixel] (protected val pixels: IndexedSeq[IndexedSeq[P]]) {

  def this() {
    this(Vector.empty[Vector[P]])
  }

  def getHeight(): Int = {
    pixels.length
  }

  def getWidth(): Int = {
    if (getHeight() == 0)
      return 0
    pixels(0).length
  }

  def getPixel(x: Int, y: Int): P =
    pixels(y)(x)

  /**
   * Appends a new line of pixels to the grid
   * @param pixelLine
   * @return
   */
  def appended(pixelLine: IndexedSeq[P]): PixelGrid[P] = {
    if(pixels.nonEmpty && pixelLine.length != getWidth())
      throw new Exception("New pixel line length not same as grid width")
    new PixelGrid[P](pixels.appended(pixelLine))
  }
}