package be.vives.pokechamp.model

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)