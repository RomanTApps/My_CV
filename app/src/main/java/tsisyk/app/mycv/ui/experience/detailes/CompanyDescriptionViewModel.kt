package tsisyk.app.mycv.ui.experience.detailes

import androidx.lifecycle.ViewModel
import tsisyk.app.mycv.repository.MyCvRepository
import tsisyk.app.mycv.utils.lazyDeferred

class CompanyDescriptionViewModel(
    private val myCvRepository: MyCvRepository,
    private val firmName: String
) : ViewModel() {
    val workExperienceDetaileEntry
            by lazyDeferred { myCvRepository.getWorkExperienceDetails(firmName) }
}