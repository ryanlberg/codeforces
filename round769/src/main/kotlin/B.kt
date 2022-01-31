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
    var cases : Int = readInt()
    repeat(cases) {
        var pillars : Int = readInt()
        var logtester = pillars -1
        var maxcando = 0
        while(logtester > 1) {
            maxcando++
            logtester /= 2
        }

        var outlist : MutableList<Int> = mutableListOf<Int>()

        var max = 0
        if(maxcando == 0) {
            max = 0
        } else {

            max = 2
            for(i in 1 until maxcando) {

                max *= 2
            }
        }

        for(i in 1 until max) {
            outlist.add(i)
        }
        if(max != 0) {
            outlist.add(0)
        }
        for(i in max until pillars) {
            outlist.add(i)
        }


        println(outlist.joinToString(" "))




    }
}