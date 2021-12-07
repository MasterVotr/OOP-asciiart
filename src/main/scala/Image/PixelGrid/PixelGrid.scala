package Image.PixelGrid

import Image.PixelGrid.Pixel.Pixel

abstract class PixelGrid[P <: Pixel] {
    var width: Int = 0
    var height: Int = 0
    private var pixels: Array[Array[P]] = new Array[Array[P]](0)

    def this(_width: Int, _height: Int, _pixels: Array[Array[P]]) = {
        this()
        // Check received resolution
        if (_width < 1 || _height < 1) {
            throw new Exception("Resolution cannot be <= 0!")
        }
        // Check pixels array resolution
        if (pixels.length != _height) {
            throw new Exception("Pixels, wrong height!")
        }
        for (line <- _pixels) {
            if (line.length != _width) {
                throw new Exception("Pixels, wrong width!")
            }
        }
        this.width = _width
        this.height = _height
        this.pixels = _pixels
    }
}
