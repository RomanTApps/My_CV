package tsisyk.app.mycv.ui.info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.DKodein
import org.kodein.di.generic.instanceOrNull
import tsisyk.app.mycv.repository.CvRepository

class InfoViewModelFactory(private val cvRepository: CvRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return InfoViewModel(cvRepository) as T
    }
}