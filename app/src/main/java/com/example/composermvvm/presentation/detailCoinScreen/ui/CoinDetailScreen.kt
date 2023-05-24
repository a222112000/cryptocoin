package com.example.composermvvm.presentation.detailCoinScreen.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composermvvm.presentation.detailCoinScreen.DetailCoinViewModel
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CoinDetailScreen(
    viewModel: DetailCoinViewModel = hiltViewModel()
){

    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize().padding(6.dp)){

       state.coin?.let {
           LazyColumn(modifier = Modifier.fillMaxSize()){
              item{
                  Row(modifier = Modifier.fillMaxSize(),
                      horizontalArrangement = Arrangement.SpaceBetween
                  ){
                    Text(
                        text = "${it.rank}. ${it.name} (${it.symbol})",
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.weight(8f)
                    )
                      Text(
                          text = if(it.isActive) "Active" else "Inactive",
                      color = if(it.isActive) Color.Green else Color.Red,
                          fontStyle = FontStyle.Italic,
                          textAlign = TextAlign.End,
                          modifier = Modifier
                              .align(CenterVertically)
                              .weight(8f)
                    )
                  }
                  Spacer(modifier = Modifier.height(15.dp))
                  Text(text = "Tags", style = MaterialTheme.typography.headlineSmall)
                  Spacer(modifier = Modifier.height(15.dp))
                  FlowRow(mainAxisSpacing = 10.dp,
                      crossAxisSpacing = 10.dp,
                  modifier = Modifier.fillMaxWidth()){
                    it.tags.forEach {
                        CoinTag(tag = it.toString())
                    }
                  }
                  Spacer(modifier = Modifier.height(15.dp))
                  Text(text = "Team", style = MaterialTheme.typography.headlineSmall)
                  Spacer(modifier = Modifier.height(15.dp))
              }
               items(it.team){
                   TeamListItem(team = it,
                   modeifier = Modifier
                       .fillMaxWidth()
                       .padding(10.dp))
                   Divider()
               }
           }
       }

        if(state.error.isNotBlank()){
            Text(
                text = state.error,
                color = Color.Red,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}