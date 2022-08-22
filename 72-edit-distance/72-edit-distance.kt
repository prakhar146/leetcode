class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val rows = word1.length
        val cols = word2.length
        val dp = Array(rows) { Array(cols) {-1} }
        return calculateLevenshteinDistance(word1, word2, 0, 0, dp)
    }

    private fun calculateLevenshteinDistance(first: String, second: String, firstIdx: Int, secondIdx: Int, dp: Array<Array<Int>>): Int {
        if(firstIdx == first.length && secondIdx == second.length) {
            return 0
        }
        if(firstIdx >= first.length) {
            return second.length - secondIdx
        }
        if(secondIdx >= second.length) {
            return first.length - firstIdx
        }
        if(dp[firstIdx][secondIdx] != -1) {
            return dp[firstIdx][secondIdx]
        }

        var noChange = Int.MAX_VALUE
        if(first[firstIdx] == second[secondIdx]) {
            noChange = calculateLevenshteinDistance(first, second, firstIdx + 1, secondIdx + 1, dp)
        }
        // insert
        val insertOption = 1 + calculateLevenshteinDistance(first, second, firstIdx, secondIdx + 1, dp)
        val replaceOption = 1 + calculateLevenshteinDistance(first, second, firstIdx + 1, secondIdx + 1, dp)
        val deleteOption = 1 + calculateLevenshteinDistance(first, second, firstIdx + 1, secondIdx, dp)

        val ans = noChange.coerceAtMost(insertOption.coerceAtMost(replaceOption.coerceAtMost(deleteOption)))
        dp[firstIdx][secondIdx] = ans;
        return ans
    }
}