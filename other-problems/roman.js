const romanToNumMap = new Map([
    ['I', 1],
    ['V', 5],
    ['X', 10],
    ['L', 50],
    ['C', 100]
]);

function romanToNum(roman) {
    let current = 0;
    let prev = 0;
    let result = 0;

    for (let i = roman.length - 1; i >= 0; i--) {
        current = romanToNumMap.get(roman[i]);
        if (current >= prev)
            result += current;
        else
            result -= current;
        prev = current;
    }
    return result;
}

console.log(romanToNum('LXIX')); // 69