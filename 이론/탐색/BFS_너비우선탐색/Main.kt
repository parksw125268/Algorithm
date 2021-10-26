import java.util.*

fun main(){
    val graph = HashMap<String,MutableList<String>>()
    graph["A"] = mutableListOf("B", "C")
    graph["B"] = mutableListOf("A", "D")
    graph["C"] = mutableListOf("A", "G", "H", "I")
    graph["D"] = mutableListOf("B", "E", "F")
    graph["E"] = mutableListOf("D")
    graph["F"] = mutableListOf("D")
    graph["G"] = mutableListOf("C")
    graph["H"] = mutableListOf("C")
    graph["I"] = mutableListOf("C", "J")
    graph["J"] = mutableListOf("I")

    print(BFS().bfsFunc(graph,"A"))
}

class BFS{
    fun bfsFunc(graph : HashMap<String, MutableList<String>>, firstNode : String) : MutableList<String>{
        val needVisit = mutableListOf<String>()
        val visited = mutableListOf<String>()

        needVisit.add(firstNode)
        while(needVisit.isNotEmpty()){
            val node = needVisit.removeAt(0)
            if(!visited.contains(node)){
                visited.add(node)
                needVisit.addAll(graph[node]!!)
            }
        }
        return visited
    }
}