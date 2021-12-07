package Image.PixelGrid.Pixel

class RGBPixel (var red: Int, var green: Int, var blue: Int) extends Pixel {

    def this(colour: Int) = {
        this(
            colour & 0xff0000,        // red
            (colour & 0x00ff00) >> 8, // green
            (colour & 0x0000ff) >> 16 // blue
        )
    }

    override def clamp(): Unit = {
        // clamp red
        this.red = if (red > 255) 255 else red
        this.red = if (red < 0) 0 else red
        // clamp green
        this.green = if (green > 255) 255 else green
        this.green = if (green < 0) 0 else green
        // clamp blue
        this.blue = if (blue > 255) 255 else blue
        this.blue = if (blue < 0) 0 else blue
    }
}
