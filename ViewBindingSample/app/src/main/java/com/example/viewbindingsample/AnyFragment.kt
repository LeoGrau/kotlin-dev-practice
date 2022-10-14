package com.example.viewbindingsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewbindingsample.databinding.FragmentAnyBinding


class AnyFragment : Fragment() {

    private var _binding: FragmentAnyBinding? = null
    private val binding get() = _binding!! //getter (research getters and setters)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = FragmentAnyBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_any, container, false) the same down
        return binding.root
    }


}