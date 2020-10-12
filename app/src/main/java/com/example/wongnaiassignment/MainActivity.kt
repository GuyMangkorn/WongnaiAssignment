package com.example.wongnaiassignment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wongnaiassignment.recyclerCrypto.CoinsObject
import com.example.wongnaiassignment.recyclerCrypto.CryptoAdapter
/**
 * MainActivity declaration Recycler and Presenter
 *
 * https://github.com/sotgame1234/WongnaiAssignment
 *
 * for source control
 */
class MainActivity : AppCompatActivity(),IMain.View{
    private lateinit var presenter: Presenter
    private lateinit var recyclerView:RecyclerView
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var recyclerLayoutManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerCrypto)
        recyclerView.isNestedScrollingEnabled = false
        recyclerView.setHasFixedSize(true)
        recyclerLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = recyclerLayoutManager
        presenter = Presenter(this)
        /** Get Api request */
        presenter.loadData()
    }

    /** Result of api request and set Recyclerview Adapter */
    override fun resultData(arr: ArrayList<CoinsObject>) {
        recyclerAdapter = CryptoAdapter(arr,this)
        recyclerView.adapter = recyclerAdapter
    }
}