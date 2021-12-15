package ASCIIArt.Controller.Command.FilterCommand

import ASCIIArt.Image.Image
import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import ASCIIArt.ImageFilter.TransformFilter.RotateFilter.{GreyscaleRotateFilter, Rot180, Rot270, Rot90}

/**
 * Filter commands that uses a rotate filter to process a given image and return the result
 * @param _deg
 */
class RotateCmd(_deg: String) extends FilterCommand {
  override def Execute(target: Image[GreyscalePixel]): Image[GreyscalePixel] = {
    val deg = _deg.toInt % 360
    deg match {
      case 90  => new GreyscaleRotateFilter(Rot90).apply(target)
      case 180 => new GreyscaleRotateFilter(Rot180).apply(target)
      case 270 => new GreyscaleRotateFilter(Rot270).apply(target)
      case 0   => target
      case _   => throw new Exception("Invalid angle!")
    }
  }
}
