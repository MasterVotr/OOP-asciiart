package ASCIIArt.Image.PixelGrid.Pixel

/**
 * Object holding utilization methods for Pixels
 */
object PixelUtils {

  /**
   * Method used for combining multiple Greyscale pixels into one
   * @param pixels
   * @return
   */
  def CombineGreyscalePixels(pixels: List[GreyscalePixel]): GreyscalePixel = {
    if (pixels.isEmpty)
      throw new Exception("Cannot combine 0 pixels!")
    var sumBrightness = 0
    for (pixel <- pixels)
      sumBrightness += pixel.brightness
    GreyscalePixel(sumBrightness / pixels.length).clamp()
  }
}
