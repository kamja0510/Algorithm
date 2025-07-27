package templates

fun dfs(node: Int, visited: BooleanArray, tree: Array<MutableList<Int>>){
    visited[node] = true
    tree[node].forEach{next->
        if(!visited[next]) dfs(next, visited, tree)
    }
}