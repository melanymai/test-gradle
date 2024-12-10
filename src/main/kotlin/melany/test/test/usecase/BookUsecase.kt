package melany.test.test.usecase

import melany.test.test.model.Book
import melany.test.test.port.BookRepository

class BookUsecase(private val bookRepository: BookRepository) {

    fun getBooks(): List<Book> {
        // order by asc title
        return bookRepository.getBooks().sortedBy { it.title }
    }

    fun createBook(book: Book): Book {
        return bookRepository.saveBook(book)
    }
}