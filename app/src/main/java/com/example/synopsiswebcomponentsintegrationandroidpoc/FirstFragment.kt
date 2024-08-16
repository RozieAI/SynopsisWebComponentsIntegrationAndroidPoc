package com.example.synopsiswebcomponentsintegrationandroidpoc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.synopsiswebcomponentsintegrationandroidpoc.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sessions = listOf(
            Session("Session 1", "https://synopsis-web-components.vercel.app"),
            Session("Session 2", "https://synopsis-web-components.vercel.app"),
            Session("Session 3", "https://synopsis-web-components.vercel.app"),
            Session("Session 4", "https://synopsis-web-components.vercel.app"),
            Session("Session 5", "https://synopsis-web-components.vercel.app"),
            Session("Session 6", "https://synopsis-web-components.vercel.app"),
        )

        val widgetsRecyclerView = view.findViewById<RecyclerView>(R.id.widgetsRecyclerView)
        widgetsRecyclerView.adapter = WidgetsAdapter(sessions, requireContext())
        widgetsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}