# 🎄 Advent of Code 2025 - Kotlin

Simple structure to solve Advent of Code 2025 exercises in Kotlin.

## 📁 Project Structure

```
adventcode-2025/
├── src/
│   ├── main/
│   │   ├── kotlin/
│   │   │   ├── Main.kt              # Main entry point
│   │   │   ├── days/                # Solutions by day
│   │   │   │   ├── Day01.kt
│   │   │   │   └── ...
│   │   │   └── utils/
│   │   │       └── InputReader.kt  # Utility to read input files
│   │   └── resources/
│   │       └── inputs/              # Input files
│   │           ├── day01.txt
│   │           └── ...
│   └── test/
│       └── kotlin/                  # Tests (optional)
└── build.gradle.kts
```

## 🚀 How to Use

### 1. 📦 Setup the Project

```bash
# Make sure you have Java 17+ installed
java -version

# Run Gradle wrapper (will download automatically if it doesn't exist)
./gradlew build
```

### 2. 📥 Add Input Files

Download input files from [Advent of Code](https://adventofcode.com/2025) and save them in:
```
src/main/resources/inputs/day01.txt
src/main/resources/inputs/day02.txt
...
```

### 3. ✏️ Implement a Day

Each day has a `DayXX.kt` file with the following structure:
- `solve()`: Main function called from Main
- `solvePart1()`: Solution for part 1
- `solvePart2()`: Solution for part 2

**Note:** Currently only Day 1 is created. Use the helper script to add more days as needed.

### 4. ▶️ Run a Day

```bash
# Run day 1
./gradlew run --args="1"

# Run day 2
./gradlew run --args="2"

# etc.
```

### 5. ➕ Create a New Day

To create a new day, use the helper script:

```bash
./new-day.sh <day_number>
```

For example:
```bash
./new-day.sh 2
```

This will:
- ✅ Create the `Day02.kt` file
- 📝 Remind you to add the input file
- 📝 Remind you to add the case in `Main.kt`

## 💡 Implementation Example

```kotlin
object Day01 {
    fun solve() {
        println("=== Day 1 ===")
        
        val input = readInput("day01")
        
        val part1 = solvePart1(input)
        println("Part 1: $part1")
        
        val part2 = solvePart2(input)
        println("Part 2: $part2")
    }
    
    private fun solvePart1(input: List<String>): Int {
        // Your solution here
        return input.size
    }
    
    private fun solvePart2(input: List<String>): Int {
        // Your solution here
        return 0
    }
}
```

## 📝 Notes

- 📂 Input files are automatically read from `src/main/resources/inputs/`
- 🎯 Each day is an independent object, easy to maintain and test
- 🎨 The structure is simple and straightforward, without unnecessary complications
- 🔧 Use `./new-day.sh` to quickly scaffold new days

Happy coding! 🎄✨
