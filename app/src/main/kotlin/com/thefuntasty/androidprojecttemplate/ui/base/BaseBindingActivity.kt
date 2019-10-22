package com.thefuntasty.androidprojecttemplate.ui.base

import androidx.databinding.ViewDataBinding
import com.thefuntasty.androidprojecttemplate.BR
import com.thefuntasty.mvvm.BaseViewModel
import com.thefuntasty.mvvm.ViewState
import com.thefuntasty.mvvm.dagger.activity.BaseDaggerBindingActivity

abstract class BaseBindingActivity<VM : BaseViewModel<VS>, VS : ViewState, B : ViewDataBinding> :
    BaseDaggerBindingActivity<VM, VS, B>() {

    override val brViewVariableId = BR.view
    override val brViewModelVariableId = BR.viewModel
    override val brViewStateVariableId = BR.viewState
}
