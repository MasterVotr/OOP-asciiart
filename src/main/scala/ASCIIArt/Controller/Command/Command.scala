package ASCIIArt.Controller.Command

import ASCIIArt.Image.GreyscaleImage

trait Command {
  def Execute(target: GreyscaleImage): Unit
}
