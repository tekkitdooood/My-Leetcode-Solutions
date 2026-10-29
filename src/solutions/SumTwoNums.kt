package solutions

/**
 * THE PROBLEM:
 * Given some integer array and some integer target, return an array
 * consisting of the two indices that add up to the target.
 *
 * Assume there is always only one answer, and the answer is always only 2 members from the nums array
 * Example:
 * array = [1,3,4,5]
 * target = 7
 * answer = [1,2]
 * 3 + 4 = 7, 3 is [1] and 4 is [2] in the array
 * https://leetcode.com/problems/two-sum/
 */

class SumTwoNums {
    fun twoNums(nums: IntArray, target: Int): IntArray {

        val hashMap = HashMap<Int, Int>()
        var first: Int? = null
        var second: Int? = null

        for (i in nums.indices) {
            val difference = target - nums[i]
            if (hashMap.isEmpty()) {
                hashMap[nums[i]] = i
            } else {
                if (!hashMap.containsKey(difference)) {
                    hashMap[nums[i]] = i
                } else {
                    first = i
                    second = hashMap[difference]
                }
            }
        }
        return intArrayOf(first!!, second!!)
    }
}