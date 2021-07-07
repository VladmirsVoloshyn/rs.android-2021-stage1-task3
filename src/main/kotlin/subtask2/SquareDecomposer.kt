package subtask2

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        if (number < 4) {
            return null
        }
        val mValue = number.toLong()
        val arrayOfSquares = arrayListOf(mValue)
        var currentSqrt = 0L
        var value: Long
        val loop = 0L

        while (loop == 0L) {
            value = arrayOfSquares[arrayOfSquares.lastIndex]
            currentSqrt += getSquare(value)
            arrayOfSquares.removeAt(arrayOfSquares.lastIndex)
            for (i in value - STEP downTo 0) {
                if (currentSqrt - getSquare(i) >= 0) {
                    currentSqrt -= getSquare(i)
                    arrayOfSquares.add(i)
                    if (currentSqrt == 0L) {
                        arrayOfSquares.sort()
                        return arrayOfSquares.map { it.toInt() }.toTypedArray()
                    }
                }
            }
        }
        return null
    }

    companion object {
        private const val STEP = 1
        private fun getSquare(num: Long) = num * num
    }
}
