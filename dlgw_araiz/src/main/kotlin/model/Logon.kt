package model

import org.w3c.xhr.XMLHttpRequest
import utils.*

open class Logon {
    var G1 = ""
    var G2 = ""
    var G3 = ""
    var G4 = ""
    var G5 = ""
    var G6 = ""
    var G7 = ""
    var aaGenericoEmp: ArrayList<aaGenericoEmp>? = null //MutableList<aaGenericoEmp> = ArrayList()

    fun ini(G1: String, G2: String, G3: String, G4: String, G5: String, G6: String, G7: String,
            aaGenericoEmp: ArrayList<aaGenericoEmp>?): Logon {

        //this.G1 = G1.ffVss()?:"teste"
        this.G1 = G1.ffVss()
        this.G2 = G2.ffVss()
        this.G3 = G3.ffVss()
        this.G4 = G4.ffVss()
        this.G5 = G5.ffVss()
        this.G6 = G6.ffVss()
        this.G7 = G7.ffVss()
        this.aaGenericoEmp = aaGenericoEmp
        return this
    }

    fun valid(obj: Logon): Logon {

        this.G1 = obj.G1.ffVss()
        this.G2 = obj.G2.ffVss()
        this.G3 = obj.G3.ffVss()
        this.G4 = obj.G4.ffVss()
        this.G5 = obj.G5.ffVss()
        this.G6 = obj.G6.ffVss()
        return this
    }

    open class AdmRet {
        var EMPRESA2: String = ""
        var LOGON: String = ""
        var SENHA: String = ""
        var OBS: String = ""
        var CHAVE: String = ""
        //var EMPSERIE: String = ""

        var EMPRESA: Empresa? = null
        var EMP_SERIE = 0
        var FUNC_FUNCAO = ""
        var FUNC_NOME = ""
        var FUNC_TRANSPDOM00 = ""
        var FUNC_URLLOGON = ""
        var ID_FUNCIONARIO = 0
        var GSDESENVOLVEDOR = ""
        var GSCANVIEW = ""
        var GSLOGONSIS = "" //armazena o tipo de sistema ADM - RET - FOR
        var GSLOGONFOR = "" //armazena o código do fornecedor/fabricante

        fun construtorLista(it: XMLHttpRequest): List<Logon.AdmRet> {

            var iLinha = 0
            val lObj = ArrayList<Logon.AdmRet>()
            //ff.println0("zuza aqui")
            //ff.println0(it.responseText.toString())

            if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                var sTeste = it.responseText
                if (sTeste.ffCopy(1,1).equals("{"))
                    sTeste = "[$sTeste]"
                val lista = JSON.parse<Array<Logon.AdmRet>>(sTeste)
                lista.forEach {
                    val o = Logon.AdmRet()
                    o.CHAVE = it.CHAVE
                    o.EMPRESA2 = it.EMPRESA2
                    o.LOGON = it.LOGON
                    o.SENHA = it.SENHA
                    o.OBS = it.OBS

                    o.EMPRESA = it.EMPRESA
                    o.EMP_SERIE = it.EMP_SERIE
                    o.FUNC_FUNCAO = it.FUNC_FUNCAO
                    o.FUNC_NOME = it.FUNC_NOME
                    o.FUNC_TRANSPDOM00 = it.FUNC_TRANSPDOM00
                    o.FUNC_URLLOGON = it.FUNC_URLLOGON
                    o.ID_FUNCIONARIO = it.ID_FUNCIONARIO
                    //o.GSDESENVOLVEDOR = true
                    o.GSCANVIEW = it.GSCANVIEW
                    o.GSLOGONSIS = it.GSLOGONSIS
                    o.GSLOGONFOR = it.GSLOGONFOR

                    lObj.add(o)
                }
            }
            return lObj
        }

        /*
        fun ini(LOGON: String, OBS: String, CHAVE: String, EMPRESA: Empresa?, FUNC_FUNCAO: String): AdmRet {
            this.EMPRESA2 = EMPRESA!!.ID_EMPRESA.ffVis()
            this.LOGON = LOGON
            this.OBS = OBS
            this.CHAVE = CHAVE
            this.FUNC_FUNCAO = FUNC_FUNCAO
            this.EMPRESA = Empresa().ini(EMPRESA!!.ID_EMPRESA.ffVis(), EMPRESA!!.EMP_NOME, EMPRESA!!.EMP_NRSERIE,
                    EMPRESA!!.EMP_FTP, EMPRESA!!.EMP_WEBVERSAO, EMPRESA!!.EMP_CIDADE)
            return this
        }
        */

    }
}

