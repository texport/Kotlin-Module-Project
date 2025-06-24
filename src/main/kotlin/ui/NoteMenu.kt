package ui

import models.Archive
import models.Note

class NoteMenu(private val archive: Archive) : BaseMenu<Note>("Заметки в архиве '${archive.name}':", archive.notes) {
    override fun onItemSelected(index: Int) {
        val note = archive.notes[index]
        println("\nЗаметка: ${note.name}")
        println("Содержимое: ${note.content}")
    }

    override fun onCreateNew() {
        print("Введите имя заметки: ")
        val name = readLine()?.trim()

        if (name.isNullOrEmpty()) {
            println("Имя заметки не может быть пустым.")
            return
        }

        print("Введите текст заметки: ")
        val content = readLine()?.trim()

        if (content.isNullOrEmpty()) {
            println("Текст заметки не может быть пустым.")
            return
        }

        archive.notes.add(Note(name, content))
        println("Заметка '$name' добавлена.")
    }
}