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
    var output = arrayListOf<String>()
    repeat(cases) {
        output = arrayListOf<String>()
        var n = readInt()
        var k = readInt()
        var start = 1
        var end = n-2
        if(k == n-1 && n == 4) {
            println(-1)
        } else if(k == n-1) {
            start = 0
            end = n-1
            var twos = arrayListOf<Pair<Int, Int>>()
            while(start < end) {
                if (start.countOneBits() == 1 || end.countOneBits() == 1) {
                    if (start.countOneBits() == 1) {
                        twos.add(Pair(start, end))
                    } else {
                        twos.add(Pair(end, start))
                    }

                } else {
                    output.add(start.toString() + " " + end.toString())
                }
                start++
                end--
            }
            var temp = twos.get(twos.size-1).second
            for(i in 0 until twos.size) {
                output.add(twos.get(i).first.toString() + " " + temp.toString())
                temp = twos.get(i).second
            }
            println(output.joinToString( "\n" ))

        } else {
                output.add((n-1).toString() + " " + k.toString())
                while(start < end) {
                    if(start == k || end == k) {
                        if(start == k) {
                            output.add(end.toString() + " 0")
                        } else {
                            output.add(start.toString() + " 0")
                        }
                    } else {
                        output.add(start.toString() +  " " + end.toString())
                    }
                    start++
                    end--
                }
                println(output.joinToString( "\n" ))
        }
    }
}