package com.example.practice2api

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.example.practice2api.databinding.FragmentMainContentBinding

class MainContentFragment : Fragment() {
    lateinit var binding: FragmentMainContentBinding
    private val informationModel : InformationModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainContentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        informationModel.username.observe(activity as LifecycleOwner, {
            binding.nameTitle.text = "Имя - " + it
        })

        informationModel.email.observe(activity as LifecycleOwner, {
            binding.emailTitle.text = "Почта - " + it
        })

        informationModel.dateOfBirth.observe(activity as LifecycleOwner, {
            binding.dateOfBirthTitle.text = "Дата рождения - " + it
        })

        binding.changeDataButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainContentFragment_to_changeDataFragment)
        }

        binding.backToAuthorization.setOnClickListener {
            findNavController().navigate(R.id.action_mainContentFragment_to_authorizationFragment3)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainContentFragment()
    }
}