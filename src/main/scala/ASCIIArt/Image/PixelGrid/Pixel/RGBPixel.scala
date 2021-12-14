package ASCIIArt.Image.PixelGrid.Pixel

case class RGBPixel(red: Int, green: Int, blue: Int) extends Pixel {

  def this(colour: Int) =
    this(
      (colour & 0xff0000) >> 16, // red
      (colour & 0x00ff00) >> 8, // green
      colour & 0x0000ff) // blue

  override def clamp(): RGBPixel = {
    // clamp red
    var newRed = red
    if (red > 255)
      newRed = 255
    else if (red < 0)
      newRed = 0

    // clamp green
    var newGreen = green
    if (green > 255)
      newGreen = 255
    else if (green < 0)
      newGreen = 0

    // clamp blue
    var newBlue = blue
    if (blue > 255)
      newBlue = 255
    else if (blue < 0)
      newBlue = 0

    RGBPixel(newRed, newGreen, newBlue)
  }
}
