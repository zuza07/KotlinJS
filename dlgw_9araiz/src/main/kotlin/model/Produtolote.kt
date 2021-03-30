package model

import org.w3c.xhr.XMLHttpRequest
import utils.*
import kotlin.js.Date

open class Produtolote {
    var PROLOT_EMPRESA = 0
    var PROLOT_PRODUTO = 0
    var PROLOT_ID = 0
    var PROLOT_LOTEFAB = ""
    var PROLOT_FORNEC = 0
    var PROLOT_NRNOTA = 0
    var PROLOT_QTDENT = 0.0
    var PROLOT_DTFABR = ff.InicialDate
    var PROLOT_DTVAL = ff.InicialDate
    var PROLOT_DTVIG = ff.InicialDate
    var PROLOT_SALDO = 0.0
    var PROLOT_OBS = ""
    var PROLOT_USUARIO = ""
    var PROLOT_QTRESOF = 0.0
    var PROLOT_QTRESERVA = 0.0
    var PROLOT_QTRESPROD = 0.0
    var PROLOT_CUSTOL = 0.0
    var PROLOT_PERDESC = 0.0
    var PROLOT_FCINR = ""
    var PROLOT_OF = 0
    var PROLOT_ESTCONTROLE = 0

    var EST_SALDO00 = 0.0
    var DIF_SALDO00 = 0.0
    //var EST_SALDOLOTE00 = 0.0
    var EST_CONTRLOTE00 = ""
    var PRO_DESCRCOMPLETA00 = ""

    var EST_PRECOA00 = 0.0
    var EST_CUSLIQ00 = 0.0


    var DIASVALID00 = Int.MAX_VALUE

/*
    fun construtor1(EMPRESA: Int, PRODUTO: Int, ID: Int, LOTEFAB: String,
                   FORNEC: Int, NRNOTA: Int, QTDENT: Double,
                   DTFABR: Date, DTVAL: Date, DTVIG: Date,
                   SALDO: Double, OBS: String, USUARIO: String,
                   QTRESOF: Double, QTRESERVA: Double, QTRESPROD: Double,
                   CUSTOL: Double, PERDESC: Double, FCINR: String,
                   OF: Int, ESTCONTROLE: Int, EST_SALDO00: Double, DIF_SALDO00: Double,
                   CONTRLOTE00: String, DESCRCOMPLETA00: String, DIASVAL00: Int): Produtolote {

        this.PROLOT_EMPRESA = EMPRESA
        this.PROLOT_PRODUTO = PRODUTO
        this.PROLOT_ID = ID
        this.PROLOT_LOTEFAB = LOTEFAB
        this.PROLOT_FORNEC = FORNEC
        this.PROLOT_NRNOTA = NRNOTA
        this.PROLOT_QTDENT = QTDENT
        this.PROLOT_DTFABR = DTFABR
        this.PROLOT_DTVAL = DTVAL
        this.PROLOT_DTVIG = DTVIG
        this.PROLOT_SALDO = SALDO ?: 0.0
        this.PROLOT_OBS = OBS
        this.PROLOT_USUARIO = USUARIO
        this.PROLOT_QTRESOF = QTRESOF
        this.PROLOT_QTRESERVA = QTRESERVA
        this.PROLOT_QTRESPROD = QTRESPROD
        this.PROLOT_CUSTOL = CUSTOL
        this.PROLOT_PERDESC = PERDESC
        this.PROLOT_FCINR = FCINR
        this.PROLOT_OF = OF
        this.PROLOT_ESTCONTROLE = ESTCONTROLE
        this.EST_SALDO00 = EST_SALDO00
        this.DIF_SALDO00 = DIF_SALDO00 ?: 0.0
        this.EST_CONTRLOTE00 = CONTRLOTE00 ?: "N"
        this.PRO_DESCRCOMPLETA00 = DESCRCOMPLETA00
        this.DIASVALID00 = DIASVAL00 ?: Int.MAX_VALUE // Esta no valor maximo pois pode ter a coincidencia do item vencer no mesmo dia (dif = 0)
        return this
    }
*/

    fun construtorLista(it: XMLHttpRequest): List<Produtolote> {

        var iLinha = 0
        val lObj = ArrayList<Produtolote>()
        if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
            val lista = JSON.parse<Array<Produtolote>>(it.responseText)
            lista.forEach {
                val o = Produtolote()
                o.PROLOT_EMPRESA = it.PROLOT_EMPRESA
                o.PROLOT_PRODUTO = it.PROLOT_PRODUTO
                o.PROLOT_ID = it.PROLOT_ID.ffVii()
                o.PROLOT_LOTEFAB = it.PROLOT_LOTEFAB.ffVss()
                println(it.PROLOT_FORNEC.ffVii())
                o.PROLOT_FORNEC = it.PROLOT_FORNEC.ffVii()
                o.PROLOT_NRNOTA = it.PROLOT_NRNOTA.ffVii()
                o.PROLOT_QTDENT = it.PROLOT_QTDENT.ffVdo()
                o.PROLOT_DTFABR = it.PROLOT_DTFABR.ffDdd()
                o.PROLOT_DTVAL = it.PROLOT_DTVAL.ffDdd()
                o.PROLOT_DTVIG = it.PROLOT_DTVIG.ffDdd()
                o.PROLOT_SALDO = it.PROLOT_SALDO ?: 0.0
                o.PROLOT_OBS = it.PROLOT_OBS.ffVss()
                o.PROLOT_USUARIO = it.PROLOT_USUARIO.ffVss()
                o.PROLOT_QTRESOF = it.PROLOT_QTRESOF.ffVdo()
                o.PROLOT_QTRESERVA = it.PROLOT_QTRESERVA.ffVdo()
                o.PROLOT_QTRESPROD = it.PROLOT_QTRESPROD.ffVdo()
                o.PROLOT_CUSTOL = it.PROLOT_CUSTOL.ffVdo()
                o.PROLOT_PERDESC = it.PROLOT_PERDESC.ffVdo()
                o.PROLOT_FCINR = it.PROLOT_FCINR.ffVss()
                o.PROLOT_OF = it.PROLOT_OF.ffVii()
                o.PROLOT_ESTCONTROLE = it.PROLOT_ESTCONTROLE.ffVii()
                o.EST_SALDO00 = it.EST_SALDO00.ffVdo()
                o.DIF_SALDO00 = it.DIF_SALDO00 ?: 0.0
                //o.EST_SALDOLOTE00 = it.EST_SALDOLOTE00 ?: 0.0
                o.EST_CONTRLOTE00 = it.EST_CONTRLOTE00 ?: "N"
                o.PRO_DESCRCOMPLETA00 = it.PRO_DESCRCOMPLETA00.ffVss()
                o.EST_PRECOA00 = it.EST_PRECOA00.ffVdo()
                o.EST_CUSLIQ00 = it.EST_CUSLIQ00.ffVdo()
                o.DIASVALID00 = it.DIASVALID00
                        ?: Int.MAX_VALUE // Esta no valor maximo pois pode ter a coincidencia do item vencer no mesmo dia (dif = 0)
                lObj.add(o)
                if (iLinha == 1)
                    ff.println0(it)
                iLinha = iLinha + 1
            }
        }
        return lObj
    }
}