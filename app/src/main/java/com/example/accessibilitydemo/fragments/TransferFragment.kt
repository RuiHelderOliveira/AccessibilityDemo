package com.example.accessibilitydemo.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.accessibilitydemo.IBAN_STR
import com.example.accessibilitydemo.NAME_STR
import com.example.accessibilitydemo.activities.ConfirmActivity
import com.example.accessibilitydemo.databinding.FragmentTransferBinding

class TransferFragment : Fragment() {

    private lateinit var _binding: FragmentTransferBinding

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding
    private lateinit var mView: View

    companion object {

        fun newInstance(): TransferFragment {
            val frag = TransferFragment()

            return frag
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTransferBinding.inflate(inflater, container, false)
        mView = binding.root

        _binding.nextButton.setOnClickListener {

            if(_binding.ibanEditText.text.toString().trim().isEmpty()){
                _binding.ibanEditText.error = "Enter a destination account"
                return@setOnClickListener
            }

            val intent = Intent(activity, ConfirmActivity::class.java)
            intent.putExtra(IBAN_STR, binding.ibanEditText.text.toString())
            intent.putExtra(NAME_STR, binding.toEditText.text.toString())
            startActivity(intent)
        }

        return mView
    }
}