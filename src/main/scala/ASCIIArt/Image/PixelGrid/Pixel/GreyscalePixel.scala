package ASCIIArt.Image.PixelGrid.Pixel

/**
 * A specialized class for a single Greyscale pixel
 * Brightness attribute represents the pixels brightness
 * Can be constructed using an Int or a List of other Greyscale pixels, combining their brightness using a PixelUtils method
 * @param brightness
 */
case class GreyscalePixel(brightness: Int) extends Pixel {

  def this(pixels: List[GreyscalePixel]) {
    this(PixelUtils.CombineGreyscalePixels(pixels).brightness)
  }

  override def clamp(): GreyscalePixel = {
    if (brightness > 255)
      return GreyscalePixel(255)
    else if (brightness < 0)
      return GreyscalePixel(0)
    this
  }
}
