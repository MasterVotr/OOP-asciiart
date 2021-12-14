package ASCIIArt.Image.PixelGrid.Pixel

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
