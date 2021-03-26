package model

import utils.ff
//import utils.ffVss
//import utils.ff
import kotlin.js.Date

open class Inventarioite {
    var INV_EMPRESA = 0
    var INV_CODIGO = 0
    var INV_PRODUTO = 0
    var INV_GRADE = 0
    var INV_QTD = 0.0
    var INV_DTPROCESSAMENTO = ff.InicialDate

    var EST_BARRAOFICIAL = ""
    var ESTG_TIPO = ""
    var ESTG_EAN = ""
    var ESTG_UNIDVENDA = 0.0
    var EST_SALDO = 0.0
    var PRO_CXEMBARQUE = ""
    var PRO_DESCRCOMPLETA = ""

    fun construtor(EMPRESA: Int, CODIGO: Int, PRODUTO: Int, GRADE: Int,
                   QTD: Double, DTPROCESSAMENTO: Date,
                   BARRAOFICIAL: String, TIPO: String, EAN: String,
                   UNIDVENDA: Double, SALDO: Double,
                   CXEMBARQUE: String, DESCRCOMPLETA: String): Inventarioite {
        this.INV_EMPRESA = EMPRESA?: 0
        this.INV_CODIGO = CODIGO?: 0
        this.INV_PRODUTO = PRODUTO
        this.INV_GRADE = GRADE?: 0
        this.INV_QTD = QTD?: 0.0
        this.INV_DTPROCESSAMENTO = DTPROCESSAMENTO?: ff.InicialDate
        this.EST_BARRAOFICIAL = BARRAOFICIAL
        this.ESTG_TIPO = TIPO
        this.ESTG_EAN = EAN
        this.ESTG_UNIDVENDA = UNIDVENDA
        this.EST_SALDO = SALDO?: 0.0
        this.PRO_CXEMBARQUE = CXEMBARQUE
        this.PRO_DESCRCOMPLETA = DESCRCOMPLETA
        return this
    }
}