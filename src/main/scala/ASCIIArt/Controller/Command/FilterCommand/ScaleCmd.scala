package ASCIIArt.Controller.Command.FilterCommand

import ASCIIArt.Image.{GreyscaleImage, Image}
import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import ASCIIArt.ImageFilter.TransformFilter.ScaleFilter.{ScaleDouble, ScaleFilterGreyscale, ScaleFull, ScaleHalf}

class ScaleCmd(scale: Double) extends FilterCommand {
  override def Execute(target: Image[GreyscalePixel]): Image[GreyscalePixel] =
    scale match {
      case 0.25 => new ScaleFilterGreyscale(ScaleHalf).apply(target)
      case 1    => new ScaleFilterGreyscale(ScaleFull).apply(target)
      case 4    => new ScaleFilterGreyscale(ScaleDouble).apply(target)
      case _    => throw new Exception("Invalid scaling factor!")
    }
}
