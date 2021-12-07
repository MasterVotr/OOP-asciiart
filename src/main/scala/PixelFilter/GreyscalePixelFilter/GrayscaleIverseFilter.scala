package PixelFilter.GreyscalePixelFilter

import Image.PixelGrid.Pixel.GreyscalePixel
import PixelFilter.PixelFilter

class GrayscaleIverseFilter extends PixelFilter[GreyscalePixel]{
    override def applyFiler(pixel: GreyscalePixel): Unit = {
        pixel.brightness = 255 - pixel.brightness
    }
}
