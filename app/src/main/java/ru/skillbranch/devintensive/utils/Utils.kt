package ru.skillbranch.devintensive.utils

/**
 * @author iamserj
 * 29.06.2019 1:39
 */

object Utils {
    // 3. Implement method Utils.parseFullName(fullName) with argument containing full user name (null, empty string)
    // and returning a pair of values Pair(firstName, lastName)
    // If full name or a part of it is not parsable, return null null or "firstName" null
    // Examples:
    // Utils.parseFullName(null) // null null
    // Utils.parseFullName("") // null null
    // Utils.parseFullName(" ") // null null
    // Utils.parseFullName("John") // John null
    fun parseFullName(fullName:String?):Pair<String?, String?> {
        val parts = fullName?.trim()?.split(" ")
        val firstName = parts?.getOrNull(0)?.ifEmpty { null }
        val lastName = parts?.getOrNull(1)?.ifEmpty { null }
        // return Pair(firstName, lastName)
        // same as:
        return firstName to lastName
    }

    fun transliteration(payload: String, divider:String = " "): String {
        //TODO("not implemented")
        return "asdf"
    }
    /*

     */
    // 6. Implement method Utils.toInitials(firstName lastName) returning first letters in upper case.
    // if one of them is null return the second one, if both null return null
    fun toInitials(firstName: String?, lastName: String?): String? {
        // orEmpty() Returns the string if it is not null, or the empty string otherwise.
        // getOrNull(index) Returns a character at the given index or null if the index is out of bounds of this char sequence.
        val firstChar = firstName.orEmpty().trim().getOrNull(0)?.toUpperCase()
        val lastChar = lastName.orEmpty().trim().getOrNull(0)?.toUpperCase()

        // If the expression to the left of Elvis (?:) is not null, the Elvis operator returns it, otherwise it returns the expression to the right.
        val firstI = firstChar?.toString() ?: ""
        val lastI = lastChar?.toString() ?: ""

        // ifEmpty { expression } returns string if it's not empty or the result of calling expression in curly braces.
        return "$firstI$lastI".ifEmpty { null }
    }

}