import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.waren.tarea5_thewitcher3.R

class PortadaFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_portada, container, false)

        val slider = view.findViewById<ViewPager2>(R.id.image_slider)
        val imageList = listOf(
            R.drawable.slider01,
            R.drawable.slider02,
            R.drawable.slider1,
            R.drawable.slider2,
            R.drawable.slider3,
            R.drawable.slider4,
            R.drawable.slider5,
            R.drawable.slider6,
            R.drawable.slider7,
            R.drawable.slider8,
            R.drawable.slider9,
            R.drawable.slider10,
            R.drawable.slider11,
            R.drawable.slider12,
            R.drawable.slider13,
            R.drawable.slider14
        )
        slider.adapter = ImageSliderAdapter(imageList)

        return view
    }
}
