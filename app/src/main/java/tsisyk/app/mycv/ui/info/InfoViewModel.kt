package tsisyk.app.mycv.ui.info

import androidx.lifecycle.ViewModel
import tsisyk.app.mycv.repository.MyCvRepository
import tsisyk.app.mycv.utils.lazyDeferred

class InfoViewModel(private val myCvRepository: MyCvRepository) : ViewModel() {
        val cv by lazyDeferred { myCvRepository.getInfo() }
//    val cv = cvRepository.getInfo()
}