import Foundation

func solution(_ n:Int) -> Int {
    var n = n
    var sum = 0.0
    var arr : [Int] = []
    while n >= 3{
        arr.append(n % 3)
        n /= 3
    }
    arr.append(n)
    arr.reverse()
    for i in 0...arr.count-1 {
        let temp = Double(i)
        sum += Double(arr[i]) * pow(3.0,temp)
    }

    return Int(sum)
}