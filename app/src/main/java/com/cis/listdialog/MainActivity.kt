package com.cis.listdialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val dataBasic = arrayOf("항목1", "항목2", "항목3", "항목4", "항목5", "항목6")
    val customDataCountry = arrayOf("토고", "프랑스", "스위스", "스페인", "일본", "독일", "브라질", "대한민국")
    val customDataSrc = intArrayOf(R.drawable.imgflag1, R.drawable.imgflag2, R.drawable.imgflag3, R.drawable.imgflag4, R.drawable.imgflag5, R.drawable.imgflag6, R.drawable.imgflag7, R.drawable.imgflag8)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBasic.setOnClickListener { view ->
            val builder = AlertDialog.Builder(this)
            builder.setTitle("리스트 다이얼로그")
            builder.setNegativeButton("취소", null)

            val listener = object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    tv1.text = "기본 리스트 다이얼로그 : ${dataBasic[which]}"
                }
            }

            builder.setItems(dataBasic, listener)
            builder.show()
        }

        btnCustom.setOnClickListener { view ->
            val builder = AlertDialog.Builder(this)
            builder.setTitle("커스텀 리스트 다이얼로그")

            val list = ArrayList<HashMap<String, Any>>()

            var idx = 0
            while (idx < customDataCountry.size){
                val map = HashMap<String, Any>()
                map.put("country", customDataCountry[idx])
                map.put("src", customDataSrc[idx])

                list.add(map)
                idx++
            }

            val keys = arrayOf("country", "src")
            val ids = intArrayOf(R.id.customTv, R.id.customIv)

            val listener = object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    tv1.text = "커스텀 리스트 다이얼로그 : ${customDataCountry[which]}"
                }
            }

            val adapter = SimpleAdapter(this, list, R.layout.custom_dialog, keys, ids)
            builder.setAdapter(adapter, listener)

            builder.setNegativeButton("취소", null)
            builder.show()
        }

    }
}
