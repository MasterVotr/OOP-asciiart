package ASCIIArt.Controller.Command

import ASCIIArt.Image.PixelGrid.Pixel.GreyscalePixel

/**
 * Traait for commands that execute on greyscale images
 */
trait GreyscaleCommand extends Command[GreyscalePixel] {}
