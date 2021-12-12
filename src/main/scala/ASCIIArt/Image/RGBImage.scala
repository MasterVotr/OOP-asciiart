package ASCIIArt.Image

import ASCIIArt.Image.PixelGrid.Pixel.RGBPixel
import ASCIIArt.Image.PixelGrid.PixelGrid

case class RGBImage(pixelGrid: PixelGrid[RGBPixel])
    extends Image[RGBPixel](pixelGrid) {}
