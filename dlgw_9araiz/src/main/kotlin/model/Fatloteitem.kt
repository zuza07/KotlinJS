package model

import org.w3c.xhr.XMLHttpRequest
import utils.*

open class Fatloteitem {
    var FATITE_EMPRESA = 0
    var FATITE_LOTE	= 0
    var FATITE_PRODUTO = 0
    var FATITE_QTDE = 0.0
    var FATITE_QTCONT = 0.0
    var ESTG_UNIDVENDA = 0.0
    var ESTG_EAN = ""
    var PRO_CXEMBARQUE = ""
    var PRO_DESCRCOMPLETA = ""

    fun construtor(EMPRESA: Int, LOTE: Int, PRODUTO: Int,
                   QTDE: Double, QTCONT: Double,
                   UNIDVENDA: Double, EAN: String,
                   CXEMBARQUE: String, DESCRCOMPLETA: String): Fatloteitem {
        this.FATITE_EMPRESA = EMPRESA
        this.FATITE_LOTE = LOTE
        this.FATITE_PRODUTO = PRODUTO
        this.FATITE_QTDE = QTDE?: 0.0
        this.FATITE_QTCONT = QTCONT?: 0.0
        this.ESTG_UNIDVENDA = UNIDVENDA
        this.ESTG_EAN = EAN
        this.PRO_CXEMBARQUE = CXEMBARQUE
        this.PRO_DESCRCOMPLETA = DESCRCOMPLETA
        return this
    }

    fun construtorLista(it: XMLHttpRequest): List<Fatloteitem> {

        var iLinha = 0
        val lObj = ArrayList<Fatloteitem>()
        //ff.println0("zuza aqui")
        //ff.println0(it.responseText.toString())

        if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
            val lista = JSON.parse<Array<Fatloteitem>>(it.responseText)
            lista.forEach {
                val o = Fatloteitem()
                o.FATITE_EMPRESA = it.FATITE_EMPRESA.ffVii()
                o.FATITE_LOTE    = it.FATITE_LOTE.ffVii()
                o.FATITE_PRODUTO = it.FATITE_PRODUTO.ffVii()
                o.FATITE_QTDE    = it.FATITE_QTDE.ffVdo()
                o.FATITE_QTCONT  = it.FATITE_QTCONT.ffVdo()
                o.ESTG_UNIDVENDA = it.ESTG_UNIDVENDA
                o.ESTG_EAN       = it.ESTG_EAN
                o.PRO_CXEMBARQUE = it.PRO_CXEMBARQUE.ffVss()
                o.PRO_DESCRCOMPLETA = it.PRO_DESCRCOMPLETA

                lObj.add(o)
            }
        }
        return lObj
    }

}