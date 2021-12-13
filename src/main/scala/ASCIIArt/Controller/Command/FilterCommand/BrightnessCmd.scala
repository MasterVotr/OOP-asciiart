package ASCIIArt.Controller.Command.FilterCommand

import ASCIIArt.Image.Image
import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import ASCIIArt.ImageFilter.PixelFilterer.GreyscalePixelFilterer
import ASCIIArt.ImageFilter.PixelFilterer.PixelFilter.BrightnessPixelFilter

class BrightnessCmd(change: String) extends FilterCommand {
  override def Execute(target: Image[GreyscalePixel]): Image[GreyscalePixel] =
    new GreyscalePixelFilterer(new BrightnessPixelFilter(change.toInt)).apply(target)
}
