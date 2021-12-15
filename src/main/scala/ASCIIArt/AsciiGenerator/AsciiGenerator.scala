package ASCIIArt.AsciiGenerator

/**
 * Trait for abstract generation of AsciiArt from object of type T
 * @tparam T
 */
trait AsciiGenerator[T] {
  def generateArt(target: T): String
}
