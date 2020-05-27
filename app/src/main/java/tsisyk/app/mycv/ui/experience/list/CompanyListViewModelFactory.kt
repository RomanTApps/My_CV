package tsisyk.app.mycv.ui.experience.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import tsisyk.app.mycv.repository.MyCvRepository

@Suppress("UNCHECKED_CAST")
class CompanyListViewModelFactory(private val myCvRepository: MyCvRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CompanyListViewModel(myCvRepository) as T
    }
}