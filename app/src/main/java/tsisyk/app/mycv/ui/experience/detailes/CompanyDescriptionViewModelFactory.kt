package tsisyk.app.mycv.ui.experience.detailes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import tsisyk.app.mycv.repository.MyCvRepository

@Suppress("UNCHECKED_CAST")
class CompanyDescriptionViewModelFactory(
    private val myCvRepository: MyCvRepository,
    private val firmName: String
) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CompanyDescriptionViewModel(myCvRepository, firmName) as T
    }
}