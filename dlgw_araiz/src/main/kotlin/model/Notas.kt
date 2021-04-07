package model

import org.w3c.xhr.XMLHttpRequest
import utils.*
import kotlin.js.Date

open class Notas{
    var NOT_EMPRESA = 0
    var NOT_OF = 0
    var NOT_CLIENTE = 0
    var NOT_NRNOTA = 0
    var NOT_FUNC = 0
    var NOT_DTEMI = ff.InicialDate
    var NOT_DTVIG = ff.InicialDate
    var NOT_CPAG = 0
    var NOT_FPAG = 0
    var NOT_CFOCOD = ""
    var NOT_RAZAO = ""
    var NOT_ENDER = ""
    var NOT_NUMERO = ""
    var NOT_BAIRRO = ""
    var NOT_CEP = ""
    var NOT_CIDADE = ""
    var NOT_UF = ""
    var NOT_CNPJ = ""
    var NOT_IE = ""
    var NOT_TOTPROD = 0.0
    var NOT_TOTNOTA = 0.0
    var NOT_CHAVEACESSO = ""
    var NOT_USUCAD = ""
    var NOT_FINALIDADE = 0
    var NOT_CFODES = ""
    var NOT_QTCONF = ""
    var NOT_FATLOTE = 0
    var NOT_QTVOLUMES = 0
    var NOT_IDENTREGA = 0
    var NOT_TRANSP = ""
    var NOT_ENTRSEQUENCIA = 0
    var NOT_NOTATIPO = ""

    //outros campos
    var REG_DESCR00 = ""
    var MOTO_NOME00 = ""

    fun construtorLista(it: XMLHttpRequest): List<Notas> {

        var iLinha = 0
        val lObj = ArrayList<Notas>()
        if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
            val lista = JSON.parse<Array<Notas>>(it.responseText)
            lista.forEach {
                val o = Notas()

                o.NOT_EMPRESA = it.NOT_EMPRESA.ffVii()
                o.NOT_OF = it.NOT_OF.ffVii()
                o.NOT_CLIENTE = it.NOT_CLIENTE.ffVii()
                o.NOT_NRNOTA = it.NOT_NRNOTA.ffVii()
                o.NOT_FUNC = it.NOT_FUNC.ffVii()
                o.NOT_DTEMI = it.NOT_DTEMI.ffDdd()
                o.NOT_DTVIG = it.NOT_DTVIG.ffDdd()
                o.NOT_CPAG = it.NOT_CPAG.ffVii()
                o.NOT_FPAG = it.NOT_FPAG.ffVii()
                o.NOT_CFOCOD = it.NOT_CFOCOD.ffVss()
                o.NOT_RAZAO = it.NOT_RAZAO.ffVss()
                o.NOT_ENDER = it.NOT_ENDER.ffVss()
                o.NOT_NUMERO = it.NOT_NUMERO.ffVss()
                o.NOT_BAIRRO = it.NOT_BAIRRO.ffVss()
                o.NOT_CEP = it.NOT_CEP.ffVss()
                o.NOT_CIDADE = it.NOT_CIDADE.ffVss()
                o.NOT_UF = it.NOT_UF.ffVss()
                o.NOT_CNPJ = it.NOT_CNPJ.ffVss()
                o.NOT_IE = it.NOT_IE.ffVss()
                o.NOT_TOTPROD = it.NOT_TOTPROD.ffVdo()
                o.NOT_TOTNOTA = it.NOT_TOTNOTA.ffVdo()
                o.NOT_CHAVEACESSO = it.NOT_CHAVEACESSO.ffVss()
                o.NOT_USUCAD = it.NOT_USUCAD.ffVss()
                o.NOT_FINALIDADE = it.NOT_FINALIDADE.ffVii()
                o.NOT_CFODES = it.NOT_CFODES.ffVss()
                o.NOT_QTCONF = it.NOT_QTCONF.ffVss()
                o.NOT_FATLOTE = it.NOT_FATLOTE.ffVii()
                o.NOT_QTVOLUMES = it.NOT_QTVOLUMES.ffVii()
                o.NOT_IDENTREGA = it.NOT_IDENTREGA.ffVii()
                o.NOT_TRANSP = it.NOT_TRANSP.ffVss()
                o.NOT_ENTRSEQUENCIA = it.NOT_ENTRSEQUENCIA.ffVii()
                o.NOT_NOTATIPO = it.NOT_NOTATIPO.ffVss()

                o.REG_DESCR00 = it.REG_DESCR00.ffVss()
                o.MOTO_NOME00 = it.MOTO_NOME00.ffVss()

                lObj.add(o)
            }
        }
        return lObj
    }

}