package calculator

import calculator.InputView

class Calculator {
    private val inputView = InputView()

    fun run() {
        try {
            var input = inputView.readInput()
            val numbers: List<Int> = processInput(input)
            println("결과 : ${numbers.sum()}")
        } catch (e: NoSuchElementException) {
            println("결과 : 0")
        }
    }

    private fun processInput(input: String): List<Int> {
        var input = input
        if (validateCustom(input)) {
            input = replacCustomSeperator(input)
        }
        val splitedInput = input.split(COMMA_SEPARATOR, COLON_SEPARATOR)
        return validateNumber(splitedInput)
    }

    private fun validateNumber(splitedInput: List<String>): List<Int> {
        val numbers: List<Int> = splitedInput.map { it.toInt() }
        if (!numbers.all { it > 0 }) {
            throw IllegalArgumentException()
        }
        return numbers
    }

    private fun validateCustom(input: String): Boolean {
        if (input.contains(PREFIX_CUSTOM_SEPARATOR) && input.contains(POSTFIX_CUSTOM_SEPARATOR)) {
            if (input.indexOf(PREFIX_CUSTOM_SEPARATOR) < input.indexOf(POSTFIX_CUSTOM_SEPARATOR)) {
                return true
            }
        }
        return false
    }

    private fun replacCustomSeperator(input: String): String {
        val inputs = input.split(POSTFIX_CUSTOM_SEPARATOR)
        val customSeparator = inputs[0].replace(PREFIX_CUSTOM_SEPARATOR, "")
        if (customSeparator.contains(Regex("\\d"))) {
            throw IllegalArgumentException()
        }
        return inputs[1].replace(customSeparator, COMMA_SEPARATOR)
    }

    companion object {
        const val PREFIX_CUSTOM_SEPARATOR = "//"
        const val POSTFIX_CUSTOM_SEPARATOR = "\\n"
        const val COMMA_SEPARATOR = ","
        const val COLON_SEPARATOR = ":"
    }
}