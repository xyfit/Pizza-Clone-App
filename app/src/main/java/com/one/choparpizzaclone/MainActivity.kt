package com.one.choparpizzaclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.one.choparpizzaclone.databinding.ActivityMainBinding
import com.one.choparpizzaclone.fragment.DiscountFragment
import com.one.choparpizzaclone.fragment.FavoritesFragment
import com.one.choparpizzaclone.fragment.MenuFragment
import com.one.choparpizzaclone.fragment.ProfilFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //first start fragment
        changeFragment(MenuFragment())

        bottomNavigation()

    }

    private fun bottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.menu_id->{
                    changeFragment(MenuFragment())
                }
                R.id.discount_id->{
                    changeFragment(DiscountFragment())
                }
                R.id.profile_id->{
                    changeFragment(ProfilFragment())
                }
                R.id.favorites_id->{
                    changeFragment(FavoritesFragment())
                }
            }
            true
        }
    }

    private fun changeFragment(fragment: Fragment) {
        //replace fragment
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
        //add fragment
//        fragmentTransaction
//            .add(R.id.fragment_container, fragment, "TAG")
////            .addToBackStack("TAG")
//        fragmentTransaction.commit()
    }
}
