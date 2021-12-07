package PixelFilter.GreyscalePixelFilter

import Image.PixelGrid.Pixel.GreyscalePixel
import PixelFilter.PixelFilter

class GrayscaleBrightnessFilter(val amount: Int) extends PixelFilter[GreyscalePixel]{
    override def applyFiler(pixel: GreyscalePixel): Unit = {
        pixel.brightness += amount
        pixel.clamp()
    }
}
