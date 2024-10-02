package com.example.practice2api

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.practice2api.databinding.FragmentChangeDataBinding

class ChangeDataFragment : Fragment() {
    lateinit var binding: FragmentChangeDataBinding
    private val informationModel : InformationModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChangeDataBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.changeConfirmButton.setOnClickListener {
            informationModel.username.value = if (binding.nameChangeInput.text.toString().isEmpty()) {
                informationModel.username.value
            } else {
                binding.nameChangeInput.text.toString()
            }

            informationModel.email.value = if (binding.emailChangeInput.text.toString().isEmpty()) {
                informationModel.email.value
            } else {
                binding.emailChangeInput.text.toString()
            }

            informationModel.dateOfBirth.value = if (binding.birthdayChangeInput.text.toString().isEmpty()) {
                informationModel.dateOfBirth.value
            } else {
                binding.birthdayChangeInput.text.toString()
            }

            findNavController().navigate(R.id.action_changeDataFragment_to_mainContentFragment2)
        }

        binding.backToMainContent.setOnClickListener {
            findNavController().navigate(R.id.action_changeDataFragment_to_mainContentFragment)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ChangeDataFragment()
    }
}