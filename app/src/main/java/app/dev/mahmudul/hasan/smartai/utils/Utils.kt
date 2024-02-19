package app.dev.mahmudul.hasan.smartai.utils

import com.google.firebase.firestore.DocumentReference
import kotlinx.coroutines.tasks.await

object Utils {
    var userRole = listOf("TeachersList", "StudentList")
    val departmentList = listOf(
        "Computer Science",
        "Electrical",
        "Civil",
        "Mechanical",
        "Architecture",
        "Power",
        "Electronics",
        "RAC",
        "Automobile",
        "Marine",
        "Shipbuilding",
        "Textile",
        "Chemical",
        "Food",
        "Glass",
        "Ceramic",
        "Mining",
    )
    val shiftList = listOf("1st Shift", "2nd Shift")
    val groupList = listOf("Group of A", "Group of B")
    val sessionList = listOf(
        "2019-2020",
        "2020-2021",
        "2021-2022",
        "2022-2023",
        "2023-2024",
        "2024-2025",
        "2025-2026",
        "2026-2027",
        "2027-2028",
        "2028-2029",
        "2029-2030",
        "2030-2031",
        "2031-2032",
        "2032-2033",
        "2033-2034",
        "2034-2035",
        "2035-2036",
        "2036-2037",
        "2037-2038",
        "2038-2039",
        "2039-2040",
        "2040-2041",
        "2041-2042",
        "2042-2043",
        "2043-2044",
        "2044-2045",
        "2045-2046",
        "2046-2047",
        "2047-2048",
        "2048-2049",
        "2049-2050",
        "2050-2051",
        "2051-2052",
        "2052-2053",
        "2053-2054",
        "2054-2055",
        "2055-2056",
        "2056-2057",
        "2057-2058",
        "2058-2059",
        "2059-2060",
        "2060-2061",
        "2061-2062",
        "2062-2063",
        "2063-2064",
        "2064-2065",
        "2065-2066",
        "2066-2067",
        "2067-2068",
        "2068-2069",
        "2069-2070",
        "2070-2071",
        "2071-2072",
        "2072-2073",
        "2073-2074",
        "2074-2075",
        "2075-2076",
        "2076-2077",
        "2077-2078",
        "2078-2079",
        "2079-2080",
        "2080-2081",
        "2081-2082",
        "2082-2083",
        "2083-2084",
        "2084-2085",
        "2085-2086",
        "2086-2087",
        "2087-2088",
        "2088-2089",
        "2089-2090",
    )
    val semesterList = listOf(
        "1st Semester",
        "2nd Semester",
        "3rd Semester",
        "4th Semester",
        "5th Semester",
        "6th Semester",
        "7th Semester",
        "8th Semester",
    )
    suspend fun getFirebaseSingleField(
        documentRef: DocumentReference,
        fieldName: String
    ): String? {
        var result = ""
        try {
            val documentSnapshot = documentRef.get().await()
            result = documentSnapshot.data?.get(fieldName).toString()

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return result
    }
    suspend fun updateFirebaseSingleField(documentRef: DocumentReference, field: String, newValue: String) {
        try {
            documentRef.update(field, newValue).await()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}