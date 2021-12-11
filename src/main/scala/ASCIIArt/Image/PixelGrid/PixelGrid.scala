package ASCIIArt.Image.PixelGrid

import ASCIIArt.Image.PixelGrid.Pixel.Pixel

abstract class PixelGrid[P <: Pixel] extends IndexedSeq[IndexedSeq[P]] {

  protected var pixels: Vector[Vector[P]] = Vector[Vector[P]]()

  def this(_pixels: Vector[Vector[P]]) = {
    this()
    this.pixels = _pixels
    checkRes()
  }

  def getHeight(): Int = {
    pixels.length
  }

  def getWidth(): Int = {
    pixels(0).length
  }

  def checkRes(): Unit = {
    // Check resolution
    if (getWidth() < 1 || getHeight() < 1)
      throw new Exception("Resolution cannot be <= 0!")
    // Check pixels array resolution
    for (line <- pixels)
      if (line.length != getWidth())
        throw new Exception("Pixels, wrong width!")
  }

  def getPixel(x: Int, y: Int): P =
    pixels(y)(x)

  override def apply(i: Int): IndexedSeq[P] = {
    pixels.apply(i)
  }

  override def length: Int = {
    pixels.length
  }

  def CombinePixels(pixels: List[P]): P
}
