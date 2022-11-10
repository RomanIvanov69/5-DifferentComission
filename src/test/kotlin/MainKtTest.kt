package ru.netology

import org.junit.Test
import kotlin.test.assertEquals

class MainKtTest {

    @Test
    fun testVisaMir() {
        val cardType = "VISA"
        val transferCount = 100_000
        val previousMoneyTransfers = 50_000

        val result = calcCommission(
            cardType = cardType,
            transferCount = transferCount,
            previousMoneyTransfers = previousMoneyTransfers
        )
        assertEquals("750 рублей", actual = result)
    }

    @Test
    fun testCommVisaMir() {
        val cardType = "VISA"
        val transferCount = 1_000
        val previousMoneyTransfers = 0

        val result = calcCommission(
            cardType = cardType,
            transferCount = transferCount,
            previousMoneyTransfers = previousMoneyTransfers
        )
        assertEquals("75 рублей", actual = result)
    }

    @Test
    fun testMaxPreviousVisaMir() {
        val cardType = "VISA"
        val transferCount = 1_000
        val previousMoneyTransfers = 700_000

        val result = calcCommission(
            cardType = cardType,
            transferCount = transferCount,
            previousMoneyTransfers = previousMoneyTransfers
        )
        assertEquals("Месячный лимит превышен", actual = result)
    }

    @Test
    fun testMaxDayLimitVisaMir() {
        val cardType = "VISA"
        val transferCount = 170_000
        val previousMoneyTransfers = 100_000

        val result = calcCommission(
            cardType = cardType,
            transferCount = transferCount,
            previousMoneyTransfers = previousMoneyTransfers
        )
        assertEquals("Дневной лимит превышен", actual = result)
    }

    @Test
    fun testCommissMastercardMaestro() {
        val cardType = "MasterCard"
        val transferCount = 1_000
        val previousMoneyTransfers = 0

        val result = calcCommission(
            cardType = cardType,
            transferCount = transferCount,
            previousMoneyTransfers = previousMoneyTransfers
        )
        assertEquals("Комиссия 0 руб", actual = result)
    }

    @Test
    fun testMaxLimitMastercardMaestro() {
        val cardType = "Maestro"
        val transferCount = 170_000
        val previousMoneyTransfers = 100_000

        val result = calcCommission(
            cardType = cardType,
            transferCount = transferCount,
            previousMoneyTransfers = previousMoneyTransfers
        )
        assertEquals("Дневной лимит превышен", actual = result)
    }

    @Test
    fun testMaxLimitMonthMastercardMaestro() {
        val cardType = "Maestro"
        val transferCount = 170_000
        val previousMoneyTransfers = 700_000

        val result = calcCommission(
            cardType = cardType,
            transferCount = transferCount,
            previousMoneyTransfers = previousMoneyTransfers
        )
        assertEquals("Месячный лимит превышен", actual = result)
    }

    @Test
    fun testMaxLimitVKPAY() {
        val cardType = "VKPay"
        val transferCount = 100_000
        val previousMoneyTransfers = 500_000

        val result = calcCommission(
            cardType = cardType,
            transferCount = transferCount,
            previousMoneyTransfers = previousMoneyTransfers
        )
        assertEquals("Месячный лимит превышен", actual = result)
    }
    @Test
    fun testMaxLimitDayVKPAY() {
        val cardType = "VKPay"
        val transferCount = 50_000
        val previousMoneyTransfers = 0

        val result = calcCommission(
            cardType = cardType,
            transferCount = transferCount,
            previousMoneyTransfers = previousMoneyTransfers
        )
        assertEquals("Слишком большая сумма", actual = result)
    }
    @Test
    fun testCommissionVKPAY() {
        val cardType = "VKPay"
        val transferCount = 100
        val previousMoneyTransfers = 0

        val result = calcCommission(
            cardType = cardType,
            transferCount = transferCount,
            previousMoneyTransfers = previousMoneyTransfers
        )
        assertEquals("нет комиссии", actual = result)
    }
}



