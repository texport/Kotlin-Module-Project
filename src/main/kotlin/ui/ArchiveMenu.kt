package ui

import models.Archive

class ArchiveMenu(private val archives: MutableList<Archive>) : BaseMenu<Archive>("Список архивов:", archives) {
    override fun onItemSelected(index: Int) {
        val archive = archives[index]
        NoteMenu(archive).show()
    }

    override fun onCreateNew() {
        print("Введите имя архива: ")
        val name = readLine()?.trim()

        if (name.isNullOrEmpty()) {
            println("Имя архива не может быть пустым.")
            return
        }

        archives.add(Archive(name))
        println("Архив '$name' создан.")
    }
}