package Image.PixelGrid.Pixel

class GreyscalePixel (var brightness: Int) extends Pixel {
    override def clamp(): Unit = {
        this.brightness = if (brightness > 255) 255 else brightness
        this.brightness = if (brightness < 0) 0 else brightness
    }
}
