package services

//import kotlinx.html.dom.create
//import kotlinx.html.js.div
import kotlinx.browser.*
import kotlinx.html.*
import kotlinx.html.dom.*

import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLSpanElement
import org.w3c.dom.Node
import org.w3c.dom.parsing.DOMParser
import html.CabecLogon
import html.Password
import html.Principal
import html.println0

import kotlin.dom.addClass
import kotlin.dom.clear
import kotlin.dom.removeClass

class ControllerLogon() {
    public companion object {
        var htmlDivCabec: HTMLDivElement = document.getElementById("htmlDivCabec") as HTMLDivElement
        var htmlDiv1: HTMLDivElement = document.getElementById("htmlDiv1") as HTMLDivElement
        var htmlDiv2: HTMLDivElement = document.getElementById("htmlDiv2") as HTMLDivElement
        //var htmlDiv11: HTMLDivElement = document.getElementById("htmlDiv11") as HTMLDivElement
        var lbErro: HTMLSpanElement? = null //document.getElementById("lbErro") as HTMLSpanElement
        var lbTitulo: HTMLSpanElement? = null //document.getElementById("lbErro") as HTMLSpanElement
        var divTitulo: HTMLDivElement? = null

        var gsRota: String = ""
        var bPassword: Boolean = false
        var gsTela: String = ""
    }

    fun abrirCabec(sForm: String) {
        println0("zuza abrir password")
        abrir("Password", "")
//        if (sForm.equals("CabecLogon")) {
//            htmlDivCabec.clear()
//            CabecLogon(htmlDivCabec).show()
//        }
    }

    fun abrir(_sForm: String, sParametro: String) {
        println0("zuza abrir")
        gsRota = gsRota + "/$_sForm"
        htmlDiv1.clear()
        htmlDiv2.clear()

        if (_sForm.equals("Password")) {
            CabecLogon(htmlDivCabec).show()
            Password().show()
            //ffSleep(7000)
            //Password(htmlDiv1, htmlDiv2).mapearObjetos()
        }

        if (_sForm.equals("Principal")) {
            CabecLogon(htmlDivCabec).show()
            println0("chamou chamando principal")
            Principal(htmlDiv1).show()
            gsRota = ""
        }
    }

    fun mensagem(sClasse: String, sTexto: String) {
        console.log("mensagem = $sTexto")
        if (lbErro != null) {
            lbErro!!.removeClass("bg-danger")
            lbErro!!.removeClass("bg-warning")
            if (sTexto.equals("")) {
                ControllerLogon.lbErro!!.style.display = "none"
            } else {
                lbErro!!.addClass(sClasse)
                lbErro!!.innerText = sTexto
                lbErro!!.style.display = "block"
            }
        }
    }

    fun passMapear() {
        Password().start()
        //return "Zuza ok"
    }

    /*
    fun tbPadraoNovaLinha(tbPadrao: HTMLTableElement?, iColunas: Int, sLinha:String): HTMLTableRowElement {

        println0("ZUZA$sLinha")
        //lançando os módulos no grid
        val tLinha = tbPadrao!!.insertRow(tbPadrao!!.rows.length)
        var texto = document.createTextNode("")
        var tCell = tLinha.insertCell(0)

        //tLinha.onclick = { println0("zuza teste 123") }
        //onClickFunction = { abreConsulta(obj.PROLOT_PRODUTO) }
        for (i in 0..iColunas-1) {
            val sCol = "|${i.toString().ffZeroLeft(2)}"
            tCell = tLinha.insertCell(i)
            texto = document.createTextNode(sLinha.ffPegaCampo(sCol))
            tCell.appendChild(texto)
            texto.clear()
        }
        return tLinha
    }
    */
}

fun ffappendChildPromessa(principal: HTMLDivElement, node: HTMLDivElement, cb: (String) -> Unit) {

    principal.appendChild(node)
    cb("ok")
}

fun ffappendChildPromessa(principal: HTMLDivElement, node: HTMLDivElement): HTMLElement {

    return document.create.div {
        principal.appendChild(node)
    }
}

fun ffJavaScriptLoad(sCaminho: String): Node {
    var sTeste = "<div>abc</div>"
//    js("\$(\"#htmlDiv11\").load(\"${ff.gsCamView}/Password.html\");")

    println0(sCaminho)
    var documento = DOMParser().parseFromString(sTeste,"text/xml")
    var node = document.create.div() { }
    node.appendChild(documento.firstChild!!)
    return node
}

fun ffTextoLoad3(sTexto: String): HTMLElement {
    //var sTeste = "<div>abc</div>"
    //js("\$(\"#htmlDiv11\").load(\"${ff.gsCamView}/Password.html\");")

    //println0(sTexto)
    var documento = DOMParser().parseFromString(sTexto,"text/xml")
    var node = document.create.div() { }
    node.appendChild(documento.firstChild!!)
    //node.appendChild(documento)
    return node
}

