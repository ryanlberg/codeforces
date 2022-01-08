import java.util.Scanner
class A {

    fun main(args: Array<String>) {
        val read = Scanner(System.`in`)
        val cases = read.nextInt()
        for(i in 1..cases+1) {
            val a = read.nextInt()
            val b=  read.nextInt();
            println(a + b)
        }
        
    }
    
}
