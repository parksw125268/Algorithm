import Foundation
var sum = 0
var ansArr : [Int] = []
func solution(_ numbers:[Int]) -> [Int] {
    dfs(0,0,numbers)
    ansArr.sort()
    return ansArr
}
func dfs(_ idx:Int, _ startIdx:Int, _ numbers:[Int] ){
    if idx == 2 {
        if !ansArr.contains(sum) {
            ansArr.append(sum)
        }
        return
    }
    if startIdx == numbers.count {return}
    for i in startIdx...numbers.count-1{
        sum += numbers[i]
        dfs(idx+1,i+1,numbers)
        sum -= numbers[i]
    }
}