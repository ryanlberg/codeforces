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
    val cases : Int = readInt()
    repeat(cases) {
        var hc = readLong()
        var dc = readLong()
        var hm = readLong()
        var dm = readLong()
        var coins = readLong()
        var attackAdd = readLong()
        var armorAdd = readLong()

        var cando = false
        var attack = coins
        var armor = 0.toLong()
        while(attack >= 0) {
            var tempdc = dc + attack * attackAdd
            var temphc = hc + armor * armorAdd
            if(turnsToKill(tempdc, hm) <= turnsToKill(dm, temphc)) {
                cando = true
                break
            }
            attack--
            armor++
        }
        if(cando) {
            println("YES")
        } else {
            println("NO")
        }
    }



}

fun turnsToKill(attack : Long, health : Long) : Long {
    return if(health % attack == 0.toLong()) {
        health/attack
    } else {
        health/attack + 1
    }
}