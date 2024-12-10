package melany.test.test

import io.kotest.core.spec.style.FunSpec

class CipherTests: FunSpec({
    test("shouldCipherChar") {
        val res = Cipher().cipher('A', 3)
        assert(res == 'D')
    }

    test("shouldCipherCharWithKeyGreaterThan26") {
        val res = Cipher().cipher('A', 29)
        assert(res == ' ')
    }
})