import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.lang.Thread.sleep

/**
 * @author TastyCake
 * @date 8/22/2024
 */

val file = File("../complicatedCode.123")

fun main() {
    do {
        with(file) {
            setWritable(true)
            writeText("e")
        }

        println("Staging changes...")
        println(runCommand("git add ."))

        println("Committing changes...")
        println(runCommand("git commit -m \"added a missing 'e'\""))

        println("Pushing to repository...")
        println(runCommand("git push"))

        sleep(2)
        println("Starting next commit in 3 seconds...")
        sleep(3)
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