package ASCIIArt.Controller.Command.FilterCommand

import ASCIIArt.Image.Image
import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import ASCIIArt.ImageFilter.PixelFilterer.GreyscalePixelFilterer
import ASCIIArt.ImageFilter.PixelFilterer.PixelFilter.BrightnessPixelFilter

/**
 * Filter commands that uses a pixel filterer and a brightness filter to process a given image and return the result
 * @param change
 */
class BrightnessCmd(change: String) extends FilterCommand {
  override def Execute(target: Image[GreyscalePixel]): Image[GreyscalePixel] =
    new GreyscalePixelFilterer(new BrightnessPixelFilter(change.toInt))
      .apply(target)
}
