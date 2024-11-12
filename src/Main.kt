
fun main() {
    //1
    while (true) {
        println("Введите строку из скобок: ")
        var workString = readLine().toString();
        if (workString.length == 6 &&
            (workString.contains('[') && workString.contains('{') && workString.contains('('))
            )
        {
            val workPairString: Pair<String, String> =
                Pair(workString.substring(0,3),workString.substring(3,workString.length))

            var countTrueSymbols = 0;
            for (i in 0..workString.length/2-1)
            {
                var charLeftInt = workPairString.first.get(i).toInt();
                var charRightInt = workPairString.second.get((workString.length/2)-1-i).toInt();
                if (Math.abs(charLeftInt - charRightInt) <=2 ) ++countTrueSymbols
            }
            println("countTrueSymbols ${countTrueSymbols}")
            if (countTrueSymbols == 3) println("Введена правильная строка.")
            else                       println("Введена неправильная строка.")
        }
        else
        {
            println("Введена не подходящая строка для работы")
        }
        println("Продолжить работу? 1 Да. 2 Нет.")

        if (readLine().toString()=="2") break
    }

    //2
    val arrayInt = intArrayOf(1, 2, 3)
    val result = permutations(arrayInt)
    result.forEach { println(it) }
}

fun permutations(arrayInt: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val used = BooleanArray(arrayInt.size)
    val currentPermutation = mutableListOf<Int>()

    fun generate() {
        if (currentPermutation.size == arrayInt.size) {
            result.add(currentPermutation.toList())
            return
        }

        for (i in arrayInt.indices) {
            if (!used[i]) {
                used[i] = true
                currentPermutation.add(arrayInt[i])
                generate()
                currentPermutation.removeAt(currentPermutation.size - 1)
                used[i] = false

                // Skip duplicate elements
                var j = i
                while (j + 1 < arrayInt.size && arrayInt[j] == arrayInt[j + 1]) {
                    j++
                }
            }
        }
    }

    // Start generating permutations
    generate()
    return result
}