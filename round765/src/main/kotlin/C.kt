class C {
}import java.io.PrintWriter
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

var dists = IntArray(1)
var speed = IntArray(1)
var mapper = Array(501) {IntArray(500) {Int.MAX_VALUE} }

fun fillMap(i : Int, end: Int, k : Int, total: Int, l: Int) : Int {
    if(end == dists.size-1) {
        return total + (l - dists[i]) * speed[i]
    } else if(mapper[i][k] != Integer.MAX_VALUE) {
        return mapper[i][k]
    } else {
        if(k <= 0) {
            mapper[i][k] = min(mapper[i][k], fillMap(i+1, end+1, k, (dists[i+1] - dists[i]) * speed[i], l))
        } else {
            for(i in 1..min())
        }
    }
}

fun main(args: Array<String>) {
    var n = readInt()
    var l = readInt()
    var k = readInt()
    dists = readIntArray(n)
    speed = readIntArray(n)
    println(mapper[0][0])

}