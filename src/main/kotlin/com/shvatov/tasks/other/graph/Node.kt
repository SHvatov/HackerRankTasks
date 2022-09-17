@file:Suppress("MemberVisibilityCanBePrivate")

package com.shvatov.tasks.other.graph

data class Node<T : Any>(val value: T? = null)

data class Edge<T : Any>(
    val from: Node<T>,
    val to: Node<T>,
    val direction: EdgeDirection = EdgeDirection.NOT_ORIENTED,
    val weight: Int = 0
) {
    init {
        require(weight >= 0)
    }
}

enum class EdgeDirection {
    NOT_ORIENTED
}

class Graph<T : Any> {
    private val nodes: MutableSet<Node<T>> = mutableSetOf()
    private val edges: MutableSet<Edge<T>> = mutableSetOf()
    lateinit var rootNode: Node<T>

    fun getEdgesFrom(node: Node<T>): Set<Edge<T>> =
        edges.filter { it.from == node }.toSet()

    fun addNodes(vararg nodes: Node<T>) {
        nodes.forEach { node -> addNode(node) }
    }

    fun addNode(node: Node<T>, vararg edges: Edge<T>) {
        if (node in nodes || nodes.any { it.value == node.value }) {
            throw IllegalArgumentException("Node is already present")
        }
        nodes.add(node)

        edges.forEach { edge ->
            if (node !in setOf(edge.from, edge.to)) {
                throw IllegalArgumentException("Edge must be associated with the provided node")
            }
            addEdge(edge)
        }
    }

    fun addEdge(edge: Edge<T>) {
        if (!nodes.containsAll(setOf(edge.from, edge.to))) {
            throw IllegalArgumentException("Either node \"${edge.from}\" or \"${edge.to}\" is missing")
        }

        if (edges.any { it.from == edge.from && it.to == edge.to }) {
            throw IllegalArgumentException("Edge for nodes \"${edge.from}\" -> \"${edge.to}\" is already present")
        }

        if (edges.any { it.from == edge.to && it.to == edge.from && it.direction in setOf(EdgeDirection.NOT_ORIENTED) }) {
            throw IllegalArgumentException("Edge for nodes \"${edge.to}\" -> \"${edge.from}\" is already present")
        }

        edges.add(edge)
    }
}