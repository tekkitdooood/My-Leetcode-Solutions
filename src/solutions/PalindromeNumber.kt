package solutions

import kotlin.math.abs
import kotlin.math.log10
import kotlin.math.pow

/**
 * THE PROBLEM:
 * Given some int X, return a boolean determining whether the number is a palindrome
 * A palindrome is something that is the same when reversed
 * Example:
 * x = 16761 -> 16761, true
 * x = 6785 -> 5875, false
 * x = -10 -> 01-, false
 * https://leetcode.com/problems/palindrome-number/description/
 */


// lets us get the number of digits in a number
// this avoids a string conversion

class PalindromeNumber {

    fun Int.length() = when(this) {
        0 -> 1
        else -> log10(abs(toDouble())).toInt() + 1
    }

    fun isPalindrome(x: Int): Boolean {

        // negative can't be palindrome
        if (x < 0) return false

        var len = x.length()

        // single digit are obviously mirrors
        if (len == 1) return true
        --len


        val list = mutableListOf<Int>()

        var copy = x

        for (i in len downTo 0) {
            val digitPlace = 10.0.pow(i).toInt()
            val digit = copy / digitPlace
            list.add(digit)
            copy -= (digit * digitPlace)
        }

        val copyOf = list.reversed()

        for (i in copyOf.indices) {
            if (copyOf[i] != list[i]) return false

        }
        return true
    }
}