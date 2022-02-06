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

fun printBoard(row : Int, col : Int) {
    var out = ""
    var odd = 1
    var even = 2
    for(i in 0 until row) {
        for(j in 0 until col) {
            if(i % 2 == 0) {
                out += odd.toString() + " "
                odd += 2
            }  else {
                out+= even.toString() + " "
                even += 2
            }
        }
        if(i != row-1) {
            out += "\n"
        }
    }
    println(out)
}

fun main(args: Array<String>) {
    var cases = readInt()
    var candos = mutableSetOf<Int>()
    for(i in 0 until 18) {
        candos.add(Math.pow(2.toDouble(), i.toDouble()).toInt())
    }
    repeat(cases) {
        var row = readInt()
        var col = readInt()
        if(col == 1) {
            println("YES")
            printBoard(row, col)
        } else if(row % 2 != 0 || col % 2 != 0) {
            println("NO")
        } else {

            println("YES")
            printBoard(row, col)


        }
    }
}