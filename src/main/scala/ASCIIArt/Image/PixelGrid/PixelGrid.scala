package ASCIIArt.Image.PixelGrid

import ASCIIArt.Filter.ImageFilter.TransformFilter._
import ASCIIArt.Filter.PixelFilter.{PixelFilter, PixelFilterable}
import ASCIIArt.Image.PixelGrid.Pixel.Pixel

import scala.collection.mutable.ArrayBuffer

abstract class PixelGrid[P <: Pixel]
    extends Flipable
    with Rotable
    with Scalable
    with PixelFilterable[P] {

  var width: Int
  var height: Int
  protected var pixels: Array[Array[P]]

  def this(_width: Int, _height: Int, _pixels: Array[Array[P]]) = {
    this()
    // Check received resolution
    if (_width < 1 || _height < 1)
      throw new Exception("Resolution cannot be <= 0!")
    // Check pixels array resolution
    if (pixels.length != _height)
      throw new Exception("Pixels, wrong height!")
    for (line <- _pixels)
      if (line.length != _width)
        throw new Exception("Pixels, wrong width!")
    this.width = _width
    this.height = _height
    this.pixels = _pixels
  }

  override def ApplyPixelFilter(filter: PixelFilter[P]): Unit =
    for (y <- 0 until height)
      for (x <- 0 until width)
        filter.applyFiler(pixels(y)(x))

  def Flip(flipAxis: FlipAxisEnum): Unit =
    flipAxis match {
      case FlipX => this.XFlip()
      case FlipY => this.YFlip()
      case _     => throw new Exception("Unknown flip!")
    }

  def XFlip(): Unit = {
    val newPixels = ArrayBuffer[Array[P]]()
    for (y <- 0 until height) {
      val pixelLine = ArrayBuffer[P]()
      for (x <- 0 until width)
        pixelLine.addOne(pixels(height - y - 1)(x))
      newPixels.addOne(pixelLine.toArray)
    }
    pixels = newPixels.toArray
  }

  def YFlip(): Unit = {
    val newPixels = ArrayBuffer[Array[P]]()
    for (y <- 0 until height) {
      val pixelLine = ArrayBuffer[P]()
      for (x <- 0 until width)
        pixelLine.addOne(pixels(y)(width - x - 1))
      newPixels.addOne(pixelLine.toArray)
    }
    pixels = newPixels.toArray
  }

  def Rotate(rotation: RotationEnum): Unit =
    rotation match {
      case Rot90 => Rotate90deg()
      case Rot180 =>
        Rotate90deg()
        Rotate90deg()
      case Rot270 =>
        Rotate90deg()
        Rotate90deg()
        Rotate90deg()
      case _ => throw new Exception("Unknown rotation!")
    }

  def Rotate90deg(): Unit = {
    val newPixels = ArrayBuffer[Array[P]]()
    for (x <- 0 until width) {
      val pixelLine = ArrayBuffer[P]()
      for (y <- 0 until height)
        pixelLine.addOne(pixels(height - y - 1)(x))
      newPixels.addOne(pixelLine.toArray)
    }
    val swap = height
    height = width
    width = swap
    pixels = newPixels.toArray
  }

  def Scale(scale: ScalingEnum): Unit =
    scale match {
      case ScaleHalf   => this.HalfScale()
      case ScaleDouble => this.DoubleScale()
      case ScaleFull   => Unit
      case _           => throw new Exception("Unknown scale!")
    }

  def HalfScale(): Unit = {
    val newPixels = ArrayBuffer[Array[P]]()
    for (y <- 0 until height / 2) {
      val pixelLine = ArrayBuffer[P]()
      for (x <- 0 until width / 2) {
        val pixelsToCombine = List[P]()
        pixelsToCombine
          .appended(pixels(2 * y)(2 * x))
          .appended(pixels(2 * y)(2 * x + 1))
          .appended(pixels(2 * y + 1)(2 * x))
          .appended(pixels(2 * y + 1)(2 * x + 1))
        pixelLine.addOne(CombinePixels(pixelsToCombine))
      }
      newPixels.addOne(pixelLine.toArray)
    }
    height /= 2
    width /= 2
    pixels = newPixels.toArray
  }

  def DoubleScale(): Unit = {
    val newPixels = ArrayBuffer[Array[P]]()
    for (y <- 0 until height) {
      val pixelLine = ArrayBuffer[P]()
      for (x <- 0 until width) {
        pixelLine.addOne(pixels(y)(x))
        pixelLine.addOne(pixels(y)(x))
      }
      newPixels.addOne(pixelLine.toArray)
      newPixels.addOne(pixelLine.toArray)
    }
    height *= 2
    width *= 2
    pixels = newPixels.toArray
  }

  def getPixel(x: Int, y: Int): P =
    pixels(y)(x)

  def CombinePixels(pixels: List[P]): P
}
