package tsisyk.app.mycv.ui.experience.list

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import tsisyk.app.mycv.R

class FirmListFragment : Fragment() {

    companion object {
        fun newInstance() = FirmListFragment()
    }

    private lateinit var viewModel: FirmListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.firm_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FirmListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
