package game

open class Wight() {

    var attack: Int = 1
    var  protection: Int = 1

    private var mn = readLine()!!.toInt()
    private var mx = readLine()!!.toInt()

    var health: Int = 0
    private var damage: IntRange = mn.rangeTo(mx)

    init {

        if (attack > 20 || attack < 1){
            throw Exception("Параметр Атака вышел за границы диапазона 1...20, введите новый")

        } else {
            this.attack = attack
        }

        if (protection > 20 || protection < 1) {
            throw Exception("Параметр Защита вышел за границы диапазона 1...20, введите заново")
        } else {
            this.protection = protection
        }

        if (health < 1) {
            throw Exception("Параметр Здоровье принимает недопустимое значение, введите заново")
        } else {
            this.health = health
        }

        if (mn < 0 || mx < 0 || mn > mx) {
            throw Exception("$mn - $mx неверный диапазон, введите новый диапазон")
        } else {
            this.damage  = mn..mx
        }
    }

    fun getRandDamage(): Int {
        return damage.random()
    }

    fun takeDamage(damage: Int) {
        this.health -= damage
    }

}