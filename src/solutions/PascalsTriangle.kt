package solutions


/**
 * THE PROBLEM:
 * Given some int N, create a pascal triangle in the form of a List<List<Int>>
 * The triangle works in the following manner:
 *    1
 *   1 1
 *  1 2 1
 * 1 3 3 1
 * Where each number is the sum of the two directly above it
 * https://leetcode.com/problems/pascals-triangle/
 */
class PascalsTriangle {

    fun generate(rows: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        for (i in 1..rows) {
            val currentRow = MutableList(i) { 1 }

            if (i > 2) {
                val previousRow = result[i - 2]
                for (j in 1..<currentRow.size - 1) {
                    currentRow[j] = previousRow[j] + previousRow[j - 1]
                }
            }
            result.add(currentRow)
        }
        return result
    }
}