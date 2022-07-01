import Foundation

func solution(_ answers:[Int]) -> [Int] {
    let arr1 = [1, 2, 3, 4, 5]
    let arr2 = [2, 1, 2, 3, 2, 4, 2, 5]
    let arr3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    var ansArr : [Int] = []
    var sum1 = 0; var  sum2 = 0; var  sum3 = 0;
    for i in 0...answers.count-1 {
        if arr1[i % 5]  == answers[i] { sum1 += 1 }
        if arr2[i % 8]  == answers[i] { sum2 += 1 }
        if arr3[i % 10] == answers[i] { sum3 += 1 }
    }

    if sum1 > sum2 {
        if sum1 > sum3       { ansArr.append(1) }
        else if sum1 == sum3 { ansArr.append(1); ansArr.append(3) }
        else                 { ansArr.append(3) }
    }else if sum1 == sum2 {
        if sum1 > sum3       { ansArr.append(1); ansArr.append(2) }
        else if sum1 == sum3 { ansArr.append(1); ansArr.append(2); ansArr.append(3) }
        else                 { ansArr.append(3) }
    }else {
        if sum2 > sum3       { ansArr.append(2) }
        else if sum2 == sum3 { ansArr.append(2); ansArr.append(3) }
        else                 { ansArr.append(3) }
    }
    return ansArr
}