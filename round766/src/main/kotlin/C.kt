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



var cando = true
var mapper = mutableMapOf<Pair<Int, Int>, Int>()
var seen = mutableSetOf<Int>()

fun main(args: Array<String>) {
    var cases = readInt()

    repeat(cases) {
        cando = true
        mapper = mutableMapOf<Pair<Int, Int>, Int>()
        seen = mutableSetOf<Int>()
        var edgeOrder = arrayListOf<Pair<Int, Int>>()

        var graph = mutableMapOf<Int, ArrayList<Int>>()
        var nodes = readInt()
        repeat(nodes-1) {
            var from = readInt()
            var to = readInt()
            edgeOrder.add(Pair(from, to))
            if(!graph.containsKey(from)) {
                graph[from] = ArrayList<Int>()
            }
            if(!graph.containsKey(to)) {
                graph[to] = ArrayList<Int>()
            }
            graph[from]!!.add(to)
            graph[to]!!.add(from)
        }
        dfs(1, -1, graph)
        if(!cando) {
            println(-1)

        } else {
            var outlist = arrayListOf<Int>()
            for (pair in edgeOrder) {
                outlist.add(mapper[pair]!!)
            }
            println(outlist.joinToString(" "))
        }
    }
}

fun dfs(value: Int, prime: Int, g: Map<Int, ArrayList<Int>> ) {
    if(!seen.contains(value) && cando) {
        seen.add(value)
        var neighbors = g[value]!!
        if(neighbors.size > 2) {
            cando = false
            return
        }
        if(prime == -1) {
            if(neighbors.size == 2) {
                mapper[Pair(value, neighbors[0])] = 2
                mapper[Pair(neighbors[0], value)] = 2
                mapper[Pair(value, neighbors[1])] = 3
                mapper[Pair(neighbors[1], value)] = 3
                dfs(neighbors[0], 3, g)
                dfs(neighbors[1], 2, g)
            } else {
                mapper[Pair(value, neighbors[0])] = 2
                mapper[Pair(neighbors[0], value)] = 2
                dfs(neighbors[0], 3, g)
            }
        } else {
            for (node in neighbors) {
                if (!seen.contains(node)) {
                    mapper[Pair(value, node)] = prime
                    mapper[Pair(node, value)] = prime
                    if(prime == 2) {
                        dfs(node, 3, g)
                    } else {
                        dfs(node, 2, g)
                    }
                }
            }
        }
    }
    return
}
