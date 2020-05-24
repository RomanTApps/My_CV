package tsisyk.app.mycv.ui.info

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.info_fragment.*
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance
import tsisyk.app.mycv.R
import tsisyk.app.mycv.ui.BaseScopedFragment

@Suppress("DEPRECATION")
class InfoFragment() : BaseScopedFragment(), KodeinAware {

    override val kodein by closestKodein()
    private val viewModelFactory: InfoViewModelFactory by instance<InfoViewModelFactory>()
    private lateinit var mViewModel: InfoViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.info_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(InfoViewModel::class.java)
        bindUI()
    }

    private fun bindUI() = launch {
       val item =  mViewModel.cv.await()
           item.observe(viewLifecycleOwner, Observer {
            Log.i("infoEntry", it.email)
            textGitHub.text = it?.toString()
        })
    }


}