package ASCIIArt.ImageFilter.PixelFilterer

import ASCIIArt.Image.PixelGrid.Pixel.Pixel
import ASCIIArt.ImageFilter.ImageFilter
import ASCIIArt.ImageFilter.PixelFilterer.PixelFilter.PixelFilter

/**
 * Abstract class for applaying pixel filters to images of given type P
 * @param pixelFilter
 * @tparam P
 */
abstract class PixelFilterer[P <: Pixel](pixelFilter: PixelFilter[P])
    extends ImageFilter[P] {}
