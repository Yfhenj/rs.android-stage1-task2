package subtask3

class Abbreviation {

    // TODO: Complete the following function
    fun abbreviationFromA(a: String, b: String): String {
        if (a.length < b.length) return "NO"
        for (i in a.withIndex()) {
            if (i.index < b.length) {
                if (i.value != b[i.index]) {
                    if (i.value.isUpperCase()) return "NO" else {
                        if (i.value.toUpperCase() != b[i.index]) {
                            val newa = a.removeRange(i.index..i.index)
                            return abbreviationFromA(newa, b)
                        }
                    }
                }
            }else if(i.value.isUpperCase()) return "NO"
        }
        return "YES"
    }
}
