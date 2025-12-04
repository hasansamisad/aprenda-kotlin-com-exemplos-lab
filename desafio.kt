// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { 
    BASICO, 
    INTERMEDIARIO, 
    AVANCADO 
}

data class Usuario(val nome: String)


data class ConteudoEducacional(
    val nome: String, 
    val duracao: Int, 
    val nivel: Nivel 
) 

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) { 
    
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("${usuario.nome} matriculado(a) na formação '$nome'.")
        } else {
            println("${usuario.nome} já está matriculado(a) nesta formação.")
        }
    }
    
    fun calcularDuracaoTotal(): Int {
        return conteudos.sumOf { it.duracao }
    }
    
    fun listarInscritos() {
        println("\n--- Inscritos na Formação '$nome' (${inscritos.size} total) ---")
        if (inscritos.isEmpty()) {
            println("Ninguém está inscrito ainda.")
        } else {
            inscritos.forEachIndexed { index, usuario ->
                println("${index + 1}. ${usuario.nome}")
            }
        }
    }
}

fun main() {
    
    val disciplinaIA : ConteudoEducacional = ConteudoEducacional("Introdução à IA", 30, Nivel.BASICO)
    val disciplinaCloud : ConteudoEducacional = ConteudoEducacional("Cloud Computing Essencial", 40, Nivel.INTERMEDIARIO)
    val disciplinaKotlin : ConteudoEducacional = ConteudoEducacional("Kotlin Avançado", 50, Nivel.AVANCADO)

    val listaConteudoKotlinIA = listOf(disciplinaKotlin, disciplinaIA, disciplinaCloud)

    val kotlinComIA = Formacao(
        nome = "Kotlin Com IA na Cloud",
        conteudos = listaConteudoKotlinIA
    )
    
    val hasan = Usuario("Hasan")
    val daniel = Usuario("Daniel")
    val vinicius = Usuario("Vinicius")
    
    kotlinComIA.matricular(hasan)
    kotlinComIA.matricular(daniel)
    kotlinComIA.matricular(vinicius)
    kotlinComIA.matricular(hasan) 

    println("\nNome da Formação: ${kotlinComIA.nome}")
    println("Total de Conteúdos: ${kotlinComIA.conteudos.size}")
    println("Duração Total: ${kotlinComIA.calcularDuracaoTotal()} minutos") 
    
    kotlinComIA.listarInscritos()
}