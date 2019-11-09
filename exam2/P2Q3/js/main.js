(function () {
    function multiplesCount(nums, b) {
        return nums.filter(function (num) {
            return num % b == 0;
        }).length;
    }

    document.getElementById('root').innerHTML = 'Function : ' + multiplesCount + '<br/>' +
        ' Execution: multiplesCount([1, 2, 3, 4, 5, 6], 3)\'s result: ' + multiplesCount([1, 2, 3, 4, 5, 6], 3) +
        '<br/> Execution: multiplesCount([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15], 5)\'s result : ' + multiplesCount([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15], 5);

    console.log(multiplesCount([1, 2, 3, 4, 5, 6], 3));
    console.log(multiplesCount([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15], 5));
})();
