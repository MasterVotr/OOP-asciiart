package ASCIIArt.Controller.Command.FilterCommand

import ASCIIArt.Image.Image
import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel
import ASCIIArt.ImageFilter.TransformFilter.FlipFilter.{FlipX, FlipY, GreyscaleFlipFilter}

/**
 * Filter commands that uses a flip filter to process a given image and return the result
 * @param axis
 */
class FlipCmd(axis: String) extends FilterCommand {
  override def Execute(target: Image[GreyscalePixel]): Image[GreyscalePixel] =
    axis match {
      case "x" => new GreyscaleFlipFilter(FlipX).apply(target)
      case "y" => new GreyscaleFlipFilter(FlipY).apply(target)
      case _   => throw new Exception("Invalid axis!")
    }
}
