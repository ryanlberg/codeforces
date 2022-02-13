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


var numArr = IntArray(0)
var seen = mutableMapOf<Pair<Int, Int>, Int>()
var pairseen = mutableMapOf<Pair<Int, Int>, Int>()
fun mex(i : Int , j : Int) : Int {

    var pair = Pair(i, j)
    if(seen.contains(pair)) {
        return seen[pair]!!
    }

    var numset = mutableSetOf<Int>()
    for(x in i until j) {
        if(x < numArr.size) {
            numset.add(numArr[x])
        }
    }
    for(i in 0 .. j - i + 2) {
        if(!numset.contains(i)) {
            seen[pair] = i
            return i
        }
    }
    seen[pair] = j - i + 1
    return j - i + 1

}


fun getBest(i : Int, j : Int) : Int {
    if(i == j) {
        return 0
    }
    var pair = Pair(i, j)
    if(pairseen.contains(pair)) {
        return pairseen[pair]!!
    }
    if(j - i == 1) {
        return 1 + mex(i, j)
    }
    var max = 0
    for(k in i+1 .. j) {
        max = max(max, 1 + mex(i, k) + getBest(k, j))

    }
    pairseen[pair] = max
    return max
}


fun main(args: Array<String>) {
    var cases = readInt()
    repeat(cases) {
        var nums = readInt()
        seen = mutableMapOf<Pair<Int, Int>, Int>()
        pairseen = mutableMapOf<Pair<Int, Int>, Int>()
        numArr = readIntArray(nums)
        var totalVal = 0
        for(i in 0 .. nums) {
            for(j in 0 .. nums) {
                //println("${i} ${j}")
                totalVal += getBest(i, j)
            }
        }
        println(totalVal)
    }

}