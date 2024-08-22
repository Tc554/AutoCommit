import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.lang.Thread.sleep
import kotlin.random.Random

/**
 * @author TastyCake
 * @date 8/22/2024
 */

val file = File("./complicatedCode.123")

fun main() {
    do {
        with(file) {
            setWritable(true)
            writeText(readText() + "e")
        }

        println("Staging changes...")
        println(runCommand("git add ."))

        println("Committing changes...")
        println(runCommand("git commit -m \"added a missing 'e'\""))

        println("Pushing to repository...")
        println(runCommand("git push"))

        sleep(2000)
        println("Starting next commit soon...")
        sleep(Random.nextInt(4000, 10000) + 1L)
    } while (true)
}

fun runCommand(command: String): String {
    val process = Runtime.getRuntime().exec(command)
    val reader = BufferedReader(InputStreamReader(process.inputStream))
    val output = StringBuilder()
    reader.lines().forEach { line -> output.append(line).append("\n") }
    process.waitFor()
    return output.toString()
}