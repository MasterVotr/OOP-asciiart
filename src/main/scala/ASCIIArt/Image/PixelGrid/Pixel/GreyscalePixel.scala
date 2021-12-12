package ASCIIArt.Image.PixelGrid.Pixel

case class GreyscalePixel(brightness: Int) extends Pixel {

  def this(pixels: List[GreyscalePixel]) {
    this(PixelUtils.CombineGreyscalePixels(pixels).brightness)
  }

  override def clamp(): GreyscalePixel = {
    if (brightness > 255) {
      GreyscalePixel(255)
    } else {
      if (brightness < 0) {
        GreyscalePixel(0)
      } else {
        this
      }
    }
  }
}
