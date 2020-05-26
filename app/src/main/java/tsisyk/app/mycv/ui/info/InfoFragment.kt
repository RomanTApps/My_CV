package tsisyk.app.mycv.ui.info

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.info_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance
import tsisyk.app.mycv.R
import tsisyk.app.mycv.network.ConnectivityInterceptorImpl
import tsisyk.app.mycv.network.MyMockApiService
import tsisyk.app.mycv.network.NetWorkDataSourceImpl
import tsisyk.app.mycv.ui.BaseScopedFragment

class InfoFragment() : BaseScopedFragment(), KodeinAware {

    override val kodein by closestKodein()
    private val viewModelFactory  by instance <InfoViewModelFactory>()

    private lateinit var mViewModel: InfoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        return inflater.inflate(R.layout.info_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProvider(this, viewModelFactory).get(InfoViewModel::class.java)
        bindUI()
    }


    private fun bindUI() = launch {
        val item = mViewModel.cv.await()
        item.observe(viewLifecycleOwner, Observer {
            if (it == null) return@Observer
            Log.i("TAG" , it.email)
            textGitHub.text = it.github
            textEmail.text = it.email
            textWebPage.text = it.linkedIn
            textName.text = it.name
            textSummary.text = it.summary
            textPhone.text = it.tel
            Glide.with(this@InfoFragment).load(it.image).into(imageView)
        })
    }


}