package melany.test.test.port

import melany.test.test.model.Book

interface BookRepository {
    fun getBooks(): List<Book>
    fun saveBook(book: Book): Book
}