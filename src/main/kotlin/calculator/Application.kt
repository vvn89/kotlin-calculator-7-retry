package calculator

import camp.nextstep.edu.missionutils.Console

fun useTryCatch() {
    try {
        val input = Console.readLine()
        val splitedInput = input.split(",", ":")
        val numbers: List<Int> = splitedInput.map { it.toInt() }
        println("결과 : ${numbers.sum()}")
    } catch (e: NoSuchElementException) {
        println("결과 : 0")
    }
}

fun useCompare() {
    val input = Console.readLine()
    if (input == "") {
        println("결과 : 0")
    } else {
        val splitedInput = input.split(",", ":")
        val numbers: List<Int> = splitedInput.map { it.toInt() }
        println("결과 : ${numbers.sum()}")
    }
}

fun useNull() {
    val input = Console.readLine()
    if (input == null) {
        println("결과 : 0")
    } else {
        val splitedInput = input.split(",", ":")
        val numbers: List<Int> = splitedInput.map { it.toInt() }
        println("결과 : ${numbers.sum()}")
    }
}

fun useIsBlank() {
    val input = Console.readLine()
    if (input.isBlank()) {
        println("결과 : 0")
    } else {
        val splitedInput = input.split(",", ":")
        val numbers: List<Int> = splitedInput.map { it.toInt() }
        println("결과 : ${numbers.sum()}")
    }
}

fun useIsEmpty() {
    val input = Console.readLine()
    if (input.isEmpty()) {
        println("결과 : 0")
    } else {
        val splitedInput = input.split(",", ":")
        val numbers: List<Int> = splitedInput.map { it.toInt() }
        println("결과 : ${numbers.sum()}")
    }
}

fun useIsNullOrBlank() {
    val input = Console.readLine()
    if (input.isNullOrBlank()) {
        println("결과 : 0")
    } else {
        val splitedInput = input.split(",", ":")
        val numbers: List<Int> = splitedInput.map { it.toInt() }
        println("결과 : ${numbers.sum()}")
    }
}

fun useIsNullOrEmpty() {
    val input = Console.readLine()
    if (input.isNullOrEmpty()) {
        println("결과 : 0")
    } else {
        val splitedInput = input.split(",", ":")
        val numbers: List<Int> = splitedInput.map { it.toInt() }
        println("결과 : ${numbers.sum()}")
    }
}

fun validateCustom(input: String): Boolean {
    if (input.contains("//") && input.contains("\\n")) {
        return true
    }
    return false
}

fun main() {
//    useTryCatch()
//    useCompare()
//    useNull()
//    useIsBlank()
//    useIsEmpty()
//    useIsNullOrBlank()
//    useIsNullOrEmpty()

    try {
        var input = Console.readLine()
        if (validateCustom(input)) {
            input = replacCustomSeperator(input)
        }
        val splitedInput = input.split(",", ":")
        val numbers: List<Int> = splitedInput.map { it.toInt() }
        if (!numbers.all { it > 0 }) {
            throw IllegalArgumentException()
        }
        println("결과 : ${numbers.sum()}")
    } catch (e: NoSuchElementException) {
        println("결과 : 0")
    }
}

fun replacCustomSeperator(input: String): String {
    val prefix = "//"
    val postfix = "\\n"
    val inputs = input.split(postfix)
    val customSeparator = inputs[0].replace(prefix, "")
    return inputs[1].replace(customSeparator, ",")
}
