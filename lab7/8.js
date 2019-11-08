var make_adder = (function () {
    var counter = 0;
    return function (adder) {
        return counter += adder;
    }
})();