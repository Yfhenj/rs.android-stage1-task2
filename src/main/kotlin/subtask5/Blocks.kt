package subtask5

import kotlin.reflect.KClass
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Blocks {

    // TODO: Complete the following function
    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        if(blockB.simpleName == "String") {
            val result = StringBuilder()
            for (i in blockA) {
                if (blockB.isInstance(i))
                    result.append(i)
            }
            return result.toString()
        }
        if(blockB.simpleName == "Int"){
            var result = 0
            for (i in blockA) {
                if (blockB.isInstance(i))
                    result += i as Int
            }
            return result
        }
        if(blockB.simpleName == "LocalDate"){
            var result = arrayListOf<LocalDate>()
            for (i in blockA) {
                if (blockB.isInstance(i))
                    result.add(i as LocalDate)
            }
            result.sort()
            var formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
            return result[result.size - 1].format(formatter)
        }

        return ""
    }
}
