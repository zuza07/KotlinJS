package utils

import model.*
import org.w3c.xhr.XMLHttpRequest
import utils.ff.Companion.giEmpresa
import utils.ff.Companion.gsToken
import utils.ff.Companion.gsUniverso
import utils.ff.Companion.println0
import kotlin.js.Console

class StorageService() {

    class stTask(val eventEmitter: TodoEventEmitter) : LinkedHashMap<String, Task>() {

        val addEvent: String = "addTask"
        val doneEvent: String = "doneEvent"
        val undoneEvent: String = "undoneEvent"

        fun getAll(callback: () -> Unit) {
            return Ajax().get("/tasks") {
                val tasks = JSON.parse<Array<Task>>(it.responseText)
                tasks.forEach {
                    val task = Task(it.id, it.text)
                    task.isArchived = it.isArchived
                    task.isDone = it.isDone
                    this.put(it.id, it)
                }
                callback()
            }
        }

        fun update(task: Task) {
            return Ajax().post("/task/${task.id}", task) {
                console.log(it.response)
            }
        }

        override fun put(key: String, value: Task): Task? {
            eventEmitter.trigger(addEvent, value)
            return super.put(key, value)
        }
    }

    class stPadrao(val eventEmitter: TodoEventEmitter): Any() {

        fun selectGETString(sClasse: String, callback: (String) -> Unit) {
            var sUrl = "${ff.gsDom1}/$sClasse"
            ff.println0("select stPadrao $sUrl")
            return Ajax().get(sUrl, gsToken) {
                //val sTexto: String = it.responseText
                //ff.println0(sTexto)
                callback(it.responseText)
            }
        }

        fun selectGET(sClasse: String, callback: (XMLHttpRequest) -> Unit) {
            val sUrl = "${ff.gsDom1}/$sClasse"
            ff.println0("select stPadrao $sUrl")
            return Ajax().get(sUrl, gsToken) {
                //val sTexto: String = it.responseText
                //ff.println0(sTexto)
                callback(it)
            }
        }

        fun selectPOSTx(sClasse: String, objAny: Any?, callback: (XMLHttpRequest) -> Unit) {
            val sUrl = "${ff.gsDom1}/$sClasse"
            ff.println0("select stPadrao $sUrl")
            val sDinamico = objAny.asDynamic()
            //val sObj = JSON.stringify(obj)
            return Ajax().post(sUrl, sDinamico, gsToken) {

                callback(it)
            }
        }

        fun selectPOST(sClasse: String, objAny: Any?, callback: (String) -> Unit) {
            val sUrl = "${ff.gsDom1}/$sClasse"
            ff.println0("select stPadrao $sUrl")
            val sDinamico = objAny.asDynamic()
            //val sObj = JSON.stringify(obj)
            return Ajax().post(sUrl, sDinamico, gsToken) {

                callback(it.responseText)
            }
        }

        fun deleteObj(sPath: String, ObjAny: Any, callback: (String) -> Unit) {
            val sUrl = "${ff.gsDom1}/$sPath"
            ff.println0("solicitando deleteObj em stPadrao $sUrl")
            var sDinamico = ObjAny.asDynamic()
            //val sObj = JSON.stringify(obj)
            return Ajax().post(sUrl, sDinamico, gsToken) {

                callback(it.responseText)
            }
        }

        fun delete(sPath: String, callback: (String) -> Unit) { //não testado
            val sUrl = "${ff.gsDom1}/$sPath"
            ff.println0("solicitando delete em stPadrao $sUrl")
            val sTask = ("").asDynamic()
            //val sObj = JSON.stringify(obj)
            return Ajax().post(sUrl, sTask, gsToken) {
                callback(it.responseText)
            }
        }

        fun update(sPath: String, ObjAny: Any, callback: (String) -> Unit) {
            val sUrl = "${ff.gsDom1}/$sPath"
            ff.println0("solicitando update em stPadrao $sUrl")
            val sDinamico = ObjAny.asDynamic()
            //val sObj = JSON.stringify(obj)
            return Ajax().post(sUrl, sDinamico, gsToken) {

                callback(it.responseText)
            }
        }
    }

    class stRegras(val eventEmitter: TodoEventEmitter) : LinkedHashMap<String, Regras>() {
        fun getRegras(callback: () -> Unit) {
            return Ajax().get("URl") {
                val regras = JSON.parse<Array<Regras>>(it.responseText)
                regras.forEach {
                    val regra = Regras(it.ID_REGRAS, it.REG_DESCR, it.REG_GRUPO, it.REG_MENU, it.REG_ATIVO, it.REG_MODULO)
                    //regra.isArchived = it.isArchived
                    //regra.isDone = it.isDone
                    this.put(it.ID_REGRAS, it)
                }
                callback()
            }
        }
    }

    class stLogonInicial(val eventEmitter: TodoEventEmitter) : ArrayList<Logon>() {

        fun getLogonDlogicaInicial(sUsuario: String, sSenha: String, callback: (ArrayList<Logon>) -> Unit) {
            ff.println1("executa getLogonDlogicaInicial")
            var sTeste = "$gsUniverso/logon/${sUsuario}/pass/${sSenha}/pro"
            return Ajax().get(sTeste) {
                this.clear()
                if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                    ff.println1(it.responseText)
                    val lista = JSON.parse<Array<Logon>>(it.responseText)

                    //println(lista)
                    //this = lista as ArrayList<Logon>()
                    for (obj in lista) {
                        this.add(obj)
                    }
                    //println0(lista)
                    //val lista = it.responseText.ffParse(Logon)
                }
                callback(this)
            }
        }


    }

    class stLogon1(val eventEmitter: TodoEventEmitter) : ArrayList<aaGenerico>() {

        fun getLogonDlogica(sUsuario: String, sSenha: String, callback: (ArrayList<aaGenerico>) -> Unit) {
            ff.println0("getLogonDlogica1")
            var sTeste = "$gsUniverso/logon/${sUsuario}/pass/${sSenha}/pro"
            return Ajax().get(sTeste) {
                //this.clear()
                //var lista = ArrayList<aaGenericoEmp>()
                if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                    println0(it.responseText)
                    //val lista = JSON.parse<MutableList<aaGenerico>>(it.responseText)
                    val lista = JSON.parse<Array<aaGenerico>>(it.responseText)
                    //println0(lista)
                    for (obj in lista) {
                        this.add(obj)
                    }
                    //val steste = JSON.stringify(this)
                    println0(lista)
                }
                //println0("vai imprimir o this")
                //println0(this)
                callback(this)
            }
        }
/*
        class stPasta(val eventEmitter: TodoEventEmitter) : ArrayList<Pasta>() {
            fun getPasta(iPasta: Int, callback: (ArrayList<Pasta>) -> Unit) {
                var sTeste = "${ff.gsDom1}/pasta/011/$giEmpresa/$iPasta"
                ff.println0("solicitando ajax de $sTeste")
                return Ajax().get(sTeste, gsToken) {
                    this.clear()
                    if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                        val lista = JSON.parse<Array<Pasta>>(it.responseText)
                        for (obj in lista) {
                            this.add(obj)
                        }
                    }
                    callback(this)
                }
            }
        }

 */


    }

    class stCliente(val eventEmitter: TodoEventEmitter) : ArrayList<Cliente>() {
        fun getCliente(task: Task, callback: (ArrayList<Cliente>) -> Unit) {
            var sTeste = "${ff.gsDom1}/cliente/012"
            ff.println0("solicitando $sTeste")
            //val sObj = JSON.stringify(obj)
            return Ajax().post(sTeste, task, gsToken) {
                this.clear()
                if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                    //println0(it.responseText)
                    val lista = JSON.parse<Array<Cliente>>(it.responseText)
                    for (obj in lista) {
                        this.add(obj)
                    }
                }
                callback(this)
            }
        }
    }

    class stAniversariosLogon(val eventEmitter: TodoEventEmitter) : ArrayList<Aniversarios>() {

        fun getAniversariosLogon(callback: (ArrayList<Aniversarios>) -> Unit) {
            var sTeste = "${ff.gsDom1}/logon/013/${ff.giEmpresa}"
            ff.println0("solicitando $sTeste")
            //val sObj = JSON.stringify(obj)
            return Ajax().get(sTeste, gsToken) {
                this.clear()
                if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                    //println0(it.responseText)
                    val lista = JSON.parse<Array<Aniversarios>>(it.responseText)
                    for (obj in lista) {
                        this.add(obj)
                    }
                }
                callback(this)
            }
        }
    }

/*
    class stAniversarios(val eventEmitter: TodoEventEmitter) : ArrayList<Aniversarios>() {

        fun getAniversarios(sCliente: String, sSetor: String, callback: (ArrayList<Aniversarios>) -> Unit) {
            var sTeste = "${ff.gsDom1}/aniversarios/011/${ff.giEmpresa}/${sCliente}/${sSetor}"
            ff.println0("solicitando $sTeste")
            //val sObj = JSON.stringify(obj)
            return Ajax().get(sTeste, gsToken) {
                this.clear()
                if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                    //println0(it.responseText)
                    val lista = JSON.parse<Array<Aniversarios>>(it.responseText)
                    for (obj in lista) {
                        this.add(obj)
                    }
                }
                callback(this)
            }
        }
    }
*/

    //***** RELACIONADOS A EMPRESA
    class stEmpresa00(val eventEmitter: TodoEventEmitter) : LinkedHashMap<String, Empresa>() {
        //retorna a string para conexão com a empresa
        fun getEmpresa(sUsuario: String, sSenha: String, callback: () -> Unit) {

            if ((ff.gsDom1.equals("/res") || ff.gsDom1.length < 10) && ff.gsDom2.length > 10)
                ff.gsDom1 = ff.gsDom2
            var sTeste = ff.gsDom1 + "/empresa/001"
            console.log("StorageService.getEmpresa $sTeste DOM1=${ff.gsDom1} DOM2=${ff.gsDom2}")

            // Heuller // getEmpresa tem timeout 3 segundos, se der errado cai no else e faz get com outra url
            return Ajax().getEmpresa(sTeste) {
                this.clear()
                ff.println1("getEmpresa $it.responseText")
                if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                    val lista = JSON.parse<Array<Empresa>>(it.responseText)
                    lista.forEach {
                        val obj = Empresa()//.ini(it.ID_EMPRESA.ffVis(), it.EMP_NOME, "", "", "", "")
                        obj.ID_EMPRESA = it.ID_EMPRESA
                        obj.EMP_NOME = it.EMP_NOME
                        this.put(it.ID_EMPRESA.ffVis(), it)
                    }
                    callback()
                } else {
                    //val sBlock = "AdmRetSUPORTE#AdmRet-1#AdmRetZUZA#AdmRetHeuller"
                    var bContinua = true
                    ff.println0("DOM0=${ff.gsDom1}")
                    if (ff.gsDom1.contains("AdmRetSUPORTE")
                            || ff.gsDom1.contains("AdmRetZUZA")
                            || ff.gsDom1.contains("AdmRetHEULLER")
                            || ff.gsDom1.contains("AdmRet-1")) {
                        bContinua = false
                    }

                    if (!ff.gsDom1.equals(ff.gsDom2) && (bContinua)) {
                        ff.gsDom1 = ff.gsDom2
                        ff.println1("novo dominio estabelecido: ${ff.gsDom1} variável sEmp = ${ff.gsDom1}")
                        Ajax().get(ff.gsDom1 + "/empresa/001") {
                            val lista = JSON.parse<Array<Empresa>>(it.responseText)
                            lista.forEach {
                                val obj = Empresa() //.ini(it.ID_EMPRESA.toString(), it.EMP_NOME, "", "", "", "")
                                obj.ID_EMPRESA = it.ID_EMPRESA
                                obj.EMP_NOME = it.EMP_NOME
                                this.put(it.ID_EMPRESA.ffVis(), it)
                            }
                            callback()
                        }
                    }
                }
            }
        }
    }

    class stEmpresa(val eventEmitter: TodoEventEmitter) : ArrayList<Empresa>() {

        fun getEmpresa(sEmpresa: String, callback: (ArrayList<Empresa>) -> Unit) {
            var sTeste = "${ff.gsDom1}/empresa/011/$sEmpresa"
            ff.println0("solicitando $sTeste")
            //val sObj = JSON.stringify(obj)
            return Ajax().get(sTeste, gsToken) {
                this.clear()
                if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                    //println0(it.responseText)
                    val lista = JSON.parse<Array<Empresa>>(it.responseText)
                    for (obj in lista) {
                        this.add(obj)
                    }
                }
                callback(this)
            }
        }
    }

    //***** RELACIONADOS A LOGON
    class stLogonAdm(val eventEmitter: TodoEventEmitter) : LinkedHashMap<String, Logon.AdmRet>() {
        /*
        fun postLogonAdmretANT(obj: Logon.AdmRet, callback: () -> Unit) {

            //println("executando postLogonAdmret")
            //console.log("zuza entrou em stLogonAdm")
            var sTeste = ff.gsDom1 + "/logon/004/funcionarioLogon"
            console.log(sTeste)
            //var Texto = Task("teste","conteudo")
            var Texto = obj.asDynamic()

            //return Ajax().post(sTeste,JSON.stringify(obj)) {
            return Ajax().post(sTeste, Texto) {
                this.clear()
                if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                    //console.log(it.responseText)
                    val lista = JSON.parse<Array<Logon.AdmRet>>("[" + it.responseText + "]")
                    //console.log("zuza" + it.responseText)
                    //console.log( lista)
                    lista.forEach {
                        //val obj =
                        val obj = Logon.AdmRet().ini(it.LOGON, it.OBS, it.CHAVE, it.EMPRESA, it.FUNC_FUNCAO)
                        this.put(it.CHAVE, it)
                    }
                    //console.log(lista)
                }
                callback()
            }
        }
         */

        /*
        fun postLogonAdmret(obj: Logon.AdmRet, callback: () -> Unit) {

            //println("executando postLogonAdmret")
            //console.log("zuza entrou em stLogonAdm")
            //var sTeste = ff.gsDom1 + "/logon/004/funcionarioLogon"
            var sTeste = ff.gsDom1 + "/logon/004/${obj.EMPRESA2}/${obj.LOGON}/${obj.SENHA}"
            ff.println0(sTeste)
            //var Texto = Task("teste","conteudo")
            var Texto = obj.asDynamic()

            //return Ajax().post(sTeste,JSON.stringify(obj)) {
            return Ajax().get(sTeste) {
                this.clear()
                if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                    //console.log(it.responseText)
                    val lista = JSON.parse<Array<Logon.AdmRet>>("[" + it.responseText + "]")
                    //console.log("zuza" + it.responseText)
                    //console.log( lista)
                    lista.forEach {
                        //val obj =
                        val obj = Logon.AdmRet().ini(it.LOGON, it.OBS, it.CHAVE, it.EMPRESA, it.FUNC_FUNCAO)
                        this.put(it.CHAVE, it)
                    }
                    //console.log(lista)
                }
                callback()
            }
        }

         */
    }

    class stFabricante(val eventEmitter: TodoEventEmitter) : ArrayList<Fabricante>() {

        fun getFabricante(callback: (ArrayList<Fabricante>) -> Unit) {
            var sTeste = "${ff.gsDom1}/aniversarios/010/${ff.giEmpresa}"
            ff.println0("solicitando $sTeste")
            //val sObj = JSON.stringify(obj)
            return Ajax().get(sTeste, gsToken) {
                this.clear()
                if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                    //println0(it.responseText)
                    val lista = JSON.parse<Array<Fabricante>>(it.responseText)
                    for (obj in lista) {
                        this.add(obj)
                    }
                }
                callback(this)
            }
        }

    }

    class stFatlote(val eventEmitter: TodoEventEmitter) : LinkedHashMap<String, Fatlote>() {
        fun getFatlote(iLote: String, callback: () -> Unit) {
            console.log("Solicitando fatlote ${iLote}")
            try {
                var sTeste = "${ff.gsDom1}/fatlote/011/${ff.giEmpresa}/${iLote}"
                return Ajax().get(sTeste, ff.gsToken) {
                    this.clear()
                    if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                        var lista = JSON.parse<Array<Fatlote>>("[${it.responseText}]")
                        if (lista[0] != null) {
                            lista.forEach {
                                val fatlote = Fatlote().construtor(it.FAT_EMPRESA, it.FAT_LOTE,
                                        it.FAT_DATA, it.FAT_ATUALIZADO, it.FAT_TITULO, it.FAT_TIPO,
                                        it.FAT_LOTEORIGINAL, it.FAT_ARM)
                                this.put(it.FAT_LOTE.toString(), it)
                            }
                        } else {
                            console.log("objeto indefinido ou nulo")
                        }
                    }
                    callback()
                }
            } catch (e: Exception) {
                console.log(e.message)
            }
        }
    }

    /*
    class stFatloteItens(val eventEmitter: TodoEventEmitter) : LinkedHashMap<String, Fatloteitem>() {
        fun getFatloteItens(iLote: String, callback: () -> Unit) {
            console.log("Solicitando itens do lote $iLote")
            try {
                var sTeste = "${ff.gsDom1}/fatlote/012/${ff.giEmpresa}/${iLote}"
                return Ajax().get(sTeste, ff.gsToken) {
                    this.clear()
                    if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                        var lista = JSON.parse<Array<Fatloteitem>>(it.responseText)
                        if (lista[0] != null) {
                            lista.forEach {
                                val fatloteItem = Fatloteitem().construtor(it.FATITE_EMPRESA,
                                        it.FATITE_LOTE, it.FATITE_PRODUTO, it.FATITE_QTDE,
                                        it.FATITE_QTCONT, it.ESTG_UNIDVENDA, it.ESTG_EAN,
                                        it.PRO_CXEMBARQUE, it.PRO_DESCRCOMPLETA)
                                this.put(it.FATITE_PRODUTO.toString(), fatloteItem)
                            }
                        } else {
                            console.log("objeto indefinido ou nulo")
                        }
                    }
                    callback()
                }
            } catch (e: Exception) {
                console.log(e.message)
            }
        }
    }
     */

    class stFatloteItem(val eventEmitter: TodoEventEmitter) : LinkedHashMap<String, Fatloteitem>() {
        fun getFatloteItem(iLote: String, iProduto: String, callback: () -> Unit) {
            console.log("Solicitando item do lote $iLote")
            try {
                var sTeste = "${ff.gsDom1}/fatlote/013/${ff.giEmpresa}/${iLote}/${iProduto}"
                return Ajax().get(sTeste, ff.gsToken) {
                    this.clear()
                    if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                        var lista = JSON.parse<Array<Fatloteitem>>("[${it.responseText}]")
                        if (lista[0] != null) {
                            lista.forEach {
                                val fatloteItem = Fatloteitem().construtor(it.FATITE_EMPRESA,
                                        it.FATITE_LOTE, it.FATITE_PRODUTO, it.FATITE_QTDE,
                                        it.FATITE_QTCONT, it.ESTG_UNIDVENDA, it.ESTG_EAN,
                                        it.PRO_CXEMBARQUE, it.PRO_DESCRCOMPLETA)
                                this.put(it.FATITE_LOTE.toString(), fatloteItem)
                            }
                        } else {
                            console.log("objeto indefinido ou nulo")
                        }
                    }
                    callback()
                }
            } catch (e: Exception) {
                console.log(e.message)
            }
        }
    }

    class stIndprocesso(val eventEmitter: TodoEventEmitter) : LinkedHashMap<String, Indprocesso>() {
        fun getIndprocesso(sDtconclusao: String, callback: () -> Unit) {
            try {
                var sTeste = "${ff.gsDom1}/indprocesso/011/${ff.giEmpresa}/${sDtconclusao}"
                return Ajax().get(sTeste, ff.gsToken) {
                    this.clear()
                    if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                        var lista = JSON.parse<Array<Indprocesso>>("${it.responseText}")
                        if (lista[0] != null) {
                            lista.forEach {
                                val indprocesso = Indprocesso().construtor(it.INDPRO_EMPRESA, it.INDPRO_PROCESSO,
                                        it.INDPRO_TITULO, it.INDPRO_FORNEC, it.INDPRO_DATA, it.INDPRO_DTPREV,
                                        it.INDPRO_ESTRUTURA, it.INDPRO_OBS, it.INDPRO_ESTCONTROLE)
                                this.put(it.INDPRO_PROCESSO.toString(), indprocesso)
                            }
                        } else {
                            console.log("objeto indefinido ou nulo")
                        }
                    }
                    callback()
                }
            } catch (e: Exception) {
                console.log("Erro getIndprocesso: ${e.message}")
            }
        }
    }

    class stIndprocessoItens(val eventEmitter: TodoEventEmitter) : LinkedHashMap<String, IndprocessoItem>() {
        fun getIndprocessoItens(iProcesso: Int, iEstoque: Int, callback: () -> Unit) {
            try {
                var sTeste = "${ff.gsDom1}/indprocesso/012/${ff.giEmpresa}/${iProcesso}/${iEstoque}"
                return Ajax().get(sTeste, ff.gsToken) {
                    this.clear()
                    if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                        var lista = JSON.parse<Array<IndprocessoItem>>("${it.responseText}")
                        if (lista[0] != null) {
                            lista.forEach {
                                val indprocessoItens = IndprocessoItem().construtor(it.INDPROI_EMPRESA, it.INDPROI_PROCESSO,
                                        it.INDPROI_ITEM, it.INDPROI_INDICE, it.INDPROI_PRODUTO, it.INDPROI_QTD, it.INDPROI_TIPO,
                                        it.INDPROI_OBS, it.INDPROI_DTUTILIZADO, it.ESTS_SALDO, it.PRO_UNIDMED, it.PRO_DESC, it.CATXSUB_COR)
                                this.put(it.INDPROI_ITEM.toString(), indprocessoItens)
                            }
                        }
                    } else {
                        console.log("objeto indefinido ou nulo")
                    }
                    callback()
                }
            } catch (e: Exception) {
                console.log("Erro getIndprocessoItens: ${e.message}")
            }
        }
    }

    class stInventario(val eventEmitter: TodoEventEmitter) : LinkedHashMap<String, Inventario>() {
        fun getInventario(iCodigo: String, callback: () -> Unit) {
            console.log("Solicitando inventário ${iCodigo}")
            try {
                var sTeste = "${ff.gsDom1}/inventario/011/${ff.giEmpresa}/${iCodigo}"
                return Ajax().get(sTeste, ff.gsToken) {
                    this.clear()
                    if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                        var lista = JSON.parse<Array<Inventario>>("[${it.responseText}]")
                        if (lista[0] != null) {
                            lista.forEach {
                                val inventario = Inventario().construtor(it.INV_EMPRESA, it.INV_CODIGO,
                                        it.INV_DATA, it.INV_DTPREV, it.INV_DTPROCESSAMENTO,
                                        it.INV_TITULO, it.INV_OBSERVACAO, it.INV_ESTCONTROLE,
                                        it.INV_FUNCABERTURA, it.INV_FUNCENCERRA)
                                this.put(it.INV_CODIGO.toString(), inventario)
                            }
                        } else {
                            console.log("objeto indefinido ou nulo")
                        }
                    }
                    callback()
                }
            } catch (e: Exception) {
                console.log(e.message)
            }
        }
    }

    class stInventarioItens(val eventEmitter: TodoEventEmitter) : LinkedHashMap<String, Inventarioite>() {
        fun getInventarioItens(iCodigo: String, sContado: String, callback: () -> Unit) {

            ff.println0("Solicitando itens do inventário $iCodigo")
            var sTeste = "${ff.gsDom1}/inventario/012/${ff.giEmpresa}/$iCodigo/$sContado"
            return Ajax().get(sTeste, ff.gsToken) {
                this.clear()
                if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                    val lista = JSON.parse<Array<Inventarioite>>(it.responseText)
                    lista.forEach {
                        val inventarioite = Inventarioite().construtor(it.INV_EMPRESA, it.INV_CODIGO,
                                it.INV_PRODUTO, it.INV_GRADE, it.INV_QTD, it.INV_DTPROCESSAMENTO,
                                it.EST_BARRAOFICIAL, it.ESTG_TIPO, it.ESTG_EAN,
                                it.ESTG_UNIDVENDA, it.EST_SALDO, it.PRO_CXEMBARQUE, it.PRO_DESCRCOMPLETA)
                        this.put(it.INV_PRODUTO.toString(), inventarioite)
                    }
                }
                callback()
            }
        }
    }

    class stInventarioItem(val eventEmitter: TodoEventEmitter) : LinkedHashMap<String, Inventarioite>() {
        fun getInventarioItem(iCodigo: String, iProduto: String, callback: () -> Unit) {
            console.log("Solicitando item do inventário $iCodigo")
            try {
                var sTeste = "${ff.gsDom1}/inventario/013/${ff.giEmpresa}/${iCodigo}/${iProduto}"
                return Ajax().get(sTeste, ff.gsToken) {
                    this.clear()
                    if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                        var lista = JSON.parse<Array<Inventarioite>>("[${it.responseText}]")
                        if (lista[0] != null) {
                            lista.forEach {
                                println(it.INV_GRADE)
                                val inventarioItem = Inventarioite().construtor(it.INV_EMPRESA, it.INV_CODIGO,
                                        it.INV_PRODUTO, it.INV_GRADE, it.INV_QTD, it.INV_DTPROCESSAMENTO,
                                        it.EST_BARRAOFICIAL, it.ESTG_TIPO, it.ESTG_EAN,
                                        it.ESTG_UNIDVENDA, it.EST_SALDO, it.PRO_CXEMBARQUE, it.PRO_DESCRCOMPLETA)
                                this.put(it.INV_CODIGO.toString(), inventarioItem)
                            }
                        } else {
                            console.log("objeto indefinido ou nulo")
                        }
                    }
                    callback()
                }
            } catch (e: Exception) {
                console.log(e.message)
            }
        }
    }

/*
    class stProdutoBarras(val eventEmitter: TodoEventEmitter) : LinkedHashMap<String, Produto>() {
        fun getProdutoBarras(sProduto: String, callback: () -> Unit) {
            //console.log("Solicitando produto $sProduto")
            try {
                var sTeste = "${ff.gsDom1}/produto/017/${ff.giEmpresa}/${sProduto}"
                return Ajax().get(sTeste, ff.gsToken) {
                    this.clear()
                    if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                        var lista = JSON.parse<Array<Produto>>(it.responseText)
                        if (lista[0] != null) {
                            var iCont = 0
                            lista.forEach {
                                val produto = Produto().construtor(it.PRO_EMPRESA, it.ID_PRODUTO, it.PRO_QTEMB,
                                        it.PRO_CXEMBARQUE, it.PRO_DESCRCOMPLETA, it.PRO_USUALT, it.PRO_DTALTCAD,
                                        it.EST_CONTRLOTE, it.EST_DIASVALID, it.EST_DIASVALIDMIN,
                                        it.EST_BARRAOFICIAL, it.ESTG_EAN, it.ESTG_TIPO, it.ESTG_UNIDVENDA)
                                this.put(iCont.toString(), produto)
                                iCont++
                            }
                        } else {
                            console.log("objeto indefinido ou nulo")
                        }
                    }
                    callback()
                }
            } catch (e: Exception) {
                console.log(e.message)
            }
        }
    }
*/

    class stProdutoSaldoInv(val eventEmitter: TodoEventEmitter) : LinkedHashMap<String, Inventarioite>() {
        fun getProdutoSaldoInv(sProduto: String, callback: () -> Unit) {
            try {
                var sTeste = "${ff.gsDom1}/inventario/015/${ff.giEmpresa}/${sProduto}"
                return Ajax().get(sTeste, ff.gsToken) {
                    this.clear()
                    if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                        var lista = JSON.parse<Array<Inventarioite>>("${it.responseText}")
                        ff.println0("stProdutoSaldoInv ${lista[0].toString()}")
                        if (lista[0] != null) {
                            lista.forEach {
                                val inventarioite = Inventarioite().construtor(it.INV_EMPRESA, it.INV_CODIGO,
                                        it.INV_PRODUTO, it.INV_GRADE, it.INV_QTD, it.INV_DTPROCESSAMENTO,
                                        it.EST_BARRAOFICIAL, it.ESTG_TIPO, it.ESTG_EAN,
                                        it.ESTG_UNIDVENDA, it.EST_SALDO, it.PRO_CXEMBARQUE, it.PRO_DESCRCOMPLETA)
                                this.put(it.INV_PRODUTO.toString(), inventarioite)
                            }
                        } else {
                            console.log("objeto indefinido ou nulo")
                        }
                    }
                    callback()
                }
            } catch (e: Exception) {
                console.log(e.message)
            }
        }
    }

/*
    class stProdutoloteSaldo(val eventEmitter: TodoEventEmitter) : LinkedHashMap<String, Produtolote>() {
        fun getProdutoloteSaldo(sProduto: String, callback: () -> Unit) {
            try {
                //http://10.10.1.107:8080/AdmRet-1/res/produto/017/1/9460
                var sTeste = "${ff.gsDom1}/produtolote/011/${ff.giEmpresa}/${sProduto}"
                return Ajax().get(sTeste, ff.gsToken) {
                    this.clear()
                    if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                        var lista = JSON.parse<Array<Produtolote>>("${it.responseText}")
                        if ((lista != null) && (lista[0] != null)) {
                            var iCont = 0
                            lista.forEach {
                                val produtolote = Produtolote().construtor(it.PROLOT_EMPRESA,
                                        it.PROLOT_PRODUTO, it.PROLOT_ID, it.PROLOT_LOTEFAB,
                                        it.PROLOT_FORNEC, it.PROLOT_NRNOTA, it.PROLOT_QTDENT,
                                        it.PROLOT_DTFABR, it.PROLOT_DTVAL, it.PROLOT_DTVIG,
                                        it.PROLOT_SALDO, it.PROLOT_OBS, it.PROLOT_USUARIO,
                                        it.PROLOT_QTRESOF, it.PROLOT_QTRESERVA, it.PROLOT_QTRESPROD,
                                        it.PROLOT_CUSTOL, it.PROLOT_PERDESC, it.PROLOT_FCINR,
                                        it.PROLOT_OF, it.PROLOT_ESTCONTROLE,
                                        it.EST_SALDO00, it.DIF_SALDO00, it.EST_CONTRLOTE00,
                                        it.PRO_DESCRCOMPLETA00, it.DIASVALID00)
                                this.put(iCont.toString(), produtolote)
                                iCont++
                            }
                        } else {
                            console.log("objeto indefinido ou nulo")
                        }
                    }
                    callback()
                }
            } catch (e: Exception) {
                console.log(e.message)
            }
        }
    }
*/

    /*
    class stProdutoOF(val eventEmitter: TodoEventEmitter) : LinkedHashMap<String, Inotas.InotasResu1>() {
        fun getProdutoOF(iOF: String, iProduto: String, callback: () -> Unit) {
            console.log("Solicitando item da of $iOF")
            try {
                var sTeste = "${ff.gsDom1}/notas/014/${ff.giEmpresa}/${iOF}/${iProduto}"
                return Ajax().get(sTeste, ff.gsToken) {
                    this.clear()
                    if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                        var lista = JSON.parse<Array<Inotas.InotasResu1>>("[${it.responseText}]")
                        // Heuller - validando o valor do inot_empresa pude tratar o callback
                        if ((lista.size > 0) && (lista[0].INOT_EMPRESA > 0)) {
                            lista.forEach {
                                val inotas = Inotas().iniResu1(it.INOT_EMPRESA, it.INOT_OF,
                                        it.INOT_ORDEM, it.INOT_PROD, it.INOT_DESCPROD, it.INOT_GRADE,
                                        it.INOT_QTD, it.INOT_VLUNIT, it.INOT_TOTAL, it.INOT_TOTNOTA,
                                        it.INOT_QTDCONT, it.INOT_LOTEXML, it.PRO_MEDIDA, it.PRO_UNIDMED,
                                        it.PRO_QTEMB, it.PRO_CXEMBARQUE, it.PRO_UNID,
                                        it.PRO_PESOLIQ, it.PRO_PESOBRUTO, it.PRO_FABR,
                                        it.PRO_ARM, it.ARM_DESCR, it.PRO_DESCRCOMPLETA, it.EST_BARRAOFICIAL,
                                        it.ESTG_EAN, it.ESTG_TIPO, it.ESTG_UNIDVENDA,
                                        it.ESTG_EANC, it.ESTG_EAND, it.ESTG_EANU, it.EST_CONTRLOTE,
                                        it.EST_DIASVALID, it.EST_DIASVALIDMIN)
                                this.put(it.INOT_ORDEM.toString(), inotas)
                            }
                        } else {
                            console.log("objeto indefinido ou nulo")
                        }
                    }
                    callback()
                }
            } catch (e: Exception) {
                console.log(e.message)
                callback()
            }
        }
    }
     */
/*
    class stInotas(val eventEmitter: TodoEventEmitter) : LinkedHashMap<String, Inotas.InotasResu1>() {
        fun getInotas(iOrdem: String, callback: () -> Unit) {
            //http://10.10.1.77:8080/AdmRet-1/res/notas/012/1/392492
            //var sTeste = "${ff.gsDom1}/notas/012/${ff.gsEmpresa}/${iOrdem}"
            var sTeste = "${ff.gsDom1}/notas/012/empresa/${iOrdem}"
            console.log(sTeste)
            return Ajax().get(sTeste, gsToken) {
                console.log("zuza solicitando inotas")
                this.clear()
                if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                    val lista = JSON.parse<Array<Inotas.InotasResu1>>(it.responseText)
                    lista.forEach {
                        //console.log("inseriu ${it.NOT_RAZAO}")
                        val inotas = Inotas().iniResu1(it.INOT_EMPRESA, it.INOT_OF,
                                it.INOT_ORDEM, it.INOT_PROD, it.INOT_DESCPROD, it.INOT_GRADE,
                                it.INOT_QTD, it.INOT_VLUNIT, it.INOT_TOTAL, it.INOT_TOTNOTA,
                                it.INOT_QTDCONT, it.INOT_LOTEXML, it.PRO_MEDIDA, it.PRO_UNIDMED,
                                it.PRO_QTEMB, it.PRO_CXEMBARQUE, it.PRO_UNID,
                                it.PRO_PESOLIQ, it.PRO_PESOBRUTO, it.PRO_FABR,
                                it.PRO_ARM, it.ARM_DESCR, it.PRO_DESCRCOMPLETA, it.EST_BARRAOFICIAL,
                                it.ESTG_EAN, it.ESTG_TIPO, it.ESTG_UNIDVENDA,
                                it.ESTG_EANC, it.ESTG_EAND, it.ESTG_EANU, it.EST_CONTRLOTE,
                                it.EST_DIASVALID, it.EST_DIASVALIDMIN)
                        //println(it)
                        this.put(it.INOT_ORDEM.toString(), inotas)
                    }
                }
                callback()
            }
        }
    }

 */

    /*
    class stProdutoLoteDif(val eventEmitter: TodoEventEmitter) : LinkedHashMap<String, Produtolote>() {
        fun getProdutoLoteDif(callback: () -> Unit) {
            var sTeste = "${ff.gsDom1}/produtolote/014/empresa"
            return Ajax().get(sTeste, gsToken) {
                this.clear()
                if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                    val lista = JSON.parse<Array<Produtolote>>(it.responseText)
                    var i = 0
                    lista.forEach {
                        val produtolote = Produtolote().construtor(it.PROLOT_EMPRESA,
                                it.PROLOT_PRODUTO, it.PROLOT_ID, it.PROLOT_LOTEFAB,
                                it.PROLOT_FORNEC, it.PROLOT_NRNOTA, it.PROLOT_QTDENT,
                                it.PROLOT_DTFABR, it.PROLOT_DTVAL, it.PROLOT_DTVIG,
                                it.PROLOT_SALDO, it.PROLOT_OBS, it.PROLOT_USUARIO,
                                it.PROLOT_QTRESOF, it.PROLOT_QTRESERVA, it.PROLOT_QTRESPROD,
                                it.PROLOT_CUSTOL, it.PROLOT_PERDESC, it.PROLOT_FCINR,
                                it.PROLOT_OF, it.PROLOT_ESTCONTROLE,
                                it.EST_SALDO00, it.DIF_SALDO00, it.EST_CONTRLOTE00,
                                it.PRO_DESCRCOMPLETA00, it.DIASVALID00)
                        this.put(i.toString(), produtolote)
                        i++
                    }
                }
                callback()
            }
        }
    }

     */

    class stProdutoFCP(val eventEmitter: TodoEventEmitter) : LinkedHashMap<String, Produtofcp>() {
        fun getProdutoFCP(callback: () -> Unit) {
            var sTeste = "${ff.gsDom1}/produtofcp/011"
            return Ajax().get(sTeste, gsToken) {
                this.clear()
                if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                    val lista = JSON.parse<Array<Produtofcp>>(it.responseText)
                    var i = 0
                    lista.forEach {
                        val produtofcp = Produtofcp().construtor(it.ID_FCP, it.PFCP_UF, it.PFCP_NCM, it.PFCP_INDICE)
                        this.put(i.toString(), produtofcp)
                        i++
                    }
                }
                callback()
            }
        }
    }

    class stTarefas(val eventEmitter: TodoEventEmitter) : LinkedHashMap<String, Tarefas>() {
        fun getTarefas(callback: () -> Unit) {
            var sTeste = "${ff.gsDom1}/tarefas/011/empresa"
            return Ajax().get(sTeste, gsToken) {
                this.clear()
                if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                    val lista = JSON.parse<Array<Tarefas>>(it.responseText)
                    lista.forEach {
                        val tarefa = Tarefas().construtor(it.ID_TAREFA, it.TAR_EMPRESA, it.TAR_MENSAGEM)
                        this.put(it.ID_TAREFA.toString(), tarefa)
                    }
                }
                callback()
            }
        }
    }

    class stGen(val eventEmitter: TodoEventEmitter) : LinkedHashMap<String, Padrao>() {
        fun postGen(uri: String, task: Task, bToken: Boolean, callback: () -> Unit) {
            try {
                ff.println0("ajax de envio para $uri")
                ff.println0(JSON.stringify(task))

                var sToken = gsToken
                if (!bToken)
                    sToken = ""

                return Ajax().post(uri, task, sToken) {
                    this.clear()
                    var bContinua = true
                    ff.println0("retorno da execução postGen $uri")
                    ff.println0(it.responseText)
                    if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {

                        if (it.responseText.contains("PAD_CODIGO")) {
                            bContinua = false
                            if (it.responseText.ffCopy(0,1).equals("{")) {
                                val oPadrao = JSON.parse<Padrao>(it.responseText)
                                this.put("000", oPadrao)
                            } else {
                                val lista = JSON.parse<Array<Padrao>>(it.responseText)
                                lista.forEach {
                                    console.log(it.PAD_CODIGO.ffVss())
                                    val padrao = Padrao().ini(it.PAD_CODIGO, it.PAD_SITUAC)
                                    this.put(it.PAD_CODIGO.toString(), it)
                                }
                            }
                        }
                    }
                    if (bContinua) {
                        var sTexto = it.responseText.ffVss()
                        println(sTexto)
                        val padrao = Padrao().ini(0, sTexto)
                        this.put("000", padrao)
                    }
                    callback()
                }
            } catch (e: Exception) {
                ff.println0("erro stGen: ${e.message}")
                callback()
            }
        }

        fun postGen1(uri: String, task: Task, callback: () -> Unit) {
            try {
                return Ajax().post(uri, task, gsToken) {
                    this.clear()
                    var bContinua = true
                    if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                        if (it.responseText.contains("PAD_CODIGO")) {
                            bContinua = false
                            val lista = JSON.parse<Array<Padrao>>(it.responseText)
                            //console.log(it.responseText)
                            lista.forEach {
                                //console.log("inseriu ${it.NOT_RAZAO}")
                                console.log(it.PAD_CODIGO)
                                val padrao = Padrao().ini(it.PAD_CODIGO, it.PAD_SITUAC)
                                this.put(it.PAD_CODIGO.toString(), it)
                            }
                        }
                    }
                    if (bContinua) {
                        var sTexto = it.responseText.ffVss()
                        println(sTexto)
                        val padrao = Padrao().ini(0, sTexto)
                        this.put("000", padrao)
                    }
                    callback()
                }
            } catch (e: Exception) {
                ff.println0("erro stGen: ${e.message}")
                callback()
            }
        }

        fun postGenSimples(uri: String, task: Task, callback: (Int) -> Unit) {
            try {
                return Ajax().postSimples(uri, task, gsToken) {
                    this.clear()
                    callback(it)
                }
            } catch (e: Exception) {
                ff.println0("erro stGen: ${e.message}")
                callback(0)
            }
        }

        fun putGen(uri: String, task: Task, bToken: Boolean, callback: () -> Unit) {

            var sToken = gsToken
            if (!bToken)
                sToken = ""

            return Ajax().put(uri, task, sToken) {
                this.clear()
                console.log(it.status)
//                val lista = JSON.parse<Array<Padrao>>(it.status.)
//                lista.forEach {
//                    //console.log("inseriu ${it.NOT_RAZAO}")
//                    console.log(it.PAD_CODIGO)
//                    val padrao = Padrao().ini(it.PAD_CODIGO, it.PAD_SITUAC)
//                    this.put(it.PAD_CODIGO.toString(), it)
//                }
                val padrao = Padrao().ini(it.status.toInt(), "")
                this.put(it.status.toString(), padrao)
                callback()
            }
        }

        fun postJavaScriptLoad(sTexto: String, callback: () -> Unit) {

            var sTeste = eval(sTexto)
            console.log(sTeste)
            //var Texto = Task("teste","conteudo")
            callback()
        }
    }

    //    class stFuncionario(val eventEmitter: TodoEventEmitter) : LinkedHashMap<String, Funcionario>() {
    class stFuncionario(val eventEmitter: TodoEventEmitter) : ArrayList<Funcionario>() {

        fun getFuncionario(iFuncionario: Int, callback: (ArrayList<Funcionario>) -> Unit) {
            var sTeste = "${ff.gsDom1}/funcionario/011/lista/$giEmpresa/$iFuncionario"
            //ff.println0("solicitando ajax de $sTeste")
            return Ajax().get(sTeste, gsToken) {
                this.clear()
                if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                    val lista = JSON.parse<Array<Funcionario>>(it.responseText)
                    for (obj in lista) {
                        this.add(obj)
                    }
                    //ff.println0("tentando imprimir this")
                    //ff.println0(this)
                }
                callback(this)
            }
        }

    }

    class stFuncionarioRamo(val eventEmitter: TodoEventEmitter) : ArrayList<FuncionarioRamo>() {
        fun getFuncionarioRamo(_id: Int, callback: (ArrayList<FuncionarioRamo>) -> Unit) {
            var sTeste = "${ff.gsDom1}/funcionarioramo/011/$giEmpresa/$_id"
            //ff.println0("solicitando ajax de $sTeste")
            return Ajax().get(sTeste, gsToken) {
                this.clear()
                if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                    val lista = JSON.parse<Array<FuncionarioRamo>>(it.responseText)
                    for (obj in lista) {
                        this.add(obj)
                    }
                }
                callback(this)
            }
        }
    }

    class stUsuario(val eventEmitter: TodoEventEmitter) : ArrayList<Usuario>() {
        fun getUsuario(sUsuario: String, callback: (ArrayList<Usuario>) -> Unit) {
            var sTeste = "${ff.gsDom1}/usuario/011/$giEmpresa/$sUsuario"
            //ff.println0("solicitando ajax de $sTeste")
            return Ajax().get(sTeste, gsToken) {
                this.clear()
                if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                    val lista = JSON.parse<Array<Usuario>>(it.responseText)
                    for (obj in lista) {
                        this.add(obj)
                    }
                }
                callback(this)
            }
        }
    }

    class stRamo(val eventEmitter: TodoEventEmitter) : ArrayList<Ramo>() {
        fun getRamo(iRamo: Int, callback: (ArrayList<Ramo>) -> Unit) {
            var sTeste = "${ff.gsDom1}/ramo/011/$giEmpresa/$iRamo"
            //ff.println0("solicitando ajax de $sTeste")
            return Ajax().get(sTeste, gsToken) {
                this.clear()
                if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                    val lista = JSON.parse<Array<Ramo>>(it.responseText)
                    for (obj in lista) {
                        this.add(obj)
                    }
                }
                callback(this)
            }
        }
    }

    class stPasta(val eventEmitter: TodoEventEmitter) : ArrayList<Pasta>() {
        fun getPasta(iPasta: Int, callback: (ArrayList<Pasta>) -> Unit) {
            var sTeste = "${ff.gsDom1}/pasta/011/$giEmpresa/$iPasta"
            //ff.println0("solicitando ajax de $sTeste")
            return Ajax().get(sTeste, gsToken) {
                this.clear()
                if ((!it.responseText.equals(null)) && (!it.responseText.equals(""))) {
                    val lista = JSON.parse<Array<Pasta>>(it.responseText)
                    for (obj in lista) {
                        this.add(obj)
                    }
                }
                callback(this)
            }
        }
    }

//    class stRelatorio(val eventEmitter: TodoEventEmitter) : LinkedHashMap<String, String>() {
//        fun getRelatorio(sUrl: String, callback: () -> Unit) {
//            var sTeste = "${ff.gsDom1}/${sUrl}"
//            return Ajax().get(sTeste, gsToken) {
//                this.clear()
//            }
//        }
//    }


}
