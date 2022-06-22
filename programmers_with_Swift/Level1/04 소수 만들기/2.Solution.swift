import Foundation
var count = 0; var sum = 0; var answer = 0
var glovalNums : [Int] = [] 
func solution(_ nums:[Int]) -> Int {
    glovalNums = nums
    count = nums.count   
    work(0,0)
    return answer
}
func work(_ idx:Int, _ startIdx :Int){
    if idx == 3{
        isSosu(sum)
        return
    }
    if startIdx == count{return}
    for i in startIdx...count-1{
        sum += glovalNums[i]
        work(idx+1,i+1)
        sum -= glovalNums[i]
    }
}
func isSosu(_ sosu : Int){
    if sosu <= 2 {return}
    for i in 2...sosu-1{
        if sosu % i == 0 {return}
    }
    answer+=1
}