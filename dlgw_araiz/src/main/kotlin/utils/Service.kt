package utils

import model.*
import utils.ff.Companion.giEmpresa
import utils.ff.Companion.gsAcesso
import utils.ff.Companion.gsUrlLogon
import utils.ff.Companion.println0

//import kotlinx.coroutines.*

//import kotlin.coroutines.*

//import utils.ff.Companion.gbStorageResp

class Service() {
    private val eventEmitter = TodoEventEmitter()
    private val stAniversariosLogon = StorageService.stAniversariosLogon(eventEmitter)
    //private val stAniversarios = StorageService.stAniversarios(eventEmitter)
    private val stLogonInicial = StorageService.stLogonInicial(eventEmitter)
    private val stCliente = StorageService.stCliente(eventEmitter)
    private val stEmpresa00 = StorageService.stEmpresa00(eventEmitter)
    private val stEmpresa = StorageService.stEmpresa(eventEmitter)
    private val stLogon1 = StorageService.stLogon1(eventEmitter)
    private val stFabricante = StorageService.stFabricante(eventEmitter)
    private val stFatlote = StorageService.stFatlote(eventEmitter)
    //private val stFatloteItens = StorageService.stFatloteItens(eventEmitter)
    private val stFatloteItem = StorageService.stFatloteItem(eventEmitter)
    private val stFuncionario = StorageService.stFuncionario(eventEmitter)
    private val stFuncionarioRamo = StorageService.stFuncionarioRamo(eventEmitter)
    private val stGen = StorageService.stGen(eventEmitter)
    private val stIndprocesso = StorageService.stIndprocesso(eventEmitter)
    private val stIndprocessoItens = StorageService.stIndprocessoItens(eventEmitter)
    //private val stInotas = StorageService.stInotas(eventEmitter)
    private val stInventario = StorageService.stInventario(eventEmitter)
    private val stInventarioItens = StorageService.stInventarioItens(eventEmitter)
    private val stInventarioItem = StorageService.stInventarioItem(eventEmitter)
    private val stLogonAdm = StorageService.stLogonAdm(eventEmitter)
    //private val stNotas = StorageService.stNotas(eventEmitter)
    private val stPadrao = StorageService.stPadrao(eventEmitter)
    private val stPasta = StorageService.stPasta(eventEmitter)
    //private val stProdutoBarras = StorageService.stProdutoBarras(eventEmitter)
    private val stProdutoSaldoInv = StorageService.stProdutoSaldoInv(eventEmitter)
    //private val stProdutoLoteSaldo = StorageService.stProdutoloteSaldo(eventEmitter)
    //private val stProdutoOF = StorageService.stProdutoOF(eventEmitter)
    //private val stProdutoLoteDif = StorageService.stProdutoLoteDif(eventEmitter)
    private val stProdutoFCP = StorageService.stProdutoFCP(eventEmitter)
    private val stRamo = StorageService.stRamo(eventEmitter)
    private val stTarefas = StorageService.stTarefas(eventEmitter)
    private val stUsuario = StorageService.stUsuario(eventEmitter)
    //    private val stRelatorio = StorageService.stRelatorio(eventEmitter)
    private val st = StorageService()


//    fun launch() = suspendCoroutine<Any> {
//        //block.startCoroutine(object : Continuation<Unit> {
//        block.startCoroutine(object : Continuation<Unit> {
//            override val context: CoroutineContext get() = EmptyCoroutineContext
//            override fun resume(value: Unit) {}
//            override fun resumeWithException(e: Throwable) {
//                console.log("Coroutine failed: $e")
//            }
//        })
//    }
//
//    suspend fun launch() = coroutineScope {
//
//        val task1 = async { fetchResult(id = 42) }
//        val task2 = async { fetchResult(id = 99) }
//
//        val results = awaitAll(task1, task2)
//
//        log(results)
//    }

    /*
    fun launch(block: suspend () -> Unit) {
        //block.startCoroutine(object : Continuation<Unit> {
        block.startCoroutine(object : Continuation<Unit> {
            override val context: CoroutineContext get() = EmptyCoroutineContext
            override fun resume(value: Unit) {}
            override fun resumeWithException(e: Throwable) {
                console.log("Coroutine failed: $e")
            }
        })
    }
     */


    /*
    fun launch(block: suspend () -> Unit) {
        block.startCoroutine(object : Continuation<Unit> {
            override val context: CoroutineContext get() = EmptyCoroutineContext
            override fun resume(value: Unit) {}
            override fun resumeWithException(e: Throwable) {
                console.log("Coroutine failed: $e")
            }
        })
    }

     */

    //    fun getFuncionarioLista(iFuncionario: Int, cb: (List<Funcionario>) -> Unit) {
//        var lFuncionario = ArrayList<Funcionario>()
//
//        stFuncionario.getFuncionario(iFuncionario) { lFunc ->
//            cb(lFunc)
//        }
//    }
    //******************************************************************************** relacionados a LOGON
    fun getLogonMulti(sUsuario: String, sSenha: String, cb: (Array<aaGenericoEmp>) -> Unit) {
        println0("executando getLogonMulti")
        //var lObj = ArrayList<aaGenericoEmp>()

        stLogonInicial.getLogonDlogicaInicial(sUsuario, sSenha) { _lObj ->
            println0("zuza aqui 22")
            println0(_lObj!!)
            //println0("recebeu getLogonDlogica ${_lObj!!.get(0).aaGenericoEmp00!!.size}")
            var oLog: Logon = _lObj!!.get(0)
            println0(oLog)
            var oGenEmp00: Array<aaGenericoEmp> = oLog.aaGenericoEmp!! as Array<aaGenericoEmp>
            println0(oGenEmp00)

            //var sTeste = JSON.stringify(oGenEmp00)
            //var oTeste = JSON.parse<Array<aaGenericoEmp>>(sTeste)
            //lObj.add(oGenEmp00.get(0))
            //println0("recebeu getLogonDlogica ${lObj.size}")
            //println0(lObj)
            cb(oGenEmp00)
        }
    }

    fun getLogon(sUsuario: String, sSenha: String, cb: (Logon) -> Unit) {

        ff.println1("executa getLogon")
        stLogonInicial.getLogonDlogicaInicial(sUsuario, sSenha) { _oLog ->
            //console.log("metodo sincronizado")
            var oLog = _oLog.get(0)
            var iSerie = oLog.G2.ffVsi()
            //trabalha no logon quando P=produção
            if (ff.gsDesenvolvedor.equals("P")) {
                ff.gsDom1 = oLog.G7 //dom2
                ff.gsDom2 = oLog.G5  //dom1
                if (ff.gsDom1.equals("")) {
                    ff.gsDom1 = ff.gsDom2
                }

                //ff.gsDom0 = ff.gsDom0.replace("$","AdmRet") + "/res"
                var oGenEmp00: Array<aaGenericoEmp> = oLog.aaGenericoEmp!! as Array<aaGenericoEmp>
                println(oGenEmp00)
                println("executando o for procuranto pelo serie=$iSerie")
                for (obj in oGenEmp00) {
                    if (obj.idGenEmpresa.ffVsi() == iSerie) {
                        ff.gsDom1 = obj.aaDom2
                        ff.gsDom2 = obj.aaGenUrl
                    }
                }
                ff.gsDom1 = ff.gsDom1.replace("$", "AdmRet") + "/res"
                ff.gsDom2 = ff.gsDom2.replace("$", "AdmRet") + "/res"

            }
            ff.println1("getLogon zuza gsDesenvolvedor=${ff.gsDesenvolvedor!!} dom0=${ff.gsDom1}")


            if (oLog == null) {
                println("objeto oLog=null em getLogon")
                //gsAcesso = "falha"
            } else if (oLog != null && !oLog.G2.equals("")) {
                //console.log("tem conteúdo = ${oLog.G2}")
                var aTeste = oLog.G2.split("\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

                for (sTeste in aTeste) {
                    if (sTeste.contains("(pro")) {
                        //console.log("Zuza " + sTeste)
                        ff.gsDom2 = ff.ffPegaCampo(sTeste, "|dom=").replace("$", "AdmRet") + "/res"
                        if (!ff.ffPegaCampo(sTeste, "|dom1=").equals("")) {
                            ff.gsDom1 = ff.ffPegaCampo(sTeste, "|dom1=").replace("$", "AdmRet") + "/res"
                        } else {
                            ff.gsDom1 = ff.gsDom2
                        }
                    }
                    if (ff.gsDesenvolvedor.equals("7")) {
                        ff.gsDom1 = "http://10.10.1.32:8080/AdmRet-1/res"
                    } else if (ff.gsDesenvolvedor.equals("GD")) {
                        ff.gsDom1 = "dom1"
                    } else if (ff.gsDesenvolvedor.equals("A")) {
                        ff.gsDom1 = "dom1"
                    } else if (ff.gsDesenvolvedor.equals("L")) {
                        ff.gsDom1 = "dom1"
                    } else if (ff.gsDesenvolvedor.equals("W")) {
                        ff.gsDom1 = "dom1"
                    } else if (ff.gsDesenvolvedor.equals("LW")) {
                        ff.gsDom1 = "dom1"
                    } else if (ff.gsDesenvolvedor.equals("S")) {
                        ff.gsDom1 = "dom1"
                    }
//                    ff.gsDom1 = ff.gsDom1.replace("http:","https:")
//                    ff.gsDom1 = ff.gsDom1.replace(":8080",":8181")
//
//                    ff.gsDom2 = ff.gsDom2.replace("http:","https:")
//                    ff.gsDom2 = ff.gsDom2.replace(":8080",":8181")
                }
                //console.log(ff.gsDom0)
                gsAcesso = "ok"
            }

            ff.println1("zuza domínio = " + ff.gsDom1)
            cb(oLog)
        }
    }

    fun aniversarioListaLogon(cb: (List<Aniversarios>) -> Unit) {

        //var lobj = ArrayList<Aniversarios.AniLogon>()
        stAniversariosLogon.getAniversariosLogon() { _lObj ->
            println0("zuza aqui")
            println0(_lObj)

            cb(_lObj)
        }
    }

    fun aniversariosLista(sCliente: String, sSetor: String, cb: (List<Aniversarios>) -> Unit) {
        //var sTeste = "${ff.gsDom1}/aniversarios/011/${ff.giEmpresa}/${sCliente}/${sSetor}"
        stPadrao.selectGETString("aniversarios/011/${ff.giEmpresa}/${sCliente}/${sSetor}") { _sRetorno ->
            val lObj = JSON.parse<Array<Aniversarios>>(_sRetorno)
            cb(lObj.toList())
        }
    }

    fun aniversariosDel(ani: Aniversarios, cb: (String) -> Unit) {
        ff.println0("executando aniversariosDel")
        stPadrao.deleteObj("aniversarios/012", ani) { _obj ->
            //if (_obj )
            cb("ok")
        }
    }

    //******************************************************************************** relacionados a EMPRESAS
    fun getEmpresas(sUsuario: String, sSenha: String, cb: (List<Empresa>) -> Unit) {
        var lemp = ArrayList<Empresa>()
        stEmpresa00.getEmpresa(sUsuario, sSenha) {
            stEmpresa00.forEach { (_, empresa) ->
                lemp.add(empresa)
            }
            cb(lemp)
        }
    }

    //retorna todos os dados da tabela empresa
//    fun getEmpresa(sEmpresa: String, cb: (Empresa) -> Unit) {
//        stPadrao.selectGETString("empresa/011/${ff.giEmpresa}") { _sRetorno ->
//            val lObj = JSON.parse<Array<Empresa>>(_sRetorno)
//            cb(lObj.get(0))
//        }
//    }

    fun getEmpresa00(_recurso: String, cb: (Empresa) -> Unit) {
        println0("getEmpresa00")
        stPadrao.selectGET(_recurso) { _sRetorno ->
            cb(Empresa().construtorLista(_sRetorno.responseText).get(0))
        }
    }

    //******************************************************************************** relacionados a FABRICANTE
    //retorna todos os dados
    fun getFabricante(cb: (List<Fabricante>) -> Unit) {
        stPadrao.selectGETString("fabricante/011/${ff.giEmpresa}") { _sRetorno ->

            //val lista = JSON.parse<Array<Logon>>(it.responseText)
            //ff.println0(_sRetorno)
            val lObj = JSON.parse<Array<Fabricante>>(_sRetorno)
            //ff.println0(lObj)
            cb(lObj.toList())
        }
    }

    //******************************************************************************** relacionados a FATLOTE
    fun getFatlote(iLote: String, cb: (List<Fatlote>) -> Unit) {
        var lFatlote = ArrayList<Fatlote>()
        stFatlote.getFatlote(iLote) {
            stFatlote.forEach { (_, fatlote) ->
                lFatlote.add(fatlote)
            }
            cb(lFatlote)
        }
    }

    fun produtoLote(sData: String, sOrdem: String, cb: (List<Inotas.InotasResu>) -> Unit) {
        //var sTeste = "${ff.gsDom1}/aniversarios/011/${ff.giEmpresa}/${sCliente}/${sSetor}"
        stPadrao.selectGET("notas/017/${ff.giEmpresa}/$sData/$sOrdem") { _sRetorno ->
            cb(Inotas.InotasResu().construtorLista(_sRetorno))
        }
    }

    //******************************************************************************** relacionados a itens do FATLOTE
    fun getFatloteItens(iCodigo: String, cb: (List<Fatloteitem>) -> Unit) {
        //var sTeste = "${ff.gsDom1}/aniversarios/011/${ff.giEmpresa}/${sCliente}/${sSetor}"

        println0("executando getFatloteItens")
        stPadrao.selectGET("fatlote/012/${ff.giEmpresa}/$iCodigo") { _sRetorno ->
            //println0("zuza aqui = $_sRetorno")
            cb(Fatloteitem().construtorLista(_sRetorno))
        }
    }

    /*
    fun getFatloteItens1(iCodigo: String, cb: (List<Fatloteitem>) -> Unit) {
        var lFatloteitem = ArrayList<Fatloteitem>()
        stFatloteItens.getFatloteItens(iCodigo) {
            stFatloteItens.forEach { (_, fatloteite) ->
                lFatloteitem.add(fatloteite)
            }
            cb(lFatloteitem)
        }
    }
     */

    //******************************************************************************** relacionados a FATLOTE
    fun getFatloteitem(iLote: String, iProduto: String, cb: (List<Fatloteitem>) -> Unit) {
        var lFatloteItem = ArrayList<Fatloteitem>()
        stFatloteItem.getFatloteItem(iLote, iProduto) {
            stFatloteItem.forEach { (_, fatloteItem) ->
                lFatloteItem.add(fatloteItem)
            }
            cb(lFatloteItem)
        }
    }

    //******************************************************************************** relacionados a INVENTARIO
    fun getIndprocesso(sDtConclusao: String, cb: (List<Indprocesso>) -> Unit) {
        var lIndprocesso = ArrayList<Indprocesso>()
        stIndprocesso.getIndprocesso(sDtConclusao) {
            stIndprocesso.forEach { (_, indprocesso) ->
                lIndprocesso.add(indprocesso)
            }
            cb(lIndprocesso)
        }
    }

    //******************************************************************************** relacionados a INVENTARIO
    fun getIndprocessoItens(iProcesso: Int, iEstoque: Int, cb: (List<IndprocessoItem>) -> Unit) {
        var lIndprocessoItens = ArrayList<IndprocessoItem>()
        stIndprocessoItens.getIndprocessoItens(iProcesso, iEstoque) {
            stIndprocessoItens.forEach { (_, indprocessoItens) ->
                lIndprocessoItens.add(indprocessoItens)
            }
            cb(lIndprocessoItens)
        }
    }

    //******************************************************************************** relacionados a INVENTARIO
    fun getInventario(iCodigo: String, cb: (List<Inventario>) -> Unit) {
        var lInventario = ArrayList<Inventario>()
        stInventario.getInventario(iCodigo) {
            stInventario.forEach { (_, inventario) ->
                lInventario.add(inventario)
            }
            cb(lInventario)
        }
    }

    //******************************************************************************** relacionados a itens do INVENTARIO
    fun getInventarioItens(iCodigo: String, sContado: String, cb: (List<Inventarioite>) -> Unit) {
        var lInventarioite = ArrayList<Inventarioite>()
        stInventarioItens.getInventarioItens(iCodigo, sContado) {
            stInventarioItens.forEach { (_, inventarioite) ->
                lInventarioite.add(inventarioite)
            }
            cb(lInventarioite)
        }
    }

    //******************************************************************************** relacionados a itens do INVENTARIO
    fun getInventarioItem(iCodigo: String, iProduto: String, cb: (List<Inventarioite>) -> Unit) {
        var lInventarioItem = ArrayList<Inventarioite>()
        stInventarioItem.getInventarioItem(iCodigo, iProduto) {
            stInventarioItem.forEach { (_, inventarioite) ->
                lInventarioItem.add(inventarioite)
            }
            cb(lInventarioItem)
        }
    }

    //******************************************************************************** relacionados a itens do INVENTARIO
    fun getProduto(_recurso: String, cb: (List<Produto>) -> Unit) {
        stPadrao.selectGET(_recurso) { _sRetorno ->
            cb(Produto().construtorLista(_sRetorno))
        }
    }

    /*
    fun getProduto(sProduto: String, cb: (List<Produto>) -> Unit) {
        //var sTeste = "${ff.gsDom1}/produto/017/${ff.giEmpresa}/${sProduto}"
        stPadrao.selectGETXML("produto/017/${ff.giEmpresa}/${sProduto}") { _sRetorno ->
            cb(Produto().construtorLista(_sRetorno))
        }
    }

     */

/*
    fun getProduto(sProduto: String, cb: (List<Produto>) -> Unit) {
        var lProduto = ArrayList<Produto>()
        stProdutoBarras.getProdutoBarras(sProduto) {
            stProdutoBarras.forEach { (_, produto) ->
                lProduto.add(produto)
            }
            cb(lProduto)
        }
    }
*/

    //******************************************************************************** relacionados a itens do INVENTARIO
    fun getProdutoSaldoInv(sProduto: String, cb: (List<Inventarioite>) -> Unit) {
        var lInventarioitem = ArrayList<Inventarioite>()
        stProdutoSaldoInv.getProdutoSaldoInv(sProduto) {
            stProdutoSaldoInv.forEach { (_, inventarioite) ->
                lInventarioitem.add(inventarioite)
            }
            cb(lInventarioitem)
        }
    }

    //******************************************************************************** relacionados a itens do INVENTARIO
    fun getProdutoLoteSaldo(sProduto: String, cb: (List<Produtolote>) -> Unit) {
        //var sTeste = "${ff.gsDom1}/produtolote/011/${ff.giEmpresa}/${sProduto}"
        stPadrao.selectGET("produtolote/011/${ff.giEmpresa}/${sProduto}") { _sRetorno ->
            cb(Produtolote().construtorLista(_sRetorno))
        }
    }
/*
    fun getProdutoLoteSaldo(sProduto: String, cb: (List<Produtolote>) -> Unit) {
        var lProdutolotesaldo = ArrayList<Produtolote>()
        stProdutoLoteSaldo.getProdutoloteSaldo(sProduto) {
            stProdutoLoteSaldo.forEach { (_, produtolotesaldo) ->
                lProdutolotesaldo.add(produtolotesaldo)
            }
            cb(lProdutolotesaldo)
        }
    }
*/

    //******************************************************************************** relacionados a itens do INVENTARIO
    fun getProdutosFCP(cb: (List<Produtofcp>) -> Unit) {
        var lProdutosfcp = ArrayList<Produtofcp>()
        stProdutoFCP.getProdutoFCP {
            stProdutoFCP.forEach { (_, produtofcp) ->
                lProdutosfcp.add(produtofcp)
            }
            cb(lProdutosfcp)
        }
    }

    //******************************************************************************** relacionados a itens do INVENTARIO
    fun getProdutoOF(_recurso: String, cb: (List<Inotas.InotasResu>) -> Unit) {

        ff.println0("executando getProdutoOF")
        stPadrao.selectGET(_recurso) { _sRetorno ->
            cb(Inotas.InotasResu().construtorLista(_sRetorno))
        }
    }
    /*
    fun getProdutoOF(sOF: String, sProduto: String, cb: (List<Inotas.InotasResu1>) -> Unit) {
        var lInotas = ArrayList<Inotas.InotasResu1>()
        stProdutoOF.getProdutoOF(sOF, sProduto) {
            stProdutoOF.forEach { (_, inotas) ->
                lInotas.add(inotas)
            }
            cb(lInotas)
        }
    }
     */

    //******************************************************************************** relacionados as NOTAS
    fun getNota00(_recurso: String, cb: (List<Notas>) -> Unit) {
        stPadrao.selectGET(_recurso) { _sRetorno ->
            cb(Notas().construtorLista(_sRetorno))
        }
    }

    //******************************************************************************** relacionado a INOTAS
    fun getInotas00(_recurso: String, cb: (List<Inotas.InotasResu>) -> Unit) {
        stPadrao.selectGET(_recurso) { _sRetorno ->
            cb(Inotas.InotasResu().construtorLista(_sRetorno))
        }
    }

/*
    fun getInotas(iOrdem: String, cb: (List<Inotas.InotasResu1>) -> Unit) {
        var linotas = ArrayList<Inotas.InotasResu1>()
        stInotas.getInotas(iOrdem) {
            stInotas.forEach { (_, inotas) ->
                linotas.add(inotas)
            }
            cb(linotas)
        }
    }


 */
    //******************************************************************************** relacionados a PRODUTOLOTE
    //localhost:8080/AdmRet-1/res/produtolote/014_1/1/0
    fun getProdutoLote(iDias: Int, cb: (List<Produtolote>) -> Unit) {
        //var sTeste = "${ff.gsDom1}/produtolote/014/empresa"
        stPadrao.selectGET("produtolote/014_1/$giEmpresa/$iDias") { _sRetorno ->
            cb(Produtolote().construtorLista(_sRetorno))
        }
    }

    fun getProdutoLoteCount(cb: (String) -> Unit) {
        //var sTeste = "${ff.gsDom1}/produtolote/014/empresa"
        stPadrao.selectGETString("produtolote/014_2/$giEmpresa") { _sRetorno ->
            val obj = JSON.parse<Padrao>(_sRetorno)
            cb(obj.PAD_SITUAC)
        }
    }

    //******************************************************************************** relacionados a TAREFAS EM ABERTO
    fun getTarefas(cb: (List<Tarefas>) -> Unit) {
        var lTarefas = ArrayList<Tarefas>()
        stTarefas.getTarefas {
            stTarefas.forEach { (_, tarefa) ->
                lTarefas.add(tarefa)
            }
            cb(lTarefas)
            console.log(lTarefas)
            //teste
        }
    }

    //******************************************************************************** relacionado a GENERICO
    fun postLogonAdmRet00(_task: Task, _uri: String, _cb: (Logon.AdmRet) -> Unit) {
        println(_task)
        stPadrao.selectPOSTx(_uri, _task) { _sRetorno ->
            println0("postLogonAdmRet00" + _sRetorno)
            _cb(Logon.AdmRet().construtorLista(_sRetorno).get(0))
        }
    }

    /*
    fun postLogonAdm(obj: Logon.AdmRet, cb: (List<Logon.AdmRet>) -> Unit) {
        //println("executando postLogonAdm")
        var llogon = ArrayList<Logon.AdmRet>()
        stLogonAdm.postLogonAdmret(obj) {
            stLogonAdm.forEach { (_, ladmret) ->
                llogon.add(ladmret)
            }
            cb(llogon)
        }
    }

     */

    fun postGen(task: Task, uri: String, cb: (Padrao) -> Unit) {
        //ff.println0("executando post $uri")
        //val sTexto: String = JSON.stringify(task)
        //ff.println0("envio para postGen")
        //ff.println0(sTexto)

        var lpadrao = ArrayList<Padrao>()

        stGen.postGen(uri, task, true) {
            stGen.forEach { (_, padrao) ->
                println(padrao)
                lpadrao.add(padrao)
            }
            cb(lpadrao[0])
        }
    }

    fun put(task: Task, uri: String, cb: (Padrao) -> Unit) {
        ff.println0("executando put $uri")
        val sTexto: String = JSON.stringify(task)
        ff.println0(sTexto)

        var lpadrao = ArrayList<Padrao>()

        stGen.putGen(uri, task, true) {
            stGen.forEach { (_, padrao) ->
                println(padrao)
                lpadrao.add(padrao)
            }
            cb(lpadrao[0])
        }
    }

    fun postUNI(task: Task, uri: String, cb: (Padrao) -> Unit) {
        //ff.println0("executando post $uri")
        var sTexto: String = JSON.stringify(task)
        if (sTexto.ffCopy(0, 1).equals("{"))
            sTexto = "[$sTexto]"
        ff.println0(sTexto)

        var lpadrao = ArrayList<Padrao>()

        stGen.postGen(uri, task, false) {
            stGen.forEach { (_, padrao) ->
                println(padrao)
                lpadrao.add(padrao)
            }
            cb(lpadrao[0])
        }
    }

    fun putUNI(task: Task, uri: String, cb: (Padrao) -> Unit) {
        ff.println0("executando put $uri")
        val sTexto: String = JSON.stringify(task)
        ff.println0(sTexto)

        var lpadrao = ArrayList<Padrao>()

        stGen.putGen(uri, task, false) {
            stGen.forEach { (_, padrao) ->
                println(padrao)
                lpadrao.add(padrao)
            }
            cb(lpadrao[0])
        }
    }

    //******************************************************************************* relacionado ao PADRAO
    fun delete(sPath: String, cb: (String) -> Unit) {
        ff.println0("executando aniversariosDel")
        stPadrao.delete(sPath) { _obj ->
            //if (_obj )
            cb("ok")
        }
    }

    fun update(sPath: String, task: Task, cb: (Padrao) -> Unit) {
        val sTexto: String = JSON.stringify(task)
        ff.println0(sTexto)

        var oPadrao = Padrao()
        stPadrao.update(sPath, task) { _sRetorno ->
            //oPadrao = _sRetorno.asDynamic()
            //ff.println0(_sRetorno)
            oPadrao = JSON.parse<Padrao>(_sRetorno)
            //console.log(oPadrao)
            cb(oPadrao)
        }
    }

    fun ffJavaScriptLoad4(sTexto: String, cb: (String) -> Unit) {

        stGen.postJavaScriptLoad(sTexto) {
            cb("Ok")
        }
    }

    //******************************************************************************** relacionado a CLIENTE
    fun getClienteCons(obj: Cliente, cb: (List<Cliente>) -> Unit) {
        stCliente.getCliente(obj.asDynamic()) { lCliente ->
            cb(lCliente)
        }
    }

    fun getClienteCompleto(iCliente: Int, cb: (Cliente) -> Unit) {
        stPadrao.selectGETString("cliente/013/${ff.giEmpresa}/$iCliente") { _sRetorno ->
            val lObj = JSON.parse<Array<Cliente>>(_sRetorno)
            cb(lObj.get(0))
        }
    }

    //******************************************************************************** relacionado a FUNCIONARIO
    fun getFuncionarioLista(iFuncionario: Int, cb: (List<Funcionario>) -> Unit) {
        var lFuncionario = ArrayList<Funcionario>()

        stFuncionario.getFuncionario(iFuncionario) { lFunc ->
            cb(lFunc)
        }
    }

    //******************************************************************************** relacionado a FUNCIONARIORAMO
    fun getFuncionarioRamoLista(_id: Int, cb: (List<FuncionarioRamo>) -> Unit) {
        var lFuncRamo = ArrayList<FuncionarioRamo>()
        stFuncionarioRamo.getFuncionarioRamo(_id) { _lFuncRamo ->
            cb(_lFuncRamo)
        }
    }

    //******************************************************************************** relacionado a USUARIO
    fun getUsuarioLista(sUsuario: String, cb: (List<Usuario>) -> Unit) {
        var lUsuario = ArrayList<Usuario>()
        stUsuario.getUsuario(sUsuario) { _lUsuario ->
            cb(_lUsuario)
        }
    }

    //******************************************************************************** relacionado a PASTA
    fun getPastaLista(iPasta: Int, cb: (List<Pasta>) -> Unit) {
        var lPasta = ArrayList<Pasta>()
        stPasta.getPasta(iPasta) { _lPasta ->
            cb(_lPasta)
        }
    }

    //******************************************************************************** relacionado a PARTICIPANTE
//    fun getFuncionarioLista(iFuncionario: Int, cb: (List<Funcionario>) -> Unit) {
//        var lFuncionario = ArrayList<Funcionario>()
//
//        stFuncionario.getFuncionario(iFuncionario) { lFunc ->
//            cb(lFunc)
//        }
//    }

    //******************************************************************************** relacionado a RAMO
    fun getRamoLista(iRamo: Int, cb: (List<Ramo>) -> Unit) {
        var lRamo = ArrayList<Ramo>()
        stRamo.getRamo(iRamo) { _lRamo ->
            cb(_lRamo)
        }
    }

}




