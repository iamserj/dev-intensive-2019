package ru.skillbranch.devintensive.utils

import android.content.Context
import kotlin.math.roundToInt

/**
 * @author iamserj
 * 29.06.2019 1:39
 */

object Utils {
    // Utils.parseFullName(fullName) with parameter (null, empty string)
    // return Pair(firstName, lastName). If fullName or a part of it is not parsable, return <null, null> or <"firstName", null>
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts = fullName?.trim()?.split(" ")
        val firstName = parts?.getOrNull(0)?.ifEmpty { null }
        val lastName = parts?.getOrNull(1)?.ifEmpty { null }
        // return Pair(firstName, lastName)
        // same as:
        return firstName to lastName
    }

    // Utils.toInitials(firstName, lastName) returning first letters in upper case
    // if one of them is null return the second one, if both null return null
    fun toInitials(firstName: String?, lastName: String?): String? {
        // orEmpty() returns the string if it is not null, or the empty string otherwise
        // getOrNull(index) returns a char at the given index or null if the index is out of bounds of this char sequence
        val firstChar = firstName.orEmpty().trim().getOrNull(0)?.toUpperCase()
        val lastChar = lastName.orEmpty().trim().getOrNull(0)?.toUpperCase()

        // if the expression to the left of Elvis (?:) !null, Elvis returns it, otherwise returns the expression to the right
        val firstI = firstChar?.toString() ?: ""
        val lastI = lastChar?.toString() ?: ""

        // ifEmpty { expression } returns string if it's not empty or the result of calling expression in curly braces
        return "$firstI$lastI".ifEmpty { null }
    }

    // Utils.transliteration(payload, divider) returns latin symbols string
    fun transliteration(payload: String, divider: String = " "): String {
        val map = fillTranslitMap()
        val stringBuilder = StringBuilder()

        for (char in payload.trim()) {
            stringBuilder.append(getTranslChar(char, map))
        }

        return stringBuilder.toString().replace(" ", divider)
    }

    private fun getTranslChar(char: Char, map: HashMap<Char, String>): String {
        val transl = map[char.toLowerCase()] ?: char.toString()
        // capitalize() returns string copy with upper-cased first letter, or the original string, if it's empty or already starts with an upper case
        return if (char.isUpperCase() && transl.isNotEmpty()) transl.capitalize() else transl
    }

    private fun fillTranslitMap(): HashMap<Char, String> {
        val map = hashMapOf<Char, String>()
        map['а'] = "a"
        map['б'] = "b"
        map['в'] = "v"
        map['г'] = "g"
        map['д'] = "d"
        map['е'] = "e"
        map['ё'] = "e"
        map['ж'] = "zh"
        map['з'] = "z"
        map['и'] = "i"
        map['й'] = "i"
        map['к'] = "k"
        map['л'] = "l"
        map['м'] = "m"
        map['н'] = "n"
        map['о'] = "o"
        map['п'] = "p"
        map['р'] = "r"
        map['с'] = "s"
        map['т'] = "t"
        map['у'] = "u"
        map['ф'] = "f"
        map['х'] = "h"
        map['ц'] = "c"
        map['ч'] = "ch"
        map['ш'] = "sh"
        map['щ'] = "sh'"
        map['ъ'] = ""
        map['ы'] = "i"
        map['ь'] = ""
        map['э'] = "e"
        map['ю'] = "yu"
        map['я'] = "ya"
        return map
    }

    fun convertPxToDp(context: Context, px: Int): Int {
        return (px / context.resources.displayMetrics.density).roundToInt()
    }

    fun convertDpToPx(context: Context, dp: Float): Int {
        return (dp * context.resources.displayMetrics.density).roundToInt()
    }

    fun convertSpToPx(context: Context, sp: Int): Int {
        return sp * context.resources.displayMetrics.scaledDensity.roundToInt()
    }
}