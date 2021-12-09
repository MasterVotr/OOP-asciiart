package ASCIIArt.Image

import ASCIIArt.Image.PixelGrid.Pixel.RGBPixel
import ASCIIArt.Image.PixelGrid.RGBPixelGrid

class RGBImage(pixelGrid: RGBPixelGrid) extends Image[RGBPixel](pixelGrid) {}
