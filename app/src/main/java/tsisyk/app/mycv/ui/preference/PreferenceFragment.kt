package tsisyk.app.mycv.ui.preference

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import tsisyk.app.mycv.R

class PreferenceFragment : Fragment() {

    companion object {
        fun newInstance() = PreferenceFragment()
    }

    private lateinit var viewModel: PreferenceViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.preference_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PreferenceViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
