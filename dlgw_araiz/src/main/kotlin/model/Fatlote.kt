package model

import utils.ff
import utils.ffVss
import kotlin.js.Date

open class Fatlote {
    var FAT_EMPRESA = 0
    var FAT_LOTE = 0
    var FAT_DATA = ff.InicialDate
    var FAT_ATUALIZADO = ""
    var FAT_TITULO = ""
    var FAT_TIPO = ""
    var FAT_LOTEORIGINAL = 0
    var FAT_ARM = ""

    fun construtor(EMPRESA: Int, LOTE: Int, DATA: Date,
                   ATUALIZADO: String, TITULO: String, TIPO: String,
                   LOTEORIGINAL: Int, ARM: String): Fatlote {
        this.FAT_EMPRESA = EMPRESA
        this.FAT_LOTE = LOTE
        this.FAT_DATA = DATA
        this.FAT_ATUALIZADO = ATUALIZADO
        this.FAT_TITULO = TITULO
        this.FAT_TIPO = TIPO
        this.FAT_LOTEORIGINAL = FAT_LOTEORIGINAL
        this.FAT_ARM = FAT_ARM
        return this
    }
}