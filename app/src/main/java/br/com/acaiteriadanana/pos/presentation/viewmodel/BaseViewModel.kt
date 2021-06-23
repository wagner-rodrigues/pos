package br.com.acaiteriadanana.pos.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

open class BaseViewModel: ViewModel() {

    private val coroutineScope by lazy { CoroutineScope(Job() + Dispatchers.IO) }

    fun getCoroutinesScope() = coroutineScope

}
