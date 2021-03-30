package model

import org.w3c.xhr.XMLHttpRequest
import utils.*


//import utils.ff.Companion.ffVss

open class Empresa {

    var ID_EMPRESA = 0
    var EMP_NOME = ""
    var EMP_NRSERIE = ""
    var EMP_FTP = ""
    var EMP_WEBVERSAO = ""
    var EMP_CIDADE = ""
    var EMP_CONFQTNOTAOK = ""

    /*
    fun ini(ID_EMPRESA: String, EMP_NOME: String, EMP_NRSERIE: String, EMP_FTP: String,
            EMP_WEBVERSAO: String, EMP_CIDADE: String): Empresa {
        this.ID_EMPRESA = ID_EMPRESA.ffVsi()
        this.EMP_NOME = EMP_NOME.ffVss()
        this.EMP_NRSERIE = EMP_NRSERIE.ffVss()
        this.EMP_FTP = EMP_FTP.ffVss().trim()
        this.EMP_WEBVERSAO = EMP_WEBVERSAO.ffVss().trim()
        this.EMP_CIDADE = EMP_CIDADE.ffVss().trim()
        this.EMP_CONFQTNOTAOK = EMP_CONFQTNOTAOK.ffVss().trim()
        return this
    }
     */

/*
    fun construtorLista(it: XMLHttpRequest): List<Empresa> {

        var iLinha = 0
        val lObj = ArrayList<Empresa>()
        //ff.println0("zuza aqui")
        //ff.println0(it.responseText.toString())

        if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
            var sTeste = it.responseText
            if (sTeste.ffCopy(1,1).equals("{"))
                sTeste = "[$sTeste]"

            ff.println0("zuza aqui")
            ff.println0(sTeste)
            val lista = JSON.parse<Array<Empresa>>(sTeste)
            lista.forEach {
                val o = Empresa()
                o.ID_EMPRESA = it.ID_EMPRESA.ffVii()
                o.EMP_NOME = it.EMP_NOME.ffVss()
                o.EMP_NRSERIE = it.EMP_NRSERIE.ffVss()
                o.EMP_FTP = it.EMP_FTP.ffVss()
                o.EMP_WEBVERSAO = it.EMP_WEBVERSAO.ffVss()
                o.EMP_CIDADE = it.EMP_CIDADE.ffVss()
                //o.EMP_CONFQTNOTAOK = it.EMP_CONFQTNOTAOK.ffVss()
                lObj.add(o)


                //arrumar isso CONFQTNOTAOK
            }
        }
        return lObj
    }

 */

    fun construtorLista(_res: String): List<Empresa> {

        var iLinha = 0
        val lObj = ArrayList<Empresa>()
        //ff.println0("zuza aqui")
        //ff.println0(it.responseText.toString())

        if ((!_res.equals(null)) && (!_res.equals(""))) {
            var res = _res
            if (res.ffCopy(1,1).equals("{"))
                res = "[$res]"

            ff.println0("zuza aqui")
            ff.println0(res)
            val lista = JSON.parse<Array<Empresa>>(res)
            lista.forEach {
                val o = Empresa()
                o.ID_EMPRESA = it.ID_EMPRESA.ffVii()
                o.EMP_NOME = it.EMP_NOME.ffVss()
                o.EMP_NRSERIE = it.EMP_NRSERIE.ffVss()
                o.EMP_FTP = it.EMP_FTP.ffVss()
                o.EMP_WEBVERSAO = it.EMP_WEBVERSAO.ffVss()
                o.EMP_CIDADE = it.EMP_CIDADE.ffVss()
                //o.EMP_CONFQTNOTAOK = it.EMP_CONFQTNOTAOK.ffVss()
                lObj.add(o)


                //arrumar isso CONFQTNOTAOK
            }
        }
        return lObj
    }

}
