package com.shvatov.tasks.other.graph

fun main() {
    val graph = Graph<String>()

    val nodes = mapOf(
        "1" to Node("1"),
        "2" to Node("2"),
        "3" to Node("3"),
        "4" to Node("4"),
        "5" to Node("5"),
        "6" to Node("6"),
        "7" to Node("7"),
    )

    // add nodes
    graph.addNodes(*nodes.values.toTypedArray())

    // add edges
    graph.addEdge(Edge(nodes["1"]!!, nodes["2"]!!, EdgeDirection.NOT_ORIENTED, 0))
    graph.addEdge(Edge(nodes["1"]!!, nodes["6"]!!, EdgeDirection.NOT_ORIENTED, 0))

    graph.addEdge(Edge(nodes["2"]!!, nodes["3"]!!, EdgeDirection.NOT_ORIENTED, 0))
    graph.addEdge(Edge(nodes["2"]!!, nodes["4"]!!, EdgeDirection.NOT_ORIENTED, 0))
    graph.addEdge(Edge(nodes["2"]!!, nodes["7"]!!, EdgeDirection.NOT_ORIENTED, 0))

    graph.addEdge(Edge(nodes["4"]!!, nodes["7"]!!, EdgeDirection.NOT_ORIENTED, 0))

    graph.addEdge(Edge(nodes["6"]!!, nodes["7"]!!, EdgeDirection.NOT_ORIENTED, 0))

    graph.addEdge(Edge(nodes["3"]!!, nodes["4"]!!, EdgeDirection.NOT_ORIENTED, 0))
    graph.addEdge(Edge(nodes["3"]!!, nodes["5"]!!, EdgeDirection.NOT_ORIENTED, 0))

    graph.rootNode = nodes["1"]!!

    val r = dfs(graph, nodes["5"]!!)
    r.forEach {
        println(it.joinToString(" -> "))
    }

    println(bfs(graph, nodes["5"]!!))
}

fun <T : Any> dfs(graph: Graph<T>, destination: Node<T>): List<List<Node<T>>> {
    val rootNode = graph.rootNode

    fun step(currentNode: Node<T>): List<MutableList<Node<T>>> {
        if (currentNode == destination) {
            val path = mutableListOf(currentNode)
            return mutableListOf(path)
        }

        val edges = graph.getEdgesFrom(currentNode)
        if (edges.isEmpty()) {
            return emptyList()
        }

        val nextNodes = edges.map { edge -> edge.to }
        return nextNodes.flatMap { node -> step(node) }
            .onEach { path -> path.add(currentNode) }
    }

    return step(rootNode)
}

fun <T : Any> bfs(graph: Graph<T>, destination: Node<T>): Int {
    val rootNode = graph.rootNode

    var nodes = 0
    fun step(currentLevelNodes: Set<Node<T>>): Boolean {
        nodes++
        if (currentLevelNodes.contains(destination)) {
            return true
        }

        if (currentLevelNodes.isEmpty()) {
            return false
        }

        val nextLevelNodes = currentLevelNodes.flatMap { node -> graph.getEdgesFrom(node).map { it.to } }.toSet()
        return step(nextLevelNodes)
    }

    step(setOf(rootNode))
    return nodes
}