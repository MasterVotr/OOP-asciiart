package ASCIIArt.Image.PixelGrid.Pixel

case class GreyscalePixel(brightness: Int) extends Pixel {

  def this(pixels: List[GreyscalePixel]) {
    this(PixelUtils.CombineGreyscalePixels(pixels).brightness)
  }

  override def clamp(): GreyscalePixel = {
    var newBrightness = if (brightness > 255) 255 else brightness
    newBrightness = if (brightness < 0) 0 else brightness
    GreyscalePixel(newBrightness)
  }
}
