package ASCIIArt.Image

import ASCIIArt.Image.PixelGrid.Pixel.RGBPixel
import ASCIIArt.Image.PixelGrid.PixelGrid

/**
 * A specialized class of RGB images
 * @param pixelGrid
 */
case class RGBImage(pixelGrid: PixelGrid[RGBPixel])
    extends Image[RGBPixel](pixelGrid) {}
