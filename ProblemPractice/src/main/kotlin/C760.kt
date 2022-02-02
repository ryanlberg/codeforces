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


fun gcd (a: Long, b : Long) : Long {
    if(a == 0.toLong()) return b
    return gcd(b % a, a)
}

fun main() {
    var cases : Int = readInt()
    for(i in 0 until cases) {
        var size : Int = readInt()
        var nums = readLongArray(size)
        var agcd : Long = nums[0]
        var bgcd : Long = nums[1]
        for(x in 2 until size) {
            if(x % 2 == 0) {
                agcd = gcd(agcd, nums[x])
            } else {
                bgcd = gcd(bgcd, nums[x])
            }

        }
        //println("${agcd} ${bgcd}")
        if(agcd == bgcd) {
            println(0)
        } else {
            var cando = true
            for(x in 0 until size step 2) {
                if(nums[x] % bgcd == 0.toLong()) {
                    cando = false
                }
            }
            if(cando) {
                println(bgcd)
                continue
            }
            cando = true
            for(x in 1 until size step 2) {
                if(nums[x] % agcd == 0.toLong()) {
                    cando = false
                }
            }
            if(cando) {
                println(agcd)
            } else {
                println(0)
            }
        }
    }
}