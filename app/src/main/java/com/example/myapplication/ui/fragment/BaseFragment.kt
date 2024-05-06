package ai.offer_landed.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
/**
 * ${BaseFragment}
 * Created by Atiq Ur Rehman on ${02/23/2024}.
 * Email: atiqurrehman90@gmail.com
 * Organization: NineSol
 */
typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding>(
    private val inflate: Inflate<VB>
) : Fragment() {
    private var _binding: VB? = null
    val binding get() = _binding
    private var drawerListener: DrawerLayout.DrawerListener? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is DrawerLayout.DrawerListener) {
            drawerListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        if (drawerListener != null) {
            drawerListener = null
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding?.root
    }

    fun backPress(callback: () -> Unit) {
        isFragmentVisible {
            requireActivity().onBackPressedDispatcher.addCallback(this,
                object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {
                        callback()
                    }
                })
        }
    }


    fun isFragmentVisible(doWork: () -> Unit) {
        if (isAdded && !isDetached)
            doWork.invoke()
    }

}