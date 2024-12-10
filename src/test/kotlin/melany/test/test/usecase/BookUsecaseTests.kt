package melany.test.test.usecase

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import melany.test.test.model.Book
import melany.test.test.port.BookRepository


class BookUsecaseTests: FunSpec({

    val bookRepository = mockk<BookRepository>()
    val bookUseCase = BookUsecase(bookRepository)

    test("shouldCreateBook") {
        val book = Book(1, "title", "author")

        every { bookRepository.saveBook(book) } returns book

        val result = bookUseCase.createBook(book) shouldBe book

        result shouldBe book
        verify { bookRepository.saveBook(book) }
    }

    test("shouldGetBooks") {
        val books = listOf(
            Book(1, "title1", "author1"),
            Book(2, "title2", "author2"),
            Book(3, "title3", "author3")
        )

        every { bookRepository.getBooks() } returns books

        val result = bookUseCase.getBooks()

        result shouldBe books.sortedBy { it.title }
        verify { bookRepository.getBooks() }
    }

    test("shouldHaveSameCount") {
        val books = listOf(
            Book(1, "title1", "author1"),
            Book(2, "title2", "author2"),
            Book(3, "title3", "author3")
        )

        every { bookRepository.getBooks() } returns books

        val result = bookUseCase.getBooks()

        result.size shouldBe books.size
        verify { bookRepository.getBooks() }
    }
})