package Filter.PixelFilter.GreyscalePixelFilter

import Image.PixelGrid.Pixel.GreyscalePixel
import Filter.PixelFilter.PixelFilter

class GrayscaleIverseFilter extends PixelFilter[GreyscalePixel]{
    override def applyFiler(pixel: GreyscalePixel): Unit = {
        pixel.brightness = 255 - pixel.brightness
    }
}
