import Foundation

func solution(_ d:[Int], _ budget:Int) -> Int {
    var newD = d; var newBud = budget; var count = 0
    newD.sort()
    for i in 0...newD.count-1{
        if newBud < newD[i]{ break }
        newBud -= newD[i]
        count += 1
    }
    return count
}