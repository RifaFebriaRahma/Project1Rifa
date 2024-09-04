package com.rifa.project1rifa

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class DuaActivity :AppCompatActivity(), AdapterView.OnItemSelectedListener{
    //: =>extends (pewarisan/inherits)
    //, =>implements (interface)
    lateinit var rbbayar : RadioButton
    val pilBerangkat = arrayOf<String>("05.00 pm", "05.00 am", "06.00 pm", "06.00 am", "07.00 pm", "07.00 am", "08.00 pm", "08.00 am", "09.00 pm", "09.00 am")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dua)
        val makanan = findViewById<CheckBox>(R.id.chkMakanan)
        val executive = findViewById<CheckBox>(R.id.chkExecutive)
        val bagasi = findViewById<CheckBox>(R.id.chkBagasi)
        val bayar = findViewById<RadioGroup>(R.id.rgBayar)
        val tujuan = findViewById<EditText>(R.id.editTujuan)
        val harga = findViewById<EditText>(R.id.editHarga)
        val jumlah = findViewById<EditText>(R.id.editJumlah)
        val proses = findViewById<Button>(R.id.btnProses)
        val trans = findViewById<TextView>(R.id.txtTrans)
        val spinBerangkat = findViewById<Spinner>(R.id.spinBerangkat)
        spinBerangkat.onItemSelectedListener=this
        val aa:ArrayAdapter<*> = ArrayAdapter<Any?>(this@DuaActivity, R.layout.spinner_style, pilBerangkat)
        aa.setDropDownViewResource(R.layout.spinner_style)
        spinBerangkat.adapter = aa
        proses.setOnClickListener{
            val tujuanP = tujuan.text.toString()
            val hargaP = harga.text.toString().toDouble()
            val jumlahP = jumlah.text.toString().toInt()
            val totTiket = hargaP * jumlahP
            val berangkat = spinBerangkat.selectedItem.toString()
            var totalbayar:Int=0
            val tambahan= StringBuffer()//object kotlin
            if(executive.isChecked) {
                tambahan.append("\nExecutive Longue")
                totalbayar += 125000
            }
            if (bagasi.isChecked){
                tambahan.append("\nBagasi")
                totalbayar += 300000
            }
            if (makanan.isChecked){
                tambahan.append("\nMakanan Minuman")
                totalbayar += 115000
            }
            tambahan.append("\nTotal Biaya Tambahan "+ totalbayar)
            val selectedRadio:Int =bayar.checkedRadioButtonId
            var total = tambahan
            var bayar = totTiket + totalbayar
            rbbayar = findViewById(selectedRadio)
            // DuaAvtivity namaObject = new DuaActivity() -> java
                trans.text = "Detil Pembayaran Tiket : " +
                        "\nTujuan : $tujuanP" +
                        "\nHarga Tiket: $hargaP" +
                        "\nJam Berangkat : $berangkat" +
                        "\nBiaya Tambahan : "+tambahan.toString() +
                        "\nJumlah Tiket : $jumlahP" +
                        "\nTotal Bayar Tiket : $totTiket" +
                        "\n Metode Pembayaran :"+rbbayar.text.toString()+
                        "\n Total Bayar : $bayar"
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val pilJamBerangkat:String = parent?.getItemAtPosition(position).toString()
        Toast.makeText(this, "Jam Berangkat : $pilJamBerangkat", Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}