import Foundation

let n = readLine()!.components(separatedBy: [" "]).map { Int($0)! }
let (a, b) = (n[0], n[1])

for i in 0...b-1{
    var s = ""
    for j in 0...a-1{
        s = s+"*" 
    }
    print(s)
}