package ASCIIArt.Image.PixelGrid.Pixel

case class RGBPixel(red: Int, green: Int, blue: Int) extends Pixel {

  def this(colour: Int) =
    this(
      colour & 0xff0000, // red
      (colour & 0x00ff00) >> 8, // green
      (colour & 0x0000ff) >> 16 // blue
    )

  override def clamp(): RGBPixel = {
    // clamp red
    var newRed = if (red > 255) 255 else red
    newRed = if (red < 0) 0 else red
    // clamp green
    var newGreen = if (green > 255) 255 else green
    newGreen = if (green < 0) 0 else green
    // clamp blue
    var newBlue = if (blue > 255) 255 else blue
    newBlue = if (blue < 0) 0 else blue
    RGBPixel(newRed, newGreen, newBlue)
  }
}
