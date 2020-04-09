package subtask4

class Pangram {

    // TODO: Complete the following function
    fun getResult(inputString: String): String {
        val alphabet = "abcdefghijklnmopqrstuvwxyz"
        var isPangram = true
        for (i in alphabet) {
            if (!inputString.contains(i, true)) isPangram = false
        }
        val words = inputString.split("[ \\n]".toRegex())
        var wordsBuilder = words.map { StringBuilder(it) }
        if (isPangram) {
            for (i in wordsBuilder.withIndex()) {
                val vowelsNumber = i.value.filter { "aieouy".contains(it, true) }.count().toString()
                i.value.insert(0, vowelsNumber)
                for (j in i.value.withIndex()) {
                    if ("aieouy".contains(j.value, true)) {
                        i.value[j.index] = j.value.toUpperCase()
                    }
                }
            }
        } else {
            for (i in wordsBuilder.withIndex()) {
                val consonantsNumber =
                    i.value.filter { "bcdfghjklnmpqrstvwxz".contains(it, true) }.count().toString()
                i.value.insert(0, consonantsNumber)
                for (j in i.value.withIndex()) {
                    if ("bcdfghjklnmpqrstvwxz".contains(j.value, true)) {
                        i.value[j.index] = j.value.toUpperCase()
                    }
                }
            }
        }

        val wordsBuilderSorted = wordsBuilder.sortedBy {
            it[0]
        }
        var result = StringBuilder()
        wordsBuilderSorted.forEach {
            if (it.toString() != "0") {
                result.append(it)
                result.append(" ")
            }
        }
        return result.trim().toString()
    }
}
