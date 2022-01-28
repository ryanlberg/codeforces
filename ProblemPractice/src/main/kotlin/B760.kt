import java.io.PrintWriter
import java.util.StringTokenizer
import kotlin.math.*
import kotlin.random.*
import kotlin.collections.*

private val INPUT = System.`in`
private val OUTPUT = System.out

private val bufferedReader = INPUT.bufferedReader()
private val outputWriter = PrintWriter(OUTPUT, false)
private  fun readLn() = bufferedReader.readLine()!!

private fun readList() = readLn().split(' ')
private var tokenizer = StringTokenizer("")
private fun read(): String {
    while(tokenizer.hasMoreTokens().not()) tokenizer = StringTokenizer(readLn(), " ")
    return tokenizer.nextToken()
}

private fun readInt() = read().toInt()
private fun readLong() = read().toLong()
private fun readDouble() = read().toDouble()

private fun readIntList() = readList().map { it.toInt() }
private fun readLongList() = readList().map { it.toLong() }
private fun readDoubleList() = readList().map { it.toDouble() }

private fun readIntArray(n: Int = 0) =
    if (n == 0) readList().run { IntArray(size) { get(it).toInt() } } else IntArray(n) { readInt() }

private fun readLongArray(n: Int = 0) =
    if (n == 0) readList().run { LongArray(size) { get(it).toLong() } } else LongArray(n) { readLong() }

private fun readDoubleArray(n: Int = 0) =
    if (n == 0) readList().run { DoubleArray(size) { get(it).toDouble() } } else DoubleArray(n) { readDouble() }


private fun Int.modPositive(other: Int): Int = if (this % other < 0) ((this % other) + other) else (this % other)



fun main(args: Array<String>) {
    var cases : Int = readInt()
    repeat(cases) {
        var totlets = readInt()
        var out = ""
        var lets = readLn().split(' ')
        if(lets.size == 1) {
            out = lets[0]
            out += 'a'
        } else {
            var added = false
            for (i in 0 until lets.size) {
                if (i == 0) {
                    out += lets[i][0]
                    if (lets[i][1] != lets[i + 1][0]) {
                        out += lets[i][1]
                        added = true
                    }
                } else if (i == lets.size - 1) {
                    out += lets[i]
                } else {
                    out += lets[i][0]
                    if (lets[i][1] != lets[i + 1][0]) {
                        out += lets[i][1]
                        added = true
                    }
                }
            }
            if(!added) {
                out += 'a'
            }
        }
        println(out)
    }
}