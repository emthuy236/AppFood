 package com.example.foody.ui.fragments.recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foody.MainViewModel
import com.example.foody.R
import com.example.foody.adapters.RecipesAdapter
import com.example.foody.util.Constants.Companion.API_KEY
import com.example.foody.util.NetworkResult
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_recipe.view.*
@AndroidEntryPoint
class RecipeFragment : Fragment() {

  private lateinit var mview:View
    private val madapter by lazy { RecipesAdapter() }
    private lateinit var mainViewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mview =  inflater.inflate(R.layout.fragment_recipe, container, false)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        setupRecyclerview()

        return mview
    }
    private fun requestApi(){
        mainViewModel.getrecipe(applyQueries())
        mainViewModel.recipeRespone. observe(viewLifecycleOwner,{ response ->
             when(response){
                is NetworkResult.Success ->{
                    showShimmerEffect()
                    response.data?.let { madapter.setdata(it) }
                }
                 is NetworkResult.Error -> {
                     hideShimmerEffect()
                     Toast.makeText(requireContext(),response.message.toString(),Toast.LENGTH_SHORT).show()
                 }
                 is NetworkResult.Loading ->{
                     hideShimmerEffect()
                 }

            }
        })

    }
    private fun applyQueries():HashMap<String,String>{
        val queries = HashMap<String,String>()
        queries["number"] = "50"
        queries["apiKey"] = API_KEY
        queries["type"] = "snack"
        queries["diet"] = "vegan"
        queries["addRecipeInformation"] = "true"
        queries["fillIngredients"] = "true"
        return queries
    }
   private fun setupRecyclerview(){
        mview.recyclerview.adapter = madapter
        mview.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        showShimmerEffect()
    }

    private fun showShimmerEffect(){
        mview.recyclerview.showShimmer()
    }
  private  fun hideShimmerEffect(){
        mview.recyclerview.hideShimmer()
    }


}