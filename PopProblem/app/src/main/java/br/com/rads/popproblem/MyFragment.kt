package br.com.rads.popproblem


import android.animation.Animator
import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import kotlinx.android.synthetic.main.fragment_my.*


class MyFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_my, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val objectAnimator = ObjectAnimator.ofInt(progress_bar, "progress", 0, 100)
        objectAnimator.duration = 5_000
        objectAnimator.interpolator = LinearInterpolator()
        objectAnimator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {}
            override fun onAnimationCancel(p0: Animator?) {}
            override fun onAnimationStart(p0: Animator?) {}
            override fun onAnimationEnd(p0: Animator?) {
                closeFragment()
            }
        })
        objectAnimator.start()
    }

    private fun closeFragment() {
        fragmentManager?.popBackStack()
    }

    object Companion {
        fun newInstance() = MyFragment()
    }

}
