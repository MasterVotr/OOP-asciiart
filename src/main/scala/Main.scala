import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import scala.util.control.Breaks.{break, breakable}

object Main extends App {
    // Process arguments
    if (args.isEmpty) {
        println("Usage: run --image <img>")
        sys.exit()
    }
    var image_address: String = ""
    var skipNext: Boolean = false;
    for (n <- 0 to args.length - 1) {
        breakable {
        println("Arg " + n + " = " + args(n))
            if (skipNext) {
            skipNext = false
            break
        }
        args(n) match {
            case "--image" =>
                if (image_address != "") {
                    println("More than one --image argument!")
                    sys.exit()
                } else {
                    if (args.length > n + 1) {
                        image_address = args(n + 1)
                        skipNext = true
                    } else {
                        println("Image address not provided!")
                        sys.exit()
                    }
                }
            case _ =>
                println("Command not recognized")
                sys.exit()
        }
    }
    }

    // Load image from image path
    println("Loading image")
    val inputedImage = ImageIO.read(new File(image_address))
    val w = inputedImage.getWidth()
    val h = inputedImage.getHeight()

    // Make image greyscale
    println("Making image greyscale")
    def makeGreyScale(img: BufferedImage): BufferedImage = {
        for (x <- 0 until  w; y <- 0 until h) {
            val color = img.getRGB(x, y)
            val red = (color & 0xff0000) / 65536
            val green = (color & 0x00ff00) / 256
            val blue = (color & 0x0000ff)
            val gray: Int = ((0.3 * red) + (0.59 * green) + (0.11 * blue)).toInt
            img.setRGB(x, y, new Color(gray, gray, gray).getRGB)
        }
        img
    }
    val imageGS = makeGreyScale(inputedImage)

    // Apply filters

    // Convert to ASCII
    println("Converting to ascii")
    var ascii_img = Array.ofDim[Char](2, 2)
    def pixel2char(pixel: Int): Char = {
        val conversionTable = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "
        val oneCharRange = (0x0000ff / conversionTable.length)
        val pixel_val = (pixel & 0x0000ff)
        conversionTable(conversionTable.length - (pixel_val / oneCharRange))
    }
    for (x <- 0 until  w; y <- 0 until h) {
        ascii_img(x)(y) = pixel2char(imageGS.getRGB(x, y))
    }

    // Display/Save to a file
    println("Displaying")
    print(ascii_img)
}