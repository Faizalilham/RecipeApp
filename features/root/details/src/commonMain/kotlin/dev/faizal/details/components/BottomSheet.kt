package dev.faizal.details.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.coil3.CoilImage
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBottomSheet(
    modifier: Modifier = Modifier,
    topHeader: String,
    onDismiss: () -> Unit = {},
    content: @Composable (dismiss: () -> Unit) -> Unit,
) {
    val bottomSheetState =
        rememberModalBottomSheetState(skipPartiallyExpanded = true, confirmValueChange = { newState ->
            newState != SheetValue.Hidden // **** Prevents hiding of the sheet *****
        })
    ModalBottomSheet(
        sheetState = bottomSheetState,
        modifier = modifier.wrapContentSize(),
        containerColor = Color.Yellow,
        onDismissRequest = onDismiss,
        shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        dragHandle = {},
    ) {
        // Bottom Sheet Content *****
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(
                        horizontal = 16.dp,
                        vertical = 20.dp,
                    ),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(modifier = Modifier.weight(1f), text = topHeader, style = MaterialTheme.typography.bodyLarge, color = Color.Black)
            Icon(
                modifier =
                    Modifier
                        .wrapContentSize()
                        .minimumInteractiveComponentSize()
                        .clickable {
                            onDismiss()
                        },
                imageVector = Icons.Default.Close,
                contentDescription ="Close",
                tint = Color.Gray,
            )
        }
        content(onDismiss)
    }
}

@Composable
fun MyBottomSheetContent(
    modifier: Modifier = Modifier,
    title: String,
    desc: String,
    imageUrl: String = "",
    textBtnLabel: String = "",
    textBtnClick: () -> Unit = {},
    btnLabel: String = "",
    btnAction: () -> Unit = {},
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
    ) {
        item {
            if (imageUrl.isNotEmpty()) {

            }
        }
        item {
            Text(
                modifier =
                    Modifier.padding(
                        10.dp
                    ),
                text = title,
                style = MaterialTheme.typography.titleSmall,
                color = Color.Black,
            )
            Text(
                modifier =
                    Modifier.padding(
                        10.dp
                    ),
                text = desc,
                style = MaterialTheme.typography.titleSmall,
                color = Color.Black,
            )
            if (textBtnLabel.isNotEmpty()) {
                TextButton(
                    onClick = {
                        textBtnClick()
                    }
                ){
                    Text(text = "Text Button")
                }
            }
            if (btnLabel.isNotEmpty()) {
                Button(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    onClick = {
                        btnAction()
                    }
                ){
                    Text(text = btnLabel)
                }
            }
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}