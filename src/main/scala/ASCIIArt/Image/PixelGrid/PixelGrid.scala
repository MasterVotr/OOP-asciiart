package ASCIIArt.Image.PixelGrid

import ASCIIArt.Image.PixelGrid.Pixel.Pixel


case class PixelGrid[P <: Pixel] (protected val pixels: IndexedSeq[IndexedSeq[P]]) {

  def this() {
    this(Vector.empty[Vector[P]])
  }

  def getHeight(): Int = {
    pixels.length
  }

  def getWidth(): Int = {
    pixels(0).length
  }

  def getPixel(x: Int, y: Int): P =
    pixels(y)(x)

  def appended(pixelLine: IndexedSeq[P]): PixelGrid[P] = {
    new PixelGrid[P](pixels.appended(pixelLine))
  }
}