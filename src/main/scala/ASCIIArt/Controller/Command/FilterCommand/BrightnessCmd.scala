package ASCIIArt.Controller.Command.FilterCommand

import ASCIIArt.Filter.PixelFilter.BrightnessFilter
import ASCIIArt.Image.GreyscaleImage

class BrightnessCmd(change: Int) extends FilterCommand {
  override def Execute(target: GreyscaleImage): Unit =
    target.ApplyPixelFilter(new BrightnessFilter(change))
}
