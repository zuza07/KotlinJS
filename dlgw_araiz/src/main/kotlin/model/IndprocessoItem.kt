package model

import utils.ff
import kotlin.js.Date

class IndprocessoItem {
    var INDPROI_EMPRESA = 0
    var INDPROI_PROCESSO = 0
    var INDPROI_ITEM = 0
    var INDPROI_INDICE = 0.0
    var INDPROI_PRODUTO = 0
    var INDPROI_QTD = 0.0
    var INDPROI_TIPO = ""
    var INDPROI_OBS = ""
    var INDPROI_DTUTILIZADO = ff.InicialDate
    var ESTS_SALDO = 0.0
    var PRO_UNIDMED = ""
    var PRO_DESC = ""
    var CATXSUB_COR = ""

    fun construtor(EMPRESA: Int, PROCESSO: Int, ITEM: Int, INDICE: Double, PRODUTO: Int,
                   QTD: Double, TIPO: String, OBS: String, DTUTILIZADO: Date,
                   SALDO: Double, UNIDMED: String, DESC: String, CATXSUB_COR: String): IndprocessoItem {
        this.INDPROI_EMPRESA = EMPRESA
        this.INDPROI_PROCESSO = PROCESSO
        this.INDPROI_ITEM = ITEM
        this.INDPROI_INDICE = INDICE
        this.INDPROI_PRODUTO = PRODUTO
        this.INDPROI_QTD = QTD
        this.INDPROI_TIPO = TIPO
        this.INDPROI_OBS = OBS
        this.INDPROI_DTUTILIZADO = DTUTILIZADO ?: ff.InicialDate
        this.ESTS_SALDO = SALDO
        this.PRO_UNIDMED = UNIDMED
        this.PRO_DESC = DESC
        this.CATXSUB_COR = CATXSUB_COR ?: "FFFFFF"
        return this
    }
}