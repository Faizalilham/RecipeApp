@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.macaronsdetail

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.text.*
import androidx.compose.material.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.skydoves.landscapist.*
import com.skydoves.landscapist.coil3.*

@Composable
fun BottomSheetMoreMenu() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                color = Color(0xFFFFFFFF),
            )
    ){
        Column(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(topStart = 32.dp,topEnd = 32.dp,))
                .fillMaxWidth()
                .weight(1f)
                .background(
                    color = Color(0xFFF5F6F8),
                    shape = RoundedCornerShape(topStart = 32.dp,topEnd = 32.dp,)
                )
                .verticalScroll(rememberScrollState())
        ){
            Row(
                modifier = Modifier
                    .padding(bottom = 16.dp,)
                    .clip(shape = RoundedCornerShape(topStart = 32.dp,topEnd = 32.dp,))
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFFFFFFFF),
                        shape = RoundedCornerShape(topStart = 32.dp,topEnd = 32.dp,)
                    )
                    .shadow(
                        elevation = 6.dp,
                        spotColor = Color(0x1A000000),
                    )
                    .padding(top = 36.dp,bottom = 12.dp,start = 24.dp,end = 24.dp,)
            ){
                Text("Lainnya",
                    color = Color(0xFF363636),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .weight(1f)
                )
                CoilImage(
                    imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/x6eWWWbBV1/i2cyi4s7_expires_30_days.png"},
                    imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                )
            }
            Column(
                modifier = Modifier
                    .padding(bottom = 103.dp,start = 13.dp,end = 13.dp,)
                    .fillMaxWidth()
            ){
                Column(
                    modifier = Modifier
                        .padding(bottom = 12.dp,)
                        .clip(shape = RoundedCornerShape(12.dp))
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(vertical = 12.dp,)
                ){
                    Text("Kontrol Area",
                        color = Color(0xFF363636),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(bottom = 14.dp,start = 12.dp,)
                    )
                    Row(
                        modifier = Modifier
                            .padding(bottom = 14.dp,start = 12.dp,end = 12.dp,)
                            .fillMaxWidth()
                    ){
                        Column(
                            modifier = Modifier
                                .padding(end = 12.dp,)
                                .weight(1f)
                        ){
                            Column(
                                modifier = Modifier
                                    .padding(bottom = 7.dp,start = 8.dp,end = 8.dp,)
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFF9C29E),
                                        shape = RoundedCornerShape(12.dp)
                                    )
                                    .clip(shape = RoundedCornerShape(12.dp))
                                    .fillMaxWidth()
                                    .background(
                                        brush = Brush.linearGradient(
                                            colors = listOf(Color(0xFFFFFFFF), Color(0xFFFEF0E7), ),
                                            start = Offset.Zero,
                                            end = Offset(0F,Float.POSITIVE_INFINITY),
                                        )
                                    )
                                    .padding(vertical = 12.dp,)
                            ){
                                CoilImage(
                                    imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/x6eWWWbBV1/zbi44ksp_expires_30_days.png"},
                                    imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                                    modifier = Modifier
                                        .padding(horizontal = 12.dp,)
                                        .height(35.dp)
                                        .fillMaxWidth()
                                )
                            }
                            Text("Timku",
                                color = Color(0xFF000000),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                            )
                        }
                        Column(
                            modifier = Modifier
                                .padding(end = 12.dp,)
                                .weight(1f)
                        ){
                            Column(
                                modifier = Modifier
                                    .padding(bottom = 7.dp,start = 8.dp,end = 8.dp,)
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFF9C29E),
                                        shape = RoundedCornerShape(12.dp)
                                    )
                                    .clip(shape = RoundedCornerShape(12.dp))
                                    .fillMaxWidth()
                                    .background(
                                        brush = Brush.linearGradient(
                                            colors = listOf(Color(0xFFFFFFFF), Color(0xFFFEF0E7), ),
                                            start = Offset.Zero,
                                            end = Offset(0F,Float.POSITIVE_INFINITY),
                                        )
                                    )
                                    .padding(vertical = 12.dp,)
                            ){
                                CoilImage(
                                    imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/x6eWWWbBV1/grgnsizm_expires_30_days.png"},
                                    imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                                    modifier = Modifier
                                        .padding(horizontal = 12.dp,)
                                        .height(36.dp)
                                        .fillMaxWidth()
                                )
                            }
                            Text("CFTalk",
                                color = Color(0xFF000000),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                            )
                        }
                        Column(
                            modifier = Modifier
                                .padding(end = 12.dp,)
                                .weight(1f)
                        ){
                            Column(
                                modifier = Modifier
                                    .padding(bottom = 7.dp,start = 8.dp,end = 8.dp,)
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFF9C29E),
                                        shape = RoundedCornerShape(12.dp)
                                    )
                                    .clip(shape = RoundedCornerShape(12.dp))
                                    .fillMaxWidth()
                                    .background(
                                        brush = Brush.linearGradient(
                                            colors = listOf(Color(0xFFFFFFFF), Color(0xFFFEF0E7), ),
                                            start = Offset.Zero,
                                            end = Offset(0F,Float.POSITIVE_INFINITY),
                                        )
                                    )
                                    .padding(vertical = 12.dp,)
                            ){
                                CoilImage(
                                    imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/x6eWWWbBV1/jjie4bp9_expires_30_days.png"},
                                    imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                                    modifier = Modifier
                                        .padding(horizontal = 12.dp,)
                                        .height(36.dp)
                                        .fillMaxWidth()
                                )
                            }
                            Text("BAK Mesin",
                                color = Color(0xFF000000),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                        Column(
                            modifier = Modifier
                                .weight(1f)
                        ){
                            Column(
                                modifier = Modifier
                                    .padding(bottom = 7.dp,start = 8.dp,end = 8.dp,)
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFF9C29E),
                                        shape = RoundedCornerShape(12.dp)
                                    )
                                    .clip(shape = RoundedCornerShape(12.dp))
                                    .fillMaxWidth()
                                    .background(
                                        brush = Brush.linearGradient(
                                            colors = listOf(Color(0xFFFFFFFF), Color(0xFFFEF0E7), ),
                                            start = Offset.Zero,
                                            end = Offset(0F,Float.POSITIVE_INFINITY),
                                        )
                                    )
                                    .padding(vertical = 12.dp,)
                            ){
                                CoilImage(
                                    imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/x6eWWWbBV1/vqir0nd0_expires_30_days.png"},
                                    imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                                    modifier = Modifier
                                        .padding(horizontal = 12.dp,)
                                        .height(36.dp)
                                        .fillMaxWidth()
                                )
                            }
                            Text("Manpower Request",
                                color = Color(0xFF000000),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 12.dp,)
                            .fillMaxWidth()
                    ){
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(end = 20.dp,)
                        ){
                            OutlinedButton(
                                onClick = { println("Pressed!") },
                                border = BorderStroke(0.dp, Color.Transparent),
                                colors = ButtonDefaults.outlinedButtonColors(),
                                contentPadding = PaddingValues(),
                                modifier = Modifier
                                    .padding(bottom = 7.dp,)
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFF9C29E),
                                        shape = RoundedCornerShape(12.dp)
                                    )
                                    .clip(shape = RoundedCornerShape(12.dp))
                                    .background(
                                        brush = Brush.linearGradient(
                                            colors = listOf(Color(0xFFFFFFFF), Color(0xFFFEF0E7), ),
                                            start = Offset.Zero,
                                            end = Offset(0F,Float.POSITIVE_INFINITY),
                                        )
                                    )
                            ){
                                Column(
                                    modifier = Modifier
                                        .padding(12.dp)
                                ){
                                    CoilImage(
                                        imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/x6eWWWbBV1/4qhyfoub_expires_30_days.png"},
                                        imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                                        modifier = Modifier
                                            .width(36.dp)
                                            .height(36.dp)
                                    )
                                }
                            }
                            Text("Kunjungan Manajemen",
                                color = Color(0xFF000000),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .width(71.dp)
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(end = 20.dp,)
                                .padding(bottom = 17.dp,)
                        ){
                            OutlinedButton(
                                onClick = { println("Pressed!") },
                                border = BorderStroke(0.dp, Color.Transparent),
                                colors = ButtonDefaults.outlinedButtonColors(),
                                contentPadding = PaddingValues(),
                                modifier = Modifier
                                    .padding(bottom = 7.dp,)
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFF9C29E),
                                        shape = RoundedCornerShape(12.dp)
                                    )
                                    .clip(shape = RoundedCornerShape(12.dp))
                                    .background(
                                        brush = Brush.linearGradient(
                                            colors = listOf(Color(0xFFFFFFFF), Color(0xFFFEF0E7), ),
                                            start = Offset.Zero,
                                            end = Offset(0F,Float.POSITIVE_INFINITY),
                                        )
                                    )
                            ){
                                Column(
                                    modifier = Modifier
                                        .padding(12.dp)
                                ){
                                    CoilImage(
                                        imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/x6eWWWbBV1/4r8dxsfo_expires_30_days.png"},
                                        imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                                        modifier = Modifier
                                            .width(36.dp)
                                            .height(36.dp)
                                    )
                                }
                            }
                            Text("Ceklis Toilet",
                                color = Color(0xFF000000),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(bottom = 17.dp,)
                        ){
                            OutlinedButton(
                                onClick = { println("Pressed!") },
                                border = BorderStroke(0.dp, Color.Transparent),
                                colors = ButtonDefaults.outlinedButtonColors(),
                                contentPadding = PaddingValues(),
                                modifier = Modifier
                                    .padding(bottom = 7.dp,)
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFF9C29E),
                                        shape = RoundedCornerShape(12.dp)
                                    )
                                    .clip(shape = RoundedCornerShape(12.dp))
                                    .background(
                                        brush = Brush.linearGradient(
                                            colors = listOf(Color(0xFFFFFFFF), Color(0xFFFEF0E7), ),
                                            start = Offset.Zero,
                                            end = Offset(0F,Float.POSITIVE_INFINITY),
                                        )
                                    )
                            ){
                                Column(
                                    modifier = Modifier
                                        .padding(vertical = 12.dp,horizontal = 11.dp,)
                                ){
                                    CoilImage(
                                        imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/x6eWWWbBV1/77ie580p_expires_30_days.png"},
                                        imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                                        modifier = Modifier
                                            .width(36.dp)
                                            .height(36.dp)
                                    )
                                }
                            }
                            Text("Scan",
                                color = Color(0xFF000000),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(12.dp))
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(vertical = 12.dp,)
                ){
                    Text("Approval",
                        color = Color(0xFF363636),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(bottom = 14.dp,start = 12.dp,)
                    )
                    Row(
                        modifier = Modifier
                            .padding(start = 12.dp,)
                    ){
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(end = 20.dp,)
                        ){
                            OutlinedButton(
                                onClick = { println("Pressed!") },
                                border = BorderStroke(0.dp, Color.Transparent),
                                colors = ButtonDefaults.outlinedButtonColors(),
                                contentPadding = PaddingValues(),
                                modifier = Modifier
                                    .padding(bottom = 7.dp,)
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFF9C29E),
                                        shape = RoundedCornerShape(12.dp)
                                    )
                                    .clip(shape = RoundedCornerShape(12.dp))
                                    .background(
                                        brush = Brush.linearGradient(
                                            colors = listOf(Color(0xFFFFFFFF), Color(0xFFFEF0E7), ),
                                            start = Offset.Zero,
                                            end = Offset(0F,Float.POSITIVE_INFINITY),
                                        )
                                    )
                            ){
                                Column(
                                    modifier = Modifier
                                        .padding(12.dp)
                                ){
                                    CoilImage(
                                        imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/x6eWWWbBV1/hyfp5zaf_expires_30_days.png"},
                                        imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                                        modifier = Modifier
                                            .width(36.dp)
                                            .height(36.dp)
                                    )
                                }
                            }
                            Text("Absensi",
                                color = Color(0xFF000000),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                        Column(
                        ){
                            OutlinedButton(
                                onClick = { println("Pressed!") },
                                border = BorderStroke(0.dp, Color.Transparent),
                                colors = ButtonDefaults.outlinedButtonColors(),
                                contentPadding = PaddingValues(),
                                modifier = Modifier
                                    .padding(bottom = 7.dp,start = 8.dp,end = 8.dp,)
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFDEDEDE),
                                        shape = RoundedCornerShape(12.dp)
                                    )
                                    .clip(shape = RoundedCornerShape(12.dp))
                                    .background(
                                        color = Color(0xFFDEDEDE),
                                        shape = RoundedCornerShape(12.dp)
                                    )
                            ){
                                Column(
                                    modifier = Modifier
                                        .padding(12.dp)
                                ){
                                    CoilImage(
                                        imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/x6eWWWbBV1/nmctbmym_expires_30_days.png"},
                                        imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                                        modifier = Modifier
                                            .width(36.dp)
                                            .height(36.dp)
                                    )
                                }
                            }
                            Text("Pengajuan Resign",
                                color = Color(0xFF000000),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .width(63.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MacaronsDetailScreenPreview() {
    BottomSheetMoreMenu()
}