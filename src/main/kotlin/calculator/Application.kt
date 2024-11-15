package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    val input = Console.readLine()
    val splitedInput = input.split(",", ":")
    val numbers: List<Int> = splitedInput.map { it.toInt() }
    println("결과 : ${numbers.sum()}")
}
