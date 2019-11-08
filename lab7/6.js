var count = (function () {
    var counter = 0;
    function add() {
        return counter++;
    }
    function reset() {
        return counter = 0;
    }
    return {
        add: function () { add(); return counter; },
        reset: function () { reset(); return counter; }
    };
})();