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
        var l  = readLn()
        var ln = l.toCharArray()
        var maxloc = 0
        var maxtotal = Character.getNumericValue(ln[0]) + Character.getNumericValue(ln[1])
        for(i in 0..ln.size-2) {
            var curdig = Character.getNumericValue(ln[i]) + Character.getNumericValue(ln[i+1])

            if(curdig >= 10) {
                maxtotal = curdig
                maxloc = i
            }
        }

        var ret  = l.subSequence(0, maxloc)
        var ret2 = maxtotal.toString()
        var ret3 = l.subSequence(maxloc+2, l.length)
        println("${ret}${ret2}${ret3}")


    }

}