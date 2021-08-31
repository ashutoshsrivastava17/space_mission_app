package assignment.leanix.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import assignment.leanix.R
import assignment.leanix.databinding.FragmentMissionsBinding
import assignment.leanix.repository.mission.models.MissionInfo
import assignment.leanix.ui.MainViewModel
import assignment.leanix.ui.adapters.BaseRecyclerAdapter
import assignment.leanix.ui.adapters.MissionAdapter


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MissionsFragment : Fragment() {

    private lateinit var missionAdapter: MissionAdapter
    private var _binding: FragmentMissionsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentMissionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // List of missions
        setUpMissionAdapter()

        // observing mission from api
        viewModel.observeMission()
            .observe(requireActivity(), {
                missionAdapter.publishResults(it)
                if (it != null) setHasOptionsMenu(true)
            })
    }

    private fun setUpMissionAdapter() {
        binding.rvData.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.rvData.setHasFixedSize(true)
        missionAdapter = MissionAdapter(requireContext())
        missionAdapter.setOnItemClickListener(object :
            BaseRecyclerAdapter.OnItemClickListener<MissionInfo> {
            override fun onItemClicked(position: Int, bean: MissionInfo?) {
                val bundle = Bundle()
                bundle.putParcelable("missionInfo", bean)
                findNavController().navigate(R.id.action_mission_to_mission_detail, bundle)
            }
        })
        binding.rvData.adapter = missionAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_sort_by_name_asc -> viewModel.sortByName("ASC")
            R.id.action_sort_by_name_desc -> viewModel.sortByName("DESC")
            R.id.action_sort_by_launch_date_asc -> viewModel.sortByLaunchDate("ASC")
            R.id.action_sort_by_launch_date_desc -> viewModel.sortByLaunchDate("DESC")
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}