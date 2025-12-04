#!/bin/bash

# Script to create a new Advent of Code day

if [ -z "$1" ]; then
    echo "Usage: ./new-day.sh <day_number>"
    echo "Example: ./new-day.sh 1"
    exit 1
fi

DAY=$1
DAY_PADDED=$(printf "%02d" $DAY)
FILE="src/main/kotlin/days/Day${DAY_PADDED}.kt"

if [ -f "$FILE" ]; then
    echo "File $FILE already exists"
    exit 1
fi

cat > "$FILE" << EOF
object Day${DAY_PADDED} {
    fun solve() {
        println("=== Day ${DAY} ===")
        
        val input = readInput("day${DAY_PADDED}")
        
        val part1 = solvePart1(input)
        println("Part 1: \$part1")
        
        val part2 = solvePart2(input)
        println("Part 2: \$part2")
    }
    
    private fun solvePart1(input: List<String>): Int {
        // TODO: Implement part 1
        return 0
    }
    
    private fun solvePart2(input: List<String>): Int {
        // TODO: Implement part 2
        return 0
    }
}
EOF

echo "✅ Created $FILE"
echo "📝 Remember to add the input file at: src/main/resources/inputs/day${DAY_PADDED}.txt"
echo "📝 Add the case in Main.kt: $DAY -> Day${DAY_PADDED}.solve()"

