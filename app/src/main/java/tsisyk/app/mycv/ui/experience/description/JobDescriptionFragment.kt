@file:Suppress("DEPRECATION")

package tsisyk.app.mycv.ui.experience.description

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance
import tsisyk.app.mycv.R
import tsisyk.app.mycv.ui.BaseScopedFragment

class JobDescriptionFragment : BaseScopedFragment(), KodeinAware {

    override val kodein by closestKodein()
    private val viewModelFactory  by instance <JobDescriptionViewModelFactory>()

    private var mViewModel: JobDescriptionViewModel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.job_description_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProvider(this, viewModelFactory).get(JobDescriptionViewModel::class.java)
    }

}