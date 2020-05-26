package tsisyk.app.mycv.ui.experience.description

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import tsisyk.app.mycv.repository.MyCvRepository

@Suppress("UNCHECKED_CAST")
class JobDescriptionViewModelFactory(private val myCvRepository: MyCvRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return JobDescriptionViewModel(myCvRepository) as T
    }
}