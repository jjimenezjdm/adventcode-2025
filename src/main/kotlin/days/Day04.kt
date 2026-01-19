/**
 * --- Day 4: Printing Department ---
 * You ride the escalator down to the printing department. They're clearly getting ready for Christmas; they have lots of large rolls of paper everywhere, and there's even a massive printer in the corner (to handle the really big print jobs).
 *
 * Decorating here will be easy: they can make their own decorations. What you really need is a way to get further into the North Pole base while the elevators are offline.
 *
 * "Actually, maybe we can help with that," one of the Elves replies when you ask for help. "We're pretty sure there's a cafeteria on the other side of the back wall. If we could break through the wall, you'd be able to keep moving. It's too bad all of our forklifts are so busy moving those big rolls of paper around."
 *
 * If you can optimize the work the forklifts are doing, maybe they would have time to spare to break through the wall.
 *
 * The rolls of paper (@) are arranged on a large grid; the Elves even have a helpful diagram (your puzzle input) indicating where everything is located.
 *
 * For example:
 *
 * ..@@.@@@@.
 * @@@.@.@.@@
 * @@@@@.@.@@
 * @.@@@@..@.
 * @@.@@@@.@@
 * .@@@@@@@.@
 * .@.@.@.@@@
 * @.@@@.@@@@
 * .@@@@@@@@.
 * @.@.@@@.@.
 *
 * The forklifts can only access a roll of paper if there are fewer than four rolls of paper in the eight adjacent positions. If you can figure out which rolls of paper the forklifts can access, they'll spend less time looking and more time breaking down the wall to the cafeteria.
 *
 * In this example, there are 13 rolls of paper that can be accessed by a forklift (marked with x):
 *
 * ..xx.xx@x.
 * x@@.@.@.@@
 * @@@@@.x.@@
 * @.@@@@..@.
 * x@.@@@@.@x
 * .@@@@@@@.@
 * .@.@.@.@@@
 * x.@@@.@@@@
 * .@@@@@@@@.
 * x.x.@@@.x.
 */
object Day04 {
    fun solve() {
        println("=== Day 4 ===")
        
        val input = readInput("input_day4")
        
        val part1 = solvePart1(input)
        println("Part 1: $part1")
        
        val part2 = solvePart2(input)
        println("Part 2: $part2")
    }
    
    private fun solvePart1(input: List<String>): Int {
        val grid = input.map { it.toCharArray() }
        val rows = grid.size
        val cols = grid[0].size
        var accessibleCount = 0
        
        // Directions for the 8 adjacent positions
        val directions = listOf(
            -1 to -1, -1 to 0, -1 to 1,  // top
            0 to -1,           0 to 1,   // left, right
            1 to -1,  1 to 0,  1 to 1     // bottom
        )
        
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (grid[i][j] == '@') {
                    // Count adjacent rolls
                    var adjacentRolls = 0
                    
                    for ((di, dj) in directions) {
                        val ni = i + di
                        val nj = j + dj
                        
                        // Check if within bounds
                        if (ni in 0 until rows && nj in 0 until cols) {
                            if (grid[ni][nj] == '@') {
                                adjacentRolls++
                            }
                        }
                    }
                    
                    // If there are fewer than 4 adjacent rolls, it's accessible
                    if (adjacentRolls < 4) {
                        accessibleCount++
                    }
                }
            }
        }
        
        return accessibleCount
    }
    
    private fun solvePart2(input: List<String>): Int {
        // Create a mutable copy of the grid
        val grid = input.map { it.toCharArray() }.toMutableList()
        val rows = grid.size
        val cols = grid[0].size
        var totalRemoved = 0
        
        // Directions for the 8 adjacent positions
        val directions = listOf(
            -1 to -1, -1 to 0, -1 to 1,  // top
            0 to -1,           0 to 1,   // left, right
            1 to -1,  1 to 0,  1 to 1     // bottom
        )
        
        // Helper function to count adjacent rolls
        fun countAdjacentRolls(i: Int, j: Int): Int {
            var count = 0
            for ((di, dj) in directions) {
                val ni = i + di
                val nj = j + dj
                if (ni in 0 until rows && nj in 0 until cols) {
                    if (grid[ni][nj] == '@') {
                        count++
                    }
                }
            }
            return count
        }
        
        // Iterate until no more changes
        var changed = true
        while (changed) {
            changed = false
            val toRemove = mutableListOf<Pair<Int, Int>>()
            
            // Find all accessible rolls in this iteration
            for (i in 0 until rows) {
                for (j in 0 until cols) {
                    if (grid[i][j] == '@') {
                        val adjacentRolls = countAdjacentRolls(i, j)
                        if (adjacentRolls < 4) {
                            toRemove.add(i to j)
                        }
                    }
                }
            }
            
            // Remove the accessible rolls
            if (toRemove.isNotEmpty()) {
                changed = true
                totalRemoved += toRemove.size
                for ((i, j) in toRemove) {
                    grid[i][j] = '.'
                }
            }
        }
        
        return totalRemoved
    }
}
