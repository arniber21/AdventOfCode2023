import java.io.File

fun main() {
    // Get input
    val lineList = mutableListOf<String>()

    File("stc/Day3input.txt").useLines { lines -> lines.forEach { lineList.add(it) }}


}