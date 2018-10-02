fun main(args : Array<String>) {
	println(isHot(10))
	val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )
	println(filterCurry(spices))
	println(filterCurryLength(spices))
	println(filterCurry(spices))
}
fun isHot(temp : Int) = temp > 20

fun filterCurry(currys : List<String>) : List<String> {
	return currys.filter{ it[0] == 'c'}
}
fun filterCurryLength(currys : List<String>) : List<String> {
	return currys.filter{it.length < 6}
}
