function f(a, b) {
    if (b === 0) return a;
    const sum = a ^ b;
    const carry = (a & b) << 1;
    return f(sum, carry);
}

console.log(f(5, 4));
