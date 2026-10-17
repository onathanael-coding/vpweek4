package com.oliver.vp_week_4.Soal2

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oliver.vp_week_4.R
import com.oliver.vp_week_4.ui.theme.VPWeek4Theme

val BgDark = Color(0xFF0C0E17)
val CardBg = Color(0xFF161826)
val CardBorder = Color(0xFF282B3E)
val GoldPrimary = Color(0xFFFFB800)
val GoldDarkBg = Color(0xFF332B12)
val HpRed = Color(0xFFFF4D4D)
val HpBarBg = Color(0xFF381B1B)
val MpBlue = Color(0xFF0091FF)
val MpBarBg = Color(0xFF13283D)
val GreenAccent = Color(0xFF00D68F)
val MythicPink = Color(0xFFFF2D55)
val MythicBg = Color(0xFF381525)
val ClassGreen = Color(0xFF00D68F)
val ClassBg = Color(0xFF103028)
val TextWhite = Color(0xFFFFFFFF)
val TextMuted = Color(0xFF8E8E93)

data class Hero(
    val id: Int,
    val name: String,
    val titleClass: String,
    val rarity: String = "MYTHIC",
    val level: Int,
    val imageRes: Int,
    var currentHp: Int,
    val maxHp: Int,
    var currentMp: Int,
    val maxMp: Int,
    val cp: Int,
    val atk: Int,
    val def: Int,
    val crit: String,
    val spd: Int,
    val skillName: String,
    val skillDesc: String,
    val roleCategory: String,
    var inSquad: Boolean = false,
    var isExpanded: Boolean = false
)

@Composable
fun Soal2View() {
    val context = LocalContext.current

    val heroes = remember {
        mutableStateListOf(
            Hero(
                id = 1,
                name = "Alistair",
                titleClass = "High Templar",
                rarity = "MYTHIC",
                level = 50,
                imageRes = R.drawable.paladin,
                currentHp = 1650,
                maxHp = 1800,
                currentMp = 650,
                maxMp = 800,
                cp = 5600,
                atk = 380,
                def = 540,
                crit = "22%",
                spd = 105,
                skillName = "Wrath of the Heavens",
                skillDesc = "Calls down a celestial hammer, stunning all enemies for 3 seconds and taunting survivors.",
                roleCategory = "Paladin",
                inSquad = true,
                isExpanded = true
            ),
            Hero(
                id = 2,
                name = "Theresa",
                titleClass = "Divine Oracle",
                rarity = "MYTHIC",
                level = 49,
                imageRes = R.drawable.cleric,
                currentHp = 1100,
                maxHp = 1200,
                currentMp = 2100,
                maxMp = 2400,
                cp = 5480,
                atk = 120,
                def = 310,
                crit = "15%",
                spd = 95,
                skillName = "Divine Grace",
                skillDesc = "Restores massive HP to all party members and grants sanctuary shield for 5s.",
                roleCategory = "Cleric",
                inSquad = true,
                isExpanded = false
            ),
            Hero(
                id = 3,
                name = "Vespera",
                titleClass = "Shadowblade",
                rarity = "MYTHIC",
                level = 48,
                imageRes = R.drawable.rogue,
                currentHp = 890,
                maxHp = 950,
                currentMp = 410,
                maxMp = 600,
                cp = 5350,
                atk = 620,
                def = 210,
                crit = "45%",
                spd = 140,
                skillName = "Shadow Dance",
                skillDesc = "Teleports behind the highest CP enemy, dealing 350% critical physical strike.",
                roleCategory = "Rogue",
                inSquad = true,
                isExpanded = false
            ),
            Hero(
                id = 4,
                name = "Elaria",
                titleClass = "Archmage",
                rarity = "MYTHIC",
                level = 47,
                imageRes = R.drawable.archmage,
                currentHp = 450,
                maxHp = 600,
                currentMp = 1950,
                maxMp = 2000,
                cp = 5120,
                atk = 750,
                def = 180,
                crit = "35%",
                spd = 110,
                skillName = "Arcane Meteor",
                skillDesc = "Summons a meteor shower dealing massive area-of-effect elemental burst damage.",
                roleCategory = "Archmage",
                inSquad = true,
                isExpanded = false
            ),
            Hero(
                id = 5,
                name = "Kaelen",
                titleClass = "Berserker",
                rarity = "MYTHIC",
                level = 46,
                imageRes = R.drawable.berserker,
                currentHp = 1920,
                maxHp = 2100,
                currentMp = 300,
                maxMp = 400,
                cp = 4980,
                atk = 580,
                def = 420,
                crit = "30%",
                spd = 115,
                skillName = "Blood Frenzy",
                skillDesc = "Increases attack speed and damage by 50% as HP drops lower in combat.",
                roleCategory = "Berserker",
                inSquad = false,
                isExpanded = false
            ),
            Hero(
                id = 6,
                name = "Gideon",
                titleClass = "Grand Crusader",
                rarity = "MYTHIC",
                level = 45,
                imageRes = R.drawable.paladin,
                currentHp = 1700,
                maxHp = 1900,
                currentMp = 500,
                maxMp = 700,
                cp = 4850,
                atk = 340,
                def = 580,
                crit = "18%",
                spd = 98,
                skillName = "Holy Barrier",
                skillDesc = "Erects an impenetrable shield absorbing 80% incoming damage for the party.",
                roleCategory = "Paladin",
                inSquad = false,
                isExpanded = false
            ),
            Hero(
                id = 7,
                name = "Lyra",
                titleClass = "High Priestess",
                rarity = "MYTHIC",
                level = 45,
                imageRes = R.drawable.cleric,
                currentHp = 1050,
                maxHp = 1150,
                currentMp = 1800,
                maxMp = 2100,
                cp = 4790,
                atk = 140,
                def = 290,
                crit = "12%",
                spd = 92,
                skillName = "Resurrection Light",
                skillDesc = "Revives a fallen ally with 50% HP and restores full MP.",
                roleCategory = "Cleric",
                inSquad = false,
                isExpanded = false
            ),
            Hero(
                id = 8,
                name = "Zephyr",
                titleClass = "Nightstalker",
                rarity = "MYTHIC",
                level = 44,
                imageRes = R.drawable.rogue,
                currentHp = 820,
                maxHp = 2000,
                currentMp = 380,
                maxMp = 550,
                cp = 4680,
                atk = 590,
                def = 190,
                crit = "50%",
                spd = 145,
                skillName = "Venomous Strike",
                skillDesc = "Poisons target for 5 seconds dealing severe damage over time.",
                roleCategory = "Rogue",
                inSquad = false,
                isExpanded = false
            ),
            Hero(
                id = 9,
                name = "Ignis",
                titleClass = "Pyromancer",
                rarity = "MYTHIC",
                level = 44,
                imageRes = R.drawable.archmage,
                currentHp = 500,
                maxHp = 650,
                currentMp = 1800,
                maxMp = 1950,
                cp = 4620,
                atk = 720,
                def = 160,
                crit = "38%",
                spd = 108,
                skillName = "Inferno Nova",
                skillDesc = "Unleashes a ring of fire burning surrounding enemies continuously.",
                roleCategory = "Archmage",
                inSquad = false,
                isExpanded = false
            ),
            Hero(
                id = 10,
                name = "Ragnar",
                titleClass = "Blood Berserker",
                rarity = "MYTHIC",
                level = 43,
                imageRes = R.drawable.berserker,
                currentHp = 2000,
                maxHp = 2200,
                currentMp = 250,
                maxMp = 350,
                cp = 4550,
                atk = 610,
                def = 390,
                crit = "28%",
                spd = 112,
                skillName = "Whirlwind Slash",
                skillDesc = "Spins with massive double axes cleaving all nearby front-line foes.",
                roleCategory = "Berserker",
                inSquad = false,
                isExpanded = false
            )
        )
    }

    var selectedFilterCategory by remember { mutableStateOf("All") }
    var searchQuery by remember { mutableStateOf("") }

    val categories = listOf("All (14)",
        "Berserker (2)",
        "Archmage (3)",
        "Paladin (2)",
        "Rogue (3)",
        "Cleric (4)")

    val squadHeroes = heroes.filter { it.inSquad }
    val totalSquadCp = squadHeroes.sumOf { it.cp }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BgDark)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            // Header Title Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Party Roster",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextWhite
                    )
                    Text(
                        text = "Guild Vanguard • ${heroes.size} Heroes Available",
                        fontSize = 12.sp,
                        color = TextMuted
                    )
                }

                // Expedition Badge Button
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .border(1.dp, GoldPrimary, CircleShape)
                        .background(GoldDarkBg)
                        .clickable {
                            Toast.makeText(context, "Expedition Mode Active", Toast.LENGTH_SHORT).show()
                        }
                ) {
                    Text(
                        text = "★ Expedition",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = GoldPrimary,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Expedition Squad Box (Top Banner)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(CardBg)
                    .border(1.dp, CardBorder, RoundedCornerShape(16.dp))
                    .padding(14.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Canvas(modifier = Modifier.size(8.dp)) {
                                drawCircle(color = GreenAccent)
                            }
                            Text(
                                text = "EXPEDITION SQUAD (${squadHeroes.size}/4)",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = GreenAccent
                            )
                        }

                        Text(
                            text = "⚔ $totalSquadCp CP",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = GoldPrimary
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // 4 Squad Slots
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            for (i in 0 until 4) {
                                val hero = squadHeroes.getOrNull(i)
                                Box(
                                    modifier = Modifier
                                        .size(50.dp)
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(Color(0xFF10121D))
                                        .border(
                                            1.dp,
                                            if (hero != null) GoldPrimary else CardBorder,
                                            RoundedCornerShape(10.dp)
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    if (hero != null) {
                                        Image(
                                            painter = painterResource(id = hero.imageRes),
                                            contentDescription = hero.name,
                                            modifier = Modifier.size(40.dp)
                                        )
                                    } else {
                                        Icon(
                                            imageVector = Icons.Default.Add,
                                            contentDescription = "Add",
                                            tint = TextMuted,
                                            modifier = Modifier.size(20.dp)
                                        )
                                    }
                                }
                            }
                        }

                        // Deploy Button
                        Button(
                            onClick = {
                                Toast.makeText(context, "Deploying Squad into battle!", Toast.LENGTH_SHORT).show()
                            },
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = GoldPrimary),
                            modifier = Modifier.height(44.dp)
                        ) {
                            Text(
                                text = "Deploy ⚡",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = BgDark
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Search Bar Input
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = {
                    Text(
                        text = "Search by hero name, class, or rarity...",
                        fontSize = 12.sp,
                        color = TextMuted
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = TextMuted
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = CardBg,
                    unfocusedContainerColor = CardBg,
                    disabledContainerColor = CardBg,
                    focusedBorderColor = CardBorder,
                    unfocusedBorderColor = CardBorder,
                    focusedTextColor = TextWhite,
                    unfocusedTextColor = TextWhite
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Horizontal Filter Chips Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    items(categories) { cat ->
                        val isSelected = cat.startsWith(selectedFilterCategory.split(" ").first())
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(if (isSelected) GoldDarkBg else CardBg)
                                .border(1.dp, if (isSelected) GoldPrimary else CardBorder, CircleShape)
                                .clickable {
                                    selectedFilterCategory = cat.split(" ").first()
                                }
                                .padding(horizontal = 14.dp, vertical = 8.dp)
                        ) {
                            Text(
                                text = cat,
                                fontSize = 11.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                color = if (isSelected) GoldPrimary else TextMuted
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))

                // Sort Button
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(CardBg)
                        .border(1.dp, CardBorder, CircleShape)
                        .clickable {
                            Toast.makeText(context, "Sorted by Power", Toast.LENGTH_SHORT).show()
                        }
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = "Sort: Power",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = GoldPrimary
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Hero List (LazyColumn)
            if (heroes.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No heroes found",
                        fontSize = 14.sp,
                        color = TextMuted
                    )
                }
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    items(
                        items = heroes,
                        key = { it.id }
                    ) { hero ->
                        HeroCard(
                            hero = hero,
                            onCardClick = {
                                val index = heroes.indexOfFirst { h -> h.id == hero.id }
                                if (index != -1) {
                                    heroes[index] = heroes[index].copy(isExpanded = !heroes[index].isExpanded)
                                }
                            },
                            onHealClick = {
                                val index = heroes.indexOfFirst { h -> h.id == hero.id }
                                if (index != -1) {
                                    val newHp = (heroes[index].currentHp + 250).coerceAtMost(heroes[index].maxHp)
                                    heroes[index] = heroes[index].copy(currentHp = newHp)
                                    Toast.makeText(context, "${hero.name} healed +250 HP!", Toast.LENGTH_SHORT).show()
                                }
                            },
                            onSquadToggle = {
                                val index = heroes.indexOfFirst { h -> h.id == hero.id }
                                if (index != -1) {
                                    val currentInSquad = heroes[index].inSquad
                                    if (!currentInSquad && squadHeroes.size >= 4) {
                                        Toast.makeText(context, "Squad is full (Max 4)", Toast.LENGTH_SHORT).show()
                                    } else {
                                        heroes[index] = heroes[index].copy(inSquad = !currentInSquad)
                                    }
                                }
                            }
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
fun HeroCard(
    hero: Hero,
    onCardClick: () -> Unit,
    onHealClick: () -> Unit,
    onSquadToggle: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(CardBg)
            .border(1.dp, CardBorder, RoundedCornerShape(16.dp))
            .clickable { onCardClick() }
            .padding(14.dp)
    ) {
        Column {
            // Top Badges Row: Mythic + Class + CP + IN SQUAD
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Rarity Badge
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(MythicBg)
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = hero.rarity,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = MythicPink
                        )
                    }

                    // Class Badge
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(ClassBg)
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = hero.titleClass,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            color = ClassGreen
                        )
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "⚔ ${hero.cp} CP",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = GoldPrimary
                    )

                    if (hero.inSquad) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .background(GoldPrimary)
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = "IN SQUAD",
                                fontSize = 8.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = BgDark
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Main Content Row: Sprite Avatar on Left, Info & Bars on Right
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Character Sprite Box
                Box(
                    modifier = Modifier
                        .size(68.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFF0F111A)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = hero.imageRes),
                        contentDescription = hero.name,
                        modifier = Modifier.size(54.dp)
                    )

                    // Level Badge at bottom
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .clip(RoundedCornerShape(topStart = 6.dp))
                            .background(Color(0xFF1F2233))
                            .padding(horizontal = 5.dp, vertical = 1.dp)
                    ) {
                        Text(
                            text = "Lvl ${hero.level}",
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextWhite
                        )
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))

                // Info & Bars Column
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    // Name + Expand Arrow
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = hero.name,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextWhite
                        )

                        Icon(
                            imageVector = if (hero.isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                            contentDescription = "Expand",
                            tint = TextMuted,
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    // HP Bar Row
                    BarRow(
                        label = "HP",
                        current = hero.currentHp,
                        max = hero.maxHp,
                        barColor = HpRed,
                        barBgColor = HpBarBg
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    // MP Bar Row
                    BarRow(
                        label = "MP",
                        current = hero.currentMp,
                        max = hero.maxMp,
                        barColor = MpBlue,
                        barBgColor = MpBarBg
                    )
                }
            }

            // Expanded Dropdown Section (Bonus Requirement)
            AnimatedVisibility(visible = hero.isExpanded) {
                Column {
                    Spacer(modifier = Modifier.height(14.dp))

                    // 4 Stat Cards Row (ATK, DEF, CRIT, SPD)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        StatCard(label = "ATK", value = "${hero.atk}", modifier = Modifier.weight(1f))
                        StatCard(label = "DEF", value = "${hero.def}", modifier = Modifier.weight(1f))
                        StatCard(label = "CRIT", value = hero.crit, modifier = Modifier.weight(1f))
                        StatCard(label = "SPD", value = "${hero.spd}", modifier = Modifier.weight(1f))
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Skill Box
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFF10121D))
                            .padding(10.dp)
                    ) {
                        Column {
                            Text(
                                text = "★ ${hero.skillName}",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = GoldPrimary
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = hero.skillDesc,
                                fontSize = 11.sp,
                                color = TextMuted,
                                lineHeight = 16.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Action Buttons Row (Heal + Squad Toggle)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Heal Button
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(38.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color(0xFF103028))
                                .border(1.dp, GreenAccent, RoundedCornerShape(8.dp))
                                .clickable { onHealClick() },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "🧪 Heal (+250 HP)",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = GreenAccent
                            )
                        }

                        // Add to Squad / Remove Button
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(38.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(GoldDarkBg)
                                .border(1.dp, GoldPrimary, RoundedCornerShape(8.dp))
                                .clickable { onSquadToggle() },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = if (hero.inSquad) "✕ Remove from Squad" else "⚔ Add to Squad",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = GoldPrimary
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BarRow(
    label: String,
    current: Int,
    max: Int,
    barColor: Color,
    barBgColor: Color
) {
    val progress = (current.toFloat() / max.toFloat()).coerceIn(0f, 1f)

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = TextMuted,
            modifier = Modifier.width(22.dp)
        )

        // Custom Bar Track using Box
        Box(
            modifier = Modifier
                .weight(1f)
                .height(8.dp)
                .clip(CircleShape)
                .background(barBgColor)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(progress)
                    .clip(CircleShape)
                    .background(barColor)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "$current / $max",
            fontSize = 10.sp,
            fontWeight = FontWeight.Medium,
            color = TextMuted
        )
    }
}

@Composable
fun StatCard(label: String, value: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF10121D))
            .padding(vertical = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = label,
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                color = TextMuted
            )
            Spacer(modifier = Modifier.height(1.dp))
            Text(
                text = value,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = TextWhite
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Soal2Preview() {
    VPWeek4Theme {
        Soal2View()
    }
}