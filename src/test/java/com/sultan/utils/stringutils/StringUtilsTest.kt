package com.example.stringutils

import com.sultan.utils.stringutils.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import java.util.regex.Pattern

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 */
class StringUtilsTest {

    private lateinit var mockStringUtils: StringUtils

    @Before
    fun initialize() {
        mockStringUtils = mock(StringUtils::class.java)
    }

    @Test
    fun test_isNullOrEmpty_whenValueIsNull() {
        assertTrue(mockStringUtils.isNullOrEmpty(null))
    }

    @Test
    fun test_isNullOrEmpty_whenValueIsEmpty() {
        assertTrue(mockStringUtils.isNullOrEmpty(""))
    }

    @Test
    fun test_isNullOrEmpty_whenValueIsNotNull() {
        assertFalse(mockStringUtils.isNullOrEmpty("hi"))
    }

    @Test
    fun test_isNotNullorEmpty_whenValueIsNull() {
        assertFalse(mockStringUtils.isNotNullorEmpty(null))
    }

    @Test
    fun test_isNotNullorEmpty_whenValueIsEmpty() {
        assertFalse(mockStringUtils.isNotNullorEmpty(""))
    }

    @Test
    fun test_isNotNullorEmpty_whenValueIsNotNull() {
        assertTrue(mockStringUtils.isNotNullorEmpty("hi"))
    }

    @Test
    fun test_areEqual_whenBothValuesAreNull() {
        assertFalse(mockStringUtils.areEqual(null, null))
    }

    @Test
    fun test_areEqual_whenSecondValueNull() {
        assertFalse(mockStringUtils.areEqual("hi", null))
    }

    @Test
    fun test_areEqual_whenFirstValueIsNull() {
        assertFalse(mockStringUtils.areEqual(null, "hi"))
    }

    @Test
    fun test_areEqual_whenBothValueAreEmpty() {
        assertTrue(mockStringUtils.areEqual("", ""))
    }

    @Test
    fun test_areEqual_whenBothValueAreSame() {
        assertTrue(mockStringUtils.areEqual("abc", "abc"))
    }

    @Test
    fun test_areEqual_whenBothValueAreNonCaseSensitive() {
        assertFalse(mockStringUtils.areEqual("aBc", "abc"))
    }

    @Test
    fun test_areEqual_whenBothValueAreDifferent() {
        assertFalse(mockStringUtils.areEqual("abc", "abd"))
    }

    @Test
    fun test_isEqual_whenBothValuesAreNull() {
        val s1: String? = null
        assertFalse(s1.isEqual(null))
    }

    @Test
    fun test_isEqual_whenFirstValueNull() {
        val s1: String? = null
        assertFalse(s1.isEqual("hi"))
    }

    @Test
    fun test_isEqual_whenSecondValueIsNull() {
        val s1 = "hi"
        assertFalse(s1.isEqual(null))
    }

    @Test
    fun test_isEqual_whenBothValueAreEmpty() {
        val s1 = ""
        assertTrue(s1.isEqual(""))
    }

    @Test
    fun test_isEqual_whenBothValueAreSame() {
        val s1 = "abc"
        assertTrue(s1.isEqual("abc"))
    }

    @Test
    fun test_isEqual_whenBothValueAreNonCaseSensitive() {
        val s1 = "aBc"
        assertFalse(s1.isEqual("abc"))
    }

    @Test
    fun test_isEqual_whenBothValueAreDifferent() {
        val s1 = "abc"
        assertFalse(s1.isEqual("abd"))
    }

    @Test
    fun test_areEqualIgnoreCase_whenBothValuesAreNull() {
        assertFalse(mockStringUtils.areEqualIgnoreCase(null, null))
    }

    @Test
    fun test_areEqualIgnoreCase_whenSecondValueNull() {
        assertFalse(mockStringUtils.areEqualIgnoreCase("hi", null))
    }

    @Test
    fun test_areEqualIgnoreCase_whenFirstValueIsNull() {
        assertFalse(mockStringUtils.areEqualIgnoreCase(null, "hi"))
    }

    @Test
    fun test_areEqualIgnoreCase_whenBothValueAreEmpty() {
        assertTrue(mockStringUtils.areEqualIgnoreCase("", ""))
    }

    @Test
    fun test_areEqualIgnoreCase_whenBothValueAreSame() {
        assertTrue(mockStringUtils.areEqualIgnoreCase("abc", "abc"))
    }

    @Test
    fun test_areEqualIgnoreCase_whenBothValueAreNonCaseSensitive() {
        assertTrue(mockStringUtils.areEqualIgnoreCase("aBc", "abc"))
    }

    @Test
    fun test_areEqualIgnoreCase_whenBothValueAreDifferent() {
        assertFalse(mockStringUtils.areEqualIgnoreCase("abc", "abd"))
    }

    @Test
    fun test_isEqualIgnoreCase_whenBothValuesAreNull() {
        val s1: String? = null
        assertFalse(s1.isEqualIgnoreCase(null))
    }

    @Test
    fun test_isEqualIgnoreCase_whenFirstValueNull() {
        val s1: String? = null
        assertFalse(s1.isEqualIgnoreCase("hi"))
    }

    @Test
    fun test_isEqualIgnoreCase_whenSecondValueIsNull() {
        val s1 = "hi"
        assertFalse(s1.isEqualIgnoreCase(null))
    }

    @Test
    fun test_isEqualIgnoreCase_whenBothValueAreEmpty() {
        val s1 = ""
        assertTrue(s1.isEqualIgnoreCase(""))
    }

    @Test
    fun test_isEqualIgnoreCase_whenBothValueAreSame() {
        val s1 = "abc"
        assertTrue(s1.isEqualIgnoreCase("abc"))
    }

    @Test
    fun test_isEqualIgnoreCase_whenBothValueAreNonCaseSensitive() {
        val s1 = "aBc"
        assertTrue(s1.isEqualIgnoreCase("abc"))
    }

    @Test
    fun test_isEqualIgnoreCase_whenBothValueAreDifferent() {
        val s1 = "abc"
        assertFalse(s1.isEqualIgnoreCase("abd"))
    }

    @Test
    fun test_isValidEmail_whenValueIsNull() {
        assertFalse(mockStringUtils.isValidEmail(null))
    }

    @Test
    fun test_isValidEmail_whenValueIsEmpty() {
        `when`(mockStringUtils.getEmailPattern()).thenReturn(EMAIL_PATTERN)
        assertFalse(mockStringUtils.isValidEmail(""))
    }

    @Test
    fun test_isValidEmail_whenEmailIsWrongFormat() {
        `when`(mockStringUtils.getEmailPattern()).thenReturn(EMAIL_PATTERN)
        assertFalse(mockStringUtils.isValidEmail("abc@yahooocom"))
    }

    @Test
    fun test_isValidEmail_whenEmailIsWrongFormat2() {
        `when`(mockStringUtils.getEmailPattern()).thenReturn(EMAIL_PATTERN)
        assertFalse(mockStringUtils.isValidEmail("abc.yahoo.com"))
    }

    @Test
    fun test_isValidEmail_whenEmailIsWrongFormat3() {
        `when`(mockStringUtils.getEmailPattern()).thenReturn(EMAIL_PATTERN)
        assertFalse(mockStringUtils.isValidEmail("abc@ yahoo.com"))
    }

    @Test
    fun test_isValidEmail_whenEmailIsWrongFormat4() {
        `when`(mockStringUtils.getEmailPattern()).thenReturn(EMAIL_PATTERN)
        assertFalse(mockStringUtils.isValidEmail("abc@yahoo.com.abc "))
    }

    @Test
    fun test_isValidEmail_whenEmailIsValid() {
        `when`(mockStringUtils.getEmailPattern()).thenReturn(EMAIL_PATTERN)
        assertTrue(mockStringUtils.isValidEmail("abc@yahoo.com"))
    }

    @Test
    fun test_isValidUrl_whenValueIsNull() {
        assertFalse(mockStringUtils.isValidUrl(null))
    }

    @Test
    fun test_isValidUrl_whenValueIsEmpty() {
        `when`(mockStringUtils.getWebUrlPattern()).thenReturn(URL_PATTERN)
        assertFalse(mockStringUtils.isValidUrl(""))
    }

    @Test
    fun test_isValidUrl_whenUrlIsWrongFormat() {
        `when`(mockStringUtils.getWebUrlPattern()).thenReturn(URL_PATTERN)
        assertFalse(mockStringUtils.isValidUrl("abc@yahooocom"))
    }

    @Test
    fun test_isValidUrl_whenUrlIsWrongFormat2() {
        `when`(mockStringUtils.getWebUrlPattern()).thenReturn(URL_PATTERN)
        assertFalse(mockStringUtils.isValidUrl("abc@yahoo.com"))
    }

    @Test
    fun test_isValidUrl_whenUrlIsWrongFormat3() {
        `when`(mockStringUtils.getWebUrlPattern()).thenReturn(URL_PATTERN)
        assertFalse(mockStringUtils.isValidUrl("www.google.com "))
    }

    @Test
    fun test_isValidUrl_whenUrlIsWrongFormat4() {
        `when`(mockStringUtils.getWebUrlPattern()).thenReturn(URL_PATTERN)
        assertFalse(mockStringUtils.isValidUrl("www.google.com.abc "))
    }

    @Test
    fun test_isValidUrl_whenUrlIsValidWithoutHttp() {
        `when`(mockStringUtils.getWebUrlPattern()).thenReturn(URL_PATTERN)
        assertTrue(mockStringUtils.isValidUrl("www.yahoo.com"))
    }

    @Test
    fun test_isValidUrl_whenUrlIsValidWithHttp() {
        `when`(mockStringUtils.getWebUrlPattern()).thenReturn(URL_PATTERN)
        assertTrue(mockStringUtils.isValidUrl("http://www.yahoo.com"))
    }

    @Test
    fun test_hasValidPattern_whenStringHasInvalidPattern1() {
        assertFalse(mockStringUtils.hasValidPattern("www.yahoo.com", EMAIL_PATTERN))
    }

    @Test
    fun test_hasValidPattern_whenStringHasInvalidPattern2() {
        assertFalse(mockStringUtils.hasValidPattern("www@yahoo.com", URL_PATTERN))
    }

    @Test
    fun test_hasValidPattern_whenStringHasValidPattern1() {
        assertTrue(mockStringUtils.hasValidPattern("mail@yahoo.com", EMAIL_PATTERN))
    }

    @Test
    fun test_hasValidPattern_whenStringHasValidPattern2() {
        assertTrue(mockStringUtils.hasValidPattern("www.yahoo.com", URL_PATTERN))
    }

    @Test
    fun test_convertCommaSeperatedStringToList_whenCommaSeperatedStringIsPassed() {
        val str = "apple,banana,mango,orange,grapes";
        assertEquals(getFruitList(), mockStringUtils.convertCommaSeperatedStringToList(str))
    }

    @Test
    fun test_convertCommaSeperatedStringToList_whenCommaSeperatedStringWithSpacesIsPassed1() {
        val str = "apple ,banana ,mango ,orange ,grapes";
        assertEquals(getFruitList(), mockStringUtils.convertCommaSeperatedStringToList(str))
    }

    @Test
    fun test_convertCommaSeperatedStringToList_whenCommaSeperatedStringWithSpacesIsPassed2() {
        val str = "apple, banana, mango, orange, grapes";
        assertEquals(getFruitList(), mockStringUtils.convertCommaSeperatedStringToList(str))
    }

    @Test
    fun test_convertCommaSeperatedStringToList_whenCommaSeperatedStringWithSpacesIsPassed3() {
        val str = " apple , banana , mango , orange , grapes";
        assertEquals(getFruitList(), mockStringUtils.convertCommaSeperatedStringToList(str))
    }

    @Test
    fun test_convertCommaSeperatedStringToList_whenNullStringIsPassed() {
        assertEquals(ArrayList<String>(), mockStringUtils.convertCommaSeperatedStringToList(null))
    }

    @Test
    fun test_convertCommaSeperatedStringToList_whenEmptyStringIsPassed() {
        assertEquals(ArrayList<String>(), mockStringUtils.convertCommaSeperatedStringToList(""))
    }

    @Test
    fun test_convertCharSeperatedStringToList_whenCommaSeperatedStringIsPassed() {
        val str = "apple.banana.mango.orange.grapes";
        assertEquals(getFruitList(), mockStringUtils.convertCharSeperatedStringToList(str, '.'))
    }

    @Test
    fun test_convertCharSeperatedStringToList_whenCommaSeperatedStringWithSpacesIsPassed1() {
        val str = "apple ,banana ,mango ,orange ,grapes";
        assertEquals(getFruitList(), mockStringUtils.convertCommaSeperatedStringToList(str))
    }

    @Test
    fun test_convertCharSeperatedStringToList_whenCommaSeperatedStringWithSpacesIsPassed2() {
        val str = "apple* banana* mango* orange* grapes";
        assertEquals(getFruitList(), mockStringUtils.convertCharSeperatedStringToList(str, '*'))
    }

    @Test
    fun test_convertCharSeperatedStringToList_whenCommaSeperatedStringWithSpacesIsPassed3() {
        val str = " apple - banana - mango - orange - grapes";
        assertEquals(getFruitList(), mockStringUtils.convertCharSeperatedStringToList(str, '-'))
    }

    @Test
    fun test_convertCharSeperatedStringToList_whenNullStringIsPassed() {
        assertEquals(ArrayList<String>(), mockStringUtils.convertCharSeperatedStringToList(null, '-'))
    }

    @Test
    fun test_convertCharSeperatedStringToList_whenEmptyStringIsPassed() {
        assertEquals(ArrayList<String>(), mockStringUtils.convertCharSeperatedStringToList("", '\''))
    }

    @Test
    fun test_convertStringListToCommaSeperatedString_whenNullListIsPassed() {
        assertEquals("", mockStringUtils.convertStringListToCommaSeperatedString(null))
    }

    @Test
    fun test_convertStringListToCommaSeperatedString_whenEmptyListIsPassed() {
        assertEquals("", mockStringUtils.convertStringListToCommaSeperatedString(ArrayList()))
    }

    @Test
    fun test_convertStringListToCommaSeperatedString_whenListIsPassed() {
        val str = "apple,banana,mango,orange,grapes";
        assertEquals(str, mockStringUtils.convertStringListToCommaSeperatedString(getFruitList()))
    }


    @Test
    fun test_convertStringListToCharSeperatedString_whenNullListIsPassed() {
        assertEquals("", mockStringUtils.convertStringListToCharSeperatedString(null, ','))
    }

    @Test
    fun test_convertStringListToCharSeperatedString_whenEmptyListIsPassed() {
        assertEquals("", mockStringUtils.convertStringListToCharSeperatedString(ArrayList(), ','))
    }

    @Test
    fun test_convertStringListToCharSeperatedString_whenListIsPassed1() {
        val str = "apple,banana,mango,orange,grapes";
        assertEquals(str, mockStringUtils.convertStringListToCharSeperatedString(getFruitList(), ','))
    }

    @Test
    fun test_convertStringListToCharSeperatedString_whenListIsPassed2() {
        val str = "apple*banana*mango*orange*grapes";
        assertEquals(str, mockStringUtils.convertStringListToCharSeperatedString(getFruitList(), '*'))
    }

    @Test
    fun test_convertStringListToCharSeperatedString_whenListIsPassed3() {
        val str = "apple-banana-mango-orange-grapes";
        assertEquals(str, mockStringUtils.convertStringListToCharSeperatedString(getFruitList(), '-'))
    }

    @Test
    fun test_convertStringListToCharSeperatedString_whenListIsPassed4() {
        val str = "apple\'banana\'mango\'orange\'grapes";
        assertEquals(str, mockStringUtils.convertStringListToCharSeperatedString(getFruitList(), '\''))
    }

    @Test
    fun test_capitalize_whenNullIsPassed() {
        assertEquals(null, mockStringUtils.capitalize(null))
    }

    @Test
    fun test_capitalize_whenEmptyIsPassed() {
        assertEquals("", mockStringUtils.capitalize(""))
    }

    @Test
    fun test_capitalize_whenSmallCaseIsPassed() {
        assertEquals("Hello", mockStringUtils.capitalize("hello"))
    }

    @Test
    fun test_capitalize_whenCapitalCaseIsPassed() {
        assertEquals("HELLO", mockStringUtils.capitalize("HELLO"))
    }

    @Test
    fun test_capitalize_whenCamelCaseIsPassed() {
        assertEquals("HeLLo", mockStringUtils.capitalize("heLLo"))
    }

    @Test
    fun test_capitalize_whenCapitalizeStringIsPassed() {
        assertEquals("Hello", mockStringUtils.capitalize("Hello"))
    }

    @Test
    fun test_deCapitalize_whenNullIsPassed() {
        assertEquals(null, mockStringUtils.deCapitalize(null))
    }

    @Test
    fun test_deCapitalize_whenEmptyIsPassed() {
        assertEquals("", mockStringUtils.deCapitalize(""))
    }

    @Test
    fun test_deCapitalize_whenSmallCaseIsPassed() {
        assertEquals("hello", mockStringUtils.deCapitalize("hello"))
    }

    @Test
    fun test_deCapitalize_whenCapitalCaseIsPassed() {
        assertEquals("hELLO", mockStringUtils.deCapitalize("HELLO"))
    }

    @Test
    fun test_deCapitalize_whenCamelCaseIsPassed() {
        assertEquals("heLLo", mockStringUtils.deCapitalize("heLLo"))
    }

    @Test
    fun test_deCapitalize_whenCapitalizeStringIsPassed() {
        assertEquals("hello", mockStringUtils.deCapitalize("Hello"))
    }

    @Test
    fun test_lowerCase_whenNullIsPassed() {
        assertEquals(null, mockStringUtils.lowerCase(null))
    }

    @Test
    fun test_lowerCase_whenEmptyIsPassed() {
        assertEquals("", mockStringUtils.lowerCase(""))
    }

    @Test
    fun test_lowerCase_whenSmallCaseIsPassed() {
        assertEquals("hello", mockStringUtils.lowerCase("hello"))
    }

    @Test
    fun test_lowerCase_whenCapitalCaseIsPassed() {
        assertEquals("hello", mockStringUtils.lowerCase("HELLO"))
    }

    @Test
    fun test_lowerCase_whenCamelCaseIsPassed() {
        assertEquals("hello", mockStringUtils.lowerCase("heLLo"))
    }

    @Test
    fun test_lowerCase_whenCapitalizeStringIsPassed() {
        assertEquals("hello", mockStringUtils.lowerCase("Hello"))
    }

    @Test
    fun test_upperCase_whenNullIsPassed() {
        assertEquals(null, mockStringUtils.upperCase(null))
    }

    @Test
    fun test_upperCase_whenEmptyIsPassed() {
        assertEquals("", mockStringUtils.upperCase(""))
    }

    @Test
    fun test_upperCase_whenSmallCaseIsPassed() {
        assertEquals("HELLO", mockStringUtils.upperCase("hello"))
    }

    @Test
    fun test_upperCase_whenCapitalCaseIsPassed() {
        assertEquals("HELLO", mockStringUtils.upperCase("HELLO"))
    }

    @Test
    fun test_upperCase_whenCamelCaseIsPassed() {
        assertEquals("HELLO", mockStringUtils.upperCase("heLLo"))
    }

    @Test
    fun test_upperCase_whenCapitalizeStringIsPassed() {
        assertEquals("HELLO", mockStringUtils.upperCase("Hello"))
    }

    @Test
    fun test_removePrefix_whenNullStringIsPassed(){
        assertEquals(null, mockStringUtils.removePrefix(null, "hi") )
    }

    @Test
    fun test_removePrefix_whenNullPrefixIsPassed(){
        val str = "Hi, i am sultan here"
        assertEquals(str, mockStringUtils.removePrefix(str, null) )
    }

    @Test
    fun test_removePrefix_whenPrefixIsNotFound(){
        val str = "Hi, i am sultan here"
        assertEquals(str, mockStringUtils.removePrefix(str, "sultan") )
    }

    @Test
    fun test_removePrefix_whenPrefixIsCaseSensitive(){
        val str = "Hi, i am sultan here"
        assertEquals(str, mockStringUtils.removePrefix(str, "hi") )
    }

    @Test
    fun test_removePrefix_whenPrefixIsSame(){
        val str = "Hi, i am sultan here"
        assertEquals(", i am sultan here", mockStringUtils.removePrefix(str, "Hi") )
    }

    @Test
    fun test_removeSuffix_whenNullStringIsPassed(){
        assertEquals(null, mockStringUtils.removeSuffix(null, "hi") )
    }

    @Test
    fun test_removeSuffix_whenNullSuffixIsPassed(){
        val str = "Hi, i am sultan here"
        assertEquals(str, mockStringUtils.removeSuffix(str, null) )
    }

    @Test
    fun test_removeSuffix_whenSuffixIsNotFound(){
        val str = "Hi, i am sultan here"
        assertEquals(str, mockStringUtils.removeSuffix(str, "sultan") )
    }

    @Test
    fun test_removeSuffix_whenSuffixIsCaseSensitive(){
        val str = "Hi, i am sultan here"
        assertEquals(str, mockStringUtils.removeSuffix(str, "Here") )
    }

    @Test
    fun test_removeSuffix_whenPrefixIsSame(){
        val str = "Hi, i am sultan here"
        assertEquals("Hi, i am sultan ", mockStringUtils.removeSuffix(str, "here") )
    }

    @Test
    fun test_remove_whenNullStringIsPassed(){
        assertEquals(null, mockStringUtils.remove(null, "hi") )
    }

    @Test
    fun test_remove_whenNullSubstringIsPassed(){
        val str = "Hi, i am sultan here"
        assertEquals(str, mockStringUtils.remove(str, null) )
    }

    @Test
    fun test_remove_whenSubstringIsEmpty(){
        val str = "Hi, i am sultan here"
        assertEquals(str, mockStringUtils.remove(str, "") )
    }

    @Test
    fun test_remove_whenSubStringSensitive(){
        val str = "Hi, i am sultan here"
        assertEquals(str, mockStringUtils.remove(str, "Sultan") )
    }

    @Test
    fun test_remove_whenSubStringIsSame(){
        val str = "Hi, i am sultan here"
        assertEquals("Hi, i am  here", mockStringUtils.remove(str, "sultan") )
    }

    @Test
    fun test_remove_whenMultipleSubStringIsPassed(){
        val str = "Hi, I am sultan here. I am an Engineer"
        assertEquals("Hi,  sultan here.  an Engineer", mockStringUtils.remove(str, "I am") )
    }

    @Test
    fun test_toInt_whenStringIsNull(){
        val str : String? = null
        assertEquals(0, str.convertToInt() )
    }

    @Test
    fun test_toInt_whenStringIsEmpty(){
        assertEquals(0, "".convertToInt() )
    }

    @Test
    fun test_toInt_whenStringIsNotANumber(){
        assertEquals(0, "sultan".convertToInt() )
    }

    @Test
    fun test_toInt_whenStringIsAFloat(){
        assertEquals(0, "30.6".convertToInt() )
    }

    @Test
    fun test_toInt_whenStringIsANumber(){
        assertEquals(20, "20".convertToInt() )
    }

    @Test
    fun test_toInt_whenStringIsNullAndDefaultIsPassed(){
        val str : String? = null
        assertEquals(10, str.convertToInt(10) )
    }

    @Test
    fun test_toInt_whenStringIsAndDefaultIsPassed(){
        assertEquals(10, "".convertToInt(10) )
    }

    @Test
    fun test_toInt_whenStringIsNotANumberAndDefaultIsPassed(){
        assertEquals(10, "sultan".convertToInt(10) )
    }

    @Test
    fun test_toInt_whenStringIsAFloatAndDefaultIsPassed(){
        assertEquals(10, "30.6".convertToInt(10) )
    }

    @Test
    fun test_toInt_whenStringIsANumberAndDefaultIsPassed(){
        assertEquals(20, "20".convertToInt(10) )
    }

    @Test
    fun test_toDouble_whenStringIsNull(){
        val str : String? = null
        assertEquals(0.0, str.convertToDouble(), 0.0 )
    }

    @Test
    fun test_toDouble_whenStringIsEmpty(){
        assertEquals(0.0, "".convertToDouble(), 0.0 )
    }

    @Test
    fun test_toDouble_whenStringIsNotANumber(){
        assertEquals(0.0, "sultan".convertToDouble(), 0.0 )
    }

    @Test
    fun test_toDouble_whenStringIsAFloat(){
        assertEquals(30.6, "30.6".convertToDouble(), 0.0 )
    }

    @Test
    fun test_toDouble_whenStringIsANumber(){
        assertEquals(20.0, "20".convertToDouble(), 0.0 )
    }

    @Test
    fun test_toDouble_whenStringIsNullAndDefaultIsPassed(){
        val str : String? = null
        assertEquals(10.5, str.convertToDouble(10.5), 0.0 )
    }

    @Test
    fun test_toDouble_whenStringIsAndDefaultIsPassed(){
        assertEquals(10.0, "".convertToDouble(10.0), 0.0 )
    }

    @Test
    fun test_toDouble_whenStringIsNotANumberAndDefaultIsPassed(){
        assertEquals(10.5, "sultan".convertToDouble(10.5), 0.0 )
    }

    @Test
    fun test_toDouble_whenStringIsANumberAndDefaultIsPassed(){
        assertEquals(30.0, "30".convertToDouble(10.5), 0.0 )
    }

    @Test
    fun test_toDouble_whenStringIsADoubleAndDefaultIsPassed(){
        assertEquals(20.5, "20.5".convertToDouble(30.0), 0.0 )
    }

    @Test
    fun test_toLong_whenStringIsNull(){
        val str : String? = null
        assertEquals(0, str.convertToLong() )
    }

    @Test
    fun test_toLong_whenStringIsEmpty(){
        assertEquals(0, "".convertToLong() )
    }

    @Test
    fun test_toLong_whenStringIsNotANumber(){
        assertEquals(0, "sultan".convertToLong() )
    }

    @Test
    fun test_toLong_whenStringIsAFloat(){
        assertEquals(0, "30.6".convertToLong() )
    }

    @Test
    fun test_toLong_whenStringIsANumber(){
        assertEquals(20, "20".convertToLong() )
    }

    @Test
    fun test_toLong_whenStringIsNullAndDefaultIsPassed(){
        val str : String? = null
        assertEquals(10, str.convertToLong(10) )
    }

    @Test
    fun test_toLong_whenStringIsAndDefaultIsPassed(){
        assertEquals(10, "".convertToLong(10) )
    }

    @Test
    fun test_toLong_whenStringIsNotANumberAndDefaultIsPassed(){
        assertEquals(10, "sultan".convertToLong(10) )
    }

    @Test
    fun test_toLong_whenStringIsAFloatAndDefaultIsPassed(){
        assertEquals(10, "30.6".convertToLong(10) )
    }

    @Test
    fun test_toLong_whenStringIsANumberAndDefaultIsPassed(){
        assertEquals(20, "20".convertToLong(10) )
    }

    @Test
    fun test_toBoolean_whenStringIsNull(){
        val str : String? = null
        assertEquals(false, str.convertToBoolean() )
    }

    @Test
    fun test_toBoolean_whenStringIsEmpty(){
        assertEquals(false, "".convertToBoolean() )
    }

    @Test
    fun test_toBoolean_whenStringIsName(){
        assertEquals(false, "sultan".convertToBoolean() )
    }

    @Test
    fun test_toBoolean_whenStringIsFalse(){
        assertEquals(false, "False".convertToBoolean() )
    }

    @Test
    fun test_toBoolean_whenStringIsTrue(){
        assertEquals(true, "True".convertToBoolean() )
    }

    @Test
    fun test_toBoolean_whenStringIsfalse(){
        assertEquals(false, "false".convertToBoolean() )
    }

    @Test
    fun test_toBoolean_whenStringIstrue(){
        assertEquals(true, "true".convertToBoolean() )
    }

    @Test
    fun test_toBoolean_whenStringIsFALSE(){
        assertEquals(false, "FALSE".convertToBoolean() )
    }

    @Test
    fun test_toBoolean_whenStringIsTRUE(){
        assertEquals(true, "TRUE".convertToBoolean() )
    }

    @Test
    fun test_toBoolean_whenStringIsNullAndDefaultIsPassed(){
        val str : String? = null
        assertEquals(false, str.convertToBoolean(false) )
    }

    @Test
    fun test_toBoolean_whenStringIsEmptyAndDefaultIsPassed(){
        assertEquals(false, "".convertToBoolean(false) )
    }

    @Test
    fun test_toBoolean_whenStringIsNameAndDefaultIsPassed(){
        assertEquals(false, "sultan".convertToBoolean(false) )
    }

    @Test
    fun test_toBoolean_whenStringIsFalseAndDefaultIsPassed(){
        assertEquals(false, "False".convertToBoolean(true) )
    }

    @Test
    fun test_toBoolean_whenStringIsTrueAndDefaultIsPassed(){
        assertEquals(true, "True".convertToBoolean(false) )
    }

    @Test
    fun test_toBoolean_whenStringIsfalseAndDefaultIsPassed(){
        assertEquals(false, "false".convertToBoolean(true) )
    }

    @Test
    fun test_toBoolean_whenStringIstrueAndDefaultIsPassed(){
        assertEquals(true, "true".convertToBoolean(false) )
    }

    @Test
    fun test_toBoolean_whenStringIsFALSEAndDefaultIsPassed(){
        assertEquals(false, "FALSE".convertToBoolean(true) )
    }

    @Test
    fun test_toBoolean_whenStringIsTRUEAndDefaultIsPassed(){
        assertEquals(true, "TRUE".convertToBoolean(false) )
    }


    private val EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    )

    private val URL_PATTERN = Pattern.compile("^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?\$")

    private fun getFruitList() : List<String>{
        val list = ArrayList<String>()
        list.add("apple")
        list.add("banana")
        list.add("mango")
        list.add("orange")
        list.add("grapes")
        return list
    }
}
