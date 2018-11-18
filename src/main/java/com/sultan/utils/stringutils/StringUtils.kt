package com.sultan.utils.stringutils

import java.util.regex.Pattern

open class StringUtils {

    /*
    * return true if the value passed is null or empty
    * @param string : value of string passed
    * */
    fun isNullOrEmpty(string: String?) = string?.equals("") ?: true

    /*
    * return true if the value passed is neither null nor empty
    * @param string : value of string passed
    * */
    fun isNotNullorEmpty(string: String?) = string?.let { it -> !it.equals("") } ?: false

    /*
    * return true if the value passed in parameters are equal in case sensitive manner
    * @param string1: first string value
    * @param string2: second string value
    * */
    fun areEqual(string1: String?, string2: String?) =
            safeLet(string1, string2) { string1, string2 -> string1.equals(string2) } ?: false

    /*
    * return true if the value passed in parameters are equal in non case sensitive manner
    * @param string1: first string value
    * @param string2: second string value
    * */
    fun areEqualIgnoreCase(string1: String?, string2: String?) =
            safeLet(string1, string2) { string1, string2 -> string1.isEqualIgnoreCase(string2) }
                    ?: false

    /*
   * return true if the value passed in parameter has same pattern as android email patter
   * @param email: email value
   * */
    fun isValidEmail(email: String?) = email?.let {
        getEmailPattern().matcher(it).matches()
    } ?: false


    /*
   * return true if the value passed in parameter has same pattern as android WEB_URL patter
   * @param webUrl: email value
   * */
    fun isValidUrl(webUrl: String?) = webUrl?.let { getWebUrlPattern().matcher(it).matches() }
            ?: false


    /*
   * return true if the value passed in parameter has same pattern passed in second parameter
   * @param string: email value
   * @param pattern: pattern passed
   * */
    fun hasValidPattern(string: String?, pattern: Pattern?) =
            safeLet(string, pattern) { s, p -> p.matcher(s).matches() } ?: false


    /*
   * return list of string when a comma seperated String is passed
   * @param string: comma seperated String
   * */
    fun convertCommaSeperatedStringToList(string: String?) =
            convertCharSeperatedStringToList(string, ',')


    /*
   * return list of string when a delimiter seperated String is passed
   * @param string: delimiter seperated String
   * @param char: delimiter character
   * */
    fun convertCharSeperatedStringToList(string: String?, char: Char?): ArrayList<String> =
            safeLetWithEmptyString(string, char) { s, c -> remove(s, " ")?.split(c) } as ArrayList<String>?
                    ?: ArrayList()


    /*
   * return delimiter seperated String when list of string is passed
   * @param stringList: list of string
   * @param char: delimiter character
   * */
    fun convertStringListToCommaSeperatedString(stringList: List<String>?) =
            convertStringListToCharSeperatedString(stringList, ',')

    /*
   * return delimiter seperated String when list of string is passed
   * @param stringList: list of string
   * @param char: delimiter character
   * */
    fun convertStringListToCharSeperatedString(stringList: List<String>?, char: Char?) =
            safeLet(stringList, char) { s, c -> s.joinToString(separator = c.toString(), limit = s.size) }
                    ?: ""

    /*
   * return capitalize form of the string passed in parameter
   * @param string: string
   * */
    fun capitalize(string: String?) = string?.capitalize()

    /*
   * return capitalize form of the string passed in parameter
   * @param string: string
   * */
    fun deCapitalize(string: String?) = string?.decapitalize()

    /*
   * return lowercase form of the string passed in parameter
   * @param string: string
   * */
    fun lowerCase(string: String?) = string?.toLowerCase()

    /*
   * return uppercase form of the string passed in parameter
   * @param string: string
   * */
    fun upperCase(string: String?) = string?.toUpperCase()

    /*
   * take string and prefix as input and remove prefix if it is present
   * @param string: string to remove prefix
   * @param prefix: to remove from string
   * */
    fun removePrefix(string: String?, prefix: String?) =
            safeLetWithOneNullAndEmptyString(string) { s ->
                prefix?.let { s?.removePrefix(it) } ?: s
            }

    /*
   * take main string and substring as input and remove substring if it is present
   * @param string: string to remove prefix
   * @param prefix: to remove from string
   * */
    fun remove(string: String?, toRemove: String?) =
            safeLetWithOneNullAndEmptyString(string) { main ->
                toRemove?.let { main?.replace(it, "") } ?: main
            }

    /*
   * take main string and suffix as input and remove suffix if it is present
   * @param string: string to remove prefix
   * @param prefix: to remove from string
   * */
    fun removeSuffix(string: String?, suffix: String?) =
            safeLetWithOneNullAndEmptyString(string) { str ->
                suffix?.let { str?.removeSuffix(it) } ?: str
            }


    open fun getEmailPattern() = android.util.Patterns.EMAIL_ADDRESS
    open fun getWebUrlPattern() = android.util.Patterns.WEB_URL
}

/*
  * kotlin extension function
  * return true if the value passed in parameter is equal to my string in case sensitive manner
  * @param string: first string value
  * */
public fun String?.isEqual(string: String?): Boolean {
    return safeLet(this, string) { a, b -> a.equals(b) } ?: false
}

/*
  * kotlin extension function
  * return true if the value passed in parameter is equal to my string in non case sensitive manner
  * @param string: first string value
  * */
fun String?.isEqualIgnoreCase(string: String?): Boolean {
    return safeLet(this, string) { a, b -> a.toLowerCase().equals(b.toLowerCase()) } ?: false
}

fun String?.convertToInt(default: Int = 0): Int {
    return this?.toIntOrNull() ?: default
}

fun String?.convertToDouble(default: Double = 0.0): Double {
    return this?.toDoubleOrNull() ?: default
}

fun String?.convertToLong(default: Long = 0L): Long {
    return this?.toLongOrNull() ?: default
}

fun String?.convertToBoolean(default: Boolean = false): Boolean {
    return this?.toBoolean() ?: default
}

private fun <T1 : Any, T2 : Any, R : Any> safeLet(p1: T1?, p2: T2?, block: (T1, T2) -> R?): R? {
    return if (p1 != null && p2 != null) block(p1, p2) else null
}

private fun <T1 : String?, T2 : Any, R : Any> safeLetWithEmptyString(p1: T1, p2: T2?, block: (T1, T2) -> R?): R? {
    return if (p1 != null && p2 != null && p1.isNotEmpty()) block(p1, p2) else null
}

private fun <T1 : String?, R : Any> safeLetWithOneNullAndEmptyString(p1: T1, block: (T1) -> R?): R? {
    return if (p1 != null && p1.isNotEmpty()) block(p1) else null
}


