# ASCII Art


The idea of this project is to load images, translate them into ASCII ART images, optionally apply filters, and save them. (https://courses.fit.cvut.cz/BI-OOP/projects/ASCII-art.html)

## How to use this program

- Launch `sbt`
- use command `run` with the desired parameters/options:

### Options:

#### Image loading:

- `--image-random` => generates a random image
- `--image <path>` => loades image from given path (currently supported formats are JPG, PNG and GIF)

#### Output mode:

- `--output-console` => prints the output to the console
- `--output-file <path>` => prints the output to given path

#### Filters:

- `--rotate <degrees>` => rotates the image around the amount of degress given (currently supported degrees are 90, 180, 270 and multiples of 360)
- `--flip <axis>` => flips the image on a given axis (axis are x and y)
- `--brightness <amount>` => imcreases the images brightness by the given amount
- `--inverse` => inverses the images brightness
- `--scale <amount>` => scales the image by the given amount (currently supported scales are 0.25, 1 and 4)

### Examples:
`run --image resources/seagull.jpg --output-console`

`run --image resources/test_gradient.png --scale 4 --rotate 180 --brightness 20 --invert --flip x --scale 0.25 --output-file output/gradient.txt`
