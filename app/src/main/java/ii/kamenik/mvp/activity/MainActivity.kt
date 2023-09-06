package ii.kamenik.mvp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import ii.kamenik.mvp.R
import ii.kamenik.mvp.contract.Contract
import ii.kamenik.mvp.model.Model
import ii.kamenik.mvp.presenter.Presenter

/**MainActivity - это и есть слой view. Класс View отвечает за обновление пользовательского интерфейса в соответствии с изменениями, вызванными слоем Presenter. Данные, предоставленные Моделью, будут использоваться View, и в действие будут внесены соответствующие изменения. */

class MainActivity : AppCompatActivity(), Contract.View {
    private var textView: TextView ?= null //TextView class
    private var button: Button ?= null // Button class
    private var progress: ProgressBar ?= null //ProgressBar class

    var presenter: Presenter ?= null //объект класса Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView) //определили TextView
        button = findViewById(R.id.button) //определили Button
        progress = findViewById(R.id.progressBar) //определили progressBar

        presenter = Presenter(this, Model()) //передаем в презентер view и model

        //когда нажали на кнопку
        this.button!!.setOnClickListener(
            View.OnClickListener{
                presenter!!.onButtonClick()
            }
        )
    }

    //отображает прогресс
    override fun showProgress() {
        progress!!.visibility = View.VISIBLE
        textView!!.visibility = View.INVISIBLE
    }

    //прячет прогресс
    override fun hideProgress() {
        progress!!.visibility = View.GONE
        textView!!.visibility = View.VISIBLE
    }

    //устанавливает текст
    override fun setString(input: String?) {
        textView!!.text = input
    }
}