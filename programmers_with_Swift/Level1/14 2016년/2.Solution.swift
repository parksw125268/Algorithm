func solution(_ a:Int, _ b:Int) -> String {
    let month = [0,31,29,31,30,31,30,31,31,30,31,30,31]
    let yoil = ["THU","FRI","SAT","SUN","MON","TUE","WED"]//1월1일이 금요일이므로
    var sum = 0
    for i in 0...a-1{ sum += month[i] }
    sum += b
    return yoil[sum % 7]
}