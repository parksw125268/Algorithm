import Foundation

func solution(_ numbers:[Int]) -> Int {
    var Sum = 45
    for i in 0...numbers.count-1{
        Sum -= numbers[i]   
    }
    return Sum
}