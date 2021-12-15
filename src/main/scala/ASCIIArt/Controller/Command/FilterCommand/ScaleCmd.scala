package ASCIIArt.Controller.Command.FilterCommand

import ASCIIArt.Image.Image
import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import ASCIIArt.ImageFilter.TransformFilter.ScaleFilter.{ScaleDouble, GreyscaleScaleFilter, ScaleFull, ScaleHalf}

class ScaleCmd(scale: String) extends FilterCommand {
  override def Execute(target: Image[GreyscalePixel]): Image[GreyscalePixel] =
    scale.toDouble match {
      case 0.25 => new GreyscaleScaleFilter(ScaleHalf).apply(target)
      case 1    => new GreyscaleScaleFilter(ScaleFull).apply(target)
      case 4    => new GreyscaleScaleFilter(ScaleDouble).apply(target)
      case _    => throw new Exception("Invalid scaling factor!")
    }
}
