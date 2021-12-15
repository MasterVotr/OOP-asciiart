package ASCIIArt.Controller.Command

import ASCIIArt.Image.Image
import ASCIIArt.Image.PixelGrid.Pixel.Pixel

/**
 * Basic trait for commands, with and Execute method that takes in an Image[P] and return an Image[P] processed by the command
 * @tparam P
 */
trait Command[P <: Pixel] {
  def Execute(target: Image[P]): Image[P]
}
