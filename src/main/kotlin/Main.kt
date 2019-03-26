import java.io.File
import java.nio.file.Paths

fun getText(): String = "Hello Kotlin"

fun main(args: Array<String>) {
    var f = Paths.get(args[0]).toFile()
    if (f.exists()) {
        f.forEachLine { wordWrap(it, args[1].toInt()).forEach { i -> println("${i.length} $i") } }
    } else {
        throw IllegalArgumentException("しんじゃったよ！")
    }
}

fun wordWrap(mojiretsu:String , wrapmojisu:Int): List<String> {
    val split = mojiretsu.split(" ")
    var counter = 0

    val result: MutableList<String> = MutableList(1) { "" }
    split.forEach {word ->
        if (counter + word.length >= wrapmojisu) {
            result.add("")
            counter = 0
        }
        result[result.lastIndex] += "$word "
        counter = result[result.lastIndex].length
    }
    return result.toList()
}