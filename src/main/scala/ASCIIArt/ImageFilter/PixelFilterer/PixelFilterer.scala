package ASCIIArt.ImageFilter.PixelFilterer

import ASCIIArt.Image.PixelGrid.Pixel.Pixel
import ASCIIArt.ImageFilter.ImageFilter
import ASCIIArt.ImageFilter.PixelFilterer.PixelFilter.PixelFilter

abstract class PixelFilterer[P <: Pixel](pixelFilter: PixelFilter[P])
    extends ImageFilter[P] {}
