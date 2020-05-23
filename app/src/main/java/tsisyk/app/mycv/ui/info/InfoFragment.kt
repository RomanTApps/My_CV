package tsisyk.app.mycv.ui.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.info_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import tsisyk.app.mycv.R
import tsisyk.app.mycv.network.ConnectivityInterceptorImpl
import tsisyk.app.mycv.network.MyMockApiService
import tsisyk.app.mycv.network.NetWorkDataSourceImpl

class InfoFragment : Fragment() {
    private var mViewModel: InfoViewModel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.info_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(InfoViewModel::class.java)


        // TODO: remove test responce

        val myMockApiService = MyMockApiService(ConnectivityInterceptorImpl(requireContext()))
        val netWorkDataSource = NetWorkDataSourceImpl(myMockApiService)
        netWorkDataSource.fetchedInfo.observe(viewLifecycleOwner, Observer {
            info_txt.text = "Hello. \n\n  My nama is ${it.position}. \n\n I`m an ${it.position}"
        })

        GlobalScope.launch(Dispatchers.Main) { netWorkDataSource.fetchInfo() }
    }

    companion object {
        fun newInstance(): InfoFragment {
            return InfoFragment()
        }
    }
}