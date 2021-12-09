package ASCIIArt.Controller.Command.FilterCommand

import ASCIIArt.Filter.PixelFilter.InverseFilter
import ASCIIArt.Image.GreyscaleImage

class InverseCmd extends FilterCommand {
  override def Execute(target: GreyscaleImage): Unit =
    target.ApplyPixelFilter(new InverseFilter())
}
