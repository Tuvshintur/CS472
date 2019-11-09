(function () {// for run on onload to execute function
    const Car = {
        make: 'default',
        model: 'default',
        color: 'default',
        drive: function (speed) {
            console.log("The [" + this.color + "] [" + this.make + "] [" + this.model + "] is driving at [" + speed + "] mph");
        },
        stop: function () {
            console.log("The [" + this.color + "] [" + this.make + "] [" + this.model + "] is stopping");
        }
    };

    let redHondaAccord = Object.create(Car);
    redHondaAccord.color = "red";
    redHondaAccord.make = "Honda";
    redHondaAccord.model = "Accord";

    redHondaAccord.drive(200);


    redHondaAccord.stop();

})();