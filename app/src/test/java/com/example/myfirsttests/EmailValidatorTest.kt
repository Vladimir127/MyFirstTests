package com.example.myfirsttests

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class EmailValidatorTest {

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.com"))
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.co.uk"))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email..com"))
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@email.com"))
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null))
    }

    @Test
    fun emailValidator_CyrillicLetters_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("володя@email.com"))
    }

    @Test
    fun emailValidator_NoDomain_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("example.com"))
    }

    @Test
    fun emailValidator_SpecialSymbol_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("example?@email.com"))
    }

    @Test
    fun emailValidator_ContainsSpaces_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("my email address@email.com"))
    }

    @Test
    fun emailValidator_TooLongDomainFirstLevel_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("example@email.qwertyuiopasdfghjklzxcvbnmqwerty"))
    }

    @Test
    fun emailValidator_TooLongDomainSecondLevel_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("example@qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnm.com"))
    }

    @Test
    fun emailValidator_TooLongUserName_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnm@email.com"))
    }
}
