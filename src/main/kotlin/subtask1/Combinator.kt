package subtask1

class Combinator {
    fun checkChooseFromArray(array: Array<Int>): Int? {
        for (choose in 0..array[1]) {
            if (array[0] == temp(array[1], choose))
                return choose
        }
        return null
    }

    private fun temp(pool: Int, choose: Int) =
        (factorial(pool) / (factorial(choose) * factorial(pool - choose))).toInt()

    private fun factorial(i: Int): Long {
        var result = 1L
        var count = i
        return if (count == 0)
            1
        else {
            do {
                result *= count
                count--
            } while (count != 0)
            result
        }
    }
}
