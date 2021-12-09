package ASCIIArt.Controller.Command.FilterCommand

import ASCIIArt.Filter.ImageFilter.TransformFilter.{Rot180, Rot270, Rot90}
import ASCIIArt.Image.GreyscaleImage

class RotateCmd(_deg: Int) extends FilterCommand {
  override def Execute(target: GreyscaleImage): Unit = {
    val deg = _deg % 360
    deg match {
      case 90  => target.Rotate(Rot90)
      case 180 => target.Rotate(Rot180)
      case 270 => target.Rotate(Rot270)
      case 0   => Unit
      case _   => throw new Exception("Invalid angle!")
    }
  }
}
