package ii.kamenik.mvp.model

import android.os.Handler
import ii.kamenik.mvp.contract.Contract
import java.util.*

/**Слой для хранения данных. Он отвечает за обработку логики предметной области (реальные бизнес-правила) и связь с уровнями базы данных и сети. Ничего не знает о Presenter */

class Model: Contract.Model {
    //рандомный текст из интернета, который мы рандомно будем брать для отображения на дисплее
    private val array = Arrays.asList(
        "Hello, World ",
        "Somebody once told me...",
        "Hello, there",
        "Help me",
        "I love coding",
        "MVP is good",
        "Is MVP better than MVC?",
        "Who is Robert Martin?",
        "Have you ever met uncle Bob?",
        "You should just know about SRP!",
    )

    //метод, вызываемый тогда, когда нажали на кнопку и прошло заданное время (delayMillis)
    override fun getNext(onFinishedListener: Contract.Model.OnFinishedListener?) {
        Handler().postDelayed({ onFinishedListener!!.onFinished(getRandomString) }, 1200)
    }

    //рандомный выбор текста
    private val getRandomString: String
        private get() {
            val random = Random()
            val index = random.nextInt(array.size)
            return array[index]
        }
}