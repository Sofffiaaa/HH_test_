package game

class Player: Wight() {

    private var maxHealth: Int = 0
    private var beHealed: Int = 3 //Можно исцелиться только 3 раза

    init {
        var h = health
        if (h < 1) {

            throw Exception("Параметр Здоровье принимает недопустимое значение, введите заново")

        }

        this.maxHealth = h

    }


    fun healing() {

        if (beHealed == 0){
            println("Больше нельзя исцелиться!")
            return
        }

        health += maxHealth/2

        if (health > maxHealth) {
            health = maxHealth
        }
        beHealed -=1

    }

    fun playerInfo() {
        println("")
    }
}