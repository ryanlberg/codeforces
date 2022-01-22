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
        var l = readInt()
        var r = readInt()
        var k = readInt()
        var evens = 0
        var odds = 0
        if(l == r && l != 1) {
            println("YES")
        } else {
            if(l % 2 == 0 && r % 2 == 0) {
                evens = (r-l)/2 + 1
                odds = evens-1
            } else if(l % 2 != 0 && r % 2 != 0) {
                odds = (r-l)/2 + 1
                evens = odds-1
            } else {
                odds = (r-l + 1)/2
                evens = odds
            }

            if(odds <= k) {
                println("YES")
            } else {
                println("NO")
            }
        }
    }
}