func solution(_ arr:[Int]) -> Double {
    var answer : Double = 0
    for i in 0...arr.count-1{
        answer = answer + Double(arr[i])
    }
    return answer/Double(arr.count)
}