package subtask1
import java.util.*
class InvalidDayException : Exception()

class DateFormatter {

    // TODO: Complete the following function
    fun toTextDay(day: String, month: String, year: String): String {
        val date = Date(day.toInt(), month.toInt(), year.toInt())
        return try {
            "${day} ${date.monthString}, ${date.weekdayString}"
        } catch (e: InvalidDayException) {
            "Такого дня не существует"
        }
    }
}

fun isLeap(year: Int) = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0

data class Date(val day: Int, val month: Int, val year: Int) {

    val monthString
        get() = when (month) {
            1 -> {
                if (day !in 0..31) throw InvalidDayException()
                "января"
            }
            2 -> {
                if (day !in if (isLeap(year)) 0..29 else 0..28) throw InvalidDayException()
                "февраля"
            }
            3 -> {
                if (day !in 0..31) throw InvalidDayException()
                "марта"
            }
            4 -> {
                if (day !in 0..30) throw InvalidDayException()
                "апреля"
            }
            5 -> {
                if (day !in 0..31) throw InvalidDayException()
                "мая"
            }
            6 -> {
                if (day !in 0..30) throw InvalidDayException()
                "июня"
            }
            7 -> {
                if (day !in 0..31) throw InvalidDayException()
                "июля"
            }
            8 -> {
                if (day !in 0..31) throw InvalidDayException()
                "августа"
            }
            9 -> {
                if (day !in 0..30) throw InvalidDayException()
                "сентября"
            }
            10 -> {
                if (day !in 0..31) throw InvalidDayException()
                "октября"
            }
            11 -> {
                if (day !in 0..30) throw InvalidDayException()
                "ноября"
            }
            12 -> {
                if (day !in 0..31) throw InvalidDayException()
                "декабря"
            }
            else -> throw InvalidDayException()
        }

    val weekdayString: String
        get() = when (getWeekday()) {
            0 -> "понедельник"
            1 -> "вторник"
            2 -> "среда"
            3 -> "четверг"
            4 -> "пятница"
            5 -> "суббота"
            6 -> "воскресенье"
            else -> throw InvalidDayException()
        }

    private fun getWeekday(): Int {
        val baseDate = Date(6, 1, 2020)
        val weekdayShift = getDaysCountTo(baseDate) % 7 * -1
        return if (weekdayShift < 0) 7 + weekdayShift else weekdayShift
    }

    private fun getDaysCountTo(date: Date): Int {

        val dayDiff = date.day - day
        val monthDiff = monthRangeToDays(month, date.month)
        val yearDiff = yearRangeToDays(year, date.year)
        return dayDiff + monthDiff + yearDiff
    }

    private fun monthRangeToDays(month: Int, baseMonth: Int): Int {
        val daysInMonth = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        val inverse = month > baseMonth
        var count = 0
        for (i in if (inverse) baseMonth until month else month until baseMonth) {
            count += daysInMonth[i - 1]
        }
        return if (inverse) count * -1 else count
    }

    private fun yearRangeToDays(year: Int, baseYear: Int): Int {
        val inverse = year > baseYear
        var count = 0
        for (i in if (inverse) baseYear until year else year until baseYear) {
            count += if (isLeap(i)) 366 else 365
        }
        if (month > 2 && isLeap(year) && !inverse) count -= 1
        if (month > 2 && isLeap(year) && inverse) count += 1
        return if (inverse) count * -1 else count
    }
}
