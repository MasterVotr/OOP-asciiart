package ASCIIArt.Image

import ASCIIArt.Image.PixelGrid.PixelGrid
import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel

case class GreyscaleImage(pixelGrid: PixelGrid[GreyscalePixel])
    extends Image[GreyscalePixel](pixelGrid) {}
