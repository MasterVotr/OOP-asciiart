package ASCIIArt.Controller.Command

import ASCIIArt.Image.Image
import ASCIIArt.Image.PixelGrid.Pixel.Pixel

trait Command[P <: Pixel] {
  def Execute(target: Image[P]): Image[P]
}
