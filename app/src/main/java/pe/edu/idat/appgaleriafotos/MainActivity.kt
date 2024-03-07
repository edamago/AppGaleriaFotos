package pe.edu.idat.appgaleriafotos

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import pe.edu.idat.appgaleriafotos.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var binding:ActivityMainBinding
    private lateinit var archivo:File
    private var rutaFotoActual=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btnTomarFoto -> tomarFoto()
            R.id.btnCompartir -> compartirFoto()
        }
    }

    private fun compartirFoto() {
        TODO("Not yet implemented")
    }

    private fun tomarFoto() {
        abrirCamara.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
    }

    private val abrirCamara = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        resultado ->
        if(resultado.resultCode== RESULT_OK){
            val foto=resultado.data!!
            val fotoBitmap = foto.extras!!.get("data") as Bitmap
            binding.ivFoto.setImageBitmap(fotoBitmap)
        }
    }
}