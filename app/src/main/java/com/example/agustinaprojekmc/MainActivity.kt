package com.example.agustinaprojekmc

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var nama : Array<String>
    private lateinit var gambar : Array<Int>
    private lateinit var keterangan : Array<String>
    private lateinit var listKerajaan :ArrayList<ItemData>
    private lateinit var kerajaanRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        gambar = arrayOf(
            R.drawable.kedatontidore,
            R.drawable.kerajaanpagaruyung,
            R.drawable.kerajaansambas,
            R.drawable.kerajaanubud,
            R.drawable.keratonsumenep,
            R.drawable.kesultanancirebon,
            R.drawable.kesultanandeli,
            R.drawable.kesultanansiak,
            R.drawable.kesultananyogyakarta,
            R.drawable.krajaansekalabrak,
        )

        nama = arrayOf(
            "Kesultanan Tidore",
            "Kerajaan Pagaruyung",
            "Kerajaan Sambas",
            "Kerajaan Ubud",
            "Kerajaan Sumenep",
            "Kesultanan Cirebon",
            "Kesultanan Deli",
            "Kesultanan Siak",
            "Kesultanan Yogyakarta",
            "Kerajaan Kalabrak"
        )

        keterangan = arrayOf(
            getString(R.string.Kesultanan_Tidore),
            getString(R.string.Kerajaan_Pagaruyung),
            getString(R.string.Kerajaan_Sambas),
            getString(R.string.Kerajaan_Ubud),
            getString(R.string.Kerajaan_Sumenep),
            getString(R.string.Kesultanan_Cirebon),
            getString(R.string.Kesultanan_Deli),
            getString(R.string.Kesultanan_Siak),
            getString(R.string.Kesultanan_Yogyakarta),
            getString(R.string.Kerajaan_Kalabrak)
        )

        kerajaanRecyclerView = findViewById(R.id.kerajaanrv)
        kerajaanRecyclerView.layoutManager = LinearLayoutManager(this)
        kerajaanRecyclerView.setHasFixedSize(true)

        listKerajaan = arrayListOf<ItemData>()
        getDataUser()
    }
    private fun getDataUser() {
        for (i in gambar.indices){
            val  dataKerajaan = ItemData(gambar[i],nama[i])
            listKerajaan.add(dataKerajaan)
        }

        var adapter = MyAdapter(listKerajaan)
        kerajaanRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object: MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("idgambar",listKerajaan[position].gambar)
                intent.putExtra("idnama",listKerajaan[position].nama)
                intent.putExtra("idketerangan",keterangan[position])

                startActivity(intent)
            }
        })
    }
}