package com.example.composermvvm.presentation.detailCoinScreen.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.composermvvm.data.remote.dto.Team

@Composable
fun TeamListItem(
    team: Team,
    modeifier: Modifier = Modifier
){
    Column(modifier = modeifier,
    verticalArrangement = Arrangement.Center
        ) {
        Text(text = team.name,
        style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = team.position,
            style = MaterialTheme.typography.labelMedium,
            fontStyle = FontStyle.Italic
        )
    }
}