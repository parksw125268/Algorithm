import Foundation

func solution(_ sizes:[[Int]]) -> Int {
    var newSizes = sizes
    var width = 0 ; var height = 0
    for i in 0...sizes.count-1{
        newSizes[i].sort()
        height = max(newSizes[i][0],height)
        width = max(newSizes[i][1],width)
    }
    return height*width
}