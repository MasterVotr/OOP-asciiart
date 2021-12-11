package ASCIIArt.AsciiGenerator

trait AsciiGenerator[T] {
  def generateArt(target: T): String
}
