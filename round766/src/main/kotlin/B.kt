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
        var rows = readInt()
        var cols = readInt()
        var dists = arrayListOf<Int>()
        var corners = arrayOf(intArrayOf(0, 0), intArrayOf(0, cols-1), intArrayOf(rows-1, 0), intArrayOf(rows-1, cols-1))
        for(i in 0..rows-1) {
            for(j in 0..cols-1) {
                var mindist = Integer.MIN_VALUE
                for(corner in corners) {
                    mindist = max(mindist, getDist(i, j, corner[0], corner[1]))
                }
                dists.add(mindist)
            }
        }
        dists.sort()
        for(dist in dists) {
            print(dist)
            print(" ")
        }
        println()
    }
}

fun getDist(a1: Int, a2: Int, b1: Int, b2: Int) : Int {
    return abs(a1 - b1) + abs(a2 - b2)
}