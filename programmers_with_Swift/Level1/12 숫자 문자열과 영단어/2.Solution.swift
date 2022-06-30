import Foundation

func solution(_ s:String) -> Int {
    let arr = ["zero","one","two","three","four","five","six","seven","eight","nine"]
    var newS = s
    for i in 0...9{
        newS = newS.replacingOccurrences(of:arr[i] , with:String(i))
    }
    return Int(newS) ?? 0
}