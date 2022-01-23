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
        var s = readInt()
        var nums = ArrayDeque<Int>()
        var mexprefs = ArrayDeque<Int>()
        var out = ArrayList<Int>()
        for(i in 0 until s) {
            nums.add(readInt())
        }

        //mex prefixes
        var numseen = mutableSetOf<Int>()
        var start = 0
        for(i in s-1 downTo 0 ) {
            if(nums[i] == start) {
                numseen.add(nums[i])
                var nextmex = getMex(numseen, start)
                mexprefs.addFirst(nextmex)
                for(j in start..nextmex) {
                    numseen.remove(j)
                }
                start = nextmex

            } else if(nums[i] > start) {
                numseen.add(nums[i])
                mexprefs.addFirst(start)
            } else {
                mexprefs.addFirst(start)
            }
        }


        numseen = mutableSetOf<Int>()
        var needed = -1
        for(i in 0 until nums.size) {
            if(needed == -1) {
                needed = mexprefs[i]
            }
            if(nums[i] < needed) {
                numseen.add(nums[i])
            }
            if(numseen.size == needed) {
                out.add(needed)
                numseen = mutableSetOf<Int>()
                needed = -1
            }
        }
        println(out.size)
        println(out.joinToString(" "))

    }
}

fun getMex(nums : Set<Int>, start : Int) : Int {
    for(i in start until start + nums.size+1) {
        if(!nums.contains(i)) {
            return i;
        }
    }
    return start + nums.size
}