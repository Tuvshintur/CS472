(function () {// for run on onload to execute function
    const Car = function (make, model, color) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.drive = function (speed) {
            console.log("The [" + this.color + "] [" + this.make + "] [" + this.model + "] is driving at [" + speed + "] mph");
        }
        this.stop = function () {
            console.log("The [" + this.color + "] [" + this.make + "] [" + this.model + "] is stopping");
        }
    }

    let RedHondaAccord = new Car('Honda', 'Accord', 'red');

    RedHondaAccord.drive(300);
    RedHondaAccord.stop();

})();