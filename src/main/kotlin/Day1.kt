import java.io.File
import java.lang.Math.pow
import java.util.*
import kotlin.math.log10
import kotlin.math.pow
fun convertStringToInt(input: String): Long {
    val digitMap = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9
    )

    val result = StringBuilder()
    for (i in input.indices) {
        for (j in i + 1..input.length) {
            val subString = input.substring(i, j)
            if(subString.length == 1 && subString[0].isDigit()) {
                result.append(subString[0])
            }
            val digitValue = digitMap[subString]
            if (digitValue != null) {
                result.append(digitValue)
            }
        }
    }

    return result.toString().toLong()
}


fun main() {
    // setup line list
    val lineList = mutableListOf<String>()

    // Read from file into lineList
    File("src/Day1input.txt").useLines { lines -> lines.forEach{ lineList.add(it) } }

    // digit list
    val digitList = lineList.map { convertStringToInt(it) }
    // convert digit list to just have first and last
    // we already know first is preserved, so we just take last
    println(digitList)
    val valueList = digitList.map {
        val output = it % 10
        val base = log10(it.toDouble()).toInt();
        val lastDigit = it / (10.0).pow(base.toDouble()).toInt()
        output + lastDigit * 10
    }
    println(valueList)

    // now we sum
    val sum = valueList.reduce { x, y -> x + y }
    println(sum);
}