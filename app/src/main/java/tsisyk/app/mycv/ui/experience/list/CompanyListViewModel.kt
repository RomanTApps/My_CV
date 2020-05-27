package tsisyk.app.mycv.ui.experience.list

import androidx.lifecycle.ViewModel
import tsisyk.app.mycv.repository.MyCvRepository
import tsisyk.app.mycv.utils.lazyDeferred

class CompanyListViewModel (private val myCvRepository: MyCvRepository) : ViewModel() {
    val companiesEntry by lazyDeferred { myCvRepository.getWorkExperience() }
}
