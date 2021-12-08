package Filter.ImageFilter

import Image.Image
import _root_.Image.PixelGrid.Pixel.Pixel

trait ImageFilter[P <: Pixel, I <: Image[P]] {
    def apply(image: I) : Unit
}
