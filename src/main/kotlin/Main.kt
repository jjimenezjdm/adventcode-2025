fun main(args: Array<String>) {
    val day = if (args.isNotEmpty()) {
        args[0].toIntOrNull() ?: 1
    } else {
        println("Usage: ./gradlew run --args=\"<day_number>\"")
        println("Example: ./gradlew run --args=\"1\"")
        return
    }
    
    when (day) {
        1 -> Day01.solve()
        2 -> Day02.solve()
        3 -> Day03.solve()
        4 -> Day04.solve()
        else -> println("Day $day not implemented yet")
    }
}

