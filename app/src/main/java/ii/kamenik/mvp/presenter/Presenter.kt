package ii.kamenik.mvp.presenter

import ii.kamenik.mvp.contract.Contract

/**Методы этого класса содержат основную бизнес-логику, которая решает, что и как отображать. Он запускает класс View для внесения необходимых изменений в пользовательский интерфейс.*/

class Presenter (
    private var mainView: Contract.View?, //объект View
    private val model: Contract.Model,    //объект Model
): Contract.Presenter, Contract.Model.OnFinishedListener {
    //когда нажимаю кнопку
    override fun onButtonClick() {
        if (mainView != null) {
            mainView!!.showProgress()
        }
        model.getNext(this)
    }

    override fun onDestroy() {
        mainView = null
    }

    override fun onFinished(input: String?) {
        if (mainView != null) {
            mainView!!.setString(input)
            mainView!!.hideProgress()
        }
    }
}