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

fun difference(a : Int, b : Int) : Int {
    var astring = a.toString(2).padStart(Int.SIZE_BITS, '0')
    var bstring = b.toString(2).padStart(Int.SIZE_BITS, '0')
    println("$astring")
    println("$bstring")
    return 0
}

fun main(args: Array<String>) {
    var cases = readLn().toInt()

    repeat(cases) {
        var forms = readInt()
        var letters = readInt()
        var ones = IntArray(32)
        var zeros = IntArray(32)
        for(i in 0..forms-1) {
            var cur = readInt().toString(2).padStart(Int.SIZE_BITS, '0')
            for(j in 0..cur.length-1) {
                if(cur[j] == '0') {
                    zeros[j]++
                } else {
                    ones[j]++
                }
            }
        }
        var out = ""
        for(i in 0..ones.size-1) {
            if(ones[i] > zeros[i]) {
                out += "1"
            } else {
                out += "0"
            }
        }
        println(Integer.parseInt(out, 2))
    }
}