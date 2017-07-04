val seq = List(1, 2, -3, 12, 2, -1)
val masterMap = Map()
var maxSumMap = Map()
val seqIndex = seq.zipWithIndex
for (
	el<-seqIndex;
  levelMapsList<- masterMap(el._2);
	levelMap <- levelMapsList
  levelMap += (el._2 -> el._1)
  masterMap += ((el._2 + 1) -> levelMap)
  if(maxSumMap.foldLeft(0)(_+_._2) < levelMap.foldLeft(0)(_+_._2))){
    maxSumMap = levelMap
  }
println(maxSumMap)
//Finding maximum sublist
//
//Create map of list of maps which will have keys set to indicate level of the maps
//eg. First element on the list will create maps on the level 0, second element on the list
//Will create maps on the level 1 and so on.
//Each map on the level represents subarray combination on this level,
//eg. on level 3 there are 3 subarrays: (1,2,-3),(2,-3), (-3)
//Foreach element on the list create new map with key indicating ‘level’
//On each level I can clear maps from 2 levels below.
//And need to store map with currently highest sum of elements
