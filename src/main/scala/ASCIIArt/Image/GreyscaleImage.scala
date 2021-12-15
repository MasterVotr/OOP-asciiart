package ASCIIArt.Image

import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import ASCIIArt.Image.PixelGrid.PixelGrid

/**
 * A specialized class of Greyscale images
 * @param pixelGrid
 */
case class GreyscaleImage(pixelGrid: PixelGrid[GreyscalePixel])
    extends Image[GreyscalePixel](pixelGrid) {}
