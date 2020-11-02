package app.futured.androidprojecttemplate.ui.base

import androidx.databinding.ViewDataBinding
import app.futured.androidprojecttemplate.BR
import app.futured.arkitekt.core.BaseViewModel
import app.futured.arkitekt.core.ViewState
import app.futured.arkitekt.dagger.fragment.BaseDaggerBindingFragment

abstract class BaseBindingFragment<VM : BaseViewModel<VS>, VS : ViewState, B : ViewDataBinding> :
    BaseDaggerBindingFragment<VM, VS, B>() {

    override val brViewVariableId = BR.view
    override val brViewModelVariableId = BR.viewModel
    override val brViewStateVariableId = BR.viewState
}
