package model

import org.w3c.xhr.XMLHttpRequest
import utils.*
import kotlin.js.Date

class Produto {
    var PRO_EMPRESA = 0
    var ID_PRODUTO = 0
    var PRO_QTEMB = 0
    var PRO_CXEMBARQUE = 0.0
    var PRO_DESCRCOMPLETA = ""
    var PRO_USUALT = ""
    var PRO_DTALTCAD = ff.InicialDate
    var EST_CONTRLOTE = ""
    var EST_DIASVALID = 0
    var EST_DIASVALIDMIN = 0
    var EST_BARRAOFICIAL = ""
    var EST_SALDO = 0.0
    var EST_LOCAL00 = ""
    var ESTG_EAN = ""
    var ESTG_TIPO = ""
    var ESTG_UNIDVENDA = 0.0

    /*
    fun construtor(EMPRESA: Int, PRODUTO: Int, QTEMB: Int, CXEMBARQUE: Double,
                   DESCRCOMPLETA: String, USUALT: String, DTALTCAD: Date,
                   CONTRLOTE: String, DIASVALID: Int, DIASVALIDMIN: Int,
                   BARRAOFICIAL: String, EAN: String, TIPO: String, UNIDVENDA: Double): Produto {
        this.PRO_EMPRESA = EMPRESA
        this.ID_PRODUTO = PRODUTO
        this.PRO_QTEMB = QTEMB
        this.PRO_CXEMBARQUE = CXEMBARQUE
        this.PRO_DESCRCOMPLETA = DESCRCOMPLETA
        this.PRO_USUALT = USUALT
        this.PRO_DTALTCAD = DTALTCAD
        this.EST_CONTRLOTE = CONTRLOTE
        this.EST_DIASVALID = DIASVALID
        this.EST_DIASVALIDMIN = DIASVALIDMIN
        this.EST_BARRAOFICIAL = BARRAOFICIAL
        this.ESTG_EAN = EAN
        this.ESTG_TIPO = TIPO
        this.ESTG_UNIDVENDA = UNIDVENDA
        return this
    }
    */

    fun construtorLista(it: XMLHttpRequest): List<Produto> {

        var iLinha = 0
        val lObj = ArrayList<Produto>()
        if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
            val lista = JSON.parse<Array<Produto>>(it.responseText)
            lista.forEach {
                val o = Produto()
                o.PRO_EMPRESA = it.PRO_EMPRESA.ffVii()
                o.ID_PRODUTO = it.ID_PRODUTO.ffVii()
                o.PRO_QTEMB = it.PRO_QTEMB.ffVii()
                o.PRO_CXEMBARQUE = it.PRO_CXEMBARQUE.ffVdo()
                o.PRO_DESCRCOMPLETA = it.PRO_DESCRCOMPLETA.ffVss()
                o.PRO_USUALT = it.PRO_USUALT.ffVss()
                o.PRO_DTALTCAD = it.PRO_DTALTCAD.ffDdd()
                o.EST_CONTRLOTE = it.EST_CONTRLOTE.ffVss()
                o.EST_DIASVALID = it.EST_DIASVALID.ffVii()
                o.EST_DIASVALIDMIN = it.EST_DIASVALIDMIN.ffVii()
                o.EST_BARRAOFICIAL = it.EST_BARRAOFICIAL.ffVss()
                o.EST_SALDO = it.EST_SALDO.ffVdo()
                o.EST_LOCAL00 = it.EST_LOCAL00.ffVss()
                o.ESTG_EAN = it.ESTG_EAN.ffVss()
                o.ESTG_TIPO = it.ESTG_TIPO.ffVss()
                o.ESTG_UNIDVENDA = it.ESTG_UNIDVENDA.ffVdo()

                lObj.add(o)
            }
        }
        return lObj
    }

}