exports.adding = function (a,b) {
   
    return a+b;
  };
  exports.factorial = function (a) {
    let fact = 1;
    for (let i = 1; i <= a; i++) {
        fact *= i;
    }
    return fact;
  };