fun readInput(day: String): List<String> {
    val resource = object {}.javaClass.getResourceAsStream("/inputs/$day.txt")
        ?: throw IllegalArgumentException("Input file not found for day $day")
    
    return resource.bufferedReader().readLines()
}

