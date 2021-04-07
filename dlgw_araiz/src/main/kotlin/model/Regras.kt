package model

data class Regras(
        val ID_REGRAS: String,
        val REG_DESCR: String,
        val REG_GRUPO: String,
        val REG_MENU: String,
        val REG_ATIVO: String,
        val REG_MODULO: String
) {

    var isArchived = false
    var isDone = false

    fun markAsDone() {
        isDone = true
    }

    fun archive() {
        isArchived = true
    }

}