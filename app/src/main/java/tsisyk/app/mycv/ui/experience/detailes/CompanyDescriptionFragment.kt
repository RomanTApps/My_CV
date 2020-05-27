@file:Suppress("DEPRECATION")

package tsisyk.app.mycv.ui.experience.detailes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.job_description_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.factory
import tsisyk.app.mycv.R
import tsisyk.app.mycv.ui.BaseScopedFragment

class CompanyDescriptionFragment : BaseScopedFragment(), KodeinAware {

    override val kodein by closestKodein()
    private val viewModelFactory:
            ((firmName: String) -> CompanyDescriptionViewModelFactory) by factory()

    private var mViewModel: CompanyDescriptionViewModel? = null
    override fun onCreateView( inflater: LayoutInflater,  container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.job_description_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val firmName = arguments?.get("firmName").toString()
        Log.i("ARG", firmName)
        mViewModel = ViewModelProvider(
            this,
            viewModelFactory(firmName)
        ).get(CompanyDescriptionViewModel::class.java)
        bindUI()
    }

    private fun bindUI() = launch(Dispatchers.Main) {
        val companyDescription = mViewModel!!.workExperienceDetaileEntry.await()
        companyDescription.observe(viewLifecycleOwner, Observer {
            if (it == null) return@Observer
            Log.i("TAG", it.toString())
            textView_companyName.text = it.firmName
            textView_location.text = it.location
            textView_date.text = it.date
            textView_position.text = it.position
            textView_responsibility.text ="Responsibilities: " + it.responsibility
            textView_languages.text = "Language: " + it.languages
            textView_tools.text = "Tools: " + it.tools
            textView_team_size.text = "Team size: " + it.team
            textView_libraries.text = "Libraries: " + it.libraries

            Glide.with(this@CompanyDescriptionFragment).load(it.logo).into(imageView4)
        })


    }

}