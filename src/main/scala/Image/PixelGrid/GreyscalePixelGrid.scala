package Image.PixelGrid

import Image.PixelGrid.Pixel.GreyscalePixel

class GreyscalePixelGrid (_width: Int, _height: Int, _pixels: Array[Array[GreyscalePixel]])
    extends PixelGrid[GreyscalePixel] (_width, _height, _pixels) {
}
