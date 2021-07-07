package subtask3

import java.lang.NumberFormatException

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        var mNumber = number
        val temp = arrayListOf<String>()
        var neighbourArray: Array<Int>

        for (i in mNumber.indices) {
            try {
                neighbourArray = getNeighbour(mNumber[i].toString().toInt())
            } catch (e: NumberFormatException) {
                e.printStackTrace()
                return null
            }
            for (item in neighbourArray.indices) {
                if (mNumber.length == 1) {
                    mNumber = neighbourArray[item].toString()
                    temp.add(mNumber)
                } else {
                    val subOne = mNumber.substring(0, i)
                    val subTwo = if (i == mNumber.length) {
                        ""
                    } else mNumber.substring(i + 1)
                    val resString = subOne + neighbourArray[item] + subTwo
                    temp.add(resString)
                }
            }
        }
        return temp.toTypedArray()
    }

    private fun getNeighbour(num: Int): Array<Int> {
        return when (num) {
            0 -> arrayOf(8)
            1 -> arrayOf(4, 2)
            2 -> arrayOf(1, 5, 3)
            3 -> arrayOf(2, 6)
            4 -> arrayOf(1, 5, 7)
            5 -> arrayOf(2, 4, 6, 8)
            6 -> arrayOf(3, 5, 9)
            7 -> arrayOf(4, 8)
            8 -> arrayOf(5, 7, 9, 0)
            else -> arrayOf(6, 8)
        }
    }
}

