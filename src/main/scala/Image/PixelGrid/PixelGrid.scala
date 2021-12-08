package Image.PixelGrid

import Filter.ImageFilter.TransformFilter.{FlipAxisEnum, FlipX, FlipY, Flipable, Rot180, Rot270, Rot90, Rotable, RotationEnum, Scalable, ScaleDouble, ScaleFull, ScaleHalf, ScalingEnum}
import Filter.PixelFilter.PixelFilter
import Image.PixelGrid.Pixel.Pixel

abstract class PixelGrid[P <: Pixel] extends Flipable with Rotable with Scalable {
    var width: Int = 0
    var height: Int = 0
    private var pixels: Array[Array[P]] = new Array[Array[P]](0)

    def this(_width: Int, _height: Int, _pixels: Array[Array[P]]) = {
        this()
        // Check received resolution
        if (_width < 1 || _height < 1) {
            throw new Exception("Resolution cannot be <= 0!")
        }
        // Check pixels array resolution
        if (pixels.length != _height) {
            throw new Exception("Pixels, wrong height!")
        }
        for (line <- _pixels) {
            if (line.length != _width) {
                throw new Exception("Pixels, wrong width!")
            }
        }
        this.width = _width
        this.height = _height
        this.pixels = _pixels
    }

    def ApplyFilter(filter: PixelFilter[P]): Unit = {
        for(y <- 0 until height) {
            for(x <- 0 until width) {
                filter.applyFiler(pixels(y)(x))
            }
        }
    }

    def Flip(flipAxis: FlipAxisEnum): Unit = {
        flipAxis match {
            case FlipX => this.XFlip()
            case FlipY => this.YFlip()
        }
    }

    def XFlip(): Unit = {
        // TODO
    }

    def YFlip(): Unit = {
        // TODO
    }

    def Rotate(rotation: RotationEnum): Unit = {
        rotation match {
            case Rot90 => Rotate90deg()
            case Rot180 => {
                Rotate90deg()
                Rotate90deg()
            }
            case Rot270 => {
                Rotate90deg()
                Rotate90deg()
                Rotate90deg()
            }
        }
    }

    def Rotate90deg(): Unit = {
        // TODO
    }

    def Scale(scale: ScalingEnum): Unit = {
        scale match {
            case ScaleHalf => this.HalfScale()
            case ScaleDouble => this.DoubleScale()
            case ScaleFull => Unit
        }
    }

    def HalfScale(): Unit = {
        // TODO
    }

    def DoubleScale(): Unit = {
        // TODO
    }

    def getPixel(x: Int, y: Int): P = {
        pixels(y)(x)
    }
}
