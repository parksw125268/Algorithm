import Foundation

func solution(_ array:[Int], _ commands:[[Int]]) -> [Int] {
    var ansArr : [Int] = [] 
    for arr in commands{
        var newArr : [Int] = [] 
        for j in arr[0]...arr[1]{
            newArr.append(array[j-1])
        }
        newArr.sort()
        ansArr.append(newArr[arr[2]-1])
    }
    return ansArr
}