package game

open class Game {

    private var monsters = ArrayList<Monster>()
    private  var player: Player ?= null
    var round: Int = 1

    init {}

    fun start() {

        if (isPlayerEmpty()) {
            println("Создайте игрока")
            return
        }

        while (!isPlayerEmpty() && !isMonstersEmpty()) {
            if (round % 2 == 1) {
                playerFight()
            } else {
                monsterFight()
            }

            removeDead()

            round += 1
        }

        if (isMonstersEmpty()) {
            println()
        } else {

        }
        clear()
    }

    fun addPlayer(p: Player){
        if (player == null){
            player = p
        } else {
            throw Exception ("Игрок уже существует")
        }
    }

    fun addMonster(m: Monster) {
        monsters.add(m)
    }

    fun playerFight() {
        var randMonster = monsters.random()

        println("Атакует: ${player!!.playerInfo()} , Защищается: ${randMonster.monsterInfo()}")
        hit(player!!,randMonster )
    }

    fun monsterFight() {
        var randMonster = monsters.random()

        println("Атакует: ${randMonster.monsterInfo()} , Защищается: ${player!!.playerInfo()}")
        hit(randMonster, player!!)
    }

    private fun isPlayerEmpty(): Boolean {
        if (player == null) {
            return true
        } else {
            return false
        }
    }

    private fun isMonstersEmpty(): Boolean {
        if (monsters.isEmpty()) {
            return true
        } else {
            return false
        }
    }

    private  fun hit(attacker: Wight, defensive: Wight) {
        var attackModifier: Int

        if (attacker.attack < defensive.protection ) {
            attackModifier = 1
        } else {
            attackModifier = attacker.attack - defensive.protection + 1
        }

        var isSuccess: Boolean = false

        for (i:Int in 1..attackModifier){

            var dice: Int = (1..6).random()

            println("Игральных кубиков - $dice")

            if (dice == 5 || dice == 6) {
                isSuccess = true
                break
            }
        }

        if (isSuccess ) {
            var damage = attacker.getRandDamage()

            defensive.takeDamage(damage)
            println("Атака успешна! Урон - $damage")
        } else {
            println("Атака произведена неуспешно!")
        }
    }

    private fun removeDead() {

        for (monster in monsters) {
            if (monster.health <1) {
                println("Монстр побеждён!")
                monsters.remove(monster)
            }

        }

        if (player!!.health < 1) {
            println("Игрок побежден!")
            player = null
        }
    }

    fun clear() {
        monsters.removeAll(monsters)
        player = null
    }

}