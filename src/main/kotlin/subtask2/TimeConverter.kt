package subtask2

class TimeConverter {
    fun toTextFormat(hour: String, minute: String): String {
        if(hour.toInt() > 23) return ""
        val hourString = numberToString(hour.toInt())
        val nextHourString = if(hour.toInt() == 23) "zero" else numberToString(hour.toInt() + 1)
        return when (minute.toInt()) {
            0 -> "$hourString o' clock"
            1 -> "one minute past $hourString"
            15 -> "quarter past $hourString"
            in 2..29 -> "${numberToString(minute.toInt())} minutes past $hourString"
            30 -> "half past $hourString"
            45 -> "quarter to $nextHourString"
            in 31..58 -> "${numberToString(60 - minute.toInt())} minutes to $nextHourString"
            59 -> "one minute to $nextHourString"
            else -> ""
        }
    }
}

fun numberToString(number: Int): String = when (number) {
    0 -> "zero"
    1 -> "one"
    2 -> "two"
    3 -> "three"
    4 -> "four"
    5 -> "five"
    6 -> "six"
    7 -> "seven"
    8 -> "eight"
    9 -> "nine"
    10 -> "ten"
    11 -> "eleven"
    12 -> "twelve"
    13 -> "thirteen"
    14 -> "fourteen"
    15 -> "fifteen"
    16 -> "sixteen"
    17 -> "seventeen"
    18 -> "eighteen"
    19 -> "nineteen"
    20 -> "twenty"
    in 21..29 -> "twenty ${numberToString(number % 20)}"
    else -> ""
}
