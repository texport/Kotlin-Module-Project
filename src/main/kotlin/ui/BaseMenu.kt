package ui

abstract class BaseMenu<T>(
    private val title: String,
    protected val items: List<T>
) {
    abstract fun onItemSelected(index: Int)
    abstract fun onCreateNew()

    fun show() {
        while (true) {
            println("\n$title")
            println("0. Создать новый")
            items.forEachIndexed { i, item -> println("${i + 1}. $item") }
            println("${items.size + 1}. Выход")

            val input = readLine()
            val index = input?.toIntOrNull()

            if (index == null) {
                println("Введите корректную цифру.")
                continue
            }

            when {
                index == 0 -> onCreateNew()
                index in 1..items.size -> onItemSelected(index - 1)
                index == items.size + 1 -> return
                else -> println("Нет такого пункта. Повторите ввод.")
            }
        }
    }
}