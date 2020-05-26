package tsisyk.app.mycv.ui.info

import androidx.lifecycle.ViewModel
import tsisyk.app.mycv.repository.CvRepository
import tsisyk.app.mycv.utils.lazyDeferred

class InfoViewModel(private val cvRepository: CvRepository) : ViewModel() {
        val cv by lazyDeferred { cvRepository.getInfo() }
//    val cv = cvRepository.getInfo()
}