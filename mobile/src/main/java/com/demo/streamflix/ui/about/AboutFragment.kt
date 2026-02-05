package com.demo.streamflix.ui.about

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.demo.streamflix.R
import com.demo.streamflix.databinding.FragmentAboutBinding
import com.demo.streamflix.util.Extensions.showToast

class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        // Setup back button
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        // Company
        binding.itemCompany.ivIcon.setImageResource(R.drawable.ic_info)
        binding.itemCompany.tvTitle.text = getString(R.string.company)
        binding.itemCompany.tvSubtitle.text = getString(R.string.company_name)

        // Email
        binding.itemEmail.ivIcon.setImageResource(R.drawable.ic_email)
        binding.itemEmail.tvTitle.text = getString(R.string.email)
        binding.itemEmail.tvSubtitle.text = getString(R.string.contact_email)
        binding.itemEmail.root.setOnClickListener { sendEmail() }

        // Contact
        binding.itemContact.ivIcon.setImageResource(R.drawable.ic_phone)
        binding.itemContact.tvTitle.text = getString(R.string.contact)
        binding.itemContact.tvSubtitle.text = getString(R.string.contact_phone)
        binding.itemContact.root.setOnClickListener { makePhoneCall() }

        // About Us
        binding.itemAboutUs.ivIcon.setImageResource(R.drawable.ic_team)
        binding.itemAboutUs.tvTitle.text = getString(R.string.about_us)
        binding.itemAboutUs.tvSubtitle.text = getString(R.string.about_us_description)

        // Privacy Policy
        binding.itemPrivacyPolicy.ivIcon.setImageResource(R.drawable.ic_privacy)
        binding.itemPrivacyPolicy.tvTitle.text = getString(R.string.privacy_policy)
        binding.itemPrivacyPolicy.root.setOnClickListener { openPrivacyPolicy() }
    }

    private fun openPrivacyPolicy() {
        try {
            val url = getString(R.string.privacy_policy_url)
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        } catch (e: Exception) {
            showToast("No se pudo abrir el navegador web")
        }
    }

    private fun sendEmail() {
        try {
            val email = getString(R.string.contact_email)
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
                putExtra(Intent.EXTRA_SUBJECT, "Consulta - StreamFlix DEMO")
            }
            startActivity(intent)
        } catch (e: Exception) {
            showToast("No se pudo abrir el cliente de correo")
        }
    }

    private fun makePhoneCall() {
        try {
            val phone = getString(R.string.contact_phone)
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phone")
            }
            startActivity(intent)
        } catch (e: Exception) {
            showToast("No se pudo abrir el marcador")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}