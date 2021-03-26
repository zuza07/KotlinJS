package utils

import model.Padrao
import model.Task

class Services1 {
    private val eventEmitter1 = TodoEventEmitter()
    private val stGen1 = StorageService.stGen(eventEmitter1)

    /*
    fun post1(task: Task, uri: String, cb: (Padrao) -> Unit) {
        ff.println0("zuzazzz11")

        var lpadrao = ArrayList<Padrao>()

        stGen.postGen(uri, task) {
            stGen.forEach { (_, padrao) ->
                println(padrao)
                lpadrao.add(padrao)
            }
            cb(lpadrao[0])
        }
    }
    */

    fun post1(task: Task, uri: String, cb: (Padrao) -> Unit) {
        ff.println0("zuzazzz1 post1")

        var lpadrao1 = ArrayList<Padrao>()

        stGen1.postGen1(uri, task) {
            stGen1.forEach { (_, padrao1) ->
                println(padrao1)
                lpadrao1.add(padrao1)
            }
            cb(lpadrao1[0])
        }
    }

    fun postSimples(task: Task, uri: String, cb: (Int) -> Unit) {
        ff.println0("zuzazzz1 post1")

        //var lpadrao1 = ArrayList<Padrao>()

        stGen1.postGenSimples(uri, task) { iResposta ->
            cb(iResposta)
        }
    }

}