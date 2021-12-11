package ASCIIArt.Image

import ASCIIArt.Image.PixelGrid.GreyscalePixelGrid
import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel

case class GreyscaleImage(pixelGrid: GreyscalePixelGrid)
    extends Image[GreyscalePixel](pixelGrid) {}
