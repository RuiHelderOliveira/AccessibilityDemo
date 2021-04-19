package com.example.accessibilitydemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.accessibilitydemo.databinding.FragmentShareBinding

class ShareFragment : Fragment() {

    private lateinit var _binding: FragmentShareBinding

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding
    private lateinit var mView: View

    companion object {

        fun newInstance(): ShareFragment {
            val frag = ShareFragment()

            return frag
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShareBinding.inflate(inflater, container, false)
        mView = binding.root

        return mView
    }
}