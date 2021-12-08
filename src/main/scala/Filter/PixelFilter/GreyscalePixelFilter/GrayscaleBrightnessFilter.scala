package Filter.PixelFilter.GreyscalePixelFilter

import Image.PixelGrid.Pixel.GreyscalePixel
import Filter.PixelFilter.PixelFilter

class GrayscaleBrightnessFilter(val amount: Int) extends PixelFilter[GreyscalePixel]{
    override def applyFiler(pixel: GreyscalePixel): Unit = {
        pixel.brightness += amount
        pixel.clamp()
    }
}
