package ASCIIArt.Image

import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import ASCIIArt.Image.PixelGrid.PixelGrid

case class GreyscaleImage(pixelGrid: PixelGrid[GreyscalePixel])
    extends Image[GreyscalePixel](pixelGrid) {}
