package ASCIIArt.Image.PixelGrid.Pixel

/**
 * Abstract class representing a single pixel
 */
abstract class Pixel {

  /**
   * Method for clamping pixel values, so they don't go out their predetermined range
   * @return
   */
  def clamp(): Pixel
}
