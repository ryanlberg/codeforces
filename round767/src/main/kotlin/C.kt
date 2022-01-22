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
    for(x in 0..cases-1){
        var nums = readInt()
        var numsleft = ArrayDeque<Int>()
        for(i in 0..nums-1) {
            numsleft.add(readInt())
        }

        var maxmex = 0
        var curnums = mutableSetOf<Int>()
        var curneeded = 0
        var out = ArrayList<Int>()
        var curmexloc = 0
        while(numsleft.size > 0) {
            curnums = mutableSetOf<Int>()
            curneeded = 0
            maxmex = 0
            curmexloc = 0
            for(i in 0..numsleft.size-1) {
                if(numsleft.get(i) >= curneeded) {
                    curnums.add(numsleft.get(i))
                }

                if(numsleft.get(i) == curneeded) {
                    maxmex = getMex(curnums, curneeded)
                    for(j in curneeded..maxmex-1) {
                        curnums.remove(j)
                    }
                    curneeded = maxmex
                    curmexloc = i

                }
            }

            out.add(maxmex)
            for(i in 0..curmexloc) {
                numsleft.removeFirst()
            }

        }

        println(out.size)
        println(out.joinToString(" "))



    }
}

fun getMex(nums : Set<Int>, start : Int) : Int {
    for(i in start .. start + nums.size) {
        if(!nums.contains(i)) {
            return i;
        }
    }
    return nums.size
}