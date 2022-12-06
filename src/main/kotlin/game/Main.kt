import game.Game
import game.Monster
import game.Player

fun main(args: Array<String>) {
    var m1 = Monster()
    var m2 = Monster()
    var p = Player()

    var gameGame = Game()

    gameGame.addMonster(m1)
    gameGame.addMonster(m2)
    gameGame.addPlayer(p)

    gameGame.start()
}