import models.Archive
import ui.ArchiveMenu

class App {
    private val archives = mutableListOf<Archive>()

    fun start() {
        ArchiveMenu(archives).show()
    }
}