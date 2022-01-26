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
    var cases = readInt()
    repeat(cases) {
        var w = readInt()
        var h = readInt()

        var bottom : MutableList<Long> = mutableListOf<Long>()
        var top : MutableList<Long> = mutableListOf<Long>()
        var left : MutableList<Long> = mutableListOf<Long>()
        var right : MutableList<Long> = mutableListOf<Long>()

        var curside = readInt()
        for(i in 0 until curside) {
            bottom.add(readLong())
        }
        curside = readInt()
        for(i in 0 until curside) {
            top.add(readLong())
        }
        curside = readInt()
        for(i in 0 until curside) {
            left.add(readLong())
        }
        curside = readInt()
        for(i in 0 until curside) {
            right.add(readLong())
        }

        var maximum : Long = 0

        maximum = max(maximum, (bottom.last() - bottom.first()) * h )
        maximum = max(maximum, (top.last() - top.first()) * h)
        maximum = max(maximum, (left.last() - left.first()) * w)
        maximum = max(maximum, (right.last() - right.first()) * w)

        println(maximum)

    }

}