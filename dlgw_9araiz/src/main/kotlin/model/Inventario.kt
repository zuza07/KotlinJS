package model

import utils.ff
//import utils.ffVss
import kotlin.js.Date

open class Inventario {
    var INV_EMPRESA = 0
    var INV_CODIGO = 0
    var INV_DATA = ff.InicialDate
    var INV_DTPREV = ff.InicialDate
    var INV_DTPROCESSAMENTO = ff.InicialDate
    var INV_TITULO = ""
    var INV_OBSERVACAO = ""
    var INV_ESTCONTROLE = 0
    var INV_FUNCABERTURA = ""
    var INV_FUNCENCERRA = ""

    fun construtor(EMPRESA: Int, CODIGO: Int, DATA: Date, DTPREV: Date,
                   DTPROCESSAMENTO: Date, TITULO: String, OBSERVACAO: String,
                   ESTCONTROLE: Int, FUNCABERTURA: String, FUNCENCERRA: String): Inventario {
        this.INV_EMPRESA = EMPRESA
        this.INV_CODIGO = CODIGO
        this.INV_DATA = DATA
        this.INV_DTPREV = DTPREV
        this.INV_DTPROCESSAMENTO = DTPROCESSAMENTO
        this.INV_TITULO = TITULO
        this.INV_OBSERVACAO = OBSERVACAO
        this.INV_ESTCONTROLE = ESTCONTROLE
        this.INV_FUNCABERTURA = FUNCABERTURA
        this.INV_FUNCENCERRA = FUNCENCERRA
        return this
    }

}