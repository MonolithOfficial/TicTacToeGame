package ge.edu.btu.game102

import android.graphics.Color.*
import android.hardware.camera2.params.BlackLevelPattern
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.widget.CompoundButton
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private var xCountNum = 0
    private var oCountNum = 0
    private var drawCountNum = 0
    private var resetCount = 0
    private var isFirstPlayer = true
    private lateinit var mp: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mp = MediaPlayer.create(this, R.raw.epicyessweartrack)
        mp.isLooping = true
        mp.setVolume(1f, 1f)
        init()
        restartTheGame(restartButton)
    }

    private fun init() {
        button00.setOnClickListener {
            checkPlayer(button00)
            winnerColor()
        }
        button01.setOnClickListener {
            checkPlayer(button01)
            winnerColor()
        }
        button02.setOnClickListener {
            checkPlayer(button02)
            winnerColor()
        }
        button10.setOnClickListener {
            checkPlayer(button10)
            winnerColor()
        }
        button11.setOnClickListener {
            checkPlayer(button11)
            winnerColor()
        }
        button12.setOnClickListener {
            checkPlayer(button12)
            winnerColor()
        }
        button20.setOnClickListener {
            checkPlayer(button20)
            winnerColor()
        }
        button21.setOnClickListener {
            checkPlayer(button21)
            winnerColor()
        }
        button22.setOnClickListener {
            checkPlayer(button22)
            winnerColor()
        }
    }


    private fun checkPlayer(button: Button) {
        if (button.text.isEmpty())
            if (isFirstPlayer) {
                button.text = "X"
                isFirstPlayer = false
                button.setTextColor(RED)
            } else {
                button.text = "0"
                isFirstPlayer = true
                button.setTextColor(BLUE)
            }

        if (button00.text.isNotEmpty() && button00.text == button01.text && button00.text == button02.text){
            winnerTextView.text = "The Winner is ${button00.text}"
            deleteClick()
        }else if (button10.text.isNotEmpty() && button10.text == button11.text && button10.text == button12.text){
            winnerTextView.text = "The Winner is ${button10.text}"
            deleteClick()
        }else if (button20.text.isNotEmpty() && button20.text == button21.text && button20.text == button22.text){
            winnerTextView.text = "The Winner is ${button20.text}"
            deleteClick()
        }else if (button00.text.isNotEmpty() && button00.text == button10.text && button00.text == button20.text){
            winnerTextView.text = "The Winner is ${button00.text}"
            deleteClick()
        }else if (button01.text.isNotEmpty() && button01.text == button11.text && button01.text == button21.text){
            winnerTextView.text = "The Winner is ${button01.text}"
            deleteClick()
        }else if (button02.text.isNotEmpty() && button02.text == button12.text && button02.text == button22.text){
            winnerTextView.text = "The Winner is ${button02.text}"
            deleteClick()
        }else if (button00.text.isNotEmpty() && button00.text == button11.text && button00.text == button22.text){
            winnerTextView.text = "The Winner is ${button00.text}"
            deleteClick()
        }else if (button02.text.isNotEmpty() && button02.text == button11.text && button02.text == button20.text){
            winnerTextView.text = "The Winner is ${button02.text}"
            deleteClick()
        }else if (button00.text.isNotEmpty() && button01.text.isNotEmpty() && button02.text.isNotEmpty() && button10.text.isNotEmpty() && button11.text.isNotEmpty() && button12.text.isNotEmpty() && button20.text.isNotEmpty() && button21.text.isNotEmpty() && button22.text.isNotEmpty()){
            winnerTextView.text = "DRAW"
            deleteClick()
        }

    }



    private fun deleteClick(){
        button00.isClickable = false
        button01.isClickable = false
        button02.isClickable = false
        button10.isClickable = false
        button11.isClickable = false
        button12.isClickable = false
        button20.isClickable = false
        button21.isClickable = false
        button22.isClickable = false
    }

    private fun winnerColor(){
        if (winnerTextView.text == "The Winner is 0"){
            winnerTextView.setTextColor(BLUE)
            oCountNum += 1
            oCount.text = "0 - " + oCountNum
        }else if (winnerTextView.text == "The Winner is X"){
            winnerTextView.setTextColor(RED)
            xCountNum += 1
            xCount.text = "X - " + xCountNum
        }else if (winnerTextView.text == "DRAW"){
            winnerTextView.setTextColor(CYAN)
            drawCountNum += 1
            drawCount.text = "D - " + drawCountNum
        }
    }





        private fun restartTheGame(restartButton: Button) {
            restartButton.setOnClickListener {
                resetCount += 1
                roundCount.text = "Round " + resetCount
                winnerTextView.text = ""
                button00.text = ""
                button00.isClickable = true
                button01.text = ""
                button01.isClickable = true
                button02.text = ""
                button02.isClickable = true
                button10.text = ""
                button10.isClickable = true
                button11.text = ""
                button11.isClickable = true
                button12.text = ""
                button12.isClickable = true
                button20.text = ""
                button20.isClickable = true
                button21.text = ""
                button21.isClickable = true
                button22.text = ""
                button22.isClickable = true
            }
        }

    fun audioBtnClick(v: View){
        if (mp.isPlaying){
            //stop
            mp.pause()
            audioButton.setBackgroundResource(R.drawable.mute)
        }else{
            //start
            mp.start()
            audioButton.setBackgroundResource(R.drawable.soundk)
        }
    }

    override fun onBackPressed() {
        if (mp.isPlaying) {
            mp.stop()
        }
        super.onBackPressed()
    }

    override fun onPause(){
        if (mp.isPlaying){
            mp.pause()
            audioButton.setBackgroundResource(R.drawable.mute)
        }
        super.onPause()
    }





    }



