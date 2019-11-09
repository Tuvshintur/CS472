(function () {
    const calculateAverage = function (...input) {
        if (!input || input.length === 0) return;
        const add = (a, b) => a + b;

        return (input.reduce(add) / input.length).toFixed(5);
    };

    document.getElementById('root').innerHTML = 'Function : ' + calculateAverage + '<br/>' +
        ' Execution: calculateAverage(1, 2, 3)\'s result: ' + calculateAverage(1, 2, 3) +
        '<br/> Execution: calculateAverage(1, 2, 3, 4)\'s result : ' + calculateAverage(1, 2, 3, 4) +
        '<br/> Execution: calculateAverage(1, 2, 3, 4, 5, 16.6)\'s result : ' + calculateAverage(1, 2, 3, 4, 5, 16.6);


    console.log(calculateAverage(1, 2, 3));
    console.log(calculateAverage(1, 2, 3, 4));
    console.log(calculateAverage(1, 2, 3, 4, 5, 16.6));

})();
