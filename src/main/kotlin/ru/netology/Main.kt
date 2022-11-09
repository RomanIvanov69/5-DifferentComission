package ru.netology

const val maxLimitDay = 150_000 // максим. лимит для переводов за сутки
const val maxLimitMonth = 600_000 // максим. лимит для переводов за месяц

fun main() {
    val cardType = "Maestro"
    val transferCount = 100_000
    val previousMoneyTransfers = 50_000


    val commission = calcCommission(
        cardType = cardType,
        transferCount = transferCount,
        previousMoneyTransfers = previousMoneyTransfers
    )
    println("При переводе: $transferCount рублей с карты $cardType, комиссия составит: $commission")
}

fun calcCommission(cardType: String = "VK PAY", previousMoneyTransfers: Int = 0, transferCount: Int): String {
    return when (cardType) {
        "VISA", "Mir" -> commissionVisaMir(transferCount, previousMoneyTransfers)
        "MasterCard", "Maestro" -> commissionMastercardMaestro(transferCount, previousMoneyTransfers)
        else -> commissionVkPay(transferCount, previousMoneyTransfers)
    }
}

fun commissionVisaMir(transferCount: Int, previousMoneyTransfers: Int): String {
    val commissionForVisaMir = 0.075 // комиссия за перевод с Visa и Mir
    val minCommissionVisaMir = 35 // миним. комиссия за перевод с Visa и Mir
    var calculation = (transferCount * commissionForVisaMir).toInt()
    if (previousMoneyTransfers >= maxLimitMonth) return "Месячный лимит превышен"
    else if (transferCount >= maxLimitDay) return "Дневной лимит превышен"
    else if (calculation < minCommissionVisaMir) return "комиссия 35 руб"
    else return "$calculation рублей"
}

fun commissionVkPay(transferCount: Int, previousMoneyTransfers: Int): String {
    val maxLimitOneTimeVKPAY = 15000 // максим. лимит для переводов за один раз для карт VkPay
    val maxLimitMonthVKPAY = 40000 // максим. лимит для переводов за месяц для карт VkPay
    if (previousMoneyTransfers >= maxLimitMonthVKPAY) return "Месячный лимит превышен"
    else if (transferCount >= maxLimitOneTimeVKPAY) return "Слишком большая сумма"
    else return "нет комиссии"
}

fun commissionMastercardMaestro(transferCount: Int, previousMoneyTransfers: Int): String {
    val commissionForMastercardMaestro = 0.06 // комиссия за перевод с MasterCard и Maestro
    val minCommissionMastercardMaestro = 20 // миним. комиссия за перевод с MasterCard и Maestro
    var calculation = ((transferCount * commissionForMastercardMaestro) + 20).toInt()
    if (previousMoneyTransfers >= maxLimitMonth) return "Месячный лимит превышен"
    else if (transferCount >= maxLimitDay) return "Дневной лимит превышен"
    else if (transferCount <= 75000) return "Комиссия 0 руб"
    else return "$calculation рублей"
}




