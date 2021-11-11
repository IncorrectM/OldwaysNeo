package tech.zzhdev.oldwaysneo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import tech.zzhdev.oldwaysneo.ui.navigation.RootScreenNavGraph
import tech.zzhdev.oldwaysneo.ui.page.*
import tech.zzhdev.oldwaysneo.ui.screen.ArticleScreen
import tech.zzhdev.oldwaysneo.ui.theme.OldWaysNeoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OldWaysNeoTheme {
                RootScreenNavGraph(rootScreenNavController = rememberNavController())
            }
        }
    }
}