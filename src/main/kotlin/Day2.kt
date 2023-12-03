import java.io.File
import java.util.*

fun compare(value: Int, type: String): Boolean {
    if(type == "red" && value > 12) return false
    if(type == "green" && value > 13) return false
    if(type == "blue" && value > 14) return false
    return true
}

fun getId(line: List<String>): Int {
    return line[0].filter{ it.isDigit() }.toInt()
}

fun getPower(line: List<String>): Int {
    val invoice = line[1]
    var redMax = 1
    var greenMax = 1
    var blueMax = 1
    invoice.split(",", ";").map { s -> s.filter { it != ' ' } }.forEach { memo ->
        val quantity = memo.filter{ it.isDigit() }.toInt()
        val type = memo.filter { !it.isDigit() }.lowercase(Locale.getDefault())
        if(type == "red" && quantity > redMax) redMax = quantity
        if(type == "green" && quantity > greenMax) greenMax = quantity
        if(type == "blue" && quantity > blueMax) blueMax = quantity
    }
    println("${redMax},${greenMax},${blueMax}")
    return redMax * greenMax * blueMax
}

fun main() {
    // Load problem input
    val lineList = mutableListOf<String>()

    File("src/Day2Input.txt").useLines { lines -> lines.forEach { lineList.add(it) }}

    // Split each line by commas
    val lineListParsed = lineList.map { it.split(":") }

    // Filter them
    val lineListFiltered = lineListParsed.filter { line: List<String> ->
        // for part 2
        return@filter true
        // The second item in the array is the one we want
        val lineHeader = line[0]
        val lineInfoRaw = line[1]
        val lineInfo = lineInfoRaw.split(",", ";").map { s -> s.filter { it != ' ' } }

        lineInfo.forEach { memo ->
            val quantity = memo.filter{ it.isDigit() }.toInt()
            val type = memo.filter { !it.isDigit() }.lowercase(Locale.getDefault())
            if(!compare(quantity, type)) return@filter false
        }

        return@filter true
    }

    // Get ids
    val result_pt1 = lineListFiltered.map { getId(it) }.reduce { x, y -> x + y}
    println(result_pt1);
    val result_pt2 = lineListFiltered.map { getPower(it) }.reduce {x, y -> x + y}
    println(result_pt2)

}