package ASCIIArt.Controller.Command.FilterCommand

import ASCIIArt.Filter.ImageFilter.TransformFilter.{FlipX, FlipY}
import ASCIIArt.Image.GreyscaleImage

class FlipCmd(axis: String) extends FilterCommand {
  override def Execute(target: GreyscaleImage): Unit =
    axis match {
      case "x" => target.Flip(FlipX)
      case "y" => target.Flip(FlipY)
      case _   => throw new Exception("Invalid axis!")
    }
}
