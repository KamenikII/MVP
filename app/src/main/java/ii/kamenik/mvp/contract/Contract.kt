package ii.kamenik.mvp.contract

/**Чтобы установить связь между View-Presenter и Presenter-Model, необходим интерфейс. Этот класс интерфейса будет содержать все абстрактные методы, которые будут определены позже в классах View, Model и Presenter.*/

interface Contract {
    interface View {
        //метод, показывающий круг прогресса
        fun showProgress()

        //метод, скрывающий круг прогресса
        fun hideProgress()

        //метод, устанавливающий рандомный текст в TextView
        fun setString(input: String?)
    }

    interface Model {
        interface OnFinishedListener {
            // function to be called
            // once the Handler of Model class
            // completes its execution
            fun onFinished(string: String?)
        }

        fun getNext(onFinishedListener: OnFinishedListener?)
    }

    interface Presenter {
        //метод, когда нажимают на кнопку
        fun onButtonClick()

        //метод, заканчивающий жизненные цикл активити
        fun onDestroy()
    }
}