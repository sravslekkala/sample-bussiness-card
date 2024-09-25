package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.R
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // First Section: Logo, Name, and Title
        LogoNameTitleSection()

        Spacer(modifier = Modifier.height(48.dp)) // Increased space between sections

        // Second Section: Contact Information
        ContactInfoSection()
    }
}

@Composable
fun LogoNameTitleSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo Image
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Android Logo",
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Name Text
        Text(
            text = "Sai Sravani L",
            fontSize = 36.sp,  // Larger font for name
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        // Title Text
        Text(
            text = "Android Developer Extraordinaire",
            fontSize = 18.sp,
            color = Color(0xFF388E3C),  // Android green color
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun ContactInfoSection() {
    // First row for phone contact
    ContactInfoRow(iconId = R.drawable.ic_phone, info = "+11 (123) 444 555 666")

    // Second row for social media handle
    ContactInfoRow(iconId = R.drawable.ic_share, info = "@AndroidSravs")

    // Third row for email contact
    ContactInfoRow(iconId = R.drawable.ic_email, info = "sai.sravani@android.com")
}

@Composable
fun ContactInfoRow(iconId: Int, info: String) {
    Row(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start  // Aligns contact info to the start
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color(0xFF388E3C)  // Android green color
        )
        Spacer(modifier = Modifier.width(16.dp))  // Space between icon and text
        Text(text = info, fontSize = 16.sp, color = Color.Black)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBusinessCard() {
    BusinessCardAppTheme {
        BusinessCard()
    }
}
