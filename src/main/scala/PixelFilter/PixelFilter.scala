package PixelFilter

import Image.PixelGrid.Pixel.Pixel

trait PixelFilter[P <: Pixel] {
    def applyFiler(pixel: P): Unit
}
