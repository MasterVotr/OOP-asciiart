package ASCIIArt.Controller.Command.FilterCommand

import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import ASCIIArt.Image.{GreyscaleImage, Image}
import ASCIIArt.ImageFilter.PixelFilterer.GreyscalePixelFilterer
import ASCIIArt.ImageFilter.PixelFilterer.PixelFilter.InversePixelFilter

class InverseCmd extends FilterCommand {
  override def Execute(target: Image[GreyscalePixel]): Image[GreyscalePixel] =
    new GreyscalePixelFilterer(new InversePixelFilter).apply(target)
}
