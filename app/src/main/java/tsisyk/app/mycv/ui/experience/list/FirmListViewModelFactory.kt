package tsisyk.app.mycv.ui.experience.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import tsisyk.app.mycv.repository.MyCvRepository
import tsisyk.app.mycv.ui.info.InfoViewModel

@Suppress("UNCHECKED_CAST")
class FirmListViewModelFactory(private val myCvRepository: MyCvRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FirmListViewModel(myCvRepository) as T
    }
}