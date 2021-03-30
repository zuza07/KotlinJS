package model

import utils.ff
import kotlin.js.Date

open class Indprocesso {
    var INDPRO_EMPRESA = 0
    var INDPRO_PROCESSO	= 0
    var INDPRO_TITULO = ""
    var INDPRO_FORNEC = ""
    var INDPRO_DATA	= ff.InicialDate
    var INDPRO_DTPREV = ff.InicialDate
    var INDPRO_ESTRUTURA = 0
    var INDPRO_OBS = ""
    var INDPRO_ESTCONTROLE = 0

    fun construtor(EMPRESA: Int, PROCESSO: Int, TITULO: String, FORNEC: String,
                   DATA: Date, DTPREV: Date, ESTRUTURA: Int, OBS: String, ESTCONTROLE: Int): Indprocesso {
        this.INDPRO_EMPRESA = EMPRESA
        this.INDPRO_PROCESSO = PROCESSO
        this.INDPRO_TITULO = TITULO
        this.INDPRO_FORNEC = FORNEC
        this.INDPRO_DATA = DATA
        this.INDPRO_DTPREV = DTPREV
        this.INDPRO_ESTRUTURA = ESTRUTURA
        this.INDPRO_OBS = OBS
        this.INDPRO_ESTCONTROLE = ESTCONTROLE
        return this
    }
}