package ASCIIArt.Image

import ASCIIArt.Image.PixelGrid.Pixel.RGBPixel
import ASCIIArt.Image.PixelGrid.RGBPixelGrid

case class RGBImage(pixelGrid: RGBPixelGrid) extends Image[RGBPixel](pixelGrid) {}
