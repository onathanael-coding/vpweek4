package com.oliver.vp_week_4

import android.R.attr.fontWeight
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oliver.vp_week_4.ui.theme.VPWeek4Theme
val BgColor = Color(0xFFF7F5F0)
val OrangePrimary = Color(0xFFFF5733)
val OrangeLightBg = Color(0xFFFFEBE6)
val TextDark = Color(0xFF1A1A1A)
val TextMuted = Color(0xFF8E8E93)
val CardColor = Color.White

data class CarItem(
    val id: Int,
    val name: String,
    val imageRes: Int,
    val fuelType: String,
    val transmission: String,
    val year: String,
    val mileage: String,
    val price: String,
    val location: String,
    val seller: String,
    val description: String,
    var isSaved: Boolean = false
)

enum class CarTab {
    ON_SALE, SAVED
}

@Composable
fun Soal1View() {
    val cars = remember {
        mutableStateListOf(
            CarItem(
                id = 1,
                name = "Tiggo 9 CSH",
                imageRes = R.drawable.tiggo,
                fuelType = "PHEV",
                transmission = "Auto",
                year = "2024",
                mileage = "5,000 km",
                price = "Rp 550.000.000",
                location = "Jakarta",
                seller = "CHERY DIRECT",
                description = "Chery Tiggo 9 CSH is a premium plug-in hybrid SUV featuring advanced driver assistance, luxury leather interior, and exceptional fuel efficiency for modern family travels.",
                isSaved = true
            ),
            CarItem(
                id = 2,
                name = "Honda CRV",
                imageRes = R.drawable.crv,
                fuelType = "PETROL",
                transmission = "Auto",
                year = "2013",
                mileage = "15,200 km",
                price = "Rp 185.000.000",
                location = "Bandung",
                seller = "HONDA APPROVED",
                description = "Reliable and spacious SUV with a comfortable ride, reliable 2.0L i-VTEC engine, full service history, and spacious legroom ideal for daily family commuting.",
                isSaved = false
            ),
            CarItem(
                id = 3,
                name = "Toyota Yaris Cross",
                imageRes = R.drawable.yariscross,
                fuelType = "HYBRID",
                transmission = "Auto",
                year = "2024",
                mileage = "30,500 km",
                price = "Rp 398.000.000",
                location = "Surabaya",
                seller = "7928 DAW",
                description = "Toyota's stylish crossover pairs a 1.5L hybrid system with a bold design that turns heads on any road. The Yaris Cross features Toyota Safety Sense; an 8\" touchscreen, wireless Apple CarPlay; and an efficient self-charging hybrid drivetrain perfect for urban commuters.",
                isSaved = true
            ),
            CarItem(
                id = 4,
                name = "Daihatsu Xenia",
                imageRes = R.drawable.xenia,
                fuelType = "PETROL",
                transmission = "Manual",
                year = "2022",
                mileage = "28,000 km",
                price = "Rp 195.000.000",
                location = "Yogyakarta",
                seller = "DAIHATSU CERTIFIED",
                description = "Modern 7-seater MPV with efficient 1.3L Dual VVT-i engine, flexible seating arrangement, modern touchscreen infotainment, and economical daily fuel consumption.",
                isSaved = false
            ),
            CarItem(
                id = 5,
                name = "Toyota Yaris",
                imageRes = R.drawable.yaris,
                fuelType = "PETROL",
                transmission = "Auto",
                year = "2021",
                mileage = "52,400 km",
                price = "Rp 245.000.000",
                location = "Semarang",
                seller = "CARSOME",
                description = "The Toyota Yaris G AT is a sporty compact hatchback that punches above its weight class. Equipped with a 1.5L dual VVT-i engine, 7 airbags, pre-collision system, and a floating head unit, it offers premium features at a very accessible price point.",
                isSaved = true
            ),
            CarItem(
                id = 6,
                name = "Honda HRV",
                imageRes = R.drawable.hrv,
                fuelType = "PETROL",
                transmission = "Auto",
                year = "2022",
                mileage = "18,900 km",
                price = "Rp 340.000.000",
                location = "Malang",
                seller = "HONDA CERTIFIED",
                description = "Sleek compact crossover with panoramic glass roof, Honda Sensing suite, leather seats, and responsive 1.5L DOHC i-VTEC engine.",
                isSaved = true
            ),
            CarItem(
                id = 7,
                name = "Daihatsu Ayla",
                imageRes = R.drawable.ayla,
                fuelType = "PETROL",
                transmission = "Manual",
                year = "2020",
                mileage = "45,000 km",
                price = "Rp 115.000.000",
                location = "Surakarta",
                seller = "AUTO SELECT",
                description = "Ultra-fuel-efficient compact city car, easy to maneuver in tight urban traffic with Bluetooth audio and low running costs.",
                isSaved = true
            ),
            CarItem(
                id = 8,
                name = "Jaecoo J5",
                imageRes = R.drawable.j5,
                fuelType = "ELECTRIC",
                transmission = "Auto",
                year = "2025",
                mileage = "1,200 km",
                price = "Rp 420.000.000",
                location = "Jakarta",
                seller = "JAECOO OFFICIAL",
                description = "Futuristic all-electric EV crossover with extended driving range, panoramic view monitor, fast charging capability, and minimalist tech interior.",
                isSaved = false
            ),
            CarItem(
                id = 9,
                name = "MG 4 EV",
                imageRes = R.drawable.mg4,
                fuelType = "ELECTRIC",
                transmission = "Auto",
                year = "2023",
                mileage = "9,800 km",
                price = "Rp 380.000.000",
                location = "Tangerang",
                seller = "MG MOTORS",
                description = "Rear-wheel drive electric hatchback offering dynamic handling, rapid 0-100 acceleration, 10.25-inch infotainment, and comprehensive EV safety features.",
                isSaved = false
            ),
            CarItem(
                id = 10,
                name = "Toyota Innova Reborn",
                imageRes = R.drawable.reborn,
                fuelType = "DIESEL",
                transmission = "Auto",
                year = "2021",
                mileage = "68,000 km",
                price = "Rp 375.000.000",
                location = "Bekasi",
                seller = "TOYOTA TRUST",
                description = "Powerful 2.4L 2GD-FTV Turbo Diesel engine MPV renowned for its legendary durability, captain seats, high resale value, and supreme highway comfort.",
                isSaved = false
            )
        )
    }

    var selectedTab by remember { mutableStateOf(CarTab.ON_SALE) }
    var selectedCarId by remember { mutableStateOf<Int?>(null) }

    val selectedCar = cars.find { it.id == selectedCarId }

    if (selectedCar != null) {
        BackHandler {
            selectedCarId = null
        }
        CarDetailScreen(
            car = selectedCar,
            onBackClick = { selectedCarId = null },
            onSaveToggle = { carToToggle ->
                val index = cars.indexOfFirst { it.id == carToToggle.id }
                if (index != -1) {
                    cars[index] = cars[index].copy(isSaved = !cars[index].isSaved)
                }
            }
        )
    } else {
        CarListScreen(
            cars = cars,
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it },
            onCarClick = { car -> selectedCarId = car.id },
            onSaveToggle = { carToToggle ->
                val index = cars.indexOfFirst { it.id == carToToggle.id }
                if (index != -1) {
                    cars[index] = cars[index].copy(isSaved = !cars[index].isSaved)
                }
            }
        )
    }
}

@Composable
fun CarListScreen(
    cars: List<CarItem>,
    selectedTab: CarTab,
    onTabSelected: (CarTab) -> Unit,
    onCarClick: (CarItem) -> Unit,
    onSaveToggle: (CarItem) -> Unit
) {
    val savedCount = cars.count { it.isSaved }

    val filteredCars = when (selectedTab) {
        CarTab.ON_SALE -> cars
        CarTab.SAVED -> cars.filter { it.isSaved }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BgColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Box(
                modifier = Modifier
                    .width(42.dp)
                    .height(4.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(OrangePrimary)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = if (selectedTab == CarTab.ON_SALE) "On Sale" else "Saved Cars",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = TextDark
                    )
                    Text(
                        text = "Find your perfect ride",
                        fontSize = 14.sp,
                        color = TextMuted
                    )
                }

                //Saved
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(if (selectedTab == CarTab.SAVED) OrangePrimary else OrangeLightBg)
                        .clickable {
                            onTabSelected(if (selectedTab == CarTab.ON_SALE) CarTab.SAVED else CarTab.ON_SALE)
                        }
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Saved",
                            tint = if (selectedTab == CarTab.SAVED) Color.White else OrangePrimary,
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = "$savedCount saved",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (selectedTab == CarTab.SAVED) Color.White else OrangePrimary
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Pilihan Mobil
            if (filteredCars.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No saved cars yet",
                        fontSize = 24.sp,
                        color = TextMuted
                    )
                }
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(14.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    items(
                        items = filteredCars,
                        key = { it.id }
                    ) { car ->
                        CarCard(
                            car = car,
                            onCarClick = { onCarClick(car) },
                            onSaveToggle = { onSaveToggle(car) }
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun CarCard(
    car: CarItem,
    onCarClick: () -> Unit,
    onSaveToggle: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(BgColor)
            .clickable { onCarClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Car Image Container
            Box(
                modifier = Modifier
                    .width(115.dp)
                    .height(90.dp)
                    .clip(RoundedCornerShape(12.dp))
            ) {
                Image(
                    painter = painterResource(id = car.imageRes),
                    contentDescription = car.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                // Fuel Type
                FuelBadge(
                    fuelType = car.fuelType,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(6.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(100.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
//                    Nama Mobil
                    Text(
                        text = car.name,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextDark,
                        maxLines = 1,
                        modifier = Modifier.weight(1f)
                    )

                    IconButton(
                        onClick = onSaveToggle,
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            imageVector = if (car.isSaved) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                            contentDescription = "Save Car",
                            tint = if (car.isSaved) OrangePrimary else Color(0xFFC7C7CC),
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color(0xFFF2F2F7))
                ) {
                    Text(
                        text = car.transmission,
                        fontSize = 12.sp,
                        color = Color(0xFF636366),
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Canvas(modifier = Modifier.size(6.dp)) {
                            drawCircle(color = OrangePrimary)
                        }
                        Text(
                            text = car.year,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextDark
                        )
                    }

                    Text(
                        text = car.mileage,
                        fontSize = 13.sp,
                        color = TextMuted
                    )
                }
            }
        }
    }
}

//Fuel Type Badge
@Composable
fun FuelBadge(fuelType: String, modifier: Modifier = Modifier) {
    val (bgColor, textColor) = when (fuelType.uppercase()) {
        "PHEV" -> Color(0xFFE9E5F5) to Color(0xFF5E4B8B)
        "HYBRID" -> Color(0xFFE0F2E9) to Color(0xFF1B7A4B)
        "ELECTRIC" -> Color(0xFFE3F2FD) to Color(0xFF1565C0)
        "DIESEL" -> Color(0xFFF5EBE6) to Color(0xFF8D4B28)
        else -> Color(0xFFFFF1D6) to Color(0xFFB86E00) // PETROL
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(bgColor)
    ) {
        Text(
            text = fuelType,
            color = textColor,
            fontSize = 10.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
        )
    }
}

//Page detail mobil
@Composable
fun CarDetailScreen(
    car: CarItem,
    onBackClick: () -> Unit,
    onSaveToggle: (CarItem) -> Unit
) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BgColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(bottom = 90.dp)
        ) {
            // Top Car Image Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
            ) {
                Image(
                    painter = painterResource(id = car.imageRes),
                    contentDescription = car.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                // Button Back
                Box(
                    modifier = Modifier
                        .padding(30.dp)
                        .size(38.dp)
                        .align(Alignment.TopStart)
                        .clip(CircleShape)
                        .background(Color.White)
                        .clickable { onBackClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = TextDark,
                        modifier = Modifier.size(20.dp)
                    )
                }

                FuelBadge(
                    fuelType = car.fuelType,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = car.name,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextDark
                    )

                    IconButton(
                        onClick = { onSaveToggle(car) },
                        modifier = Modifier.size(32.dp)
                    ) {
                        Icon(
                            imageVector = if (car.isSaved) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                            contentDescription = "Save Car",
                            tint = if (car.isSaved) OrangePrimary else Color(0xFFC7C7CC),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Canvas(modifier = Modifier.size(6.dp)) {
                        drawCircle(color = OrangePrimary)
                    }
                    Text(
                        text = car.location,
                        fontSize = 16.sp,
                        color = TextMuted
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(OrangeLightBg)
                ) {
                    Text(
                        text = car.price,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = OrangePrimary,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "SPECIFICATIONS",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFA2A2A8),
                    letterSpacing = 0.5.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        SpecCard(
                            label = "YEAR",
                            value = car.year,
                            modifier = Modifier.weight(1f)
                        )
                        SpecCard(
                            label = "MILEAGE",
                            value = car.mileage,
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        SpecCard(
                            label = "TRANSMISSION",
                            value = car.transmission,
                            modifier = Modifier.weight(1f)
                        )
                        SpecCard(
                            label = "FUEL TYPE",
                            value = car.fuelType.uppercase(),
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // ABOUT THIS CAR Section
                Text(
                    text = "ABOUT THIS CAR",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFA2A2A8),
                    letterSpacing = 0.5.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = car.description,
                    fontSize = 14.sp,
                    color = TextMuted,
                    lineHeight = 22.sp
                )
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(BgColor)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                //Button Save Bawah
                Box(
                    modifier = Modifier
                        .size(52.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(OrangeLightBg)
                        .clickable { onSaveToggle(car) },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = if (car.isSaved) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = if (car.isSaved) OrangePrimary else Color(0xFFC7C7CC),
                        modifier = Modifier.size(24.dp)
                    )
                }

                // Action Button
                Button(
                    onClick = {
                        Toast.makeText(
                            context,
                            "Contacting seller for ${car.name}",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(52.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = OrangePrimary)
                ) {
                    Text(
                        text = "Contact Seller",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun SpecCard(label: String, value: String, modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 14.dp)
        ) {
            Text(
                text = label,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFA2A2A8)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = TextDark
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Soal1Preview() {
    VPWeek4Theme {
        Soal1View()
    }
}
