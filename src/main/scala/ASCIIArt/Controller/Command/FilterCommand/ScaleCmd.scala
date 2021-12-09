package ASCIIArt.Controller.Command.FilterCommand

import ASCIIArt.Filter.ImageFilter.TransformFilter.{ScaleDouble, ScaleFull, ScaleHalf}
import ASCIIArt.Image.GreyscaleImage

class ScaleCmd(scale: Double) extends FilterCommand {
  override def Execute(target: GreyscaleImage): Unit =
    scale match {
      case 0.25 => target.Scale(ScaleHalf)
      case 1    => target.Scale(ScaleFull)
      case 4    => target.Scale(ScaleDouble)
      case _    => throw new Exception("Invalid scaling factor!")
    }
}
