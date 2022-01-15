import java.io.PrintWriter
import java.util.StringTokenizer
import kotlin.math.*
import kotlin.random.*
import kotlin.collections.*
import java.util.*

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
        var vertices = readInt()
        var pairs = arrayListOf<IntArray>()
        var g = mutableMapOf<Int, MutableSet<Int>>()
        repeat(vertices-1) {
            var from = readInt()
            var to = readInt()
            pairs.add(intArrayOf(from,  to))
            if(!g.containsKey(from)) {
                g[from] = mutableSetOf<Int>()
            }
            if(!g.containsKey(to)) {
                g[to] = mutableSetOf<Int>()
            }
            g[from]!!.add(to)
            g[to]!!.add(from)
        }


        if(vertices > 4) {
            println(-1)
        } else if(vertices == 2) {
            println(2)
        } else if(vertices == 3) {
            println(2.toString() + " " + 3.toString())
        } else {
            var twoset = mutableSetOf<Int>()
            var cando = true
            for(v in g) {
                if(g[v.key]!!.size > 2) {
                    cando = false
                    break;

                }
            }
            if(cando) {

                for(v in g) {
                    if(g[v.key]!!.size == 2) {
                        twoset.add(v.key)
                    }
                }
                var twolist = twoset.toList()
                for(pair in pairs) {
                    if(twoset.contains(pair[0]) && twoset.contains(pair[1])) {
                        print(2)
                        print(" ")
                    } else if(twolist[0] == pair[0] || twolist[0] == pair[1]){
                        print(5)
                        print(" ")
                    } else {
                        print(11)
                        print(" ")
                    }
                }
                println()

            }

        }
    }
}

