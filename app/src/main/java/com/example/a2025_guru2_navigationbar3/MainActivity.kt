package com.example.a2025_guru2_navigationbar3;



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 초기 프래그먼트 설정
        val homeFragment = HomeFragment()
        val cookFragment = CookFragment()
        val frigerFragment = FrigerFragment()
        val saveFragment = SaveFragment()

        // 기본적으로 homeFragment를 화면에 표시
        supportFragmentManager.beginTransaction()
            .add(R.id.rootlayout, homeFragment)
            .commit()

        // BottomNavigationView 설정
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNavigationView.setOnItemSelectedListener { item ->
            val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()

            when (item.itemId) {
                R.id.tabHome -> {
                    fragmentTransaction.replace(R.id.rootlayout, homeFragment).commit()
                    true
                }
                R.id.tabCook -> {
                    fragmentTransaction.replace(R.id.rootlayout, cookFragment).commit()
                    true
                }
                R.id.tabFriger -> {
                    fragmentTransaction.replace(R.id.rootlayout, frigerFragment).commit()
                    true
                }
                R.id.tabSave -> {
                    fragmentTransaction.replace(R.id.rootlayout, saveFragment).commit()
                    true
                }
                else -> false
            }
        }
    }
}

