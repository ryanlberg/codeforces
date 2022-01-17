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

var dists = mutableListOf<Int>()
var speed = mutableListOf<Int>()
var mapper = mutableMapOf<Pair<Int, Int>, Int>()

fun fillMap(i: Int, k : Int, last: Int) : Int{
    if(i > dists.size-1) {
        return 100_000_000
    }else if(i == dists.size-1) {
        return (dists[i] - dists[last]) * speed[last]
    } else if(mapper.containsKey(Pair(i, k))) {
        return mapper[Pair(i, k)]!!
    } else {
        if(i == 0) {
            mapper[Pair(i, k)] = min(fillMap(i+1, k, last), fillMap(i+2, k-1, last))
        }else if(k > 0) {
            mapper[Pair(i, k)] = min((dists[i] - dists[last]) * speed[last] + fillMap(i+1, k, i),
                fillMap(i+1, k-1, last))
        } else {
            mapper[Pair(i, k)] = fillMap(i+1, k, i) + (dists[i] - dists[last]) * speed[last]
        }
        return mapper[Pair(i, k)]!!
    }

}

fun main(args: Array<String>) {
    var n = readInt()
    var l = readInt()
    var k = readInt()
    for(i in 0 until n) {
        dists.add(readInt())
    }
    dists.add(l)

    for(i in 0 until n) {
        speed.add(readInt())
    }

    speed.add(-1)

    println(fillMap(0, k, 0))

}