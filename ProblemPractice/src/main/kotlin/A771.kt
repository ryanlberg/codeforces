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
        var nums = readInt()
        var numbers = readIntArray(nums)
        var temp = numbers.clone()
        temp.sort()
        var needed = -1
        var loc = -1
        for(i in 0 until temp.size) {
            if(temp[i] != numbers[i]) {
                needed = temp[i]
                loc = i
                break
            }
        }
        if(needed == -1) {
            println(numbers.joinToString(" "))
        } else {
            var to = -1
            for(i in 0 until numbers.size) {
                if(numbers[i] == needed) {
                    to = i
                    break
                }
            }

            while(loc < to) {
                var temp = numbers[loc]
                numbers[loc] = numbers[to]
                numbers[to] = temp
                loc++
                to--
            }

            println(numbers.joinToString(" "))

        }

    }
}