package tsisyk.app.mycv.ui.experience.description

import androidx.lifecycle.ViewModel
import tsisyk.app.mycv.repository.MyCvRepository
import tsisyk.app.mycv.utils.lazyDeferred

class JobDescriptionViewModel (private val myCvRepository: MyCvRepository) : ViewModel() {
    val cv by lazyDeferred { myCvRepository.getWorkExperience() }
}