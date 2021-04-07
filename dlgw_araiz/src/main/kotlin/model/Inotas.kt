package model

import org.w3c.xhr.XMLHttpRequest
import utils.*
import kotlin.js.Date

//import utils.ffVss

open class Inotas {

    var INOT_EMPRESA = 0
    var INOT_OF = 0
    var INOT_PROD = 0
    var INOT_GRADE = 0
    var INOT_NRPED = ""
    var INOT_QTD = 0.0
    var INOT_VLUNIT = 0.0
    var INOT_TPENTR = 0
    var INOT_CST = ""
    var INOT_TOTAL = 0.0
    var INOT_ICMS = 0.0
    var INOT_UNID = ""
    var INOT_DECRETO = ""
    var INOT_DESCPROD = ""
    var INOT_VLDESC = 0.0
    var INOT_IDESC = 0.0
    var INOT_DESCRPA = 0.0
    var INOT_IVA = 0.0
    var INOT_REDBASE = 0.0
    var INOT_BASEICM = 0.0
    var INOT_CFOP = ""
    var INOT_CFOPDESCR = ""
    var INOT_PERCOMIS = 0.0
    var INOT_PRECOBASE = 0.0
    var INOT_VERBATIPO = ""
    var INOT_GTIN = ""
    var INOT_NCM = ""
    var INOT_GENERO = ""
    var INOT_BCST = 0.0
    var INOT_ICMSST = 0.0
    var INOT_VLICMS = 0.0
    var INOT_COFINSPER = 0.0
    var INOT_PISPER = 0.0
    var INOT_IPIPER = 0.0
    var INOT_IPIVL = 0.0
    var INOT_IPIVLUNIT = 0.0
    var INOT_PPAUTA = 0.0
    var INOT_CUSTOM = 0.0
    var INOT_ICMSIVA = 0.0
    var INOT_FRETEVL = 0.0
    var INOT_PISBASE = 0.0
    var INOT_CUSTOU = 0.0
    var INOT_DESCADICIONAL = ""
    var INOT_CUSTOL = 0.0
    var INOT_SERIE = 0
    var INOT_PROLOTID = ""
    var INOT_VALIDADE = ff.InicialDate
    var INOT_VLUNITBRUTO = 0.0
    var INOT_PCREDSN = 0.0
    var INOT_CSOSN = ""
    var INOT_VCREDICMSSN = 0.0
    var INOT_GTINEMB = ""
    var INOT_SEGUROVL = 0.0
    var INOT_MODICMSST = ""
    var INOT_MODICMS = ""
    var INOT_SITPIS = ""
    var INOT_SITCOFINS = ""
    var INOT_SITIPI = ""
    var INOT_VLACESSO = 0.0
    var INOT_CUSTOANT = 0.0
    var INOT_CUSMEDANT = 0.0
    var INOT_ACRES = 0.0
    var INOT_VLREDUCAO = 0.0
    var INOT_CLIENTE = 0
    var INOT_ORDEM = 0
    var INOT_ITEORDEM = 0
    var INOT_COFINSU = 0.0
    var INOT_PISU = 0.0
    var INOT_PROCODIGO = 0
    var INOT_PISNATREC = ""
    var INOT_CFOPENT = ""
    var INOT_NTREL = 0
    var INOT_OFREL = 0
    var INOT_AJUSTEVL = 0.0
    var INOT_AJUSTEBS = 0.0
    var INOT_AJUSTETP = ""
    var INOT_GNRERECO = ""
    var INOT_REDTIPO = ""
    var INOT_FCINR = ""
    var INOT_CSTORIGEM = ""
    var INOT_CSTITEM = ""
    var INOT_IMPTRANSPER = 0.0
    var INOT_TOTNOTA = 0.0
    var INOT_FATORFISCAL = 0.0
    var INOT_FATORFISICO = 0.0
    var INOT_ESTCONTROLE = 0
    var INOT_ESTCONTROLEENT = 0
    var INOT_VICMSDESON = 0.0
    var INOT_QTDCONT = 0.0
    var INOT_DESCRANT = ""
    var INOT_BACKUP = ""
    var inot_bkppis = 0.0
    var inot_bkpcofins = 0.0
    var inot_bkppisnatrec = ""
    var INOT_IPIENQ = ""
    var INOT_VLICMSC = 0.0
    var INOT_PISPERC = 0.0
    var INOT_COFINSPERC = 0.0
    var INOT_XMLINF = ""
    var INOT_CEST = ""
    var INOT_PICMSINTRA = 0.0
    var INOT_PFCPUFDEST = 0.0
    var INOT_PICMSINTERPART = 0.0
    var INOT_DTEMI = ff.InicialDate
    var INOT_DTTERM = ff.InicialDate
    var INOT_LOTEXML = ff.InicialDate
    var ITOTAL = 0.0

    //outros campos
    var EST_QTRESOF00  = 0.0
    var INOT_PRODSEL00 = 0

    class InotasResu {
        var INOT_EMPRESA = 0
        var INOT_OF = 0
        var INOT_ORDEM = 0
        var INOT_ITEORDEM = 0
        var INOT_PROD = 0
        var INOT_DESCPROD = ""
        var INOT_GRADE = 0
        var INOT_NRPED = ""
        var INOT_QTD = 0.0
        var INOT_VLUNIT = 0.0
        var INOT_TOTAL = 0.0
        var INOT_TOTNOTA = 0.0
        var INOT_QTDCONT = 0.0
        var INOT_IVA = 0.0
        var INOT_GTIN = ""
        var INOT_GTINEMB = ""
        var INOT_NCM = ""
        var INOT_DTEMI = ff.InicialDate
        var INOT_DTVIG = ff.InicialDate
        var INOT_LOTEXML = ""
        var INOT_PROLOTID = 0
        var INOT_FATORFISICO = 0
        var INOT_FATORFISCAL = 0
        var INOT_ESTCONTROLE = 0

        var INOT_OBS00 = ""
        var NOT_CHAVEACESSO00 = ""
        var NOT_NOTATIPO00 = ""
        var NOT_CLIENTE00 = 0
        var CLI_NOME00 = ""
        var TPNT_DESCR00 = ""
        var PROLOT_LOTEFAB00 = ""
        var PROLOT_DTVAL00 = ff.InicialDate

        var PRO_MEDIDA = ""
        var PRO_UNIDMED = ""
        var PRO_QTEMB = 0.0
        var PRO_CXEMBARQUE = 0.0
        var PRO_UNID = ""
        var PRO_PALETQTD = 0
        var PRO_PESOLIQ = 0.0
        var PRO_PESOBRUTO = 0.0
        var PRO_REFER = ""
        var PRO_FABR = 0
        var FABR_DESCR = ""
        var PRO_ARM = ""
        var ARM_DESCR = ""
        var PRO_DESCRCOMPLETA = ""
        var EST_BARRAOFICIAL = ""
        var ESTG_EAN = ""
        var ESTG_TIPO = ""
        var ESTG_UNIDVENDA = 0.0
        var ESTG_EANC = ""
        var ESTG_EAND = ""
        var ESTG_EANU = ""
        var EST_CONTRLOTE = ""
        var EST_DIASVALID = 0
        var EST_DIASVALIDMIN = 0
        var EST_LOCAL00 = ""

        fun construtorLista(it: XMLHttpRequest): List<InotasResu> {

            var iLinha = 0
            val lObj = ArrayList<InotasResu>()
            ff.println0("zuza aqui")
            ff.println0(it.responseText.toString())

            if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                val lista = JSON.parse<Array<InotasResu>>(it.responseText)
                lista.forEach {
                    val o = InotasResu()
                    o.INOT_EMPRESA = it.INOT_EMPRESA.ffVii()
                    o.INOT_OF = it.INOT_OF.ffVii()
                    o.INOT_ORDEM = it.INOT_ORDEM.ffVii()
                    o.INOT_ITEORDEM = it.INOT_ITEORDEM.ffVii()
                    o.INOT_PROD = it.INOT_PROD.ffVii()
                    o.INOT_DESCPROD = it.INOT_DESCPROD.ffVss()
                    o.INOT_GRADE = it.INOT_GRADE.ffVii()
                    o.INOT_NRPED = it.INOT_NRPED.ffVss()
                    o.INOT_QTD = it.INOT_QTD.ffVdo()
                    o.INOT_QTDCONT = it.INOT_QTDCONT.ffVdo()
                    o.INOT_VLUNIT = it.INOT_VLUNIT.ffVdo()
                    o.INOT_TOTAL = it.INOT_TOTAL.ffVdo()
                    o.INOT_IVA = it.INOT_IVA.ffVdo()
                    o.INOT_GTIN = it.INOT_GTIN.ffVss()
                    o.INOT_GTINEMB = it.INOT_GTINEMB.ffVss()
                    o.INOT_NCM = it.INOT_NCM.ffVss()
                    o.INOT_DTEMI = it.INOT_DTEMI.ffDdd()
                    o.INOT_DTVIG = it.INOT_DTVIG.ffDdd()
                    o.INOT_LOTEXML = it.INOT_LOTEXML.ffVss()
                    o.INOT_PROLOTID = it.INOT_PROLOTID.ffVii()
                    o.INOT_FATORFISICO = it.INOT_FATORFISICO.ffVii()
                    o.INOT_FATORFISCAL = it.INOT_FATORFISCAL.ffVii()
                    o.INOT_ESTCONTROLE = it.INOT_ESTCONTROLE.ffVii()

                    o.INOT_OBS00 = it.INOT_OBS00.ffVss()
                    o.NOT_CHAVEACESSO00 = it.NOT_CHAVEACESSO00.ffVss()
                    o.NOT_NOTATIPO00 = it.NOT_NOTATIPO00.ffVss()
                    o.NOT_CLIENTE00 = it.NOT_CLIENTE00.ffVii()
                    o.CLI_NOME00 = it.CLI_NOME00.ffVss()
                    o.TPNT_DESCR00 = it.TPNT_DESCR00.ffVss()
                    o.PROLOT_LOTEFAB00 = it.PROLOT_LOTEFAB00.ffVss()
                    o.PROLOT_DTVAL00 = it.PROLOT_DTVAL00.ffDdd()

                    o.PRO_MEDIDA = it.PRO_MEDIDA.ffVss()
                    o.PRO_UNIDMED = it.PRO_UNIDMED.ffVss()
                    o.PRO_QTEMB = it.PRO_QTEMB.ffVdo()
                    o.PRO_CXEMBARQUE = it.PRO_CXEMBARQUE.ffVdo()
                    o.PRO_UNID = it.PRO_UNID.ffVss()
                    o.PRO_PALETQTD = it.PRO_PALETQTD.ffVii()
                    o.PRO_PESOLIQ = it.PRO_PESOLIQ.ffVdo()
                    o.PRO_PESOBRUTO = it.PRO_PESOBRUTO.ffVdo()
                    o.PRO_REFER = it.PRO_REFER.ffVss()
                    o.PRO_FABR = it.PRO_FABR.ffVii()
                    o.FABR_DESCR = it.FABR_DESCR.ffVss()
                    o.PRO_ARM = it.PRO_ARM.ffVss()
                    o.ARM_DESCR = it.ARM_DESCR.ffVss()
                    o.PRO_DESCRCOMPLETA = it.PRO_DESCRCOMPLETA.ffVss()
                    o.EST_BARRAOFICIAL = it.EST_BARRAOFICIAL.ffVss()
                    o.ESTG_EAN = it.ESTG_EAN.ffVss()
                    o.ESTG_TIPO = it.ESTG_TIPO.ffVss()
                    o.ESTG_UNIDVENDA = it.ESTG_UNIDVENDA.ffVdo()
                    o.ESTG_EANC = it.ESTG_EANC.ffVss()
                    o.ESTG_EAND = it.ESTG_EAND.ffVss()
                    o.ESTG_EANU = it.ESTG_EANU.ffVss()
                    o.EST_CONTRLOTE = it.EST_CONTRLOTE.ffVss()
                    o.EST_DIASVALID = it.EST_DIASVALID.ffVii()
                    o.EST_DIASVALIDMIN = it.EST_DIASVALIDMIN.ffVii()
                    o.EST_LOCAL00 = it.EST_LOCAL00.ffVss()

                    lObj.add(o)
                }
            }
            return lObj
        }

    }
/*
    open class InotasResu1 {
        var INOT_EMPRESA = 0
        var INOT_OF = 0
        var INOT_ORDEM = 0
        var INOT_PROD = 0
        var INOT_DESCPROD = ""
        var INOT_GRADE = ""
        var INOT_QTD = 0.0
        var INOT_VLUNIT = 0.0
        var INOT_TOTAL = 0.0
        var INOT_TOTNOTA = 0.0
        var INOT_QTDCONT = 0.0
        var INOT_LOTEXML = ""
        var PRO_MEDIDA = ""
        var PRO_UNIDMED = ""
        var PRO_QTEMB = 0.0
        var PRO_CXEMBARQUE = 0.0
        var PRO_UNID = ""
        var PRO_PALETQTD = 0
        var PRO_PESOLIQ = 0.0
        var PRO_PESOBRUTO = 0.0
        var PRO_REFER = ""
        var PRO_FABR = 0
        var FABR_DESCR = ""
        var PRO_ARM = ""
        var ARM_DESCR = ""
        var PRO_DESCRCOMPLETA = ""
        var EST_BARRAOFICIAL = ""
        var ESTG_EAN = ""
        var ESTG_TIPO = ""
        var ESTG_UNIDVENDA = 0.0
        var ESTG_EANC = ""
        var ESTG_EAND = ""
        var ESTG_EANU = ""
        var EST_CONTRLOTE = ""
        var EST_DIASVALID = 0
        var EST_DIASVALIDMIN = 0
    }

    fun iniResu1(EMPRESA: Int, OF: Int, ORDEM: Int, PROD: Int, DESCPROD: String, GRADE: String,
            QTD: Double, VLUNIT: Double, TOTAL: Double, TOTNOTA: Double, QTDCONT: Double,
            LOTEXML: String,
            MEDIDA: String, UNIDMED: String, QTEMB: Double, CXEMBARQUE: Double, UNID: String,
            PESOLIQ: Double, PESOBRUTO: Double, FABR: Int, ARM: String,
            DESCR: String, DESCRCOMPLETA: String, BARRAOFICIAL: String,
            EAN: String, TIPO: String, UNIDVENDA: Double,
            EANC: String, EAND: String, EANU: String, CONTRLOTE: String,
            EST_DIASVALID: Int, EST_DIASVALIDMIN: Int): InotasResu1 {

        val obj = InotasResu1()
        //console.log("zuza abriu ini")
        obj.INOT_EMPRESA = EMPRESA
        obj.INOT_OF = OF
        obj.INOT_ORDEM = ORDEM
        obj.INOT_PROD = PROD
        obj.INOT_DESCPROD = DESCPROD
        obj.INOT_GRADE = GRADE
        obj.INOT_QTD = QTD
        obj.INOT_VLUNIT = VLUNIT
        obj.INOT_TOTAL = TOTAL
        obj.INOT_TOTNOTA = TOTNOTA
        obj.INOT_QTDCONT = QTDCONT?: 0.0
        obj.INOT_LOTEXML = LOTEXML?: ""
        obj.PRO_MEDIDA = MEDIDA
        obj.PRO_UNIDMED = UNIDMED
        obj.PRO_QTEMB = QTEMB
        obj.PRO_CXEMBARQUE = CXEMBARQUE
        obj.PRO_UNID = UNID
        obj.PRO_PESOLIQ = PESOLIQ
        obj.PRO_PESOBRUTO = PESOBRUTO
        obj.PRO_FABR = FABR
        obj.PRO_ARM = ARM
        obj.FABR_DESCR = DESCR
        obj.PRO_DESCRCOMPLETA = DESCRCOMPLETA
        obj.EST_BARRAOFICIAL = BARRAOFICIAL
        obj.ESTG_EAN = EAN
        obj.ESTG_TIPO = TIPO
        obj.ESTG_UNIDVENDA = UNIDVENDA
        obj.ESTG_EANC = EANC
        obj.ESTG_EAND = EAND
        obj.ESTG_EANU = EANU
        obj.EST_CONTRLOTE = CONTRLOTE?: "N"
        obj.EST_DIASVALID = EST_DIASVALID?: 0
        obj.EST_DIASVALIDMIN = EST_DIASVALIDMIN?: 0

        return obj
    }

 */
}