package tsisyk.app.mycv.ui.experience.list

import com.bumptech.glide.Glide
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_position.*
import tsisyk.app.mycv.R
import tsisyk.app.mycv.database.WorkExperienceEntry

class CompanyItem(
    val workExperienceEntry: WorkExperienceEntry
) : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.apply {
            text_company_name.text = workExperienceEntry.firmName
            text_date.text = workExperienceEntry.date
            text_position.text = workExperienceEntry.position
            Glide.with(this.containerView).load(workExperienceEntry.logo).into(image_company_logo)
        }
    }

    override fun getLayout() = R.layout.item_position
}