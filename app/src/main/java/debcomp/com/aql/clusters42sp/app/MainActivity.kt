package debcomp.com.aql.clusters42sp.app

import android.accounts.AccountManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ridi.oauth2.Authorization
import debcomp.com.aql.clusters42sp.R
import debcomp.com.aql.clusters42sp.infra.api.APIservice
import debcomp.com.aql.clusters42sp.models.Coalition
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var apiServicex: APIservice
    var SECRET  = "625acf32ea7d2b9931a6b53565ede21ea4a6f7597c9c5e93f1be59da5c4f9f3a"
    var UID     = "dbad4f852950bb54fd471be38d3dd977b63029e5dc277c282959d154c3a90d99"
    var RED     = "cluster42sp://callback"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)


        val auth = validate()
        apiServicex = APIservice(auth)
        var coal: Coalition = Coalition()
        teste(coal)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }


    private fun teste (coal: Coalition){
        val testeAPI = apiServicex.coalitionEndPoint.getCoalition()

        testeAPI.enqueue(object: Callback<MutableList<Coalition>> {
            override fun onFailure(call: Call<MutableList<Coalition>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Falha na conexao com a API", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<MutableList<Coalition>>, response: Response<MutableList<Coalition>>) {
                if (response!!.isSuccessful){
                    Toast.makeText(this@MainActivity, "Bom", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, "Falha: ${response.body()}", Toast.LENGTH_SHORT).show()

                }
            }


        })
    }

    private fun validate(): String{
        val am: AccountManager = AccountManager.get(this)
        val options = Bundle()

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://api.intra.42.fr/oauth/authorize?client_id=$UID&scope=public&response_type=code&redirect_uri=$RED"))
        startActivityForResult(intent, 0)

        return ("teste")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 0) {
            var uri: Uri = intent.data!!
            var codex = uri.getQueryParameter("code")
        }
    }

}
