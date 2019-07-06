package ru.skillbranch.devintensive.extensions

import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author iamserj
 * 01.07.2019 1:58
 */

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

// implement static extension function to format Date with given pattern
fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"):String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

// implement extension Date.add(value, TimeUnits) adding or subtracting value as unit of second TimeUnits value
// (enum TimeUnits [SECOND, MINUTE, HOUR, DAY]) and return modified Date
fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND) : Date {

    var time = this.time

    time += when(units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
        //else -> throw IllegalStateException("invalid unit")
    }
    this.time = time

    return this
}


fun Date.humanizeDiff(date:Date = Date()): String {
    return "asdf секунд назад"
    //TODO("not implemented")
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}